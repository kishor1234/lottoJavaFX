/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.api.httpAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class CancelpoupController {

    @FXML
    private Text last;
    private String own;
    private String printer;
    private String drawid;
    private String utrno;
    @FXML
    private Button action;
    @FXML
    private Button close;
    @FXML
    private Text info;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void AcceptAction(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Map<String, String> data = new HashMap<>();
        data.put("enterydate", dtf.format(now));
        data.put("own", own);
        data.put("utrno", utrno);
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonEmp = gson.toJson(data);
        System.out.println("Cancel Data "+jsonEmp);
        String Data = httpAPI._jsonRequest("?r=cancelTicket", jsonEmp);
        System.out.println(Data);
        action.getScene().getWindow().hide();
    }

    @FXML
    private void CloseAction(ActionEvent event) {
        close.getScene().getWindow().hide();
    }

    void initLoadData(String own, String printer, String drawid) {
        try {
            this.own = own;
            this.printer = printer;
            this.drawid = drawid;
            Map<String, Map> finalMap = new HashMap<>();
            Map<String, String> data = new HashMap<>();
            data.put("userid", own);
            data.put("drawid", drawid);
            finalMap.put("main", data);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonEmp = gson.toJson(finalMap);
            System.out.println(jsonEmp);
            String Data = httpAPI._jsonRequest("?r=getCancelLimit", jsonEmp);
            System.out.println("Data \n" + Data);
            //{"status":"1","message":"Success","limit":"5","utrno":"9536257"}
            Object obj = new JSONParser().parse(Data);
            JSONObject jo = (JSONObject) obj;
            if ("1".equals(jo.get("status"))) {
                this.utrno = (String) jo.get("utrno");
                last.setText("Please cancel last cash Memoo/Invoice (T.No " + this.utrno + ")");
                info.setText("I hereby req. uset for cancellation of the same and indernmety for any misuse of the side cancelled\nCash Invoice");
            } else {
                last.setText((String) jo.get("message"));
                action.setVisible(false);
            }

        } catch (ParseException ex) {
            Logger.getLogger(CancelpoupController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
