/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.SystemInfo;
import Sys.api.httpAPI;
import com.github.anastaciocintra.output.PrinterOutputStream;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.print.PrintService;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * FXML Controller class
 *
 * @author asksoft
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userid;
    @FXML
    private VBox printerBox;
    @FXML
    private TextField defaultPrinter;
    @FXML
    private PasswordField password;
    @FXML
    private Label msg;
    public static LoginController lc = new LoginController();

    public static TextField staticDefaultPrinter;
    @FXML
    private Label pf;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private Button btnLogin;

    private Map<String, Button> pButton = new HashMap<>();
    @FXML
    private AnchorPane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Thread t = new Thread() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        msg.setText("");
                        loadPrinter();
                        defaultPrinter.setVisible(true);
                        PrintService printService = PrinterOutputStream.getDefaultPrintService();
                        defaultPrinter.setText(printService.getName());
                    }
                });
            }
        };
        t.start();

    }

    public static void setPrinter(String printer) {
        try {
            lc.defaultPrinter.setText(printer);
        } catch (Exception ex) {
            ////System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void login(ActionEvent event) {
        msg.setText("Authenticating... Please Wait!");
        btnLogin.setDisable(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        msg.setText("Authenticating... Please Wait!");
                        JsonObject person = new JsonObject();
                        person.addProperty("userid", userid.getText());
                        person.addProperty("password", password.getText());
                        //person.addProperty("printer", defaultPrinter.getText());
                        person.addProperty("device", SystemInfo.getSystemName());
                        String jsonString = person.toString();
                        System.out.println(jsonString);

                        try {
                            String data = httpAPI._jsonRequest("?r=gamelogin", jsonString);
                            if (data != null) {
                                JSONObject myResponse = new JSONObject(data);
                                int status = Integer.parseInt(myResponse.getString("status"));

                                if (status == 1) {
                                    msg.setText(myResponse.getString("message"));
                                    btnLogin.setDisable(false);
                                    switchScenView("/view/dashboard.fxml", new DashboardController(), myResponse, event);
                                } else {
                                    btnLogin.setDisable(false);
                                    msg.setText(myResponse.getString("message"));
                                }
                            } else {
                                msg.setText("Please check your internet connection!");
                            }
                        } catch (JSONException | NumberFormatException ex) {
                            ////System.out.println(ex.getMessage());
                        }
                        
                    }
                });
            }
        };
        t.start();

    }

    @FXML
    private void disconnectGame(MouseEvent event) {
        //close.getScene().getWindow().hide();
        System.exit(0);
    }

    @FXML
    private void restartGame(MouseEvent event) {
        Runtime runtime = Runtime.getRuntime();
        try {
            String OSName = System.getProperty("os.name");
            if (OSName.contains("Windows")) {
                Process proc = runtime.exec("shutdown -h -t 0");
            } else {
                Process proc = runtime.exec("sudo reboot");
            }

        } catch (IOException ex) {

        }
        System.exit(0);
    }

    @FXML
    private void shutdownGame(MouseEvent event) {
        Runtime runtime = Runtime.getRuntime();
        try {
            String OSName = System.getProperty("os.name");
            if (OSName.contains("Windows")) {
                Process proc = runtime.exec("shutdown -s -t 0");
            } else {
                Process proc = runtime.exec("sudo shutdown -h now");
            }
        } catch (IOException ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    private void loadPrinter() {
//        ObservableSet<Printer> printers = Printer.getAllPrinters();
//        
//        for (Printer printer : printers) {
//            defaultPrinter.setText(printer.getName());
//            Button printerButton = new Button(printer.getName());
//            pButton.put(printer.getName(), printerButton);
//            printerButton.setMaxSize(100, 200);
//            printerButton.setStyle("-fx-background-color: #42f58a;-fx-border-color:#FFFFFF; ");
//            printerButton.setOnAction(e -> setDefaultPrinter(printer.getName()));
//            printerBox.getChildren().add(printerButton);
//            
//        }
        
    }

    private void setDefaultPrinter(String name) {
        defaultPrinter.setText(name);
        Iterator<String> it = pButton.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (key.equals(name)) {
                Button printerButton = pButton.get(key);
                printerButton.setMaxSize(100, 200);
                printerButton.setStyle("-fx-background-color: #f0e851;-fx-border-color:#FFFFFF; ");
            } else {
                Button printerButton = pButton.get(key);
                printerButton.setMaxSize(100, 200);
                printerButton.setStyle("-fx-background-color: #42f58a;-fx-border-color:#FFFFFF; ");
            }

        }
    }

    private void switchScenView(String fxml, DashboardController dashboardController, JSONObject myResponse, ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            DashboardController Scl = loader.getController();
            Scl.initParameter(myResponse, defaultPrinter.getText());
            Stage stage = new Stage();
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            themStyle(stage, root);
            stage.setTitle("Dashboard");
            stage.toFront();

            stage.show();
            btnLogin.getScene().getWindow().hide();
            //
            //loadSeries(multiMap);
        } catch (Exception ex) {
            ////System.out.println("Switching Scan View  Error " + ex.getMessage());
        }
    }

    public void themStyle(Stage stage, Parent root) {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

    }

    @FXML
    private void test(MouseEvent event) {
//    
    }

}
