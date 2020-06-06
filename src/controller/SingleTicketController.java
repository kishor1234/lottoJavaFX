/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.SingleTicket;
import Sys.api.httpAPI;
import Sys.invoice.invoiceJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
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
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class SingleTicketController {

    @FXML
    private Button close;
    @FXML
    private TableView<SingleTicket> ticket_info;
    @FXML
    private TableColumn<SingleTicket, String> srno;
    @FXML
    private TableColumn<SingleTicket, String> drDate;
    @FXML
    private TableColumn<SingleTicket, String> drTime;
    @FXML
    private TableColumn<SingleTicket, String> name;
    @FXML
    private TableColumn<SingleTicket, String> mrp;
    @FXML
    private TableColumn<SingleTicket, String> digit;
    @FXML
    private TableColumn<SingleTicket, String> qty;
    @FXML
    private Text msg;
    @FXML
    private Button Accept;
    @FXML
    private Button cancel;
    public String ticket ;
    private String printer;
    private String owner;

    /**
     * Initializes the controller class.
     */
    

    private void initColom() {
        srno.setCellValueFactory(new PropertyValueFactory<>("srno"));
        drDate.setCellValueFactory(new PropertyValueFactory<>("drDate"));
        drTime.setCellValueFactory(new PropertyValueFactory<>("drTime"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        mrp.setCellValueFactory(new PropertyValueFactory<>("mrp"));
        digit.setCellValueFactory(new PropertyValueFactory<>("digit"));
        qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void loadData() {
        try {
            //Button button;
            ObservableList<SingleTicket> data_ticket = FXCollections.observableArrayList();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String cdata = dtf.format(now);
            JsonObject person = new JsonObject();
            person.addProperty("game", ticket);
            person.addProperty("own", owner);
            String jsonString = person.toString();
            String data = httpAPI._jsonRequest("/?r=singleTicketPrint", jsonString);
            Object obj = new JSONParser().parse(data);
            JSONObject jo = (JSONObject) obj;
            String status = (String) jo.get("status");
            msg.setText((String) jo.get("msg"));
            ArrayList<Map> aMap = (ArrayList<Map>) jo.get("point");
            //{"date":"2020-05-30","amount":"2.00","ticket":"ask5ed1f5e98ff72","drawtime":"11:30:00","srno":1,"drawid":"6"}
            aMap.stream().forEach((aMap1) -> {
                data_ticket.add(new SingleTicket(aMap1.get("srno").toString(), aMap1.get("drDate").toString(), aMap1.get("drTime").toString(), aMap1.get("name").toString(), aMap1.get("mrp").toString(), aMap1.get("digit").toString(), aMap1.get("qty").toString()));
            });

            ticket_info.setItems(data_ticket);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void closeWindo(ActionEvent event) {
        close.getScene().getWindow().hide();
    }

    @FXML
    private void onAcceptActionPrint(ActionEvent event) {
        try {
            int input = JOptionPane.showConfirmDialog(null, "Do you really want to Reprint ticket? it cause dublicat ticket");
            if (input == 0) {
                Map<String, String> data = new HashMap<>();
                data.put("game", ticket);
                data.put("own", owner);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonEmp = gson.toJson(data);
                String Data = httpAPI._jsonRequest("?r=reprintDesktopPrint", jsonEmp);
                //System.out.println("Data \n" + Data);
                // invoiceJSON.invoiceJSONPrint(Data,printer);
                String msg = invoiceJSON.invoiceJSONPrint(Data, printer);
                JOptionPane.showMessageDialog(null, msg);
            } else {
                JOptionPane.showMessageDialog(null, "Ticket Repring Process cancel!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ReprintTicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void CancelAction(ActionEvent event) {
        cancel.getScene().getWindow().hide();
    }

    void initLoadData(String owner,String ticket, String printer) {
        this.ticket=ticket;
        this.printer=printer;
        this.owner=owner;
        initColom();
        loadData();
    }

}
