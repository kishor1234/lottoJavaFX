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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

        String fileData = httpAPI._jsonRequest("?r=loadSeries", "");
        System.out.println(multi + " Series Load Data " + fileData);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        seriesData series = gson.fromJson(fileData, seriesData.class);
        ArrayList<Map> test = series.getProperties();
        Iterator<Map> itr = test.iterator();
        switch (multi) {
            case "multi":
                aMap = oldMap;
                mult = multi;
                HBox hbC = new HBox();
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
                    checkbox.setOnAction(e -> setaMapMultiple(checkbox, temp)); //.setOnAction(e -> aMap.put("" + sr, temp.get("series")));
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
        System.out.println(checkbox.isSelected());
        if (checkbox.isSelected()) {
            int sr = Integer.parseInt(temp.get("id")) - 1;
            aMap.put("" + sr, temp.get("series"));
        } else {
            int sr = Integer.parseInt(temp.get("id")) - 1;
            aMap.remove("" + sr);
            System.out.println("Remove " + sr + "" + aMap);
        }
    }

    private void buttonSelect(Map<String, String> temp, Button button) {
        int sr = Integer.parseInt(temp.get("id")) - 1;
        aMap.put("" + sr, temp.get("series"));
        button.getScene().getWindow().hide();

    }

}
