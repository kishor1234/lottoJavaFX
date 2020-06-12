/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.Report;
import Sys.api.httpAPI;
import Sys.invoice.PrinterService;
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.google.gson.JsonObject;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.print.PrintService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class OpratorController {

    @FXML
    private Button print;
    @FXML
    private Button close;
    @FXML
    private DatePicker fdate;
    @FXML
    private DatePicker tdate;
    @FXML
    private Button getRport;
    @FXML
    private TableView<Report> data_info;
    @FXML
    private TableColumn<Report, String> srno;
    @FXML
    private TableColumn<Report, String> userid;
    @FXML
    private TableColumn<Report, String> game;
    @FXML
    private TableColumn<Report, String> ticketno;
    @FXML
    private TableColumn<Report, String> drawid;
    @FXML
    private TableColumn<Report, String> netPoint;
    @FXML
    private TableColumn<Report, String> discountPer;
    @FXML
    private TableColumn<Report, String> discountPoint;
    @FXML
    private TableColumn<Report, String> finalPoint;
    @FXML
    private TableColumn<Report, String> winPoint;

    @FXML
    private TableColumn<Report, String> date;
    @FXML
    private Text netPT;
    @FXML
    private Text tpt;
    @FXML
    private Text wpt;
    @FXML
    private Text npt;
    private String owner;
    private String printer;
    private String data;
    @FXML
    private TableColumn<Report, String> netPayable;

    /**
     * Initializes the controller class.
     */
// srno,userid,game,ticketno,drawid,netPoint,discountPer,discountPoint,finalPoint,winPoint,netPayable,date;
    private void intiCols() {
        srno.setCellValueFactory(new PropertyValueFactory<>("srno"));
        userid.setCellValueFactory(new PropertyValueFactory<>("userid"));
        game.setCellValueFactory(new PropertyValueFactory<>("game"));
        ticketno.setCellValueFactory(new PropertyValueFactory<>("ticketno"));
        drawid.setCellValueFactory(new PropertyValueFactory<>("drawid"));
        netPoint.setCellValueFactory(new PropertyValueFactory<>("netPoint"));
        discountPer.setCellValueFactory(new PropertyValueFactory<>("discountPer"));
        discountPoint.setCellValueFactory(new PropertyValueFactory<>("discountPoint"));
        finalPoint.setCellValueFactory(new PropertyValueFactory<>("finalPoint"));
        winPoint.setCellValueFactory(new PropertyValueFactory<>("winPoint"));
        netPayable.setCellValueFactory(new PropertyValueFactory<>("netPayable"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void loadData() {
        try {
            //Button button;
            data_info.getItems().clear();
            ObservableList<Report> dt_ticket = FXCollections.observableArrayList();

            JsonObject person = new JsonObject();
            person.addProperty("fdate", fdate.getValue().toString());
            person.addProperty("tdate", tdate.getValue().toString());
            person.addProperty("userid", owner);
            String jsonString = person.toString();
            System.out.println(jsonString);
            data = httpAPI._jsonRequest("/?r=report", jsonString);
            System.out.println(data);
            Object obj = new JSONParser().parse(data);
            JSONObject jo = (JSONObject) obj;
            netPT.setText(jo.get("totalNetPoint").toString());
            tpt.setText(jo.get("totalPoint").toString());
            wpt.setText(jo.get("wintPoint").toString());
            npt.setText(jo.get("netPayble").toString());

            ArrayList<Map> dataArray = (ArrayList<Map>) jo.get("data");
            for (Map dataArray1 : dataArray) {
                Map<String, String> aMap1 = dataArray1;
                System.out.println("Data " + aMap1);
                dt_ticket.add(new Report(aMap1.get("id"), aMap1.get("userid"), aMap1.get("game"), aMap1.get("ticket"), aMap1.get("drawid"), aMap1.get("netPoint"), aMap1.get("discountPer"), aMap1.get("discountPoint"), aMap1.get("finalPoint"), aMap1.get("winAmount"), aMap1.get("netPayble"), aMap1.get("date")));
            }

            data_info.setItems(dt_ticket);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void printReport(ActionEvent event) {
        String pMsdateg = ""
                + "Date:"
                + "" + fdate.getValue() + " "
                + "To "
                + "" + tdate.getValue() + "";
        String sale = "Sale Point   : " + netPT.getText() + "";
        String profit="Profit Point : " + tpt.getText() + "";
        String win="Win Point    : " + wpt.getText() + "";
        String net="Net Payable  : " + npt.getText() + "";

        PrintService printService = PrinterOutputStream.getPrintServiceByName(printer);
        EscPos escpos;
        try {
            escpos = new EscPos(new PrinterOutputStream(printService));

            Style title = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Left_Default)
                    .setBold(true);

            Style subtitle = new Style(escpos.getStyle())
                    .setBold(true)
                    .setUnderline(Style.Underline.OneDotThick);
            Style bold = new Style(escpos.getStyle())
                    .setBold(true);

            escpos.writeLF(title, "RajLaxmi Lottery")
                    .writeLF(pMsdateg)
                    .writeLF(sale)
                    .writeLF(profit)
                    .writeLF(win)
                    .writeLF(bold,net)
                    .feed(6);

            escpos.cut(EscPos.CutMode.FULL);

            escpos.close();
        } catch (IOException | IllegalArgumentException ex) {
        }

    }

    @FXML
    private void actionReport(ActionEvent event) {
        loadData();
    }

    void initLoadData(String own, String print) {
        this.owner = own;
        this.printer = print;
        intiCols();
        //loadData();
    }

    @FXML
    private void closeAction(MouseEvent event) {
        close.getScene().getWindow().hide();
    }

}
