/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.Ticket;
import Sys.api.httpAPI;
import com.google.gson.JsonObject;
import java.awt.HeadlessException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class ReprintTicketController {

    @FXML
    private TableColumn<Ticket, String> srno;

    @FXML
    private TableColumn<Ticket, String> amount;

    @FXML
    private TableColumn<Ticket, String> date;
    @FXML
    private TableColumn<Ticket, Button> action;
    @FXML
    private TableView<Ticket> ticket_info;

    private String printer;
    private String owner;

    @FXML
    private Button close;
    private final double xOffset = 0;
    private final double yOffset = 0;
    @FXML
    private TableColumn<Ticket, String> utrno;
    @FXML
    private TableColumn<Ticket, String> userid;

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
        utrno.setCellValueFactory(new PropertyValueFactory<>("utrno"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        userid.setCellValueFactory(new PropertyValueFactory<>("userid"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        actionCols();
        System.gc();
    }

    private void actionCols() {
        utrno.setCellFactory(TextFieldTableCell.forTableColumn());
        //System.out.println(ticket.getText());
    }

    private void loadData() {
        try {
            //Button button;
            ObservableList<Ticket> data_ticket = FXCollections.observableArrayList();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            String cdata = dtf.format(now);
            JsonObject person = new JsonObject();
            person.addProperty("enterydate", cdata);
            //person.addProperty("game", ticket);
            person.addProperty("userid", owner);
            String jsonString = person.toString();
            System.out.println(jsonString);
            String data = httpAPI._jsonRequest("/?r=datewiseTicket", jsonString);
            if (data != null) {
                System.out.println(data);
                Object obj = new JSONParser().parse(data);
                ArrayList<Map> aMap = (ArrayList<Map>) obj;
                //{"date":"2020-05-30","amount":"2.00","ticket":"ask5ed1f5e98ff72","drawtime":"11:30:00","srno":1,"drawid":"6"}

                aMap.stream().forEach((aMap1) -> {
                    if ("0".equals((aMap1.get("active").toString()))) {
                        Button btn = new Button("Already Cancel");

                        data_ticket.add(new Ticket(aMap1.get("srno").toString(), aMap1.get("utrno").toString(), aMap1.get("amount").toString(), aMap1.get("userid").toString(), aMap1.get("date").toString(), btn));

                    } else {
                        Button btn = new Button("Reprint");
                        btn.setOnAction(e -> reprintTicket(aMap1.get("utrno").toString(), aMap1.get("amount").toString()));
                        data_ticket.add(new Ticket(aMap1.get("srno").toString(), aMap1.get("utrno").toString(), aMap1.get("amount").toString(), aMap1.get("userid").toString(), aMap1.get("date").toString(), btn));

                    }
                });

                ticket_info.setItems(data_ticket);
            } else {
                JOptionPane.showMessageDialog(null, "Please check internet Connection.. Remote Host not connected");
            }
        } catch (ParseException | HeadlessException ex) {
            httpAPI.erLog.write(ex);
        }
        System.gc();
    }

    private void reprintTicket(String ticket, String amount) {//ticket=utrno
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {

                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/singleTicket.fxml"));
                    Parent root = loader.load();
                    SingleTicketController Scl = loader.getController();
                    Scl.initLoadData(owner, ticket, printer, amount);
                    Stage stage = new Stage();
                    stage.setTitle("Reprint Ticket");
                    Screen screen = Screen.getPrimary();
                    Rectangle2D bounds = screen.getVisualBounds();
                    stage.setX(bounds.getMinX());
                    stage.setY(bounds.getMinY());
                    stage.setWidth(bounds.getWidth());
                    stage.setHeight(bounds.getHeight());

                    stage.setScene(new Scene(root));
                    themStyle(stage, root);
                    stage.showAndWait();
                } catch (Exception ex) {
                    httpAPI.erLog.write(ex);
                }
                System.gc();
            };

            Platform.runLater(updater);
            System.gc();
        });
        openThread.start();
    }

    void initLoadData(String own, String print) {
        this.owner = own;
        this.printer = print;
        initTable();
        loadData();
    }

    @FXML
    private void closeWindo(ActionEvent event) {
        close.getScene().getWindow().hide();
        System.gc();
    }

    private void themStyle(Stage stage, Parent root) {
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.initStyle(StageStyle.UNDERDECORATED);
        stage.initModality(Modality.WINDOW_MODAL);
        // Specifies the owner Window (parent) for new window
        stage.initOwner(close.getScene().getWindow());
        stage.getScene().getRoot().setEffect(new DropShadow());
    }

}
