/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.Sereis.seriesData;
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
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    private final double xOffset = 0;
    private final double yOffset = 0;

    //custome veriable
    public SeriesClass sc = new SeriesClass();
    private final Map<String, Button> buttonMap = new HashMap<>();
    private final Map<String, CheckBox> checkBoxMap = new HashMap<>();
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
    public int interval = 0;
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
    //private Pane msgPanel;
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
    private Map pevirous = new HashMap<>();
    private String seriesStringData;
    private String advanceDrawData;
    @FXML
    private Label allSelect;
    private Integer perPoint = 2;
    public String mybalance = "";
    private boolean allCheckSelect = false;
    private int[] allCheckNo = {25, 20, 10, 5, 5, 3, 2, 1, 1, 25};
    @FXML
    private Text msgs;
    @FXML
    private VBox msgPanel;

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
        Thread t = new Thread() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            defaultPrinter = printers;
                            myResponse = myRep;
                            pevirous.put("last", new TextField(""));
                            waits(myResponse, defaultPrinter);
                            resetDashboard();
                        } catch (Exception ex) {

                        }
                    }
                });
            }
        };
        t.start();

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
            mapCheckBox();
            mapJTextField();
            inisetClockCounter();
            //runNSOutput();
            //this.setLocationRelativeTo(null);
            messageRefreshThread();
            mapVarticalTextField();
            mapHorizontalTextField();
            //JSONObject myResponse = new JSONObject(data);
            ////System.out.println("User ID " + myResponse.getString("userid"));
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
                            ////System.out.println("Tab pressed");
                            event.consume();
                        } else if (event.getCode() == KeyCode.F6) {
                            System.out.println("Tab pressed F6");
                            javafx.event.ActionEvent et = null;
                            //ActionBuy(et);
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
            //inisetClockCounter();
            setTotalField();
            updateBalance();
            resultBoard("ALL");
            setLabelColor();
            //loadPrinter();
            lastTransaction();
            loadSeriesData();
            loadAdvanceDraw();
            System.out.println("DAta" + seriesStringData);
            System.gc();
        } catch (Exception ex) {
            ////System.out.println("Error on initParameter " + ex.getMessage());
        }
    }

    //custome code Start from here
    public void selectDefaultSeries(int i) {
        Thread thread = new Thread(() -> {
            Runnable updater = () -> {
                synchronized (DashboardController.this) {
                    ArrayList<String> temp;
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
            };
            Platform.runLater(updater);
        });
        thread.start();

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
        DateFormat f = new SimpleDateFormat("dd-MM-YYYY");
        Date dobj = new Date();
        cDate.setText(f.format(dobj));
        clockLabel.setText(f.format(dobj));
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                while (true) {
//                    synchronized (this) {
//                        Calendar cal = new GregorianCalendar();
//                        int hour = cal.get(Calendar.HOUR);
//                        int min = cal.get(Calendar.MINUTE);
//                        int sec = cal.get(Calendar.SECOND);
//                        int AM_PM = cal.get(Calendar.AM_PM);
//                        String Am_Pm = "";
//                        if (AM_PM == 1) {
//                            Am_Pm = "PM";
//                        } else {
//                            Am_Pm = "AM";
//                        }
//                        clockLabel.setText("" + hour + ":" + min + ":" + sec + " " + Am_Pm);
//                    }
//
//                }
//
//            }
//        };
        // t.start();

    }

    private void mapButton() {
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
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
                        }
                    });

                }
            };
            t.start();

        } catch (Exception ex) {

        }
    }

    private void mapCheckBox() {
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            checkBoxMap.put("c0", c0);
                            checkBoxMap.put("c1", c1);
                            checkBoxMap.put("c2", c2);
                            checkBoxMap.put("c3", c3);
                            checkBoxMap.put("c4", c4);
                            checkBoxMap.put("c5", c5);
                            checkBoxMap.put("c6", c6);
                            checkBoxMap.put("c7", c7);
                            checkBoxMap.put("c8", c8);
                            checkBoxMap.put("c9", c9);
                        }
                    });

                }
            };
            t.start();

        } catch (Exception ex) {

        }
    }

    private void mapHorizontalTextField() {
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
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
                        }
                    });

                }
            };
            t.start();
//            Iterator<String> it = horizontalTextField.keySet().iterator();
//            while (it.hasNext()) {
//                String key = it.next();
//                TextField jf = horizontalTextField.get(key);
//                jf.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
//                    if (event.getCode() == KeyCode.F6) {
//                        System.out.println("Tab pressed F6");
//                        javafx.event.ActionEvent et = null;
//                        //ActionBuy(et);
//
//                    }
//                });
//            }
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    public void setTotalField() {
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
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
                        }
                    });

                }
            };
            t.start();

        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    private void mapVarticalTextField() {
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
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
                        }
                    });

                }
            };
            t.start();
