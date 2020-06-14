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
import org.json.simple.parser.ParseException;

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
    public String ticket;
    private String printer;
    private String owner;
    private String amount;

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
            person.addProperty("utrno", ticket);
            person.addProperty("own", owner);
            person.addProperty("action", "entry");

            String jsonString = person.toString();
            String data = httpAPI._jsonRequest("/?r=singleTicketPrint", jsonString);
            //get unitrid 
            if (data != null) {
                Object obj2 = new JSONParser().parse(data);
                Map<String, String> adbPrint = new HashMap<>();
                ArrayList<Map> aMap = (ArrayList<Map>) obj2;
                for (Map aMap3 : aMap) {
                    Map<String, String> temP = aMap3;
                    adbPrint = new HashMap<>();
                    adbPrint.put("trno", temP.get("trno"));
                    adbPrint.put("own", owner);
                    adbPrint.put("action", "subentry");
                    adbPrint.put("amount", amount);
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonPrint = gson.toJson(adbPrint);
                    //System.out.println(jsonPrint);
                    String Data = httpAPI._jsonRequest("?r=singleTicketPrint", jsonPrint);
                    Object obj = new JSONParser().parse(Data);
                    JSONObject jo = (JSONObject) obj;
                    //String status = (String) jo.get("status");
                    msg.setText((String) jo.get("msg"));
                    ArrayList<Map> aMap2 = (ArrayList<Map>) jo.get("point");
                    //{"date":"2020-05-30","amount":"2.00","ticket":"ask5ed1f5e98ff72","drawtime":"11:30:00","srno":1,"drawid":"6"}
                    aMap2.stream().forEach((aMap1) -> {
                        data_ticket.add(new SingleTicket(aMap1.get("srno").toString(), aMap1.get("drDate").toString(), aMap1.get("drTime").toString(), aMap1.get("name").toString(), aMap1.get("mrp").toString(), aMap1.get("digit").toString(), aMap1.get("qty").toString()));
                    });
                }
                //

                ticket_info.setItems(data_ticket);
            } else {
                JOptionPane.showMessageDialog(null, "Please check internet Connection.. Remote Host not connected");
            }
        } catch (Exception ex) {
            httpAPI.erLog.write(ex);
        }
    }

    @FXML
    private void closeWindo(ActionEvent event) {
        close.getScene().getWindow().hide();
    }

    @FXML
    private void onAcceptActionPrint(ActionEvent event) {

        Thread printthread = new Thread() {
            public void run() {
                int input = JOptionPane.showConfirmDialog(null, "Do you really want to Reprint ticket? it cause dublicat ticket");
                if (input == 0) {

                    try {
                        Map<String, String> adbPrint = new HashMap<>();
                        adbPrint.put("utrno", ticket);
                        adbPrint.put("own", owner);
                        adbPrint.put("action", "entry");
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonPrint = gson.toJson(adbPrint);
                        //System.out.println(jsonPrint);
                        String Data = httpAPI._jsonRequest("?r=advancePrint", jsonPrint);
                        if (Data != null) {
                            Object obj2 = new JSONParser().parse(Data);
                            ArrayList<Map> aMap = (ArrayList<Map>) obj2;
                            for (Map aMap1 : aMap) {
                                try {
                                    Map<String, String> temP = aMap1;
                                    adbPrint = new HashMap<>();
                                    adbPrint.put("game", temP.get("game"));
                                    adbPrint.put("own", owner);
                                    adbPrint.put("utrno", ticket);
                                    adbPrint.put("action", "subentry");
                                    //Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                    jsonPrint = gson.toJson(adbPrint);
                                    //System.out.println(jsonPrint);
                                    Data = httpAPI._jsonRequest("?r=advancePrint", jsonPrint);
                                    invoiceJSON.invoiceJSONPrint(Data, printer);
                                }catch (Exception ex) {
                                    httpAPI.erLog.write(ex);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please check internet Connection.. Remote Host not connected");
                        }
                    } catch (ParseException ex) {
                        httpAPI.erLog.write(ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ticket Repring Process cancel!");
                }
            }
        };
        printthread.start();
    }

    @FXML
    private void CancelAction(ActionEvent event) {
        cancel.getScene().getWindow().hide();
    }

    void initLoadData(String owner, String ticket, String printer, String amount) {
        this.ticket = ticket;
        this.printer = printer;
        this.owner = owner;
        this.amount = amount;
        initColom();
        loadData();
    }

}
