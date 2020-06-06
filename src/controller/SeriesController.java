/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.Sereis.seriesData;
import Sys.api.httpAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
 * @author asksoft
 */
public class SeriesController {

    public String printer;
    @FXML
    private Button btn2;
    @FXML
    private VBox vboxpanel;

    public Map<String, String> aMap = new HashMap<>();
    public String mult = "";
    public Map<String, CheckBox> cbMap = new HashMap<>();

    /**
     * Initializes the controller class.
     */
    @FXML
    private void buttonClick(ActionEvent event) {

        if (aMap.isEmpty()) {
            aMap.put("0", "1000-1900");
        }
        btn2.getScene().getWindow().hide();
    }

    Map<String, String> getText() {
        return aMap;
    }

    void initLoadData(String multi, Map<String, String> oldMap) {
        cbMap = new HashMap<>();
        String fileData = httpAPI._jsonRequest("?r=loadSeries", "");
        //System.out.println(multi + " Series Load Data " + fileData);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        seriesData series = gson.fromJson(fileData, seriesData.class);
        ArrayList<Map> test = series.getProperties();
        Iterator<Map> itr = test.iterator();
        DropShadow shadow = new DropShadow();
        switch (multi) {
            case "multi":
                aMap = oldMap;
                mult = multi;
                HBox hbC = new HBox();

                //add 3 new buttons
                CheckBox all = new CheckBox("ALL");
                all.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                all.setStyle("-fx-background-color:#ffe014; -fx-spacing: 5; -fx-border-width: 0; -fx-padding: 10 10 10 10; -fx-border-color:yellow;-fx-background-radius:3; -fx-border-radius:3;");
                all.setOnAction(e -> {

                    if (all.isSelected()) {
                        for (Map.Entry<String, CheckBox> entry : cbMap.entrySet()) {
                            String key = entry.getKey();
                            CheckBox cb = entry.getValue();
                            cb.setSelected(true);
                            Map<String, String> tp = new HashMap<>();
                            tp.put("id", key);
                            tp.put("series", cb.getText());
                            setaMapMultiple(cb, tp);
                        }
                    } else {
                        for (Map.Entry<String, CheckBox> entry : cbMap.entrySet()) {
                            String key = entry.getKey();
                            CheckBox cb = entry.getValue();
                            cb.setSelected(false);
                            Map<String, String> tp = new HashMap<>();
                            tp.put("id", key);
                            tp.put("series", cb.getText());
                            setaMapMultiple(cb, tp);
                        }
                    }
                }); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
                HBox.setMargin(all, new Insets(5, 5, 5, 5));
                all.setMaxWidth(200);
                all.setMinWidth(100);
                all.setEffect(shadow);
                hbC.getChildren().add(all);
//                Button clear = new Button("Clear");
//                clear.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
//                clear.setStyle("-fx-background-color:#ffe014; -fx-spacing: 5; -fx-border-width: 0; -fx-padding: 10 10 10 10; -fx-border-color:yellow;-fx-background-radius:3; -fx-border-radius:3;");
//                clear.setOnAction(e -> {
//                }); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
//                clear.setMaxWidth(200);
//                clear.setMinWidth(100);
//                HBox.setMargin(clear, new Insets(5, 5, 5, 5));
//                clear.setEffect(shadow);
//                hbC.getChildren().add(clear);
                Button close = new Button("Close");
                close.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                close.setStyle("-fx-background-color:#ffe014; -fx-spacing: 5; -fx-border-width: 0; -fx-padding: 10 10 10 10; -fx-border-color:yellow;-fx-background-radius:3; -fx-border-radius:3;");
                close.setOnAction(e -> {
                    if (aMap.isEmpty()) {
                        aMap.put("0", "1000-1900");
                    }
                    close.getScene().getWindow().hide();
                }); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
                close.setMaxWidth(200);
                close.setMinWidth(100);
                HBox.setMargin(close, new Insets(5, 5, 5, 5));
                close.setEffect(shadow);
                hbC.getChildren().add(close);
                vboxpanel.getChildren().add(hbC);
                hbC = new HBox();
                //end button here
                int i = 0;
                while (itr.hasNext()) {
                    Map<String, String> temp = itr.next();
                    CheckBox checkbox = new CheckBox(temp.get("series"));
                    int sr = Integer.parseInt(temp.get("id")) - 1;
                    try {
                        if (aMap != null) {
                            if (aMap.get("" + sr).equals(temp.get("series"))) {
                                checkbox.setSelected(true);
                            }
                        }
                    } catch (Exception ex) {

                    }

                    checkbox.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                    checkbox.setStyle("-fx-background-color:#ffe014; -fx-spacing: 5; -fx-border-width: 0; -fx-padding: 10 10 10 10; -fx-border-color:yellow;-fx-background-radius:3; -fx-border-radius:3;");
                    checkbox.setOnAction(e -> setaMapMultiple(checkbox, temp)); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
                    HBox.setMargin(checkbox, new Insets(5, 5, 5, 5));
                    checkbox.setEffect(shadow);
                    cbMap.put(temp.get("id"), checkbox);
                    i++;
                    hbC.getChildren().add(checkbox);
                }
                vboxpanel.getChildren().add(hbC);
                break;
            default:

                HBox hb = new HBox();
                while (itr.hasNext()) {
                    Map<String, String> temp = itr.next();
                    Button button = new Button(temp.get("series"));
                    //int sr = Integer.parseInt(temp.get("id")) - 1;
                    button.setOnAction(e -> buttonSelect(temp, button));
                    button.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                    button.setStyle("-fx-background-color:#ffe014; -fx-spacing: 5; -fx-border-width: 0; -fx-padding: 10 10 10 10; -fx-border-color:yellow;-fx-background-radius:3; -fx-border-radius:3;");
                    //button.setOnAction(e -> setaMapMultiple(checkbox, temp)); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
                    HBox.setMargin(button, new Insets(5, 5, 5, 5));
                    button.setEffect(shadow);
                    hb.getChildren().add(button);
                }
                vboxpanel.getChildren().add(hb);
                break;
        }
//        HBox hb = new HBox();
//        for (int i = 1; i <= 5; i++) {
//            CheckBox cb = new CheckBox();
//            cb.setText("PT " + i);
//            cb.setOnMouseClicked(e -> printer = printer + "," + cb.getText());
//            hb.getChildren().add(cb);
//
//        }
//        vboxpanel.getChildren().add(hb);

    }

    private void setaMapMultiple(CheckBox checkbox, Map<String, String> temp) {
        ////System.out.println(checkbox.isSelected());
        if (checkbox.isSelected()) {
            int sr = Integer.parseInt(temp.get("id")) - 1;
            aMap.put("" + sr, temp.get("series"));
        } else {
            int sr = Integer.parseInt(temp.get("id")) - 1;
            aMap.remove("" + sr);
            //System.out.println("Remove " + sr + "" + aMap);
        }
    }

    private void buttonSelect(Map<String, String> temp, Button button) {
        int sr = Integer.parseInt(temp.get("id")) - 1;
        aMap.put("" + sr, temp.get("series"));
        button.getScene().getWindow().hide();

    }

}
