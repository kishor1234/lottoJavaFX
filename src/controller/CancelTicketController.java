/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.Ticket;
import Sys.api.httpAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.awt.HeadlessException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class CancelTicketController {

    @FXML
    private TableColumn<Ticket, String> srno;
    @FXML
    private TableColumn<Ticket, String> ticket;
    @FXML
    private TableColumn<Ticket, String> amount;
    @FXML
    private TableColumn<Ticket, String> drawid;
    @FXML
    private TableColumn<Ticket, String> drawtime;
    @FXML
    private TableColumn<Ticket, String> date;
    @FXML
    private TableColumn<Ticket, Button> action;
    @FXML
    private TableView<Ticket> ticket_info;
    private String printer;
    private String owner;
    private String drid;
    @FXML
    private Button close;
    private ObservableList<Ticket> data_ticket;

    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//        initTable();
//        loadData();
//    }
    private void initTable() {
        intiCols();
    }
// srno, ticket, amount, drawid, drawtime, date

    private void intiCols() {
        srno.setCellValueFactory(new PropertyValueFactory<>("srno"));
        ticket.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        drawid.setCellValueFactory(new PropertyValueFactory<>("drawid"));
        drawtime.setCellValueFactory(new PropertyValueFactory<>("drawtime"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        actionCols();
    }

    private void actionCols() {
        ticket.setCellFactory(TextFieldTableCell.forTableColumn());
        ////System.out.println(ticket.getText());
    }

    private void loadData() {
        try {
            //Button button;
            data_ticket = FXCollections.observableArrayList();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String cdata = dtf.format(now);
            JsonObject person = new JsonObject();
            person.addProperty("enterydate", cdata);
            person.addProperty("own", owner);
            String jsonString = person.toString();
            String data = httpAPI._jsonRequest("/?r=datewiseTicket", jsonString);
            Object obj = new JSONParser().parse(data);
            ArrayList<Map> aMap = (ArrayList<Map>) obj;
            //{"date":"2020-05-30","amount":"2.00","ticket":"ask5ed1f5e98ff72","drawtime":"11:30:00","srno":1,"drawid":"6"}
            aMap.stream().forEach((aMap1) -> {
                Button btn = new Button("Cancel");
                btn.setOnAction(e -> cancelTicket(aMap1.get("ticket").toString()));
                data_ticket.add(new Ticket(aMap1.get("srno").toString(), aMap1.get("ticket").toString(), aMap1.get("amount").toString(), aMap1.get("drawid").toString(), aMap1.get("drawtime").toString(), aMap1.get("date").toString(), btn));
            });

            ticket_info.setItems(data_ticket);
        } catch (Exception ex) {

        }
    }

    private void cancelTicket(String ticket) {
        try {
            int input = JOptionPane.showConfirmDialog(null, "Do you really want to delete ticket?");
            if (input == 0) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime now = LocalDateTime.now();
                Map<String, String> data = new HashMap<>();
                data.put("enterydate", dtf.format(now));
                data.put("own", this.owner);
                data.put("game", ticket);
                data.put("gametimeid", this.drid);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonEmp = gson.toJson(data);
                String Data = httpAPI._jsonRequest("?r=cancelTicket", jsonEmp);
                //System.out.println(Data);
                Object obj = new JSONParser().parse(Data);
                JSONObject jo = (JSONObject) obj;
                String msg = (String) jo.get("message");
                JOptionPane.showMessageDialog(null, "Cancle " + msg);
                reloadTable();
            } else {
                JOptionPane.showMessageDialog(null, "Ticket Deleteing Process cancel!");
            }

        } catch (HeadlessException | ParseException ex) {
            Logger.getLogger(ReprintTicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void initLoadData(String own, String print, String did) {
        this.owner = own;
        this.printer = print;
        this.drid = did;
        initTable();
        loadData();
    }

    @FXML
    private void closeWindo(ActionEvent event) {
        close.getScene().getWindow().hide();
    }

    private void reloadTable() {
        data_ticket.clear();
        loadData();
    }

}
