/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.Ticket;
import Sys.api.httpAPI;
import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.simple.parser.JSONParser;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class ReprintTicketController {

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
    @FXML
    private Button close;
    private double xOffset=0;
    private double yOffset=0;

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
            person.addProperty("own", owner);
            String jsonString = person.toString();
            String data = httpAPI._jsonRequest("/?r=datewiseTicket", jsonString);
            Object obj = new JSONParser().parse(data);
            ArrayList<Map> aMap = (ArrayList<Map>) obj;
            //{"date":"2020-05-30","amount":"2.00","ticket":"ask5ed1f5e98ff72","drawtime":"11:30:00","srno":1,"drawid":"6"}
            aMap.stream().forEach((aMap1) -> {
                Button btn = new Button("Reprint");
                btn.setOnAction(e -> reprintTicket(aMap1.get("ticket").toString()));
                data_ticket.add(new Ticket(aMap1.get("srno").toString(), aMap1.get("ticket").toString(), aMap1.get("amount").toString(), aMap1.get("drawid").toString(), aMap1.get("drawtime").toString(), aMap1.get("date").toString(), btn));
            });

            ticket_info.setItems(data_ticket);
        } catch (Exception ex) {

        }
    }

    private void reprintTicket(String ticket) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/singleTicket.fxml"));
            Parent root = loader.load();
            SingleTicketController Scl = loader.getController();
            Scl.initLoadData(owner,ticket, printer);
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
            Logger.getLogger(ReprintTicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }

    private void themStyle(Stage stage, Parent root) {
        stage.initStyle(StageStyle.TRANSPARENT);
            //stage.initStyle(StageStyle.UNDERDECORATED);

        //grab your root here
        root.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            double yOffset = event1.getSceneY();
        });

        //move around here
        root.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });    }

}
