/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Sys.SystemInfo;
import Sys.api.SystemMacAddress;
import Sys.api.httpAPI;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        msg.setText("");
        loadPrinter();
        //defaultPrinter.setVisible(false);

    }

    public static void setPrinter(String printer) {
        try {
            lc.defaultPrinter.setText(printer);
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void login(ActionEvent event) {
        JsonObject person = new JsonObject();
        person.addProperty("userid", userid.getText());
        person.addProperty("password", password.getText());
        //person.addProperty("printer", defaultPrinter.getText());
        person.addProperty("device", SystemInfo.getSystemName());
        String jsonString = person.toString();
        //System.out.println(jsonString);

        try {
            String data = httpAPI._jsonRequest("?r=gamelogin", jsonString);
            //System.out.println(data);
            JSONObject myResponse = new JSONObject(data);
            int status = Integer.parseInt(myResponse.getString("status"));

            if (status == 1) {
                msg.setText(myResponse.getString("message"));
                switchScenView("/view/dashboard.fxml", new DashboardController(), myResponse, event);
            } else {
                msg.setText(myResponse.getString("message"));
            }

        } catch (JSONException | NumberFormatException ex) {
            //System.out.println(ex.getMessage());
        }
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
        PrintService[] loadPrinter = Sys.Printers.loadPrinter();
        for (PrintService printerService : loadPrinter) {
            defaultPrinter.setText(printerService.getName());
            Button printerButton = new Button(printerService.getName());
            printerButton.setMaxSize(100, 200);
            printerButton.setStyle("-fx-background-color: #42f58a;-fx-border-color:#FFFFFF; ");
            printerButton.setOnAction(e -> setDefaultPrinter(printerService.getName()));
            printerBox.getChildren().add(printerButton);

        }
    }

    private void setDefaultPrinter(String name) {
        defaultPrinter.setText(name);
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
//            stage.setMaximized(true);
//            stage.setFullScreen(true);
//            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            themStyle(stage, root);
            stage.setTitle("Series");

            stage.show();
            btnLogin.getScene().getWindow().hide();
            //loadSeries(multiMap);
        } catch (Exception ex) {
            //System.out.println("Switching Scan View  Error " + ex.getMessage());
        }
    }

    public void themStyle(Stage stage, Parent root) {
        stage.initStyle(StageStyle.TRANSPARENT);
            //stage.initStyle(StageStyle.UNDERDECORATED);

        //grab your root here
        root.setOnMousePressed((MouseEvent event1) -> {
            xOffset = event1.getSceneX();
            yOffset = event1.getSceneY();
        });

        //move around here
        root.setOnMouseDragged((MouseEvent event1) -> {
            stage.setX(event1.getScreenX() - xOffset);
            stage.setY(event1.getScreenY() - yOffset);
        });
    }

    @FXML
    private void test(MouseEvent event) {
        try {
            defaultPrinter.setVisible(true);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/series.fxml"));
            Parent root = loader.load();
            SeriesController sc = loader.getController();
           // sc.initLoadData("PDF");

            //Show scene 2 in new window            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Second Window");
            // stage.setOnHidden(evt -> defaultPrinter.setText(sc.getText()));
            stage.show();

        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
