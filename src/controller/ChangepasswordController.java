/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.api.httpAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class ChangepasswordController {

    @FXML
    private PasswordField old_password;
    @FXML
    private PasswordField new_password;
    @FXML
    private TextField id;
    @FXML
    private Text msg;
    @FXML
    private Button close;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void ActionChangePassword(ActionEvent event) {
        Map<String, String> jString = new HashMap<>();
        jString.put("userid", id.getText());
        jString.put("old", old_password.getText());
        jString.put("new", new_password.getText());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonEmp = gson.toJson(jString);
        try {
            String data = httpAPI._jsonRequest("?r=gameChangePassword", jsonEmp);
            JSONObject myResponse = new JSONObject(data);
            int status = Integer.parseInt(myResponse.getString("status"));
            if (status == 1) {
                msg.setText(myResponse.getString("message"));
            } else {
                msg.setText(myResponse.getString("message"));
            }
            old_password.setText("");
            new_password.setText("");
        } catch (JSONException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void initLoadData(String text) {
        id.setText(text);
        //msg.setText(text);
    }

    @FXML
    private void closeButton(ActionEvent event) {
        close.getScene().getWindow().hide();
    }

}