//            Iterator<String> it = varticalTextField.keySet().iterator();
//            while (it.hasNext()) {
//                String key = it.next();
//                TextField jf = varticalTextField.get(key);
//                jf.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
//                    if (event.getCode() == KeyCode.F6) {
//                        System.out.println("Tab pressed F6");
//                        javafx.event.ActionEvent et = null;
//                        //ActionBuy(et);
//
//                    }
//                });
//            }

        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    private void mapJTextField() {
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
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
                }
            };
            t.start();

        } catch (Exception ex) {

        }
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        JOptionPane.showMessageDialog(null, "Simple Information Message" + str);
    }

    public void messageRefreshThread() {
        try {
            setMessageBar();
        } catch (Exception ex) {

        }
    }

    public void setMessageBar() {
        try {
            Thread threadMessageBar = new Thread(() -> {
                Runnable updater = () -> {
                    synchronized (this) {
                        //msgPanel.getChildren().clear();
                        String data = httpAPI._jsonRequest("?r=message", "");
                        if (data != null) {
                            //Text msg = new Text(data);
                            msgs.setText(data);
                            msgs.setFill(Color.RED);
                            //flashing msg
                            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.8), msgs);
                            fadeTransition.setFromValue(1.0);
                            fadeTransition.setToValue(0.0);
                            fadeTransition.setCycleCount(Animation.INDEFINITE);
                            fadeTransition.play();
                            //end
//                          msgs.setFont(Font.font(25));
                            // Set up a Translate Transition for the Text object
//                            TranslateTransition trans = new TranslateTransition(Duration.seconds(10), msgs);
//                            trans.setFromX(msgPanel.getWidth());
//                            trans.setToX(-1.0 * msgs.getLayoutBounds().getWidth());
//                            // Let the animation run forever
//                            trans.setCycleCount(TranslateTransition.INDEFINITE);
//                            // Reverse direction on alternating cycles
//                            trans.setAutoReverse(true);
//                            // Play the Animation
//                            trans.play();
                            //msgPanel.getChildren().add(msgs);
                            // Get the Width of the Scene and the Text
//                            double sceneWidth = msgPanel.getWidth();
//                            double textWidth = msgs.getLayoutBounds().getWidth();
//
//                            // Define the Durations
//                            Duration startDuration = Duration.ZERO;
//                            Duration endDuration = Duration.seconds(50);
//
//                            // Create the start and end Key Frames
//                            KeyValue startKeyValue = new KeyValue(msgs.translateXProperty(), sceneWidth);
//                            KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
//                            KeyValue endKeyValue = new KeyValue(msgs.translateXProperty(), 0 * textWidth);
//                            KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
//
//                            // Create a Timeline
//                            Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);
//                            // Let the animation run forever
//                            timeline.setCycleCount(Timeline.INDEFINITE);
//                            // Run the animation
//                            timeline.play();
                        }
                    }
                };
                Platform.runLater(updater);

            });
            threadMessageBar.start();

        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
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
            //////System.out.println(mainSeries);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
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
            // System.out.println("Test " + mainSeries);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }

    }

    public final void setNumber(String index, String value, String Main, String Sub) {
        try {
            if (!isNumeric(value)) {
                value = "0";
            }
            // Map<String, Map> mainSeries = Dashboard.series.get(Main);//Main
            String ss[] = Sub.split("-");
            //int cno = 0;
            for (int s = Integer.parseInt(ss[0]); s <= Integer.parseInt(ss[1]); s = s + 100) {
                Map<String, Map> mainSeries = series.get(Main);//Main
                String sp = s + "";

                //////System.out.println(Dashboard.series);
                if (Integer.parseInt(custome.getText()) > 0) {
                    int cno = 0;
                    for (Map.Entry<String, Map> mainSer : mainSeries.entrySet()) {
                        //keyor sp ==3100 example
                        String tempValue = value;
                        if (allCheckSelect) {
                            value = "" + Integer.parseInt(value) * allCheckNo[cno];
                            cno++;
                        }
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
                        value = tempValue;
//                        //System.out.println("Key = " + entry.getKey()
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
            System.out.println(ex.getMessage());
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
                    int cno = 0;
                    for (int s = Integer.parseInt(ss[0]); s <= Integer.parseInt(ss[1]); s = s + 100) {
                        Map<String, Map> mainSeries = series.get(serie);//Main
                        String sp = s + "";
                        String tempValue = value;
                        if (allCheckSelect) {
                            value = "" + Integer.parseInt(value) * allCheckNo[cno];
                            cno++;
                        }
                        ////System.out.println("MainSeries" + mainSeries);
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
                        value = tempValue;
                    }
                } else {
                    ////System.out.println(serie);
                    String ss[] = Sub.split("-");//subseries
                    // ////System.out.println(ss);
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
//                        //System.out.println("Key = " + entry.getKey()
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
            ////System.out.println(ex.getMessage());
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
//                        ////System.out.println("Modified ArrayList : " + Dashboard.multiSeries);
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ex) {
//                            ////System.out.println(ex.getMessage());
//                        }
//                    }

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    while (true) {
                        System.out.println("Series Map " + series);
                        String jsonEmp = gson.toJson(multiSeries);
                        System.out.println("MultiSeries Json " + jsonEmp);
                        System.out.println("Advance Array " + advanceDrawArray);
                        //calculateTotal();

                        try {
                            Thread.sleep(5000);
                            //  System.gc();
                            //resetFinalTotal();
                        } catch (InterruptedException ex) {
                            ////System.out.println(ex.getMessage());
                        }
                    }
                }
            };
            t.start();
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    private void BulkNumberWrite(int i, String p, javafx.scene.input.KeyEvent e) {
        // ////System.out.println(e.getKeyCode());
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
                    ////System.out.println("B Number Error " + ex.getMessage());
                }
                break;
        }

    }

    private void BulkNumberWriteVartical(int i, String p, javafx.scene.input.KeyEvent e) {
        //System.out.println(e.getCode().toString());
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
                    //System.out.println("NUmber only " + ex.getMessage());
                }
                break;
        }

    }

    public final void setDefaultColorOfInputPoitBox() {
        try {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            int i = 0;
                            while (i < 100) {
                                TextField jf = jField.get("E_" + i);
                                jf.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
                                i++;
                            }
                        }
                    });

                }
            };
            t.start();

        } catch (Exception e) {
            ////System.out.println(e.getMessage());
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

        int ends = Integer.parseInt(s[1]);
        int i = 0;
        for (int starts = Integer.parseInt(s[0]); starts <= ends; starts++) {
            TextField jf = jField.get("E_" + i);
            jf.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
            jf.setText("");
            jf.setPromptText("" + starts);
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
            System.out.println("Reset Clock " + data);
            if (data != null) {
                JSONObject response = new JSONObject(data);
                buy.setDisable(false);
                id.setText("D_" + response.getString("id"));
                start.setText(response.getString("stime"));
                end.setText(response.getString("etime"));
                String strTime = response.getString("etime");

                dTime.setText(TimeFormats.timeConvert(strTime));
                int time = 1;
                if (Integer.parseInt(response.getString("time")) > 0) {
                    time = Integer.parseInt(response.getString("time"));
                    interval = time;//Integer.parseInt(response.getString("time"));
                }

                loadAdvanceDraw();
                // messageRefreshThread();
            } else {
                JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
            }

        } catch (JSONException ex) {
            ////System.out.println("Rest clock error " + ex.getMessage());
        }
    }

    public void inisetClockCounter() {
        try {
            String data = httpAPI._jsonRequest("?r=updateGameRound", "");
            if (data != null) {
                System.out.println("Draw Data " + data);
                JSONObject response = new JSONObject(data);
                buy.setDisable(false);
                id.setText("D_" + response.getString("id"));
                start.setText(response.getString("stime"));
                end.setText(response.getString("etime"));

                String strTime = response.getString("etime");
                dTime.setText(TimeFormats.timeConvert(strTime));
                int time = 0;
                if (Integer.parseInt(response.getString("time")) > 0) {
                    time = Integer.parseInt(response.getString("time"));
                    closckDraw(String.valueOf(time));
                }

            } else {
                JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
            }

        } catch (JSONException ex) {
            ////System.out.println("inisetClockCounter " + ex.getMessage());
        }
    }

    public void closckDraw(String secs) {

        int delay = 0;
        int period = 1000;
        System.gc();
        timer = new Timer();
        interval = Integer.parseInt(secs);
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (drawClock.getText()) {
                            drawClock.setText(formatSeconds(setInterval()));
                            System.gc();
                        }
                    }
                });

            }
        }, delay, period);
    }

    private int setInterval() {

        if (interval == 10) {
            buy.setDisable(true);
            System.gc();
        }
        if (interval == 1) {
            Thread clock = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                resultBoard("ALL");
                                System.gc();
                                interval--;
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage() + "Thread name");
                            }
                        }
                    });

                }
            };
            clock.start();
            System.gc();
        }
        if (interval <= 0) {
            interval = 0;
            resetClock();
        }

        System.gc();
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
                    //////System.out.println(tp);
                    for (Map.Entry<String, ArrayList> num : tp.entrySet()) {
                        //////System.out.println(num.getValue());
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

            }

            dispalyTotal();

        } catch (Exception ex) {

        }

    }

    public void dispalyTotal() {
        try {
            int finalQty = 0;
            int finalAmt = 0;

            ResttotalField();
            for (Map.Entry<String, Integer> entry : final_Map.entrySet()) {
                String newString = entry.getKey().replace("-", "_");
                TextField qtyField = totalField.get("Q" + newString);
                qtyField.setText(entry.getValue() + "");
                TextField amtField = totalField.get("A" + newString);
                amtField.setText((entry.getValue() * perPoint) + "");
                finalQty = finalQty + entry.getValue();
            }
            if (advance.getText().equals("true")) {
                int nm = advanceDrawArray.size();

                fin = finalQty * perPoint;
                totq = finalQty;
                tota = fin;

                finalQty = finalQty * nm;
                finalAmt = finalQty * perPoint;
                totalqty.setText(finalQty + "");
                totalamt.setText(finalAmt + "");
            } else {
                finalAmt = finalQty * perPoint;
                totalqty.setText(finalQty + "");
                totalamt.setText(finalAmt + "");
            }

        } catch (Exception edx) {
            System.out.println("ResttotalField(); " + edx.getMessage());
        }
    }

    public void ResttotalField() {
        try {
            int i = 1;

            while (i <= 10) {
                int tstart = 1000 * i;
                int tend = tstart + 900;
                String newString = tstart + "_" + tend;
                TextField qtyField = totalField.get("Q" + newString);
                qtyField.setText("");
                TextField amtField = totalField.get("A" + newString);
                amtField.setText("");
                totalqty.setText("");
                totalamt.setText("");
                i++;
            }
        } catch (Exception ex) {

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
                    //System.out.println(index + "");
                    switch (NSystems.getText()) {
                        case "cross":
                            ArrayList<String> numb = cross(p);
                            String K;
                            for (String numb1 : numb) {
                                K = numb1;
                                // ////System.out.println("Cross K " + K);
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

                                int number[] = fpNumbers(p);
                                for (int so : number) {

                                    TextField temdp = jField.get("E_" + so);
                                    if (so != p) {
                                        temdp.setText(jf.getText());
                                    }
                                    temdp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                                    setNumberMulti(String.valueOf(so), temdp.getText(), seriesLable.getText(), subSeriesNo.getText(), alls.getText());

                                    so++;
                                }
                            } catch (NumberFormatException ex) {
                                ////System.out.println(ex.getMessage());
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

                            int number[] = fpNumbers(p);
//                         
                            for (int so : number) {

                                TextField temdp = jField.get("E_" + so);
                                if (so != p) {
                                    temdp.setText(jf.getText());
                                }
                                temdp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                                setNumber(String.valueOf(so), temdp.getText(), seriesLable.getText(), subSeriesNo.getText());

                                so++;
                            }
                        } catch (NumberFormatException ex) {
                            ////System.out.println(ex.getMessage());
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
            // ////System.out.println(Dashboard.series.get("1000-1900"));
            Map<String, Map> subSeries = series.get(MainSeries);
            //////System.out.println(subSeries.get("1000-1099"));
            String s[] = B0.getText().split("-");
            Map<String, ArrayList> aMap = subSeries.get(s[0]);
            ArrayList<Map> aListMap = aMap.get(s[0]);
            for (Map aListMap1 : aListMap) {
                Map<String, String> fi = aListMap1;
                for (Map.Entry<String, String> entry : fi.entrySet()) {
                    //////System.out.println(entry.getKey());
                    temp = jField.get("E_" + entry.getKey());
                    temp.setText(entry.getValue());
                    temp.setStyle("-fx-background-color:#99ff99;-fx-border-color:#000000;-fx-border-width:2px;");
                }
            }

        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());-fx-prompt-text-fill:#474a48;
        }
    }

    public void resetFinalTotal() {
        try {
            for (int i = 1000; i <= 10990; i = i + 1000) {
                int t = i + 900;
                //////System.out.println("Q" + i + "_" + t);
//                TextField tm = totalField.get("Q" + i + "_" + t);
//                tm.setText("");
//                tm = totalField.get("A" + i + "_" + t);
//                tm.setText("");

            }
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
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
            //System.out.println("P " + p);
//
//            int index = (((p / 10) + 1) * 10) - 1;
//            int rightbottom = index - p; //bottom right difference
//            int back = (p / 10) * 10;
//            int leftbottom = p - back;//bottom left
//            //System.out.println("RightBottm " + rightbottom);
//            //System.out.println("leftbottom " + leftbottom);
            int up = p / 10;
            int down = 9 - up;
            int ip = (p / 10) * 10;
            int forword = (ip + 9) - p;
            int backword = p - ip;
            //System.out.println(forword);
            //System.out.println(backword);
            num.add("" + p);
            int K = p;
            int s = 1;
            while (s <= forword) {
                K = K + 11;
                if (K <= 99) {
                    num.add("" + K);
                } else {
                    break;
                }
                s++;
            }
            K = p;
            s = 1;

            while (s <= backword) {
                K = K - 11;
                if (K >= 0) {
                    num.add("" + K);
                } else {
                    break;
                }
                s++;
            }
            K = p;
            s = 1;
            while (s <= backword) {
                K = K + 9;
                if (K <= 99) {
                    num.add("" + K);
                } else {
                    break;
                }
                s++;
            }
            K = p;
            s = 1;
            while (s <= forword) {
                K = K - 9;
                if (K >= 0) {
                    num.add("" + K);
                } else {
                    break;
                }

                s++;
            }
            //int rightbottom = last - p; //right difference
            //index = "" + p;
            //////System.out.println(num);
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
                            //////System.out.println(jsonEmp);
                            String data = httpAPI._jsonRequest("?r=UpdateBalance", jsonEmp);
                            if (data != null) {
                                JSONObject myResponse = new JSONObject(data);
                                mybalance = myResponse.getString("balance");
                                if (myResponse.getString("status").equals("1")) {
                                    balance.setText(myResponse.getString("balance"));
                                } else {
                                    balance.setText(myResponse.getString("balance"));
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                            }
                            //Thread.sleep(1000);
                        } catch (JSONException e) {
                            ////System.out.println("Balance Thread Error " + e.getMessage());
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
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        runnableBalance();
                    }
                });

            }
        };
        Balance.start();
    }

    public void resetDashboarWPRF() {
        try {
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
                B0.setStyle("-fx-background-color:" + ColorArray[0] + ";");
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

            resetEvenOdd();
            // loadSeries(multiMap);
            buy.setDisable(false);
        } catch (Exception e) {

        }
    }

    public void resetDashboard() {
        Thread resetDB = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        allCheckSelect = false;
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
                        //selectSubSeries(B0);
                        selectAll("#FFFFFF");
                        resetVarticalInput();
                        resetHorizontalInput();
                        if (series.size() >= 0) {
                            series.clear();
                            seriesLable.setText("1000-1900");
                            selectDefaultSeries(0);
                            selectSubSeries(B0);
                            //B0.setStyle("-fx-background-color:" + ColorArray[0] + ";");
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

                        resetEvenOdd();
                        // loadSeries(multiMap);
                        buy.setDisable(false);
                    }
                };
                //resetClock();
                Platform.runLater(updater);
            }

        });
        resetDB.start();

    }

    public void resetBuy() {
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
                        //multi.setSelected(false);
                        cross.setSelected(false);
                        odd.setSelected(false);
                        even.setSelected(false);
                        fixed.setSelected(false);
                        totalamt.setText("");
                        totalqty.setText("");
                        if (advance.getText().equals("true")) {
                            //advance.setText("false");
                            //advanceDraw.clear();
                            //advanceDrawArray.clear();
                            //selectSubSeries(B0);
                            if (multi.isSelected()) {
                                resetAll();
                            } else {
                                if (series.size() >= 0) {
                                    series.clear();
                                }
                                if (multiSeries.size() >= 0) {
                                    multiSeries.clear();
                                }
                                selectAll("#FFFFFF");
                                resetVarticalInput();
                                resetHorizontalInput();

                                loadSeries(multiMap);
                                System.out.println(multiMap);
                            }
                        } else {
                            if (multi.isSelected()) {
                                resetAll();
                            } else {
                                advance.setText("false");
                                selectAll("#FFFFFF");
                                resetVarticalInput();
                                resetHorizontalInput();
                                if (series.size() >= 0) {
                                    series.clear();

                                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                    seriesData series = gson.fromJson(seriesStringData, seriesData.class);
                                    ArrayList<Map> test = series.getProperties();
                                    Iterator<Map> itr = test.iterator();
                                    while (itr.hasNext()) {
                                        Map<String, String> temp = itr.next();
                                        if (seriesLable.getText().equals(temp.get("series"))) {
                                            selectDefaultSeries(Integer.parseInt(temp.get("id")) - 1);
                                            seriesLable.setText(temp.get("series"));
                                        }
                                    }

                                    selectSubSeries(B0);
                                    //B0.setStyle("-fx-background-color:" + ColorArray[0] + ";");
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

                            }
                        }
                        //selectSubSeries(B0);
                        lastTransaction();
                        calculateTotal();
                        resetManualPlatSeleted();
                        runnableBalance();
                        //messageRefreshThread();
                        resetEvenOdd();
                        //resetAll();
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
            Thread t = new Thread() {
                @Override
                public void run() {
                    resetDashboard();

                    //resetDashboarWPRF();
                    System.gc();
                }
            };
            t.start();
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    public void resultBoard(String srs) {
        try {
            resetClock();
            Thread timClock = new Thread(() -> {

                Runnable updater = () -> {
                    try {
                        resultPane.getChildren().removeAll(resultPane.getChildren());
                        Map<String, String> finalMap = new HashMap<>();
                        String ids[] = id.getText().split("_");
                        finalMap.put("drawid", ids[1]);
                        finalMap.put("series", srs);
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonEmp = gson.toJson(finalMap);
                        System.out.println(jsonEmp);
                        String Data = httpAPI._jsonRequest("?r=singleResult", jsonEmp);
                        System.out.println("Result" + Data);
                        if (Data != null) {
                            ArrayList<Map> wPoint = singleResult.singleResultJSONPrint(Data);
                            int ip = 0;
                            int x = 8;
                            int y = 5;
                            int a = 67;
                            int b = 29;
                            for (Map wPoint1 : wPoint) {
                                Map<String, String> dPoint = wPoint1;
                                int ks = 0;
                                //////System.out.println("Data \n" + dPoint);
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
                                        //////System.out.println("" + fl);
                                        Label jLable = new Label(" " + fl + "");
                                        jLable.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
                                        jLable.setWrapText(true);
                                        jLable.setAlignment(Pos.CENTER);
                                        jLable.setMaxWidth(Double.POSITIVE_INFINITY);
                                        jLable.setMaxHeight(Double.POSITIVE_INFINITY);
                                        jLable.setTextFill(Color.web("#000000"));
                                        jLable.setAlignment(Pos.CENTER);
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
                        } else {
                            JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                        }
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage() + "Thread name");
                    } catch (Exception ex) {
                        Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
                System.gc();
                //resetClock();
                Platform.runLater(updater);
            });
            timClock.start();

        } catch (Exception ex) {
            System.out.println("Erron Thread-8 " + ex.getMessage());
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
//            ////System.out.println();
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

            //////System.out.println("Printer = " + printerService.getName());
            //    }
        } catch (Exception ex) {

        }
    }

    public void lastTransaction() {

        Thread thread = new Thread(() -> {
            Runnable updater = () -> {
                synchronized (DashboardController.this) {
                    try {
                        Map<String, String> finalMap = new HashMap<>();
                        finalMap.put("userid", userid.getText());
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String finalData = gson.toJson(finalMap);
                        String data = httpAPI._jsonRequest("?r=lastTransaction", finalData);
                        if (data != null) {
                            JSONObject myrep = new JSONObject(data);
                            last.setText(myrep.getString("last"));
                            lastamt.setText("Rs. " + myrep.getString("lastamt"));
                        } else {
                            JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                        }
                    } catch (JSONException | HeadlessException ex) {

                    }
                }
            };
            Platform.runLater(updater);

        });
        thread.start();

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

        try {
            Thread t = new Thread() {
                String msg = "";

                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
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
                                        Map<String, Map> adbR = new HashMap<>();
                                        Map<String, String> dat = new HashMap<>();
                                        dat.put("adtotalqty", totalqty.getText());
                                        dat.put("adtotalamt", totalamt.getText());
                                        dat.put("advance", "true");
                                        dat.put("userid", userid.getText());
                                        adbR.put("main", dat);
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
                                            adbR.put(String.valueOf(i), finalMap);

                                        }
                                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                        String jsonEmp = gson.toJson(adbR);
                                        System.out.println(jsonEmp);

                                        String Data = httpAPI._jsonRequest("?r=invoice", jsonEmp);
                                        if (Data != null) {
                                            System.out.println("Data \n" + Data);
                                            //Map<String, Map> advanTemp = advanceDraw;
                                            //resetBuy();
                                            resetDashboard();
                                            // loadAdvanceArray(advanTemp);
                                            buy.setDisable(false);
                                            //get unitrid 
                                            Object obj = new JSONParser().parse(Data);
                                            //System.out.println(obj);
                                            // typecasting obj to JSONObject 
                                            Map<String, String> joMap = (Map<String, String>) obj;
                                            System.out.println(joMap);
                                            if (joMap.get("status").equals("1")) {

                                                //JSONObject jo = (JSONObject) obj;
                                                // getting firstName and lastName 
                                                String utrno = (String) joMap.get("print");
                                                Map<String, String> adbPrint = new HashMap<>();
                                                adbPrint.put("utrno", utrno);
                                                adbPrint.put("own", userid.getText());
                                                adbPrint.put("action", "entry");
                                                //Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                                String jsonPrint = gson.toJson(adbPrint);
                                                System.out.println(jsonPrint);
                                                Data = httpAPI._jsonRequest("?r=advancePrint", jsonPrint);
                                                if (Data == null) {
                                                    JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                                                }
                                                Object obj2 = new JSONParser().parse(Data);
                                                //System.out.println(obj);
                                                ArrayList<Map> aMap = (ArrayList<Map>) obj2;
                                                for (int i = 0; i < aMap.size(); i++) {
                                                    Map<String, String> temP = aMap.get(i);
                                                    adbPrint = new HashMap<>();
                                                    adbPrint.put("game", temP.get("game"));
                                                    adbPrint.put("own", userid.getText());
                                                    adbPrint.put("utrno", utrno);
                                                    adbPrint.put("action", "subentry");
                                                    //Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                                    jsonPrint = gson.toJson(adbPrint);
                                                    System.out.println(jsonPrint);
                                                    String da = httpAPI._jsonRequest("?r=advancePrint", jsonPrint);
                                                    if (da == null) {
                                                        JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                                                    }
                                                    System.out.println("[" + i + "]" + jsonPrint);
                                                    Thread tp = new Thread() {
                                                        @Override
                                                        public void run() {
                                                            Platform.runLater(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    try {
                                                                        msg = invoiceJSON.invoiceJSONPrint(da, printer.getText());
                                                                        Thread.sleep(1000);
                                                                    } catch (Exception ex) {
                                                                        System.out.println("Thread Tp line 2833 Error " + ex.getMessage());
                                                                    }
                                                                }
                                                            });

                                                        }
                                                    };
                                                    tp.start();
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, joMap.get("msg"));
                                            }
                                        } else {
                                            buy.setDisable(false);
                                            JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                                        }

                                        //invoiceJSON iJ = new invoiceJSON();
                                        //msg = invoiceJSON.invoiceJSONPrint(Data, printer.getText());
                                        lastTransaction();
                                        //System.gc();
                                    } else {
                                        Map<String, Map> finalMap = new HashMap<>();
                                        Map<String, String> data = new HashMap<>();
                                        data.put("userid", userid.getText());
                                        String did[] = id.getText().split("_");
                                        data.put("drawid", did[1]);
                                        data.put("totalqty", totalqty.getText());
                                        data.put("totalamt", totalamt.getText());
                                        data.put("perPoint", "2");
                                        data.put("advance", "false");
                                        data.put("start", start.getText());
                                        data.put("end", end.getText());
                                        data.put("ip", "127.0.0.1");
                                        finalMap.put("main", data);
                                        finalMap.put("data", series);
                                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                        String jsonEmp = gson.toJson(finalMap);
                                        System.out.println(jsonEmp);
                                        final String Data = httpAPI._jsonRequest("?r=invoice", jsonEmp);
                                        //System.out.println("Data \n" + Data);
                                        //Map<String, Map> advanTemp = advanceDraw;
                                        if (Data != null) {
                                            resetBuy();
                                            //resetAll();
//loadSeries(multiMap);
                                            //loadAdvanceArray(advanTemp);
                                            buy.setDisable(false);
                                            //invoiceJSON.invoiceJSONPrint(Data,printer.getText());
                                            Thread tp = new Thread() {
                                                @Override
                                                public void run() {
                                                    Platform.runLater(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            try {
                                                                msg = invoiceJSON.invoiceJSONPrint(Data, printer.getText());
                                                                //Thread.sleep(1000);
                                                                if (!msg.equals("Success")) {

                                                                    JOptionPane.showMessageDialog(null, msg);
                                                                    buy.setDisable(false);
                                                                }
                                                            } catch (Exception ex) {
                                                                System.out.println("Threade Exerpiton line 2891 " + ex.getMessage());
                                                            }
                                                        }
                                                    });

                                                }
                                            };

                                            tp.start();
                                            lastTransaction();

                                        } else {
                                            buy.setDisable(false);
                                            JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                                        }
                                    }

                                }
                                System.gc();
                            } catch (NumberFormatException | HeadlessException | ParseException ex) {
                                Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                    System.gc();
                    buy.setDisable(false);
                }

            };
            buy.setDisable(true);
            System.gc();
            t.start();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception message " + ex.getMessage());

        }
        System.gc();
    }

    @FXML
    private void Actionb2(javafx.event.ActionEvent event) {
        //msgPanel
        //resultBoard("ALL");
        Thread reset = new Thread() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        resetAll();
                        resetClock();
//              showTimer();
                        System.gc();
                        b2.setDisable(false);
                    }
                });

            }
        };
        b2.setDisable(true);
        reset.start();

