/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.Report;
import Sys.Ticket;
import Sys.api.httpAPI;
import Sys.invoice.PrinterService;
import com.google.gson.JsonObject;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
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
    private TableColumn<Report, String> netPayable;
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
        netPoint.setCellValueFactory(new PropertyValueFactory<>("netPint"));
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

            ArrayList<Map> aMap = (ArrayList<Map>) jo.get("data");
            //{"date":"2020-05-30","amount":"2.00","ticket":"ask5ed1f5e98ff72","drawtime":"11:30:00","srno":1,"drawid":"6"}
            aMap.stream().forEach((aMap1) -> {

                dt_ticket.add(new Report(aMap1.get("id").toString(), aMap1.get("userid").toString(), aMap1.get("game").toString(), aMap1.get("ticket").toString(), aMap1.get("drawid").toString(), aMap1.get("netPoint").toString(), aMap1.get("discountPer").toString(), aMap1.get("discountPoint").toString(), aMap1.get("finalPoint").toString(), aMap1.get("winAmount").toString(), aMap1.get("netPayble").toString(), aMap1.get("date").toString()));
            });

            data_info.setItems(dt_ticket);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void printReport(ActionEvent event) {
        String pMsg = "Sell Report\n"
                + "Date on\n"
                + "" + fdate.getValue() + "\n"
                + "To\n"
                + "" + tdate.getValue() + "\n"
                + "TOTAL NET POINT : " + netPT.getText() + "\n"
                + "TOTAL POINT : " + tpt.getText() + "\n"
                + "WIN POINT: " + wpt.getText() + "\n"
                + "NET PAYABLE : " + npt.getText() + "";
        PrinterService printerService = new PrinterService();
        printerService.printString(printer, pMsg);

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
