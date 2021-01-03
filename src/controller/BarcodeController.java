/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.github.anastaciocintra.escpos.barcode.BarCode;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author atharv
 */
public class BarcodeController implements Initializable {

    @FXML
    private Button btn2;
    @FXML
    private VBox vboxpanel;

    public BarCode.BarCodeSystem barcode = BarCode.BarCodeSystem.CODE93_Default;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    void initLoadData(BarCode.BarCodeSystem defaultBarcode, Map<String, BarCode.BarCodeSystem> barcode) {
        try {
            HBox hb = new HBox();
            int i = 0;
            for (Map.Entry<String, BarCode.BarCodeSystem> entry : barcode.entrySet()) {
                String key = entry.getKey();
                BarCode.BarCodeSystem cb = entry.getValue();
                Button button = new Button(key);
                button.setOnAction(e -> buttonSelect(cb, button));
                button.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
                button.setStyle("-fx-background-color:#ffe014; -fx-spacing: 5; -fx-border-width: 0; -fx-padding: 10 10 10 10; -fx-border-color:yellow;-fx-background-radius:3; -fx-border-radius:3;");
                //button.setOnAction(e -> setaMapMultiple(checkbox, temp)); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
                HBox.setMargin(button, new Insets(5, 5, 15, 5));
                DropShadow shadow = new DropShadow();
                button.setEffect(shadow);
                hb.getChildren().add(button);
                if (i == 7) {
                    vboxpanel.getChildren().add(hb);
                    hb = new HBox();
                    i = -1;
                }
                i++;
            }
            vboxpanel.getChildren().add(hb);

        } catch (Exception ex) {
            System.out.println("Exception Barocd inot controle " + ex.getMessage());
        }

    }

    private void buttonSelect(BarCode.BarCodeSystem bc, Button button) {

        barcode = bc;
        button.getScene().getWindow().hide();

    }

    BarCode.BarCodeSystem getBarcode() {
        return barcode;
    }

    @FXML
    private void buttonBarcodeClick(ActionEvent event) {
        btn2.getScene().getWindow().hide();
    }
}
