/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.AdvanceDraw.AdvanceData;
import Sys.TimeFormats;
import Sys.api.httpAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class AdvanceController {

    @FXML
    private VBox drawpan;
    @FXML
    private TextField number;
    @FXML
    private Text max;

    public static ArrayList<Map> advanceDrawArray = new ArrayList<>();//multi series option
    public static Map<String, Map> advanceDraw = new HashMap<>();//multi series option
    @FXML
    private Button button;
    public Map<String, CheckBox> adCheck = new HashMap<>();
    @FXML
    private HBox tf;

    public String fileData = "";
    public DropShadow shadow = new DropShadow();

    /**
     * Initializes the controller class.
     */
    @FXML
    private void selectDrawvianumber(KeyEvent event) {
        try {
            //advanceDraw = new HashMap<>();
            for (int i = 0; i < adCheck.size(); i++) {
                CheckBox js = adCheck.get(i + "");
                js.setSelected(false);
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            AdvanceData series = gson.fromJson(fileData, AdvanceData.class);
            ArrayList<Map> test = series.getProperties();
            Iterator<Map> itr = test.iterator();
            int i = 0;
            while (itr.hasNext()) {

                if (i >= Integer.parseInt(number.getText())) {
                    break;
                } else {
                    Map<String, String> temp = itr.next();
                    CheckBox checkbox = adCheck.get(i + "");
                    checkbox.setSelected(true);
                    adCheckBoxAction(checkbox, temp);
                }
                i++;

            }
            //System.out.println("Selected Advance Draw "+advanceDraw);

        } catch (JsonSyntaxException | NumberFormatException ex) {
            // JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);

        }
    }

    @FXML
    private void closeAction(ActionEvent event) {
        button.getScene().getWindow().hide();
    }

    public void loadAdvance() {
        try {

            //System.out.println("Advance Draw JSON " + fileData);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            AdvanceData series = gson.fromJson(fileData, AdvanceData.class);
            ArrayList<Map> test = series.getProperties();
            Iterator<Map> itr = test.iterator();

            int i = 0, ks = 0;

            HBox hbC = new HBox();
            while (itr.hasNext()) {

                Map<String, String> temp = itr.next();
                CheckBox checkbox = new CheckBox(String.format("%02d", Integer.parseInt(temp.get("id"))) + "[" + TimeFormats.timeConvert(temp.get("etime")) + "]");
                try {
                    if (!advanceDraw.get(temp.get("id")).isEmpty()) {
                        //System.out.println(advanceDraw);
                        checkbox.setSelected(true);
                    }

                } catch (Exception ex) {
                    // System.out.println("Msg " + ex.getMessage());
                }
                adCheck.put(ks + "", checkbox);
                checkbox.setOnAction(e -> adCheckBoxAction(checkbox, temp));
                //checkbox.setStyle("-fx-margin: 2em 2em 2em 2em ;");
                checkbox.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                checkbox.setStyle("-fx-background-color:#ffe014; -fx-spacing: 5; -fx-border-width: 0; -fx-padding: 10 10 10 10; -fx-border-color:yellow;-fx-background-radius:3; -fx-border-radius:3;");
                //checkbox.setOnAction(e -> setaMapMultiple(checkbox, temp)); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
                HBox.setMargin(checkbox, new Insets(5, 5, 5, 5));
                checkbox.setEffect(shadow);
                hbC.getChildren().add(checkbox);
                if (i == 7) {
                    drawpan.getChildren().add(hbC);
                    hbC = new HBox();
                    i = -1;
                }
                i++;
                ks++;
            }
            drawpan.getChildren().add(hbC);
            max.setText(ks + "");
        } catch (JsonSyntaxException | NumberFormatException ex) {
            //System.out.println("Advance Error " + ex.getMessage());
        }
    }

    private void adCheckBoxAction(CheckBox checkbox, Map<String, String> temp) {
        if (checkbox.isSelected()) {//checkbox has been selected
            Map<String, String> advanceDraws = new HashMap<>();
            advanceDraws.put("gametimeid", temp.get("id"));
            advanceDraws.put("gametime", temp.get("stime"));
            advanceDraws.put("gameendtime", temp.get("etime"));
            advanceDrawArray.add(advanceDraws);
            advanceDraw.put(temp.get("id"), advanceDraws);

        } else {//checkbox has been deselected
            Map<String, String> advanceDraws = new HashMap<>();
            advanceDraws.put("gametimeid", temp.get("id"));
            advanceDraws.put("gametime", temp.get("stime"));
            advanceDraws.put("gameendtime", temp.get("etime"));
            advanceDrawArray.remove(advanceDraws);
            advanceDraw.remove(temp.get("id"));

        }
    }

    void initLoadData(Map<String, Map> advanceDr) {
        advanceDraw = advanceDr;
        fileData = httpAPI._jsonRequest("?r=advanceDraw", "");
        loadAdvance();
    }

    Map<String, Map> getAdvanceArray() {
        //System.out.println("Selected Advance Draw " + advanceDraw);
        return advanceDraw;
    }
}