//        Thread resetDB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Runnable updater = new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            
//                            resetClock();
//                           // showTimer();
//                            System.gc();
//                        } catch (Exception ex) {
//                        }
//                        //buy.setDisable(false);
//                    }
//                };
//                //resetClock();
//                Platform.runLater(updater);
//            }
//
//        });
//        resetDB.start();
    }

    private void keyRelease(javafx.scene.input.KeyEvent e, TextField jf, int p) {
        ////System.out.println(e.getText());
        TextField l = null;
        switch (e.getCode().toString()) {
            case "DOWN"://down
                l = (TextField) pevirous.get("last");
                if (l.getText().equals("")) {
                    l.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
                }
                int down = p + 10;
                if (down < 100) {
                    TextField dwnjf = jField.get("E_" + down);
                    dwnjf.requestFocus();
                }
                break;
            case "UP"://up
                l = (TextField) pevirous.get("last");
                if (l.getText().equals("")) {
                    l.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
                }
                int up = p - 10;
                if (up >= 0) {
                    TextField dwnjf = jField.get("E_" + up);
                    dwnjf.requestFocus();
                }
                break;
            case "LEFT"://left
                l = (TextField) pevirous.get("last");
                if (l.getText().equals("")) {
                    l.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
                }
                int left = p - 1;
                if (left >= 0 && left < 100) {
                    TextField dwnjf = jField.get("E_" + left);
                    dwnjf.requestFocus();
                }
                break;
            case "RIGHT"://right
                l = (TextField) pevirous.get("last");
                if (l.getText().equals("")) {
                    l.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
                }
                int right = p + 1;
                if (right >= 0 && right < 100) {
                    TextField dwnjf = jField.get("E_" + right);
                    dwnjf.requestFocus();
                }
                break;
            default:
                l = (TextField) pevirous.get("last");
                if (l.getText().equals("")) {
                    l.setStyle("-fx-background-color:#FFFFFF;-fx-border-color:#000000;-fx-border-width:2px;");
                }
                pevirous.put("last", jf);
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
            ////System.out.println("Seect Series Action Error " + ex.getMessage());
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
                        Scl.initLoadData("multi", multiMap, seriesStringData);
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
                        bSeries.setDisable(false);

                    } catch (IOException ex) {
                        ////System.out.println("Multi if Error " + ex.getMessage());
                    }
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/series.fxml"));
                        Parent root = loader.load();
                        SeriesController SC = loader.getController();
                        SC.initLoadData("single", multiMap, seriesStringData);

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
                        bSeries.setDisable(false);
                    } catch (IOException ex) {
                        ////System.out.println("Multi else Error " + ex.getMessage());
                    }
                }

            };
            Platform.runLater(updater);

        });
        openThread.start();

    }

    private void loadSeries(Map<String, String> multiMap) {
        try {
            ////System.out.println("Selected Series " + multiMap);
            setDefauldButtonColor();
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
                    selectSubSeries(B0);
                }
                setMainSeries(entry.getValue());
            }
            ////System.out.println("Series " + series);
            ////System.out.println("MultiSeries " + multiSeries);
        } catch (Exception ex) {
            ////System.out.println("LoadSeris " + ex.getMessage());
        }
    }

    @FXML
    private void ActionB_0(javafx.scene.input.KeyEvent event) {
        try {
            int i = 0;
            BulkNumberWrite(i, B_0.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_1(javafx.scene.input.KeyEvent event) {
        try {
            int i = 1;
            BulkNumberWrite(i, B_1.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_2(javafx.scene.input.KeyEvent event) {
        try {
            int i = 2;
            BulkNumberWrite(i, B_2.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_3(javafx.scene.input.KeyEvent event) {
        try {
            int i = 3;
            BulkNumberWrite(i, B_3.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_4(javafx.scene.input.KeyEvent event) {
        try {
            int i = 4;
            BulkNumberWrite(i, B_4.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_5(javafx.scene.input.KeyEvent event) {
        try {
            int i = 5;
            BulkNumberWrite(i, B_5.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_6(javafx.scene.input.KeyEvent event) {
        try {
            int i = 6;
            BulkNumberWrite(i, B_6.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_7(javafx.scene.input.KeyEvent event) {
        try {
            int i = 7;
            BulkNumberWrite(i, B_7.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_8(javafx.scene.input.KeyEvent event) {
        try {
            int i = 8;
            BulkNumberWrite(i, B_8.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionB_9(javafx.scene.input.KeyEvent event) {
        try {
            int i = 9;
            BulkNumberWrite(i, B_9.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ActionI0(javafx.scene.input.KeyEvent event) {
        try {
            int i = 0;
            BulkNumberWriteVartical(i, I_0.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI1(javafx.scene.input.KeyEvent event) {
        try {
            int i = 10;
            BulkNumberWriteVartical(i, I_10.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI2(javafx.scene.input.KeyEvent event) {
        try {
            int i = 20;
            BulkNumberWriteVartical(i, I_20.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI3(javafx.scene.input.KeyEvent event) {
        try {
            int i = 30;
            BulkNumberWriteVartical(i, I_30.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI4(javafx.scene.input.KeyEvent event) {
        try {
            int i = 40;
            BulkNumberWriteVartical(i, I_40.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI5(javafx.scene.input.KeyEvent event) {
        try {
            int i = 50;
            BulkNumberWriteVartical(i, I_50.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI6(javafx.scene.input.KeyEvent event) {
        try {
            int i = 60;
            BulkNumberWriteVartical(i, I_60.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI7(javafx.scene.input.KeyEvent event) {
        try {
            int i = 70;
            BulkNumberWriteVartical(i, I_70.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI8(javafx.scene.input.KeyEvent event) {
        try {
            int i = 80;
            BulkNumberWriteVartical(i, I_80.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void ActionI9(javafx.scene.input.KeyEvent event) {
        try {
            int i = 90;
            BulkNumberWriteVartical(i, I_90.getText(), event);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());// JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Message Box", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void selectSeriesActionbtn(javafx.event.ActionEvent event) {
        try {
            bSeries.setDisable(true);
            openSeries();
        } catch (Exception ex) {
            ////System.out.println("Seect Series Action Error btn " + ex.getMessage());
        }
    }

    @FXML
    private void opneAdvanceDrawSelecter(javafx.event.ActionEvent event) {
        try {
            b1.setDisable(true);
            openAdvance();
        } catch (Exception ex) {
            ////System.out.println("Seect Advance Action Error " + ex.getMessage());
        }
    }

    private void openAdvance() {
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/advance.fxml"));
                    Parent root = loader.load();
                    AdvanceController Scl = loader.getController();
                    Scl.initLoadData(advanceDraw, advanceDrawData);
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
                    loadAdvanceArray(advanceDraw);
                    //System.out.println("Advance Selected Draw " + advanceDraw);
                    b1.setDisable(false);
                    ////System.out.println("AdvanceDrawArray " + advanceDrawArray);
                    //loadSeries(multiMap);
                } catch (Exception ex) {
                    ////System.out.println("Seect iit load Advance Action Error " + ex.getMessage());
                }

            };
            Platform.runLater(updater);
//            Platform.runLater(updater);
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
                    result.setDisable(false);
                    //loadSeries(multiMap);
                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
            Platform.runLater(updater);
            //Platform.runLater(updater);
        });
        openThread.start();

    }

    @FXML
    private void showResultBoard(MouseEvent event) {
        result.setDisable(true);
        openResult();
    }

    @FXML
    private void actionChangePassword(MouseEvent event) {
        password.setDisable(true);
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
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(buy.getScene().getWindow());
                    stage.getScene().getRoot().setEffect(new DropShadow());
                    //themStyle(stage, root);
                    stage.showAndWait();
                    password.setDisable(false);
                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            };

            Platform.runLater(updater);
            //Platform.runLater(updater);
        });
        openThread.start();

    }

    public void themStyle(Stage stage, Parent root) {
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.initModality(Modality.APPLICATION_MODAL);
        // Specifies the owner Window (parent) for new window
        //stage.initOwner(close.getScene().getWindow());
        //stage.getScene().getRoot().setEffect(new DropShadow());
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.toFront();
//        stage.setMaximized(false);
//        stage.setFullScreen(true);
//
//        stage.setResizable(false);
//            stage.initStyle(StageStyle.UNDERDECORATED);
//
//        grab your root here
//        root.setOnMousePressed((MouseEvent event1) -> {
//            xOffset = event1.getSceneX();
//            yOffset = event1.getSceneY();
//        });

        //move around here
//        root.setOnMouseDragged((MouseEvent event1) -> {
//            stage.setX(event1.getScreenX() - xOffset);
//            stage.setY(event1.getScreenY() - yOffset);
//        });
    }

    @FXML
    private void reprintTicketAction(MouseEvent event) {
        reprint.setDisable(true);
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
                    reprint.setDisable(false);
                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            };
            Platform.runLater(updater);

            //Platform.runLater(updater);
        });
        openThread.start();
    }

    @FXML
    private void cancelTicketAction(MouseEvent event) {
        cancel.setDisable(true);
        Thread openThread = new Thread(() -> {
            Runnable updater = () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cancelpoup.fxml"));
                    Parent root = loader.load();
                    CancelpoupController Scl = loader.getController();
                    String drawid[] = id.getText().split("_");

                    Scl.initLoadData(userid.getText(), printer.getText(), drawid[1]);
                    Stage stage = new Stage();
                    stage.setTitle("Reprint Ticket");
                    stage.setScene(new Scene(root));
                    themStyle(stage, root);
                    stage.showAndWait();
                    updateBalance();

                    lastTransaction();
                    cancel.setDisable(false);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            };

            Platform.runLater(updater);
            //Platform.runLater(updater);
        });
        openThread.start();

    }

    @FXML
    private void operatorAction(MouseEvent event) {
        operator.setDisable(true);
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
                    operator.setDisable(false);
                } catch (IOException ex) {
                    Logger.getLogger(DashboardController.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            };

            Platform.runLater(updater);
            // Platform.runLater(updater);
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
            stage.initStyle(StageStyle.TRANSPARENT);

            //stage.setFullScreen(true);
            //stage.setResizable(false);
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
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
        System.out.println("Event " + event.getText());
        if ("-".equals(event.getText()) && !"".equals(claimReader.getText())) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Map<String, String> finalMap = new HashMap<>();
                                String scanner[] = claimReader.getText().split("-");
                                finalMap.put("id", scanner[0]);
                                finalMap.put("userid", userid.getText());
                                String did[] = id.getText().split("_");
                                finalMap.put("gameid", did[1]);
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                String jsonEmp = gson.toJson(finalMap);
                                System.out.println(jsonEmp);
                                String data = httpAPI._jsonRequest("?r=checkWinner", jsonEmp);
                                //System.out.println(data);
                                if (data != null) {
                                    String msg = claimJSON.claimJSONPrint(data, printer.getText());
                                    claimMessageBox(msg);
                                    //JOptionPane.showMessageDialog(null, msg);
                                    claimReader.setText("");
                                    runnableBalance();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
                                }
                            } catch (Exception ex) {
                                ////System.out.println("Error on ClaimReadr Exceptione " + ex.getMessage());
                            }
                        }
                    });

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
        singleDrawPlatSelected(B0, c0);
    }

    @FXML
    private void action_c1(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B1, c1);
    }

    @FXML
    private void action_c2(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B2, c2);
    }

    @FXML
    private void action_c3(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B3, c3);
    }

    @FXML
    private void action_c4(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B4, c4);
    }

    @FXML
    private void action_c5(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B5, c5);
    }

    @FXML
    private void action_c6(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B6, c6);
    }

    @FXML
    private void action_c7(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B7, c7);
    }

    @FXML
    private void action_c8(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B8, c8);
    }

    @FXML
    private void action_c9(javafx.event.ActionEvent event) {
        singleDrawPlatSelected(B9, c9);
    }

    private void singleDrawPlatSelected(Button B0, CheckBox c0) {
        try {
            int count = Integer.parseInt(custome.getText());
            if (c0.isSelected()) {
                if (multi.isSelected()) {
                    ////System.out.println("MultiSeries Array" + multiSeries);
                    for (String multiSerie : multiSeries) {
                        //i got form button text emx 1000-1099 but my series is 3000-3900
                        //1100+3000-1000=3100
                        //
                        int Default = 1000;
                        String[] mult = multiSerie.split("-");
                        String bSplit[] = B0.getText().split("-");
                        int first = Integer.parseInt(bSplit[0]) + Integer.parseInt(mult[0]) - Default;
                        int second = first + 99;
                        String cTxt = String.valueOf(first) + "-" + String.valueOf(second);
                        setSubSeries(cTxt, multiSerie);
                    }
                } else {
                    setSubSeries(B0.getText(), seriesLable.getText());
                }
                count++;
            } else {
                if (multi.isSelected()) {
                    ////System.out.println("MultiSeries Array" + multiSeries);
                    for (String multiSerie : multiSeries) {
                        //i got form button text emx 1000-1099 but my series is 3000-3900
                        //1100+3000-1000=3100
                        //
                        int Default = 1000;
                        String[] mult = multiSerie.split("-");
                        String bSplit[] = B0.getText().split("-");
                        int first = Integer.parseInt(bSplit[0]) + Integer.parseInt(mult[0]) - Default;
                        int second = first + 99;
                        String cTxt = String.valueOf(first) + "-" + String.valueOf(second);
                        unsetSubSeries(cTxt, multiSerie);
                        //count--;
                    }
                } else {
                    unsetSubSeries(B0.getText(), seriesLable.getText());

                }
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
        Thread showandhidebalance = new Thread() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (show) {
                            balance.setText("*****");
                            show = false;
                        } else {
                            balance.setText(mybalance);
                            show = true;
                        }
                        System.gc();
                    }
                });

            }
        };
        showandhidebalance.start();
    }

    private int[] fpNumbers(int p) {
        int[][] num = {
            {10, 15, 60, 65, 1, 6, 51, 56},
            {12, 17, 62, 67, 21, 26, 71, 76},
            {13, 18, 63, 68, 31, 36, 81, 86},
            {14, 19, 64, 69, 41, 46, 91, 96},
            {20, 25, 70, 75, 2, 7, 52, 57},
            {23, 28, 73, 78, 32, 37, 82, 87},
            {24, 29, 74, 79, 42, 47, 92, 97},
            {30, 35, 80, 85, 3, 8, 53, 58},
            {34, 39, 84, 89, 43, 48, 93, 98},
            {40, 45, 90, 95, 4, 9, 54, 59},
            {11, 66, 16, 61},
            {22, 27, 72, 77},
            {33, 38, 83, 88},
            {44, 49, 94, 99},
            {55, 50, 0, 5}
        };
        int number[] = null;
        for (int[] num1 : num) {
            for (int element : num1) {
                if (element == p) {
                    number = num1;
                    break;
                }
            }
        }
        return number;
    }

    public void resetEvenOdd() {
        int i = 0;
        while (i < 100) {
            TextField temp = jField.get("E_" + i);
            temp.setDisable(false);
            i++;
        }
    }

    public void loadSeriesData() {
        seriesStringData = httpAPI._jsonRequest("?r=loadSeries", "");
        if (seriesStringData == null) {
            JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
        }
    }

    public void loadAdvanceDraw() {
        advanceDrawData = httpAPI._jsonRequest("?r=advanceDraw", "");
        if (advanceDrawData == null) {
            JOptionPane.showMessageDialog(null, "Please check you internet connection.. Host not connected");
        }
    }

    private void loadAdvanceArray(Map<String, Map> advanceDraw) {
        try {
            advanceDrawArray = new ArrayList<>();
            advanceDraw.entrySet().stream().forEach((entry) -> {
                advanceDrawArray.add(entry.getValue());
            });

            if (!advanceDrawArray.isEmpty()) {
                advance.setText("true");
            } else {
                advance.setText("false");
            }
        } catch (Exception ex) {

        }
    }

    @FXML
    private void allSelectAction(MouseEvent event) {
        if (alls.getText().equals("true")) {
            alls.setText("false");
            perPoint = 2;
            //singleDrawPlatSelected(B6, c6);
            for (int i = 0; i < 10; i++) {
                Button button = buttonMap.get("B" + i);
                CheckBox check = checkBoxMap.get("c" + i);
                check.setSelected(false);
                singleAllDrPlatSelected(button, check);
            }
            selectAll("#FFFFFF");

//            c0.setSelected(true);
//            //custome.setText("1");
//            singleAllDrPlatSelected(B0, c0);
//            
//            this.setDefauldButtonColor();
            B0.setStyle("-fx-background-color:" + ColorArray[0] + ";");
//            this.selectSubSeries(B0);
//            this.getPreviousNumber(B0);
//            resetVarticalInput();
//            resetHorizontalInput();
//            alls.setText("false");
//            buttonClickResetCheckOption();
            calculateTotal();
            allCheckSelect = false;

            custome.setText(String.valueOf(0));
        } else {
            alls.setText("true");
            selectAll("#00FFFF");

            //resetManualPlatSeleted();
            subSeriesNo.setText(seriesLable.getText());
            for (int i = 0; i < 10; i++) {
                Button button = buttonMap.get("B" + i);
                CheckBox check = checkBoxMap.get("c" + i);
                check.setSelected(true);
                button.setStyle("-fx-background-color:" + ColorArray[i] + ";");
                singleAllDrPlatSelected(button, check);
                //custome.setText(String.valueOf(i));
            }
            perPoint = 2;
            allCheckSelect = true;
            calculateTotal();
            //custome.setText(String.valueOf(0));
        }
    }

    private void singleAllDrPlatSelected(Button B0, CheckBox c0) {
        try {
//            this.setDefauldButtonColor();
            //B0.setStyle("-fx-background-color:" + ColorArray[0] + ";");
//            this.selectSubSeries(B0);
//            this.getPreviousNumber(B0);
//            resetVarticalInput();
//            resetHorizontalInput();
//            alls.setText("false");
//           // buttonClickResetCheckOption();

            int count = Integer.parseInt(custome.getText());
            if (c0.isSelected()) {
                if (multi.isSelected()) {
                    ////System.out.println("MultiSeries Array" + multiSeries);
                    for (String multiSerie : multiSeries) {
                        //i got form button text emx 1000-1099 but my series is 3000-3900
                        //1100+3000-1000=3100
                        //
                        int Default = 1000;
                        String[] mult = multiSerie.split("-");
                        String bSplit[] = B0.getText().split("-");
                        int first = Integer.parseInt(bSplit[0]) + Integer.parseInt(mult[0]) - Default;
                        int second = first + 99;
                        String cTxt = String.valueOf(first) + "-" + String.valueOf(second);
                        setSubSeries(cTxt, multiSerie);
                    }
                } else {
                    setSubSeries(B0.getText(), seriesLable.getText());
                }
                count++;
            } else {
                if (multi.isSelected()) {
                    ////System.out.println("MultiSeries Array" + multiSeries);
                    for (String multiSerie : multiSeries) {
                        //i got form button text emx 1000-1099 but my series is 3000-3900
                        //1100+3000-1000=3100
                        //
                        int Default = 1000;
                        String[] mult = multiSerie.split("-");
                        String bSplit[] = B0.getText().split("-");
                        int first = Integer.parseInt(bSplit[0]) + Integer.parseInt(mult[0]) - Default;
                        int second = first + 99;
                        String cTxt = String.valueOf(first) + "-" + String.valueOf(second);
                        unsetSubSeries(cTxt, multiSerie);
                        //count--;
                    }
                } else {
                    unsetSubSeries(B0.getText(), seriesLable.getText());

                }
                count--;
            }
            custome.setText(String.valueOf(count));
        } catch (Exception ex) {

        }
    }

}
