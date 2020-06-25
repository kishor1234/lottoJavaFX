/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class ClaimController {

    @FXML
    private Button close;
    @FXML
    private Text msg;

    void initLoadData(String msgg) {
        msg.setText(msgg);
        System.gc();
    }

    @FXML
    private void actionClose(ActionEvent event) {
        close.getScene().getWindow().hide();
        System.gc();
    }

    /**
     * Initializes the controller class.
     */
}
