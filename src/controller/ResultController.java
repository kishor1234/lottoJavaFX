/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.TimeFormats;
import Sys.api.httpAPI;
import com.google.gson.JsonObject;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Map;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class ResultController {

    @FXML
    private Text series;
    @FXML
    private DatePicker gdate;
    @FXML
    private VBox resultPan;
    @FXML
    private Button btnClose;

    public String ColorArray[] = new String[]{"#d485c2", "#82b47e", "#7ab4e8", "#5ba36a", "#d98d81", "#b9b1e6", "#ea9e7b", "#a4cc5a", "#c9bdaf", "#17bcbd"};

    @FXML
    private void getResult(ActionEvent event) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        resultPan.getChildren().clear();
                        JsonObject person = new JsonObject();
                        person.addProperty("series", series.getText());
                        person.addProperty("gdate", gdate.getValue().toString());
                        String jsonString = person.toString();
                        System.out.println(jsonString);

                        try {
                            String data = httpAPI._jsonRequest("?r=result", jsonString);
                            if (data != null) {
                                Object obj = new JSONParser().parse(data);
                                ArrayList<Map> aMap = (ArrayList<Map>) obj;
                                aMap.stream().forEach((aMap1) -> {
                                    Map<String, String> sData = aMap1;
                                    VBox mainVBox = new VBox();//main VBox
                                    mainVBox.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
                                    mainVBox.setStyle("-fx-border-color: #000000;");
                                    VBox.setMargin(mainVBox, new Insets(5, 2, 2, 2));
                                    HBox hBox1 = new HBox();
                                    HBox hBox2 = new HBox();
                                    Label drID = new Label("Draw");
                                    drID.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold;");
                                    hBox1.setAlignment(Pos.BASELINE_LEFT);
                                    drID.setMaxWidth(Double.POSITIVE_INFINITY);
                                    drID.setMaxHeight(Double.POSITIVE_INFINITY);

                                    HBox.setHgrow(drID, Priority.ALWAYS);
                                    Label drTime = new Label(TimeFormats.timeConvert(sData.get("gameetime")));
                                    drTime.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold;");
                                    drTime.setMaxWidth(Double.POSITIVE_INFINITY);
                                    drTime.setMaxHeight(Double.POSITIVE_INFINITY);
                                    HBox.setHgrow(drTime, Priority.ALWAYS);
                                    hBox1.getChildren().add(drID);
                                    hBox1.getChildren().add(drTime);
                                    mainVBox.getChildren().add(hBox1);
                                    HBox rtable = new HBox();
                                    String ss[] = sData.get("series").split("-");
                                    for (int k = 0; k <= 9; k++) {
                                        int num = (Integer.parseInt(ss[0]) + (k * 100)) + Integer.parseInt(sData.get("" + k));
                                        Label jLable = new Label(" " + num + "");
                                        jLable.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
                                        jLable.setWrapText(true);
                                        jLable.setAlignment(Pos.CENTER);
                                        jLable.setMaxWidth(Double.POSITIVE_INFINITY);
                                        jLable.setMaxHeight(Double.POSITIVE_INFINITY);
                                        jLable.setTextFill(Color.web("#000000"));
                                        //jLable.setText("" + fl);
                                        Pane p = new Pane();
                                        HBox.setMargin(p, new Insets(5, 2, 2, 2));
                                        p.setStyle("-fx-background-color: " + ColorArray[k] + ";");
                                        p.setBackground(new Background(new BackgroundFill(Color.web(ColorArray[k]), CornerRadii.EMPTY, Insets.EMPTY)));
                                        p.setPrefSize(100, 30);
                                        p.setStyle("-fx-border-color: #000000;");

                                        p.getChildren().add(jLable);
                                        rtable.getChildren().add(p);

                                    }
                                    hBox2.getChildren().add(rtable);
                                    mainVBox.getChildren().add(hBox2);
                                    resultPan.getChildren().add(mainVBox);
                                });
                            } else {
                                JOptionPane.showMessageDialog(null, "Please check internet Connection.. Remote Host not connected");
                            }

                        } catch (ParseException | HeadlessException ex) {
                            httpAPI.erLog.write(ex);
                        }
                        System.gc();
                    }
                });
            }
        };
        t.start();

    }

    @FXML
    private void Close(ActionEvent event) {
    }

    void initLoadData(String multi, String text) {
        series.setText(text);
    }

    @FXML
    private void actionBTNClose(MouseEvent event) {
        btnClose.getScene().getWindow().hide();
        System.gc();
    }

    /**
     * Initializes the controller class.
     */
}
