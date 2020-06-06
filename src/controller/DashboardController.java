/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.SeriesClass;
import Sys.TimeFormats;
import Sys.api.httpAPI;
import Sys.invoice.claimJSON;
import Sys.invoice.invoiceJSON;
import Sys.invoice.singleResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class DashboardController {

    @FXML
    public Text clockLabel;
    @FXML
    private Text id;
    @FXML
    private Label userid;
    @FXML
    private Label result;
    @FXML
    private Label operator;
    @FXML
    private Label reprint;
    @FXML
    private Label cancel;
    @FXML
    private Label password;
    @FXML
    private Label complaint;
    @FXML
    private Label singout;
    @FXML
    public TextField printer;
    @FXML
    private Text uid;
    @FXML
    private Text seriesLable;
    @FXML
    public Text drawClock;
    @FXML
    private Text dTime;
    @FXML
    private Label cDate;
    @FXML
    private Text balance;
    @FXML
    private Text last;
    @FXML
    private Text lastamt;
    @FXML
    private TextField subSeriesNo;
    @FXML
    private TextField alls;
    @FXML
    private TextField CMulti;
    @FXML
    private TextField advance;
    @FXML
    private CheckBox multi;
    @FXML
    private CheckBox odd;
    @FXML
    private CheckBox even;
    @FXML
    private CheckBox fixed;
    @FXML
    private CheckBox cross;
    @FXML
    private TextField NSystems;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private Button B0;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button B4;
    @FXML
    private Button B5;
    @FXML
    private Button B6;
    @FXML
    private Button B7;
    @FXML
    private Button B8;
    @FXML
    private Button B9;
    @FXML
    private Button BALL;
    @FXML
    private TextField E_0;
    @FXML
    private TextField E_1;
    @FXML
    private TextField E_2;
    @FXML
    private TextField E_3;
    @FXML
    private TextField E_4;
    @FXML
    private TextField E_5;
    @FXML
    private TextField E_6;
    @FXML
    private TextField E_7;
    @FXML
    private TextField E_8;
    @FXML
    private TextField E_9;
    @FXML
    private TextField E_10;
    @FXML
    private TextField E_11;
    @FXML
    private TextField E_12;
    @FXML
    private TextField E_13;
    @FXML
    private TextField E_14;
    @FXML
    private TextField E_15;
    @FXML
    private TextField E_16;
    @FXML
    private TextField E_17;
    @FXML
    private TextField E_18;
    @FXML
    private TextField E_19;
    @FXML
    private TextField E_20;
    @FXML
    private TextField E_21;
    @FXML
    private TextField E_22;
    @FXML
    private TextField E_23;
    @FXML
    private TextField E_24;
    @FXML
    private TextField E_25;
    @FXML
    private TextField E_26;
    @FXML
    private TextField E_27;
    @FXML
    private TextField E_28;
    @FXML
    private TextField E_29;
    @FXML
    private TextField E_30;
    @FXML
    private TextField E_31;
    @FXML
    private TextField E_32;
    @FXML
    private TextField E_33;
    @FXML
    private TextField E_34;
    @FXML
    private TextField E_35;
    @FXML
    private TextField E_36;
    @FXML
    private TextField E_37;
    @FXML
    private TextField E_38;
    @FXML
    private TextField E_39;
    @FXML
    private TextField E_40;
    @FXML
    private TextField E_41;
    @FXML
    private TextField E_42;
    @FXML
    private TextField E_43;
    @FXML
    private TextField E_44;
    @FXML
    private TextField E_45;
    @FXML
    private TextField E_46;
    @FXML
    private TextField E_47;
    @FXML
    private TextField E_48;
    @FXML
    private TextField E_49;
    @FXML
    private TextField E_50;
    @FXML
    private TextField E_51;
    @FXML
    private TextField E_52;
    @FXML
    private TextField E_53;
    @FXML
    private TextField E_54;
    @FXML
    private TextField E_55;
    @FXML
    private TextField E_56;
    @FXML
    private TextField E_57;
    @FXML
    private TextField E_58;
    @FXML
    private TextField E_59;
    @FXML
    private TextField E_60;
    @FXML
    private TextField E_61;
    @FXML
    private TextField E_62;
    @FXML
    private TextField E_63;
    @FXML
    private TextField E_64;
    @FXML
    private TextField E_65;
    @FXML
    private TextField E_66;
    @FXML
    private TextField E_67;
    @FXML
    private TextField E_68;
    @FXML
    private TextField E_69;
    @FXML
    private TextField E_70;
    @FXML
    private TextField E_71;
    @FXML
    private TextField E_72;
    @FXML
    private TextField E_73;
    @FXML
    private TextField E_74;
    @FXML
    private TextField E_75;
    @FXML
    private TextField E_76;
    @FXML
    private TextField E_77;
    @FXML
    private TextField E_78;
    @FXML
    private TextField E_79;
    @FXML
    private TextField E_80;
    @FXML
    private TextField E_81;
    @FXML
    private TextField E_82;
    @FXML
    private TextField E_83;
    @FXML
    private TextField E_84;
    @FXML
    private TextField E_85;
    @FXML
    private TextField E_86;
    @FXML
    private TextField E_87;
    @FXML
    private TextField E_88;
    @FXML
    private TextField E_89;
    @FXML
    private TextField E_90;
    @FXML
    private TextField E_91;
    @FXML
    private TextField E_92;
    @FXML
    private TextField E_93;
    @FXML
    private TextField E_94;
    @FXML
    private TextField E_95;
    @FXML
    private TextField E_96;
    @FXML
    private TextField E_97;
    @FXML
    private TextField E_98;
    @FXML
    private TextField E_99;
    @FXML
    private TextField B_0;
    @FXML
    private TextField B_1;
    @FXML
    private TextField B_2;
    @FXML
    private TextField B_3;
    @FXML
    private TextField B_4;
    @FXML
    private TextField B_5;
    @FXML
    private TextField B_6;
    @FXML
    private TextField B_7;
    @FXML
    private TextField B_8;
    @FXML
    private TextField B_9;
    @FXML
    private TextField I_0;
    @FXML
    private TextField Q1000_1900;
    @FXML
    private TextField Q2000_2900;
    @FXML
    private TextField Q3000_3900;
    @FXML
    private TextField Q4000_4900;
    @FXML
    private TextField Q5000_5900;
    @FXML
    private TextField Q6000_6900;
    @FXML
    private TextField Q7000_7900;
    @FXML
    private TextField Q8000_8900;
    @FXML
    private TextField Q9000_9900;
    @FXML
    private TextField Q10000_10900;
    @FXML
    private TextField totalqty;
    @FXML
    private TextField A1000_1900;
    @FXML
    private TextField A2000_2900;
    @FXML
    private TextField A3000_3900;
    @FXML
    private TextField A4000_4900;
    @FXML
    private TextField A5000_5900;
    @FXML
    private TextField A6000_6900;
    @FXML
    private TextField A7000_7900;
    @FXML
    private TextField A8000_8900;
    @FXML
    private TextField A9000_9900;
    @FXML
    private TextField A10000_10900;
    @FXML
    private TextField totalamt;
    @FXML
    private Button buy;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button bSeries;
    @FXML
    private TextField claimReader;

    private double xOffset = 0;
    private double yOffset = 0;

    //custome veriable
    public SeriesClass sc = new SeriesClass();
    private final Map<String, Button> buttonMap = new HashMap<>();
    private Map<String, TextField> jField = new HashMap<>();
    private Map<String, TextField> horizontalTextField = new HashMap<>();
    private Map<String, TextField> varticalTextField = new HashMap<>();

    public String NSystem;
    public String SelectedSingleSeries;
    public int LEFT_TO_RIGHT = 1;
    public int RIGHT_TO_LEFT = 2;
    String text;
    int Option;
    int Speed;
    public Map<String, Map> series = new HashMap<>();
    public ArrayList<String> multiSeries = new ArrayList<>();//multi series option
    public ArrayList<Map> advanceDrawArray = new ArrayList<>();//multi series option
    public Map<String, Map> advanceDraw = new HashMap<>();//multi series option
    int interval;
    Timer timer;
    public Map<String, Integer> final_Map;
    public Map<String, TextField> totalField = new HashMap<>();
    public String placeholder = "";
    @FXML
    private TextField I_10;
    @FXML
    private TextField I_20;
    @FXML
    private TextField I_30;
    @FXML
    private TextField I_40;
    @FXML
    private TextField I_50;
    @FXML
    private TextField I_60;
    @FXML
    private TextField I_70;
    @FXML
    private TextField I_80;
    @FXML
    private TextField I_90;
    @FXML
    private VBox resultPane;

    public JSONObject myResponse;
    public String defaultPrinter;
    public String ColorArray[] = new String[]{"#d485c2", "#82b47e", "#7ab4e8", "#5ba36a", "#d98d81", "#b9b1e6", "#ea9e7b", "#a4cc5a", "#c9bdaf", "#17bcbd"};
    public Map<String, String> multiMap = new HashMap<>();
    @FXML
    private Pane msgPanel;
    @FXML
    private Text lastDraw;
    @FXML
    private TextField custome;
    @FXML
    private CheckBox c0;
    @FXML
    private CheckBox c1;
    @FXML
    private CheckBox c2;
    @FXML
    private CheckBox c3;
    @FXML
    private CheckBox c4;
    @FXML
    private CheckBox c5;
    @FXML
    private CheckBox c6;
    @FXML
    private CheckBox c7;
    @FXML
    private CheckBox c8;
    @FXML
    private CheckBox c9;
    private boolean show = false;
    private int totq;
    private int fin;
    private int tota;

    //end
    /**
     * Initializes the controller class.
     *
     * @param myRep
     * @param printers
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//            //printer.setText(DashboardController.defaultPrinter);
//            String data = "{\"status\":\"1\",\"message\":\"login Success..\",\"id\":\"1\",\"userid\":\"20200431\",\"name\":\"kishor\"}";
//            JSONObject myRep = new JSONObject(data);
//            //(data);
//            this.defaultPrinter = "PDF";
//            this.myResponse = myRep;
//            waits(this.myResponse, this.defaultPrinter);
//        } catch (JSONException ex) {
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void initParameter(JSONObject myRep, String printers) {

        this.defaultPrinter = printers;
        this.myResponse = myRep;
        waits(this.myResponse, this.defaultPrinter);
        resetDashboard();
    }

    public void waits(JSONObject myResponse, String printers) {
        try {

            advanceDrawArray = new ArrayList<>();
            NSystems.setVisible(false);
            subSeriesNo.setVisible(false);
            alls.setVisible(false);
            CMulti.setVisible(false);
            advance.setVisible(false);
            start.setVisible(false);
            end.setVisible(false);
            custome.setVisible(false);
            id.setVisible(true);
            printer.setText(defaultPrinter);
            mapButton();
            mapJTextField();
            runNSOutput();
            //this.setLocationRelativeTo(null);
            messageRefreshThread();
            mapVarticalTextField();
            mapHorizontalTextField();
            //JSONObject myResponse = new JSONObject(data);
            //System.out.println("User ID " + myResponse.getString("userid"));
            userid.setText(myResponse.getString("userid"));
            id.setText(myResponse.getString("id"));
            uid.setText(myResponse.getString("name") + " " + myResponse.getString("userid"));
            for (int i = 0; i < 100; i++) {
                TextField jf = jField.get("E_" + i);
                jf.setAlignment(Pos.CENTER);
                jf.setStyle("-fx-border-width:2px;-fx-border-color:#000000;-fx-border-width:2px;");
                jf.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                jf.setOnKeyPressed((e) -> {
                    jf.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
                        if (event.getCode() == KeyCode.TAB) {
                            //System.out.println("Tab pressed");
                            event.consume();
                        }
                    });
                });

                int p = i;
                jf.setOnKeyReleased(e -> keyRelease(e, jf, p));

            }
            selectDefaultSeries(0);
            selectSubSeries(B0);
            setDefaultColorOfInputPoitBox();
            showTimer();
            inisetClockCounter();
            setTotalField();
            updateBalance();
            resultBoard("ALL");
            setLabelColor();
            //loadPrinter();
            lastTransaction();
        } catch (Exception ex) {
            //System.out.println("Error on initParameter " + ex.getMessage());
        }
    }

    //custome code Start from here
    public void selectDefaultSeries(int i) {
        ArrayList<String> temp = new ArrayList<>();
        temp = SeriesClass.series.get(i);

        Iterator litr = temp.listIterator();
        int k = 0;
        while (litr.hasNext()) {
            Button jbutton = buttonMap.get("B" + k);
            jbutton.setText((String) litr.next());
            k++;
        }
        setMainSeries(seriesLable.getText());
    }

    public void selectDefaultSeriesMulti(int i) {
        ArrayList<String> temp = new ArrayList<>();
        temp = SeriesClass.series.get(i);

        Iterator litr = temp.listIterator();
        int k = 0;
        while (litr.hasNext()) {
            Button jbutton = buttonMap.get("B" + k);
            jbutton.setText((String) litr.next());
            k++;
        }
        //Dashboard.setMainSeries(seriesLable.getText());
    }

    public void refreshMessageTimer() {
        try {
        } catch (Exception ex) {
        }
    }

    private void showTimer() {

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    DateFormat f = new SimpleDateFormat("dd-MM-YYYY");
                    Date dobj = new Date();
                    cDate.setText(f.format(dobj));
                    while (true) {
                        DateFormat df = new SimpleDateFormat("hh:mm:ss aa");
                        Date dateobj = new Date();
                        ////System.out.println(df.format(dateobj));
                        clockLabel.setText(df.format(dateobj));
                        Thread.sleep(1000);

                    }
                } catch (InterruptedException ex) {
                    //System.out.println("ShowTimer error " + ex.getMessage());
                }
            }
        };
        t.start();
        ////System.out.println();
    }

    private void mapButton() {
        try {
            buttonMap.put("B0", B0);
            buttonMap.put("B1", B1);
            buttonMap.put("B2", B2);
            buttonMap.put("B3", B3);
            buttonMap.put("B4", B4);
            buttonMap.put("B5", B5);
            buttonMap.put("B6", B6);
            buttonMap.put("B7", B7);
            buttonMap.put("B8", B8);
            buttonMap.put("B9", B9);
        } catch (Exception ex) {

        }
    }

    private void mapHorizontalTextField() {
        try {
            horizontalTextField.put("B_0", B_0);
            horizontalTextField.put("B_1", B_1);
            horizontalTextField.put("B_2", B_2);
            horizontalTextField.put("B_3", B_3);
            horizontalTextField.put("B_4", B_4);
            horizontalTextField.put("B_5", B_5);
            horizontalTextField.put("B_6", B_6);
            horizontalTextField.put("B_7", B_7);
            horizontalTextField.put("B_8", B_8);
            horizontalTextField.put("B_9", B_9);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    public void setTotalField() {
        try {
            totalField.put("Q1000_1900", Q1000_1900);
            totalField.put("A1000_1900", A1000_1900);
            totalField.put("Q2000_2900", Q2000_2900);
            totalField.put("A2000_2900", A2000_2900);
            totalField.put("Q3000_3900", Q3000_3900);
            totalField.put("A3000_3900", A3000_3900);
            totalField.put("Q4000_4900", Q4000_4900);
            totalField.put("A4000_4900", A4000_4900);
            totalField.put("Q5000_5900", Q5000_5900);
            totalField.put("A5000_5900", A5000_5900);
            totalField.put("Q6000_6900", Q6000_6900);
            totalField.put("A6000_6900", A6000_6900);
            totalField.put("Q7000_7900", Q7000_7900);
            totalField.put("A7000_7900", A7000_7900);
            totalField.put("Q8000_8900", Q8000_8900);
            totalField.put("A8000_8900", A8000_8900);
            totalField.put("Q9000_9900", Q9000_9900);
            totalField.put("A9000_9900", A9000_9900);
            totalField.put("Q10000_10900", Q10000_10900);
            totalField.put("A10000_10900", A10000_10900);

        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    private void mapVarticalTextField() {
        try {
            varticalTextField.put("I_0", I_0);
            varticalTextField.put("I_10", I_10);
            varticalTextField.put("I_20", I_20);
            varticalTextField.put("I_30", I_30);
            varticalTextField.put("I_40", I_40);
            varticalTextField.put("I_50", I_50);
            varticalTextField.put("I_60", I_60);
            varticalTextField.put("I_70", I_70);
            varticalTextField.put("I_80", I_80);
            varticalTextField.put("I_90", I_90);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    private void mapJTextField() {
        try {
            jField.put("E_0", E_0);
            jField.put("E_1", E_1);
            jField.put("E_2", E_2);
            jField.put("E_3", E_3);
            jField.put("E_4", E_4);
            jField.put("E_5", E_5);
            jField.put("E_6", E_6);
            jField.put("E_7", E_7);
            jField.put("E_8", E_8);
            jField.put("E_9", E_9);
            jField.put("E_10", E_10);
            jField.put("E_11", E_11);
            jField.put("E_12", E_12);
            jField.put("E_13", E_13);
            jField.put("E_14", E_14);
            jField.put("E_15", E_15);
            jField.put("E_16", E_16);
            jField.put("E_17", E_17);
            jField.put("E_18", E_18);
            jField.put("E_19", E_19);
            jField.put("E_20", E_20);
            jField.put("E_21", E_21);
            jField.put("E_22", E_22);
            jField.put("E_23", E_23);
            jField.put("E_24", E_24);
            jField.put("E_25", E_25);
            jField.put("E_26", E_26);
            jField.put("E_27", E_27);
            jField.put("E_28", E_28);
            jField.put("E_29", E_29);
            jField.put("E_30", E_30);
            jField.put("E_31", E_31);
            jField.put("E_32", E_32);
            jField.put("E_33", E_33);
            jField.put("E_34", E_34);
            jField.put("E_35", E_35);
            jField.put("E_36", E_36);
            jField.put("E_37", E_37);
            jField.put("E_38", E_38);
            jField.put("E_39", E_39);
            jField.put("E_40", E_40);
            jField.put("E_41", E_41);
            jField.put("E_42", E_42);
            jField.put("E_43", E_43);
            jField.put("E_44", E_44);
            jField.put("E_45", E_45);
            jField.put("E_46", E_46);
            jField.put("E_47", E_47);
            jField.put("E_48", E_48);
            jField.put("E_49", E_49);
            jField.put("E_50", E_50);
            jField.put("E_51", E_51);
            jField.put("E_52", E_52);
            jField.put("E_53", E_53);
            jField.put("E_54", E_54);
            jField.put("E_55", E_55);
            jField.put("E_56", E_56);
            jField.put("E_57", E_57);
            jField.put("E_58", E_58);
            jField.put("E_59", E_59);
            jField.put("E_60", E_60);
            jField.put("E_61", E_61);
            jField.put("E_62", E_62);
            jField.put("E_63", E_63);
            jField.put("E_64", E_64);
            jField.put("E_65", E_65);
            jField.put("E_66", E_66);
            jField.put("E_67", E_67);
            jField.put("E_68", E_68);
            jField.put("E_69", E_69);
            jField.put("E_70", E_70);
            jField.put("E_71", E_71);
            jField.put("E_72", E_72);
            jField.put("E_73", E_73);
            jField.put("E_74", E_74);
            jField.put("E_75", E_75);
            jField.put("E_76", E_76);
            jField.put("E_77", E_77);
            jField.put("E_78", E_78);
            jField.put("E_79", E_79);
            jField.put("E_80", E_80);
            jField.put("E_81", E_81);
            jField.put("E_82", E_82);
            jField.put("E_83", E_83);
            jField.put("E_84", E_84);
            jField.put("E_85", E_85);
            jField.put("E_86", E_86);
            jField.put("E_87", E_87);
            jField.put("E_88", E_88);
            jField.put("E_89", E_89);
            jField.put("E_90", E_90);
            jField.put("E_91", E_91);
            jField.put("E_92", E_92);
            jField.put("E_93", E_93);
            jField.put("E_94", E_94);
            jField.put("E_95", E_95);
            jField.put("E_96", E_96);
            jField.put("E_97", E_97);
            jField.put("E_98", E_98);
            jField.put("E_99", E_99);
        } catch (Exception ex) {

        }
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        JOptionPane.showMessageDialog(null, "Simple Information Message" + str);
    }

    public void messageRefreshThread() {
        try {
//            Thread msgThread = new Thread() {
//                @Override
//                public void run() {
//                    setMessageBar();
//                }
//            };
//            msgThread.start();
            setMessageBar();
        } catch (Exception ex) {

        }
    }

    public void setMessageBar() {
        try {
            Thread threadMessageBar = new Thread(() -> {
                Runnable updater = () -> {
                    msgPanel.getChildren().clear();
                    String data = httpAPI._jsonRequest("?r=message", "");
                    Text msg = new Text(data);
                    msg.setFill(Color.RED);
//                    msg.setStrokeWidth(2);
//                    msg.setStroke(Color.RED);
                    msg.setTextOrigin(VPos.TOP);
                    msg.setFont(Font.font(18));
                    msgPanel.getChildren().add(msg);
                    // Get the Width of the Scene and the Text
                    double sceneWidth = msgPanel.getWidth();
                    double textWidth = msg.getLayoutBounds().getWidth();

                    // Define the Durations
                    Duration startDuration = Duration.ZERO;
                    Duration endDuration = Duration.seconds(40);

                    // Create the start and end Key Frames
                    KeyValue startKeyValue = new KeyValue(msg.translateXProperty(), sceneWidth);
                    KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
                    KeyValue endKeyValue = new KeyValue(msg.translateXProperty(), 0 * textWidth);
                    KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);

                    // Create a Timeline
                    Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);
                    // Let the animation run forever
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    // Run the animation
                    timeline.play();
                };

                Platform.runLater(updater);
            });
            threadMessageBar.start();

        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    public void setMainSeries(String Series) {
        Map<String, Map> tempSeries = new HashMap<>();
        series.put(Series, tempSeries);
    }

    public void removeMainSeries(String Series) {
        //Map<String, Map> tempSeries = new HashMap<>();
        series.remove(Series);
    }

    private void unsetSubSeries(String subSeries, String Main) {
        try {
            Map<String, Map> mainSeries = series.get(Main);//get Main   
            Map<String, ArrayList> tempSubSeries = new HashMap<>();
            ArrayList<Map> aMap = new ArrayList<>();
            String s[] = subSeries.split("-");
            tempSubSeries.remove(s[0]);
            mainSeries.remove(s[0]);
            ////System.out.println(mainSeries);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    public void setSubSeries(String subSeries, String Main) {//Mian=1000-1900
        try {
            Map<String, Map> mainSeries = series.get(Main);//get Main   
            Map<String, ArrayList> tempSubSeries = new HashMap<>();
            ArrayList<Map> aMap = new ArrayList<>();
            String s[] = subSeries.split("-");
            tempSubSeries.put(s[0], aMap);
            mainSeries.put(s[0], tempSubSeries);
            ////System.out.println(mainSeries);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }

    }

    public final void setNumber(String index, String value, String Main, String Sub) {
        try {
            if (!isNumeric(value)) {
                value = "0";
            }
            // Map<String, Map> mainSeries = Dashboard.series.get(Main);//Main
            String ss[] = Sub.split("-");
            for (int s = Integer.parseInt(ss[0]); s <= Integer.parseInt(ss[1]); s = s + 100) {
                Map<String, Map> mainSeries = series.get(Main);//Main
                String sp = s + "";
                ////System.out.println(Dashboard.series);
                if (Integer.parseInt(custome.getText()) > 0) {
                    for (Map.Entry<String, Map> mainSer : mainSeries.entrySet()) {
                        //keyor sp ==3100 example
                        Map<String, ArrayList> tempSubSeries = mainSeries.get(mainSer.getKey());//Sub
                        ArrayList<Map> aMap = tempSubSeries.get(mainSer.getKey());//Array
                        boolean flag = false;
                        for (int i = 0; i < aMap.size(); ++i) {
                            Map<String, String> numberTemp = aMap.get(i);
                            for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                                if (finas.getKey().equals(index)) {
                                    if (Integer.parseInt(value) <= 0) {
                                        numberTemp.remove(finas.getKey());
                                    } else {
                                        numberTemp.replace(finas.getKey(), value);
                                    }
                                    flag = true;
                                }
                            }

                        }
                        if (!flag) {
                            Map<String, String> number = new HashMap<>();
                            if (Integer.parseInt(value) > 0) {
                                number.put(index, value);
                                aMap.add(number);
                            }
                        }
//                        System.out.println("Key = " + entry.getKey()
//                                + ", Value = " + entry.getValue());
                    }

                } else {
                    if (mainSeries.get(sp) == null) {
                        setSubSeries(sp, Main);
                    }
                    Map<String, ArrayList> tempSubSeries = mainSeries.get(sp);//Sub
                    ArrayList<Map> aMap = tempSubSeries.get(sp);//Array
                    boolean flag = false;
                    for (int i = 0; i < aMap.size(); ++i) {
                        Map<String, String> numberTemp = aMap.get(i);
                        for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                            if (finas.getKey().equals(index)) {
                                if (Integer.parseInt(value) <= 0) {
                                    numberTemp.remove(finas.getKey());
                                } else {
                                    numberTemp.replace(finas.getKey(), value);
                                }
                                flag = true;
                            }
                        }

                    }
                    if (!flag) {
                        Map<String, String> number = new HashMap<>();
                        if (Integer.parseInt(value) > 0) {
                            number.put(index, value);
                            aMap.add(number);
                        }
                    }
                }
            }
//            Map<String, ArrayList> tempSubSeries = mainSeries.get(ss[0]);//Sub
//            ArrayList<Map> aMap = tempSubSeries.get(ss[0]);//Array
//            Map<String, String> number = new HashMap<>();
//            number.put(index, value);
//            aMap.add(number);

        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }

    }

    public final void setNumberMulti(String index, String value, String Main, String Sub, String state) {
        try {
            if (!isNumeric(value)) {
                value = "0";
            }
            for (String serie : multiSeries) {//{1000-1900,....}
                if (state.equals("true")) {
                    String ss[] = serie.split("-");
                    for (int s = Integer.parseInt(ss[0]); s <= Integer.parseInt(ss[1]); s = s + 100) {
                        Map<String, Map> mainSeries = series.get(serie);//Main
                        String sp = s + "";
                        //System.out.println("MainSeries" + mainSeries);
                        if (mainSeries.get(sp) == null) {
                            setSubSeries(sp, serie);
                        }

                        Map<String, ArrayList> tempSubSeries = mainSeries.get(sp);//Sub
                        ArrayList<Map> aMap = tempSubSeries.get(sp);//Array
                        boolean flag = false;
                        for (int i = 0; i < aMap.size(); ++i) {
                            Map<String, String> numberTemp = aMap.get(i);
                            for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                                if (finas.getKey().equals(index)) {
                                    if (Integer.parseInt(value) <= 0) {
                                        numberTemp.remove(finas.getKey());
                                    } else {
                                        numberTemp.replace(finas.getKey(), value);
                                    }
                                    flag = true;
                                }
                            }

                        }
                        if (!flag) {
                            Map<String, String> number = new HashMap<>();
                            if (Integer.parseInt(value) > 0) {
                                number.put(index, value);
                                aMap.add(number);
                            }
                        }

                    }
                } else {
                    //System.out.println(serie);
                    String ss[] = Sub.split("-");//subseries
                    // //System.out.println(ss);
                    String ser[] = serie.split("-");//selected main
                    Map<String, Map> mainSeries = series.get(serie);//Main
                    int sp = Integer.parseInt(ss[0]) + Integer.parseInt(ser[0]) - 1000;
                    if (Integer.parseInt(custome.getText()) > 0) {
                        for (Map.Entry<String, Map> mainSer : mainSeries.entrySet()) {
                            //keyor sp ==3100 example
                            Map<String, ArrayList> tempSubSeries = mainSeries.get(mainSer.getKey());//Sub
                            ArrayList<Map> aMap = tempSubSeries.get(mainSer.getKey());//Array
                            boolean flag = false;
                            for (int i = 0; i < aMap.size(); ++i) {
                                Map<String, String> numberTemp = aMap.get(i);
                                for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                                    if (finas.getKey().equals(index)) {
                                        if (Integer.parseInt(value) <= 0) {
                                            numberTemp.remove(finas.getKey());
                                        } else {
                                            numberTemp.replace(finas.getKey(), value);
                                        }
                                        flag = true;
                                    }
                                }

                            }
                            if (!flag) {
                                Map<String, String> number = new HashMap<>();
                                if (Integer.parseInt(value) > 0) {
                                    number.put(index, value);
                                    aMap.add(number);
                                }
                            }
//                        System.out.println("Key = " + entry.getKey()
//                                + ", Value = " + entry.getValue());
                        }

                    } else {
                        if (mainSeries.get("" + sp) == null) {
                            setSubSeries("" + sp, serie);
                        }
                        Map<String, ArrayList> tempSubSeries = mainSeries.get("" + sp);//Sub
                        ArrayList<Map> aMap = tempSubSeries.get("" + sp);//Array
                        boolean flag = false;
                        for (int i = 0; i < aMap.size(); ++i) {
                            Map<String, String> numberTemp = aMap.get(i);
                            for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                                if (finas.getKey().equals(index)) {
                                    if (Integer.parseInt(value) <= 0) {
                                        numberTemp.remove(finas.getKey());
                                    } else {
                                        numberTemp.replace(finas.getKey(), value);
                                    }
                                    flag = true;
                                }
                            }

                        }
                        if (!flag) {
                            Map<String, String> number = new HashMap<>();
                            if (Integer.parseInt(value) > 0) {
                                number.put(index, value);
                                aMap.add(number);
                            }
                        }
                    }
                }
            }

        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }

    }

    public <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list 
        for (T element : list) {

            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list 
        return newList;
    }

    public void runNSOutput() {
        try {
            Thread t = new Thread() {

                @Override
                public void run() {
//                    while (true) {
//                        //System.out.println("Modified ArrayList : " + Dashboard.multiSeries);
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ex) {
//                            //System.out.println(ex.getMessage());
//                        }
//                    }

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    while (true) {
                        //System.out.println("Series Map " + series);
                        //String jsonEmp = gson.toJson(multiSeries);
                        //System.out.println("MultiSeries Json " + jsonEmp);
                        //System.out.println("Advance Array " + advanceDrawArray);
                        //calculateTotal();

                        try {
                            Thread.sleep(5000);
                            resetFinalTotal();
                        } catch (InterruptedException ex) {
                            //System.out.println(ex.getMessage());
                        }
                    }
                }
            };
            // t.start();
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    private void BulkNumberWrite(int i, String p, javafx.scene.input.KeyEvent e) {
        // //System.out.println(e.getKeyCode());
        switch (e.getCode().toString()) {
//            case 38:
//
//                break;
//            case 40:
//
//                break;
            case "LEFT"://left
                int tempN = i - 1;
                if (horizontalTextField.get("B_" + tempN) != null) {
                    TextField tpf = horizontalTextField.get("B_" + tempN);
                    tpf.requestFocus();
                }
                break;
            case "RIGHT"://right
                int tempP = i + 1;
                if (horizontalTextField.get("B_" + tempP) != null) {
                    TextField tpf = horizontalTextField.get("B_" + tempP);
                    tpf.requestFocus();
                }
                break;
            default:
                try {
                    if (e.getText().equals("")) {
                        int vartical = 0;//add 10
                        while (i <= 99) {
                            TextField varticalTF = varticalTextField.get("I_" + vartical);
                            TextField jf = jField.get("E_" + i);
                            if (!"".equals(varticalTF.getText())) {
                                int vPoint = Integer.parseInt(varticalTF.getText());
                                int t = vPoint + Integer.parseInt(p);
                                jf.setText(t + "");
                                inputSystem(i, jf);

                            } else {
                                jf.setText(p);
                                inputSystem(i, jf);

                            }
                            i = i + 10;
                            vartical = vartical + 10;
                        }
                    } else if (Integer.parseInt(e.getText()) >= 0 && Integer.parseInt(e.getText()) <= 9) {
                        int vartical = 0;//add 10
                        while (i <= 99) {
                            TextField varticalTF = varticalTextField.get("I_" + vartical);
                            TextField jf = jField.get("E_" + i);
                            if (!"".equals(varticalTF.getText())) {
                                int vPoint = Integer.parseInt(varticalTF.getText());
                                int t = vPoint + Integer.parseInt(p);
                                jf.setText(t + "");
                                inputSystem(i, jf);

                            } else {
                                jf.setText(p);
                                inputSystem(i, jf);

                            }
                            i = i + 10;
                            vartical = vartical + 10;
                        }
                    } else {
                        //JOptionPane.showMessageDialog(this, "Enter Valid Number", "Error Message Box", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    //System.out.println("B Number Error " + ex.getMessage());
                }
                break;
        }

    }

    private void BulkNumberWriteVartical(int i, String p, javafx.scene.input.KeyEvent e) {
        System.out.println(e.getCode().toString());
        switch (e.getCode().toString()) {
            case "UP":
                int tempN = i - 10;
                if (varticalTextField.get("I_" + tempN) != null) {
                    TextField tpf = varticalTextField.get("I_" + tempN);
                    tpf.requestFocus();
                }

                break;
            case "DOWN":
                int tempP = i + 10;
                if (varticalTextField.get("I_" + tempP) != null) {
                    TextField tpfp = varticalTextField.get("I_" + tempP);
                    tpfp.requestFocus();
                }
                break;
            case "LEFT"://left
                break;
            case "RIGHT"://right
                break;
            default:
                try {
                    if (e.getText().equals("")) {
                        int horizontal = 0;//add 10
                        int tp = i + 10;
                        while (i < tp) {
                            TextField varticalTF = horizontalTextField.get("B_" + horizontal);
                            TextField jf = jField.get("E_" + i);
                            // e.getKeyChar();
                            if (!"".equals(varticalTF.getText())) {
                                int vPoint = Integer.parseInt(varticalTF.getText());
                                int t = vPoint + Integer.parseInt(p);
                                jf.setText(t + "");
                                inputSystem(i, jf);
                            } else {
                                jf.setText(p);
                                inputSystem(i, jf);
                            }
                            i++;
                            horizontal++;
                        }
                    } else if (Integer.parseInt(e.getText()) >= 0 && Integer.parseInt(e.getText()) <= 9) {
                        int horizontal = 0;//add 10
                        int tp = i + 10;
                        while (i < tp) {
                            TextField varticalTF = horizontalTextField.get("B_" + horizontal);
                            TextField jf = jField.get("E_" + i);
                            // e.getKeyChar();
                            if (!"".equals(varticalTF.getText())) {
                                int vPoint = Integer.parseInt(varticalTF.getText());
                                int t = vPoint + Integer.parseInt(p);
                                jf.setText(t + "");
                                inputSystem(i, jf);
                            } else {
                                jf.setText(p);
                                inputSystem(i, jf);
                            }
                            i++;
                            horizontal++;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Enter Valid Number", "Error Message Box", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    System.out.println("NUmber only " + ex.getMessage());
                }
                break;
        }

    }

    public final void setDefaultColorOfInputPoitBox() {
        try {
            int i = 0;
            while (i < 100) {
                // //System.out.println("E_" + i);
                TextField jf = jField.get("E_" + i);
                jf.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
                //jf.setStyle("-fx-border-width:2px;-fx-border-color:#000000;");
                //jf.setBackground(Color.WHITE);
                //jf.setFont(new java.awt.Font("Ubuntu", 1, 15));
                i++;
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }
    }

    private void selectSubSeries(Button B0) {
        String btxt = B0.getText();
        subSeriesNo.setText(btxt);
        if (checkSubSeries(btxt, seriesLable.getText())) {

        } else {
            setSubSeries(btxt, seriesLable.getText());
        }

        String s[] = btxt.split("-");

        int end = Integer.parseInt(s[1]);
        int i = 0;
        for (int start = Integer.parseInt(s[0]); start <= end; start++) {
            TextField jf = jField.get("E_" + i);
            //jf.setForeground(Color.GRAY);
            //jf.setBackground(Color.white);
            jf.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
            jf.setText("");
            jf.setPromptText("" + start);

            //jf.setForeground(Color.BLACK);
            // //System.out.println("E_"+start);
            i++;
        }
    }

    private void setDefauldButtonColor() {
        B0.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B1.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B2.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B3.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B4.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B5.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B6.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B7.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B8.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        B9.setStyle("-fx-background-color:#FFFFFF;-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
    }

    private void selectAll(String WHITE) {
        B0.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B0);
        B1.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B1);
        B2.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B2);
        B3.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B3);
        B4.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B4);
        B5.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B5);
        B6.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B6);
        B7.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B7);
        B8.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B8);
        B9.setStyle("-fx-background-color:" + WHITE + ";-fx-border-color: #D3D3D3; -fx-border-radius:2px;");
        //this.selectSubSeries(B9);
    }

    public void resetVarticalInput() {
        I_0.setText("");
        I_10.setText("");
        I_20.setText("");
        I_30.setText("");
        I_40.setText("");
        I_50.setText("");
        I_60.setText("");
        I_70.setText("");
        I_80.setText("");
        I_90.setText("");
    }

    public void resetHorizontalInput() {
        B_0.setText("");
        B_1.setText("");
        B_2.setText("");
        B_3.setText("");
        B_4.setText("");
        B_5.setText("");
        B_6.setText("");
        B_7.setText("");
        B_8.setText("");
        B_9.setText("");
    }

    public void resetClock() {
        try {

            String data = httpAPI._jsonRequest("?r=updateGameRound", "");
            //System.out.println(data);
            JSONObject response = new JSONObject(data);
            buy.setDisable(false);
            id.setText("D_" + response.getString("id"));
            start.setText(response.getString("stime"));
            end.setText(response.getString("etime"));
            String strTime = response.getString("etime");

            dTime.setText(TimeFormats.timeConvert(strTime));
            interval = Integer.parseInt(response.getString("time"));

        } catch (JSONException ex) {
            //System.out.println("Rest clock error " + ex.getMessage());
        }
    }

    public void inisetClockCounter() {
        try {
            String data = httpAPI._jsonRequest("?r=updateGameRound", "");
            //System.out.println("Draw Data " + data);
            JSONObject myResponse = new JSONObject(data);
            buy.setDisable(false);
            id.setText("D_" + myResponse.getString("id"));
            start.setText(myResponse.getString("stime"));
            end.setText(myResponse.getString("etime"));
            String strTime = myResponse.getString("etime");
            dTime.setText(TimeFormats.timeConvert(strTime));
            closckDraw(myResponse.getString("time"));
        } catch (JSONException ex) {
            //System.out.println("inisetClockCounter " + ex.getMessage());
        }
    }

    public void closckDraw(String secs) {

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt(secs);
        ////System.out.println(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                ////System.out.println(formatSeconds(setInterval()));
                drawClock.setText(formatSeconds(setInterval()));

            }
        }, delay, period);
    }

    private int setInterval() {
        if (interval == 10) {
            buy.setDisable(true);
        }
        if (interval == 1) {
            Thread timClock = new Thread(new Runnable() {

                @Override
                public void run() {
                    Runnable updater = new Runnable() {

                        @Override
                        public void run() {
                            try {
                                //System.out.println("Clock Reset Thred sleep 2000");
                                Thread.sleep(2000);
                                //System.out.println("Start Updating Result Board");
                                resultBoard("ALL");
                                //System.out.println("END Updating Result Board");
                            } catch (InterruptedException ex) {
                                //System.out.println("Runnable Teror " + ex.getMessage());
                            }
                        }
                    };
                    resetClock();
                    Platform.runLater(updater);
                }

            });
            timClock.start();
        }
        return --interval;
    }

    public String formatSeconds(int timeInSeconds) {
        int hours = timeInSeconds / 3600;
        int secondsLeft = timeInSeconds - hours * 3600;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String formattedTime = "";
        if (hours < 10) {
            formattedTime += "0";
        }
        formattedTime += hours + ":";

        if (minutes < 10) {
            formattedTime += "0";
        }
        formattedTime += minutes + ":";

        if (seconds < 10) {
            formattedTime += "0";
        }
        formattedTime += seconds;

        return formattedTime;
    }

    public void calculateTotal() {
        try {
            int qty = 0;
            String sr = "";

            final_Map = new HashMap<>();
            for (Map.Entry<String, Map> entry : series.entrySet()) {
                Map<String, ArrayList> test = entry.getValue();
                for (Map.Entry<String, ArrayList> entrys : test.entrySet()) {
                    sr = entry.getKey();
                    Map<String, ArrayList> tp = new HashMap<>();
                    tp = (Map<String, ArrayList>) entrys.getValue();
                    ////System.out.println(tp);
                    for (Map.Entry<String, ArrayList> num : tp.entrySet()) {
                        ////System.out.println(num.getValue());
                        ArrayList<Map> number = num.getValue();
                        for (int i = 0; i < number.size(); i++) {
                            Map<String, String> numF = (number.get(i));
                            for (Map.Entry<String, String> finas : numF.entrySet()) {
                                String userNumber = finas.getValue();
                                if (userNumber.equals("")) {
                                    number.remove(i);
                                } else {
                                    int userQty = Integer.parseInt(userNumber);
                                    qty = qty + userQty;

                                }
                            }
                        }
                    }
                }
                final_Map.put(sr, qty);
                qty = 0;

                ////System.out.println("Key = " + entry.getKey()
                //    + ", Value = " + entry.getValue());
            }
            ////System.out.println(Dashboard.final_Map);
            ////System.out.println("total Qty: " + qty);
            dispalyTotal();
            ////System.out.println(Dashboard.multiSeries);

        } catch (Exception ex) {

        }

    }

    public void dispalyTotal() {
        try {
            int finalQty = 0;
            int finalAmt = 0;
            //Dashboard.ResttotalField();
            for (Map.Entry<String, Integer> entry : final_Map.entrySet()) {
                String newString = entry.getKey().replace("-", "_");
                TextField qtyField = totalField.get("Q" + newString);
                qtyField.setText(entry.getValue() + "");
                TextField amtField = totalField.get("A" + newString);
                amtField.setText((entry.getValue() * 2) + "");
                finalQty = finalQty + entry.getValue();
            }
            if (advance.getText().equals("true")) {
                int nm = advanceDrawArray.size();

                fin = finalQty * 2;
                totq = finalQty;
                tota = fin;

                finalQty = finalQty * nm;
                finalAmt = finalQty * 2;
                totalqty.setText(finalQty + "");
                totalamt.setText(finalAmt + "");
            } else {
                finalAmt = finalQty * 2;
                totalqty.setText(finalQty + "");
                totalamt.setText(finalAmt + "");
            }

        } catch (Exception edx) {

        }
    }

    public void ResttotalField() {
        int i = 1;

        while (i <= 10) {
            int tstart = 1000 * i;
            int tend = tstart * 900;
            String newString = tstart + "_" + tend;
            TextField qtyField = totalField.get("Q" + newString);
            qtyField.setText("");
            TextField amtField = totalField.get("A" + newString);
            amtField.setText("");
            totalqty.setText("");
            totalamt.setText("");
            i++;
        }
    }

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public void inputSystem(int p, TextField jf) {
        try {
            placeholder = jf.getText();
            if (multi.isSelected()) {
                if ("".equals(subSeriesNo.getText()) && multiSeries.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Please select sereis first");
                } else {
                    String index = "" + p;
                    int tQty = 0;
                    int tPoint = 0;

                    switch (NSystems.getText()) {
                        case "cross":
                            ArrayList<String> numb = cross(p);
                            String K;
                            for (String numb1 : numb) {
                                K = numb1;
                                // //System.out.println("Cross K " + K);
                                TextField temp = jField.get("E_" + K);
                                if (Integer.parseInt(K) != p) {
                                    temp.setText(jf.getText());
                                }
                                temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                                index = "" + K;
                                tQty = tQty + Integer.parseInt(jf.getText());
                                if (isNumeric(jf.getText())) {
                                    setNumberMulti(index, jf.getText(), seriesLable.getText(), subSeriesNo.getText(), alls.getText());
                                } else {
                                    setNumberMulti(index, "0", seriesLable.getText(), subSeriesNo.getText(), alls.getText());
                                }
                            }

                            break;
                        case "fixed":
                            try {

                                Map<String, String> jString = new HashMap<>();
                                TextField temp = jField.get("E_" + p);
                                temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                                jString.put("num", p + "");
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                String jsonEmp = gson.toJson(jString);
                                ////System.out.println(jsonEmp);
                                String data = httpAPI._jsonRequest("?r=fpNumber", jsonEmp);
                                // //System.out.println(data);
                                JSONObject myFixRep = new JSONObject(data);

                                int so = 1;
                                while (so <= myFixRep.length()) {

                                    TextField temdp = jField.get("E_" + myFixRep.getString("" + so));
                                    if (Integer.parseInt(myFixRep.getString("" + so)) != p) {
                                        temdp.setText(jf.getText());
                                    }
                                    temdp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                                    setNumberMulti(myFixRep.getString("" + so), temdp.getText(), seriesLable.getText(), subSeriesNo.getText(), alls.getText());

                                    so++;
                                }
                            } catch (JSONException | NumberFormatException ex) {
                                //System.out.println(ex.getMessage());
                            }
                            break;

                        default:
                            index = "" + p;
                            TextField temp = jField.get("E_" + p);
                            temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                            setNumberMulti(index, temp.getText(), seriesLable.getText(), subSeriesNo.getText(), alls.getText());
                            break;
                    }

//                                tPoint = tQty * 2;
//                                Q1000_1900.setText(tQty + "");
//                                A1000_1900.setText(tPoint + "");
                }
            } else {
                String index = "" + p;
                int tQty = 0;
                int tPoint = 0;

                switch (NSystems.getText()) {
                    case "cross":
                        ArrayList<String> numb = cross(p);
                        String K;
                        for (String numb1 : numb) {
                            K = numb1;
                            TextField temp = jField.get("E_" + K);
                            if (Integer.parseInt(K) != p) {
                                temp.setText(jf.getText());
                            }
                            temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                            index = "" + K;
                            tQty = tQty + Integer.parseInt(jf.getText());
                            setNumber(index, jf.getText(), seriesLable.getText(), subSeriesNo.getText());
                        }

                        break;
                    case "fixed":
                        try {
                            Map<String, String> jString = new HashMap<>();
                            TextField temp = jField.get("E_" + p);
                            temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                            jString.put("num", p + "");
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            String jsonEmp = gson.toJson(jString);
                            ////System.out.println(jsonEmp);
                            String data = httpAPI._jsonRequest("?r=fpNumber", jsonEmp);
                            ////System.out.println(data);
                            JSONObject myFixResponNormal = new JSONObject(data);
                            int so = 1;
                            while (so <= myFixResponNormal.length()) {

                                TextField temdp = jField.get("E_" + myFixResponNormal.getString("" + so));
                                if (Integer.parseInt(myFixResponNormal.getString("" + so)) != p) {
                                    temdp.setText(jf.getText());
                                }
                                temdp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                                setNumber(myFixResponNormal.getString("" + so), temdp.getText(), seriesLable.getText(), subSeriesNo.getText());

                                so++;
                            }
                        } catch (JSONException | NumberFormatException ex) {
                            //System.out.println(ex.getMessage());
                        }
                        break;

                    default:
                        index = "" + p;
                        TextField temp = jField.get("E_" + p);
                        temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                        setNumber(index, temp.getText(), seriesLable.getText(), subSeriesNo.getText());
                        break;
                }

            }
            calculateTotal();
        } catch (HeadlessException | NumberFormatException ex) {

        }
    }

    private void getPreviousNumber(Button B0) {
        try {
            TextField temp;
            String MainSeries = seriesLable.getText();
            // //System.out.println(Dashboard.series.get("1000-1900"));
            Map<String, Map> subSeries = series.get(MainSeries);
            ////System.out.println(subSeries.get("1000-1099"));
            String s[] = B0.getText().split("-");
            Map<String, ArrayList> aMap = subSeries.get(s[0]);
            ArrayList<Map> aListMap = aMap.get(s[0]);
            for (Map aListMap1 : aListMap) {
                Map<String, String> fi = aListMap1;
                for (Map.Entry<String, String> entry : fi.entrySet()) {
                    ////System.out.println(entry.getKey());
                    temp = jField.get("E_" + entry.getKey());
                    temp.setText(entry.getValue());
                    temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                }
            }

        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    public void resetFinalTotal() {
        try {
            for (int i = 1000; i <= 10990; i = i + 1000) {
                int t = i + 900;
                ////System.out.println("Q" + i + "_" + t);
//                TextField tm = totalField.get("Q" + i + "_" + t);
//                tm.setText("");
//                tm = totalField.get("A" + i + "_" + t);
//                tm.setText("");

            }
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }

    }

    private boolean checkSubSeries(String btxt, String text) {
        boolean r = false;
        try {
            Map<String, Map> subSeries = series.get(text);
            String s[] = btxt.split("-");
            Map<String, ArrayList> aMap = subSeries.get(s[0]);
            ArrayList<Map> aListMap = aMap.get(s[0]);
            if (aListMap.size() > 0) {
                r = true;
            } else {
                r = false;
            }
        } catch (Exception ex) {

        }
        return r;

    }

    private ArrayList<String> cross(int p) {
        // String index = "" + p;
        ArrayList<String> num = new ArrayList<>();
        try {
            int index = (((p / 10) + 1) * 10) - 1;
            int rightbottom = index - p; //bottom right difference
            int back = (p / 10) * 10;
            int leftbottom = p - back;//bottom left

            num.add("" + p);
            int K = p + 11;
            int s = 1;
            while (K <= 99 && s <= rightbottom) {

                num.add("" + K);
                K = K + 11;
                s++;
            }
            K = p - 11;
            s = 1;
            while (K >= 0 && s <= rightbottom) {

                num.add("" + K);
                K = K - 11;
                s++;
            }
            K = p + 9;
            s = 1;
            while (K <= 99 && s <= leftbottom) {

                num.add("" + K);
                K = K + 9;
                s++;
            }
            K = p - 9;
            s = 1;
            while (K > 0 && s <= leftbottom) {

                num.add("" + K);
                K = K - 9;
                s++;
            }
            //int rightbottom = last - p; //right difference
            //index = "" + p;
            ////System.out.println(num);
        } catch (Exception ex) {

        }
        return num;
    }

    public void runnableBalance() {
        Thread runnabl = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            Map<String, String> jsonData = new HashMap<>();
                            jsonData.put("userid", userid.getText());
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            String jsonEmp = gson.toJson(jsonData);
                            ////System.out.println(jsonEmp);
                            String data = httpAPI._jsonRequest("?r=UpdateBalance", jsonEmp);
                            JSONObject myResponse = new JSONObject(data);
                            if (myResponse.getString("status").equals("1")) {
                                balance.setText(myResponse.getString("balance"));
                            } else {
                                balance.setText(myResponse.getString("balance"));
                            }
                            //Thread.sleep(1000);
                        } catch (JSONException e) {
                            //System.out.println("Balance Thread Error " + e.getMessage());
                        }
                    }
                };
                //resetClock();
                Platform.runLater(updater);
            }

        });
        runnabl.start();
    }

    private void updateBalance() {

        Thread Balance = new Thread() {
            @Override
            public void run() {
                if (true) {
                    try {
                        runnableBalance();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //System.out.println("Balance Thread Error " + e.getMessage());
                    }
                }
            }
        };
        Balance.start();
    }

    public void resetDashboard() {
        Thread resetDB = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        subSeriesNo.setText("");
                        alls.setText("false");
                        CMulti.setText("");
                        NSystems.setText("");
                        multi.setSelected(false);
                        cross.setSelected(false);
                        odd.setSelected(false);
                        even.setSelected(false);
                        fixed.setSelected(false);
                        totalamt.setText("");
                        totalqty.setText("");
                        advance.setText("false");
                        advanceDraw.clear();
                        advanceDrawArray.clear();
                        selectSubSeries(B0);
                        selectAll("#FFFFFF");
                        resetVarticalInput();
                        resetHorizontalInput();
                        if (series.size() >= 0) {
                            series.clear();
                            seriesLable.setText("1000-1900");
                            selectDefaultSeries(0);
                            selectSubSeries(B0);
                        }
                        if (multiSeries.size() >= 0) {
                            multiSeries.clear();
                        }
                        Iterator<String> it = totalField.keySet().iterator();       //keyset is a method  
                        while (it.hasNext()) {
                            String key = (String) it.next();
                            TextField tf = totalField.get(key);
                            tf.setText("");
                        }

                        lastTransaction();
                        calculateTotal();
                        resetManualPlatSeleted();
                        runnableBalance();

                    }
                };
                //resetClock();
                Platform.runLater(updater);
            }

        });
        resetDB.start();
    }

    private void resetAll() {
        try {
            resetDashboard();
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    public void resultBoard(String srs) {
        try {
            resultPane.getChildren().removeAll(resultPane.getChildren());
            Map<String, String> finalMap = new HashMap<>();
            String ids[] = id.getText().split("_");
            finalMap.put("drawid", ids[1]);
            finalMap.put("series", srs);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonEmp = gson.toJson(finalMap);
            ////System.out.println(jsonEmp);
            String Data = httpAPI._jsonRequest("?r=singleResult", jsonEmp);
            //System.out.println("Result" + Data);
            ArrayList<Map> wPoint = singleResult.singleResultJSONPrint(Data);
            int ip = 0;
            int x = 8;
            int y = 5;
            int a = 67;
            int b = 29;
            for (Map wPoint1 : wPoint) {
                Map<String, String> dPoint = wPoint1;
                int ks = 0;
                ////System.out.println("Data \n" + dPoint);
                String subSeries[] = null;
                for (Map.Entry<String, String> finas : dPoint.entrySet()) {
                    if (finas.getKey().equals("series")) {
                        subSeries = finas.getValue().split("-");
                    }
                }
                HBox resutSeBox = new HBox();
                resutSeBox.setMaxWidth(Double.POSITIVE_INFINITY);
                resutSeBox.setMaxHeight(Double.POSITIVE_INFINITY);

                for (Map.Entry<String, String> finas : dPoint.entrySet()) {
                    if (finas.getKey().equals("gameetime")) {
                        lastDraw.setText(TimeFormats.timeConvert(finas.getValue()));
                        //subSeries = finas.getValue().split("-");
                    } else if (finas.getKey().equals("series")) {
                        //subSeries = finas.getValue().split("-");
                    } else {
                        int key = Integer.parseInt(finas.getKey());
                        int i = Integer.parseInt(subSeries[0]) + (100 * key);
                        int fl = i + Integer.parseInt(finas.getValue());
                        ////System.out.println("" + fl);
                        Label jLable = new Label(" " + fl + "");
                        jLable.setStyle("-fx-font-size: 15pt; -fx-font-weight: bold;");
                        jLable.setWrapText(true);
                        jLable.setAlignment(Pos.CENTER);
                        jLable.setMaxWidth(Double.POSITIVE_INFINITY);
                        jLable.setMaxHeight(Double.POSITIVE_INFINITY);
                        jLable.setTextFill(Color.web("#FFFFFF"));
                        //jLable.setText("" + fl);
                        Pane p = new Pane();
                        HBox.setMargin(p, new Insets(1, 1, 1, 1));
                        p.setStyle("-fx-background-color: " + ColorArray[ip] + ";");
                        p.setBackground(new Background(new BackgroundFill(Color.web(ColorArray[ip]), CornerRadii.EMPTY, Insets.EMPTY)));
                        p.setPrefSize(90, 30);
                        p.setStyle("-fx-border-color: #000000;");

                        p.getChildren().add(jLable);
                        resutSeBox.getChildren().add(p);

                        if (ip == 9) {
                            y = 30 + y;
                            x = 8;
                            ip = -1;
                            resultPane.getChildren().add(resutSeBox);
                            resutSeBox = new HBox();
                        } else {
                            x = 68 + x;
                            //break;
                        }
                        ip++;

                        ks++;

                    }
                }
            }

        } catch (Exception ex) {
            //System.out.println("Erron Thread-8 " + ex.getMessage());
        }
//        try {
//            Thread t = new Thread() {
//                @Override
//                public void run() {
//                    if (true) {
//                        
//                    }
//                }
//            };
//            t.start();
//        } catch (Exception ex) {
//            //System.out.println();
//        }
    }

    public void setLabelColor() {
//        result.setOpaque(true);
//        result.setBackground(new java.awt.Color(141, 235, 237));
//        account.setOpaque(true);
//        account.setBackground(new java.awt.Color(141, 235, 237));
//        operator.setOpaque(true);
//        operator.setBackground(new java.awt.Color(141, 235, 237));
//        reprint.setOpaque(true);
//        reprint.setBackground(new java.awt.Color(141, 235, 237));
//        cancel.setOpaque(true);
//        cancel.setBackground(new java.awt.Color(141, 235, 237));
//        password.setOpaque(true);
//        password.setBackground(new java.awt.Color(141, 235, 237));
//        complaint.setOpaque(true);
//        complaint.setBackground(new java.awt.Color(141, 235, 237));
//        singout.setOpaque(true);
//        singout.setBackground(new java.awt.Color(141, 235, 237));

    }

    public void loadPrinter() {
        try {
//            printer.setVisible(true);
//            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
//
//            PrintService printServices[] = PrintServiceLookup.lookupPrintServices(
//                    flavor, pras);
//            boolean flag = true;
//            int ip = 0;
//            int x = 10;
//            int y = 20;
//            int a = 100;
//            int b = 15;
//            ButtonGroup bg = new ButtonGroup();
//            for (PrintService printerService : printServices) {
//                JRadioButton jButtong = new JRadioButton(printerService.getName());
//                if (flag) {
//                    jButtong.setBounds(x, y, a, b);
//                    jButtong.setSelected(true);
//                    flag = false;
//                    printer.setText(printerService.getName());
//                } else {
//                    jButtong.setBounds(x, y, a, b);
//                }
//                jButtong.setBackground(new Color(255, 255, 255));
//                jButtong.setText(printerService.getName());
//                jButtong.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        printer.setText(jButtong.getText());
//                    }
//                });
//                if (ip == 0) {
//                    y = 15 + y;
//                    x = 10;
//                    ip = -1;
//                } else {
//                    x = 100 + x;
//                    //break;
//                }
//                ip++;
//                bg.add(jButtong);
//                printerPanel.add(jButtong);

            ////System.out.println("Printer = " + printerService.getName());
            //    }
        } catch (Exception ex) {

        }
    }

    public void lastTransaction() {
        try {
            Map<String, String> finalMap = new HashMap<>();
            finalMap.put("userid", userid.getText());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String finalData = gson.toJson(finalMap);
            String data = httpAPI._jsonRequest("?r=lastTransaction", finalData);
            JSONObject myrep = new JSONObject(data);
            last.setText(myrep.getString("last"));
            lastamt.setText("Rs. " + myrep.getString("lastamt"));
        } catch (Exception ex) {

        }
    }

    //public String ColorArray[] = new String[]{"#ED5DE2", "#46B0D8", "#74CDEF", "#F3F4A5", "#A5E87B", "#ED5DE2", "#46B0D8", "#74CDEF", "#F3F4A5", "#A5E87B"};
    @FXML
    private void ActionB0(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B0.setStyle("-fx-background-color:" + ColorArray[0] + ";");
        this.selectSubSeries(B0);
        this.getPreviousNumber(B0);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB1(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B1.setStyle("-fx-background-color:" + ColorArray[1] + ";");
        this.selectSubSeries(B1);
        this.getPreviousNumber(B1);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB2(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B2.setStyle("-fx-background-color:" + ColorArray[2] + ";");
        this.selectSubSeries(B2);
        this.getPreviousNumber(B2);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB3(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B3.setStyle("-fx-background-color:" + ColorArray[3] + ";");
        this.selectSubSeries(B3);
        this.getPreviousNumber(B3);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB4(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B4.setStyle("-fx-background-color:" + ColorArray[4] + ";");
        this.selectSubSeries(B4);
        this.getPreviousNumber(B4);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB5(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B5.setStyle("-fx-background-color:" + ColorArray[5] + ";");
        this.selectSubSeries(B5);
        this.getPreviousNumber(B5);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB6(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B6.setStyle("-fx-background-color:" + ColorArray[6] + ";");
        this.selectSubSeries(B6);
        this.getPreviousNumber(B6);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB7(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B7.setStyle("-fx-background-color:" + ColorArray[7] + ";");
        this.selectSubSeries(B7);
        this.getPreviousNumber(B7);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB8(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B8.setStyle("-fx-background-color:" + ColorArray[8] + ";");
        this.selectSubSeries(B8);
        this.getPreviousNumber(B8);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionB9(javafx.event.ActionEvent event) {
        this.setDefauldButtonColor();
        B9.setStyle("-fx-background-color:" + ColorArray[9] + ";");
        this.selectSubSeries(B9);
        this.getPreviousNumber(B9);
        resetVarticalInput();
        resetHorizontalInput();
        alls.setText("false");
        buttonClickResetCheckOption();
    }

    @FXML
    private void ActionAll(javafx.event.ActionEvent event) {
        if (alls.getText().equals("true")) {
            alls.setText("false");
            selectAll("#FFFFFF");
            subSeriesNo.setText("");
        } else {
            alls.setText("true");
            selectAll("#00FFFF");
            custome.setText(String.valueOf(0));
            resetManualPlatSeleted();
            subSeriesNo.setText(seriesLable.getText());
        }
    }

    @FXML
    private void ActionMulti(javafx.event.ActionEvent event) {
        if (multi.isSelected()) {
            CMulti.setText("Multi");
            multiSeries = new ArrayList<>();
            multiSeries.add("1000-1900");
            //series.clear();
        } else {
            CMulti.setText("");

            //Dashboard.setMainSeries("1000-1900");
        }
    }

    @FXML
    private void ActionOdd(javafx.event.ActionEvent event) {
        if (odd.isSelected()) {

            even.setSelected(false);

        }
        oddEven();
    }

    @FXML
    private void ActionEven(javafx.event.ActionEvent event) {
        if (even.isSelected()) {

            odd.setSelected(false);

        }
        oddEven();
    }

    public void oddEven() {
        if (even.isSelected()) {
            int i = 0;
            while (i < 100) {
                TextField temp = jField.get("E_" + i);
                if (i % 2 == 0) {
                    temp.setDisable(true);
                }
                i++;
            }
            odd.setSelected(false);

        } else {
            int i = 0;
            while (i < 100) {
                TextField temp = jField.get("E_" + i);
                if (i % 2 == 0) {
                    temp.setDisable(false);
                }
                i++;

            }
        }
        if (odd.isSelected()) {
            int i = 0;
            while (i < 100) {
                TextField temp = jField.get("E_" + i);
                if (i % 2 != 0) {
                    temp.setDisable(true);
                }
                i++;
            }
            even.setSelected(false);

        } else {
            int i = 0;
            while (i < 100) {
                TextField temp = jField.get("E_" + i);
                if (i % 2 != 0) {
                    temp.setDisable(false);
                }
                i++;

            }
        }
    }

    @FXML
    private void ActionFixed(javafx.event.ActionEvent event) {
        if (fixed.isSelected()) {
            NSystems.setText("fixed");
            //multi.setSelected(false);
            //odd.setSelected(false);
            //even.setSelected(false);
            cross.setSelected(false);
        } else {
            NSystems.setText("");
        }
    }

    @FXML
    private void ActionCross(javafx.event.ActionEvent event) {
        if (cross.isSelected()) {
            NSystems.setText("cross");
            //multi.setSelected(false);
            //odd.setSelected(false);
            //even.setSelected(false);
            fixed.setSelected(false);
        } else {
            NSystems.setText("");
        }
    }

    @FXML
    private void ActionBuy(javafx.event.ActionEvent event) {
        this.setMessageBar();

        try {
            Thread t = new Thread() {
                String msg = "";

                @Override
                public void run() {
                    try {
                        String qt = totalqty.getText();
                        String am = totalamt.getText();

                        if (qt.equals("") && am.equals("")) {
                            qt = "0";
                            am = "0";
                        }
                        if (Integer.parseInt(qt) <= 0 && Integer.parseInt(am) <= 0) {
                            JOptionPane.showMessageDialog(null, "Please fill lottry point");

                        } else {

                            if (advance.getText().equals("true")) {
                                for (int i = 0; i < advanceDrawArray.size(); i++) {
                                    qt = String.valueOf(totq);
                                    am = String.valueOf(tota);
                                    Map<String, String> advanceDraw = advanceDrawArray.get(i);
                                    Map<String, Map> finalMap = new HashMap<>();
                                    Map<String, String> data = new HashMap<>();
                                    data.put("userid", userid.getText());

                                    data.put("drawid", advanceDraw.get("gametimeid"));
                                    data.put("totalqty", qt);
                                    data.put("totalamt", am);
                                    data.put("perPoint", "2");
                                    data.put("start", advanceDraw.get("gametime"));
                                    data.put("end", advanceDraw.get("gameendtime"));
                                    data.put("ip", "127.0.0.1");
                                    finalMap.put("basic", data);
                                    finalMap.put("data", series);
                                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                    String jsonEmp = gson.toJson(finalMap);
                                    //System.out.println(jsonEmp);

                                    String Data = httpAPI._jsonRequest("?r=invoice", jsonEmp);
                                    //System.out.println("Data \n" + Data);
                                    invoiceJSON iJ = new invoiceJSON();
                                    msg = iJ.invoiceJSONPrint(Data, printer.getText());
                                    lastTransaction();
                                }
                            } else {
                                Map<String, Map> finalMap = new HashMap<>();
                                Map<String, String> data = new HashMap<>();
                                data.put("userid", userid.getText());
                                String did[] = id.getText().split("_");
                                data.put("drawid", did[1]);
                                data.put("totalqty", totalqty.getText());
                                data.put("totalamt", totalamt.getText());
                                data.put("perPoint", "2");
                                data.put("start", start.getText());
                                data.put("end", end.getText());
                                data.put("ip", "127.0.0.1");
                                finalMap.put("basic", data);
                                finalMap.put("data", series);
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                String jsonEmp = gson.toJson(finalMap);
                                //System.out.println(jsonEmp);
                                String Data = httpAPI._jsonRequest("?r=invoice", jsonEmp);
                                //System.out.println("Data \n" + Data);
                                //invoiceJSON.invoiceJSONPrint(Data,printer.getText());
                                invoiceJSON iJ = new invoiceJSON();
                                msg = iJ.invoiceJSONPrint(Data, printer.getText());
                                lastTransaction();

                            }

                            JOptionPane.showMessageDialog(null, msg);

                        }

                        resetAll();
                        buy.setDisable(false);
                    } catch (Exception ex) {
                        //System.out.println(ex.getMessage());
                    }
                }

            };
            buy.setDisable(true);
            t.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception message " + ex.getMessage());

        }
    }

    @FXML
    private void Actionb2(javafx.event.ActionEvent event) {
        //msgPanel
        resultBoard("ALL");
        resetAll();
        setMessageBar();

    }

    private void keyRelease(javafx.scene.input.KeyEvent e, TextField jf, int p) {
        //System.out.println(e.getText());
        switch (e.getCode().toString()) {
            case "DOWN"://down
                int down = p + 10;
                if (down < 100) {
                    TextField dwnjf = jField.get("E_" + down);
                    dwnjf.requestFocus();
                }
                break;
            case "UP"://up
                int up = p - 10;
                if (up > 0) {
                    TextField dwnjf = jField.get("E_" + up);
                    dwnjf.requestFocus();
                }
                break;
            case "LEFT"://left
                int left = p - 1;
                if (left > 0 && left < 100) {
                    TextField dwnjf = jField.get("E_" + left);
                    dwnjf.requestFocus();
                }
                break;
            case "RIGHT"://right
                int right = p + 1;
                if (right > 0 && right < 100) {
                    TextField dwnjf = jField.get("E_" + right);
                    dwnjf.requestFocus();
                }
                break;
            default:
                inputSystem(p, jf);
                break;
        }
//
//        jf.setText(placeholder);
    }

    @FXML
    private void actionOnResultUpdate(javafx.event.ActionEvent event) {
        try {
            if (multi.isSelected()) {
                //call default
                //resultBoard("ALL");
            } else {
                /// single display
                //resultBoard(seriesLable.getText());
            }
            resultBoard("ALL");
        } catch (Exception ed) {

        }
    }

    @FXML
    private void selectSeriesAction(MouseEvent event) {
        try {
            openSeries();
        } catch (Exception ex) {
            //System.out.println("Seect Series Action Error " + ex.getMessage());
        }
    }

    public void openSeries() {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                if (multi.isSelected()) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/series.fxml"));
                        Parent root = loader.load();
                        SeriesController Scl = loader.getController();
                        Scl.initLoadData("multi", multiMap);
                        Stage stage = new Stage();
                        Screen screen = Screen.getPrimary();
                        Rectangle2D bounds = screen.getVisualBounds();
                        stage.setX(bounds.getMinX());
                        stage.setY(bounds.getMinY());
                        stage.setWidth(bounds.getWidth());
                        stage.setHeight(bounds.getHeight());
                        stage.setScene(new Scene(root));
                        themStyle(stage, root);
                        stage.setTitle("Series");
                        stage.setOnHidden(evt -> multiMap = Scl.getText());
                        stage.showAndWait();
                        loadSeries(multiMap);
                    } catch (IOException ex) {
                        //System.out.println("Multi if Error " + ex.getMessage());
                    }
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/series.fxml"));
                        Parent root = loader.load();
                        SeriesController SC = loader.getController();
                        SC.initLoadData("single", multiMap);

                        //Show scene 2 in new window
                        Stage stage = new Stage();
                        Screen screen = Screen.getPrimary();
                        Rectangle2D bounds = screen.getVisualBounds();
                        stage.setX(bounds.getMinX());
                        stage.setY(bounds.getMinY());
                        stage.setWidth(bounds.getWidth());
                        stage.setHeight(bounds.getHeight());
                        stage.setScene(new Scene(root));
                        themStyle(stage, root);
                        stage.setTitle("Select Sereis");
                        stage.setOnHidden(evt -> multiMap = SC.getText());
                        stage.showAndWait();
                        loadSeries(multiMap);
                        resetManualPlatSeleted();
                    } catch (IOException ex) {
                        //System.out.println("Multi else Error " + ex.getMessage());
                    }
                }

            };

            Platform.runLater(updater);
        });
        openThread.start();

    }

    private void loadSeries(Map<String, String> multiMap) {
        try {
            //System.out.println("Selected Series " + multiMap);
            series.clear();
            multiSeries.clear();
            for (Map.Entry<String, String> entry : multiMap.entrySet()) {
                multiSeries.add(entry.getValue());
                SelectedSingleSeries = entry.getKey() + "";
                seriesLable.setText(entry.getValue());
                if (!multi.isSelected()) {

                    selectDefaultSeriesMulti(Integer.parseInt(entry.getKey()));
                    selectSubSeries(B0);
                } else {
                    selectDefaultSeriesMulti(0);
                }
                setMainSeries(entry.getValue());
            }
            //System.out.println("Series " + series);
            //System.out.println("MultiSeries " + multiSeries);
        } catch (Exception ex) {
            //System.out.println("LoadSeris " + ex.getMessage());
        }
    }

    @FXML
    private void ActionB_0(javafx.scene.input.KeyEvent event) {
        try {
            int i = 0;
            BulkNumberWrite(i, B_0.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_1(javafx.scene.input.KeyEvent event) {
        try {
            int i = 1;
            BulkNumberWrite(i, B_1.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_2(javafx.scene.input.KeyEvent event) {
        try {
            int i = 2;
            BulkNumberWrite(i, B_2.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_3(javafx.scene.input.KeyEvent event) {
        try {
            int i = 3;
            BulkNumberWrite(i, B_3.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_4(javafx.scene.input.KeyEvent event) {
        try {
            int i = 4;
            BulkNumberWrite(i, B_4.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_5(javafx.scene.input.KeyEvent event) {
        try {
            int i = 5;
            BulkNumberWrite(i, B_5.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_6(javafx.scene.input.KeyEvent event) {
        try {
            int i = 6;
            BulkNumberWrite(i, B_6.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_7(javafx.scene.input.KeyEvent event) {
        try {
            int i = 7;
            BulkNumberWrite(i, B_7.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_8(javafx.scene.input.KeyEvent event) {
        try {
            int i = 8;
            BulkNumberWrite(i, B_8.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_9(javafx.scene.input.KeyEvent event) {
        try {
            int i = 9;
            BulkNumberWrite(i, B_9.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionI0(javafx.scene.input.KeyEvent event) {
        try {
            int i = 0;
            BulkNumberWriteVartical(i, I_0.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI1(javafx.scene.input.KeyEvent event) {
        try {
            int i = 10;
            BulkNumberWriteVartical(i, I_10.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI2(javafx.scene.input.KeyEvent event) {
        try {
            int i = 20;
            BulkNumberWriteVartical(i, I_20.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI3(javafx.scene.input.KeyEvent event) {
        try {
            int i = 30;
            BulkNumberWriteVartical(i, I_30.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI4(javafx.scene.input.KeyEvent event) {
        try {
            int i = 40;
            BulkNumberWriteVartical(i, I_40.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI5(javafx.scene.input.KeyEvent event) {
        try {
            int i = 50;
            BulkNumberWriteVartical(i, I_50.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI6(javafx.scene.input.KeyEvent event) {
        try {
            int i = 60;
            BulkNumberWriteVartical(i, I_60.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI7(javafx.scene.input.KeyEvent event) {
        try {
            int i = 70;
            BulkNumberWriteVartical(i, I_70.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI8(javafx.scene.input.KeyEvent event) {
        try {
            int i = 80;
            BulkNumberWriteVartical(i, I_80.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI9(javafx.scene.input.KeyEvent event) {
        try {
            int i = 90;
            BulkNumberWriteVartical(i, I_90.getText(), event);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void selectSeriesActionbtn(javafx.event.ActionEvent event) {
        try {
            openSeries();
        } catch (Exception ex) {
            //System.out.println("Seect Series Action Error btn " + ex.getMessage());
        }
    }

    @FXML
    private void opneAdvanceDrawSelecter(javafx.event.ActionEvent event) {
        try {
            openAdvance();
        } catch (Exception ex) {
            //System.out.println("Seect Advance Action Error " + ex.getMessage());
        }
    }

    private void openAdvance() {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/advance.fxml"));
                    Parent root = loader.load();
                    AdvanceController Scl = loader.getController();
                    Scl.initLoadData(advanceDraw);
                    Stage stage = new Stage();
                    stage.setTitle("Select Advance Draw");
                    Screen screen = Screen.getPrimary();
                    Rectangle2D bounds = screen.getVisualBounds();
                    stage.setX(bounds.getMinX());
                    stage.setY(bounds.getMinY());
                    stage.setWidth(bounds.getWidth());
                    stage.setHeight(bounds.getHeight());
                    stage.setScene(new Scene(root));
//            stage.setMaximized(true);
//            stage.setFullScreen(true);
//            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                    themStyle(stage, root);
                    stage.showAndWait();
                    System.out.println("Advance Selected Draw " + advanceDraw);
                    advanceDrawArray = new ArrayList<>();
                    advanceDraw.entrySet().stream().forEach((entry) -> {
                        advanceDrawArray.add(entry.getValue());
                    });

                    if (!advanceDrawArray.isEmpty()) {
                        advance.setText("true");
                    } else {
                        advance.setText("false");
                    }
                    //System.out.println("AdvanceDrawArray " + advanceDrawArray);
                    //loadSeries(multiMap);
                } catch (Exception ex) {
                    //System.out.println("Seect iit load Advance Action Error " + ex.getMessage());
                }

            };

            Platform.runLater(updater);
        });
        openThread.start();

    }

    public void openResult() {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/result.fxml"));
                    Parent root = loader.load();
                    ResultController Scl = loader.getController();
                    Scl.initLoadData("multi", seriesLable.getText());
                    Stage stage = new Stage();
                    Screen screen = Screen.getPrimary();
                    Rectangle2D bounds = screen.getVisualBounds();
                    stage.setX(bounds.getMinX());
                    stage.setY(bounds.getMinY());
                    stage.setWidth(bounds.getWidth());
                    stage.setHeight(bounds.getHeight());
                    stage.setScene(new Scene(root));
                    themStyle(stage, root);
                    stage.setTitle("Result Borad");
                    //stage.setOnHidden(evt -> multiMap = Scl.getText());
                    stage.showAndWait();
                    //loadSeries(multiMap);
                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            };

            Platform.runLater(updater);
        });
        openThread.start();

    }

    @FXML
    private void showResultBoard(MouseEvent event) {
        openResult();
    }

    @FXML
    private void actionChangePassword(MouseEvent event) {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/changepassword.fxml"));
                    Parent root = loader.load();
                    ChangepasswordController Scl = loader.getController();
                    Scl.initLoadData(userid.getText());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Change Password");
                    stage.initStyle(StageStyle.TRANSPARENT);
                    //themStyle(stage, root);
                    stage.showAndWait();

                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            };

            Platform.runLater(updater);
        });
        openThread.start();

    }

    public void themStyle(Stage stage, Parent root) {
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        //stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            //stage.initStyle(StageStyle.UNDERDECORATED);

        //grab your root here
//        root.setOnMousePressed((MouseEvent event1) -> {
//            xOffset = event1.getSceneX();
//            yOffset = event1.getSceneY();
//        });
//
//        //move around here
//        root.setOnMouseDragged((MouseEvent event1) -> {
//            stage.setX(event1.getScreenX() - xOffset);
//            stage.setY(event1.getScreenY() - yOffset);
//        });
    }

    @FXML
    private void reprintTicketAction(MouseEvent event) {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/reprintTicket.fxml"));
                    Parent root = loader.load();
                    ReprintTicketController Scl = loader.getController();
                    Scl.initLoadData(userid.getText(), printer.getText());
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

                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            };

            Platform.runLater(updater);
        });
        openThread.start();
    }

    @FXML
    private void cancelTicketAction(MouseEvent event) {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cancelTicket.fxml"));
                    Parent root = loader.load();
                    CancelTicketController Scl = loader.getController();
                    String drawid[] = id.getText().split("_");
                    Scl.initLoadData(userid.getText(), printer.getText(), drawid[1]);
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

                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            };

            Platform.runLater(updater);
        });
        openThread.start();

    }

    @FXML
    private void operatorAction(MouseEvent event) {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/oprator.fxml"));
                    Parent root = loader.load();
                    OpratorController Scl = loader.getController();
                    Scl.initLoadData(userid.getText(), printer.getText());
                    Stage stage = new Stage();
                    Screen screen = Screen.getPrimary();
                    Rectangle2D bounds = screen.getVisualBounds();
                    stage.setX(bounds.getMinX());
                    stage.setY(bounds.getMinY());
                    stage.setWidth(bounds.getWidth());
                    stage.setHeight(bounds.getHeight());
                    stage.setScene(new Scene(root));
                    themStyle(stage, root);
                    stage.setTitle("Reprint Ticket");
                    stage.showAndWait();

                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            };

            Platform.runLater(updater);
        });
        openThread.start();

    }

    @FXML
    private void singoutAction(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            stage.setScene(new Scene(root));
            themStyle(stage, root);
            stage.setTitle("Login");
            stage.show();
            singout.getScene().getWindow().hide();

        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void barcodeAction(KeyEvent event) {
        if ("ENTER".equals(event.getCode().toString())) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        Map<String, String> finalMap = new HashMap<>();
                        finalMap.put("id", claimReader.getText());
                        finalMap.put("userid", userid.getText());
                        String did[] = id.getText().split("_");
                        finalMap.put("gameid", did[1]);
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonEmp = gson.toJson(finalMap);
                        ////System.out.println(jsonEmp);
                        String data = httpAPI._jsonRequest("?r=checkWinner", jsonEmp);
                        System.out.println(data);
                        String msg = claimJSON.claimJSONPrint(data, printer.getText());
                        claimMessageBox(msg);
                        //JOptionPane.showMessageDialog(null, msg);
                        claimReader.setText("");
                        runnableBalance();
                    } catch (Exception ex) {
                        //System.out.println("Error on ClaimReadr Exceptione " + ex.getMessage());
                    }
                }

                private void claimMessageBox(String msg) {
                    Thread claimMessage = new Thread(() -> {
                        Runnable updater = () -> {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/claim.fxml"));
                                Parent root = loader.load();
                                ClaimController Scl = loader.getController();
                                Scl.initLoadData(msg);
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.setTitle("Claim");
                                stage.initStyle(StageStyle.TRANSPARENT);
                                //themStyle(stage, root);
                                stage.showAndWait();

                            } catch (IOException ex) {
                                Logger.getLogger(DashboardController.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        };

                        Platform.runLater(updater);
                    });
                    claimMessage.start();

                }
            };
            t.start();
        }
    }

    @FXML
    private void action_c0(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B0, c0);
    }

    @FXML
    private void action_c1(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B1, c1);
    }

    @FXML
    private void action_c2(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B2, c2);
    }

    @FXML
    private void action_c3(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B3, c3);
    }

    @FXML
    private void action_c4(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B4, c4);
    }

    @FXML
    private void action_c5(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B5, c5);
    }

    @FXML
    private void action_c6(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B6, c6);
    }

    @FXML
    private void action_c7(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B7, c7);
    }

    @FXML
    private void action_c8(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B8, c8);
    }

    @FXML
    private void action_c9(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(event, B9, c9);
    }

    private void singleDrawPlatSelected(javafx.event.ActionEvent event, Button B0, CheckBox c0) {
        try {
            int count = Integer.parseInt(custome.getText());
            if (c0.isSelected()) {
                if (multi.isSelected()) {
                    //System.out.println("MultiSeries Array" + multiSeries);
                    for (int i = 0; i < multiSeries.size(); i++) {
                        //i got form button text emx 1000-1099 but my series is 3000-3900
                        //1100+3000-1000=3100
                        //
                        int Default = 1000;
                        String mult[] = multiSeries.get(i).split("-");
                        String bSplit[] = B0.getText().split("-");
                        int first = Integer.parseInt(bSplit[0]) + Integer.parseInt(mult[0]) - Default;
                        int second = first + 99;
                        String cTxt = String.valueOf(first) + "-" + String.valueOf(second);
                        setSubSeries(cTxt, multiSeries.get(i));
                    }
                } else {
                    setSubSeries(B0.getText(), seriesLable.getText());
                }
                count++;
            } else {
                unsetSubSeries(B0.getText(), seriesLable.getText());
                count--;
            }
            custome.setText(String.valueOf(count));
        } catch (Exception ex) {

        }
    }

    private void resetManualPlatSeleted() {
        try {
            custome.setText(String.valueOf(0));
            c0.setSelected(false);
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
            c5.setSelected(false);
            c6.setSelected(false);
            c7.setSelected(false);
            c8.setSelected(false);
            c9.setSelected(false);
        } catch (Exception e) {

        }
    }

    private void buttonClickResetCheckOption() {
        resetManualPlatSeleted();

    }

    @FXML
    private void showandhide(MouseEvent event) {
        if (show) {
            balance.setText("*****");
            show = false;
        } else {
            runnableBalance();
            show = true;
        }
    }

}
