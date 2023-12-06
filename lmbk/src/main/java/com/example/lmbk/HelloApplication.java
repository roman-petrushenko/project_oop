package com.example.lmbk;

import com.example.lmbk.circlecontroller.CircleController;
import com.example.lmbk.squrcontroller.QuadrangleController;
import com.example.lmbk.swtch.sceneswtch;

import com.example.lmbk.trcontroller.TriangleController;
import com.example.lmbk.views.login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class HelloApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    public HelloApplication() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        this.applicationContext = SpringApplication.run(HelloApplication.class);
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        login.loadView(primaryStage);
    }

    @FXML
    private TextField UserTextField;

    @FXML
    private PasswordField password;

    @FXML
    private TextField EmailTextField;

    @FXML
    private Button RegButton;

    @FXML
    private Button close;

    @FXML
    private Button tr;

    @FXML
    private Button sq;

    @FXML
    private Button cr;

    @FXML
    private AnchorPane str;


    @FXML
    public void Reg(ActionEvent event) throws IOException {
        new sceneswtch(str, "menu.fxml");

    }

    @FXML
    void closepr(ActionEvent event) {
        RegButton.getScene().getWindow().hide();


    }

    private Scene scene;
    private Parent root;
    private Stage stage;

    @FXML
    void open_tr(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Triangle.fxml"));
        Parent root = fxmlLoader.load();
        TriangleController triangleController = fxmlLoader.getController();
        triangleController.setStage_tr(new Stage());
        Scene scene = new Scene(root, 1200, 871);
        Stage newStage = new Stage();
        newStage.setTitle("Geometric Objects Calculator");
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();

    }

    @FXML
    void open_cr(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Circle.fxml"));
        Parent root = fxmlLoader.load();
        CircleController circleController = fxmlLoader.getController();
        circleController.setStage_cr(new Stage());
        Scene scene = new Scene(root, 1200, 871);
        Stage newStage = new Stage();
        newStage.setTitle("Geometric Objects Calculator");
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();


    }


    @FXML
    private void open_sq(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Quadrangle.fxml"));
        Parent root = fxmlLoader.load();
        QuadrangleController quadrangleController = fxmlLoader.getController();
        quadrangleController.setStage(new Stage());
        Scene scene = new Scene(root, 1200, 871);
        Stage newStage = new Stage();
        newStage.setTitle("Geometric Objects Calculator");
        newStage.setScene(scene);
        newStage.setResizable(false);
        newStage.show();



    }

    @FXML
    private AnchorPane sceneAnchoremenu;

    @FXML
    private Button close_mn;

    @FXML
    void close_mnfg(ActionEvent event) {
        sceneAnchoremenu.getScene().getWindow().hide();


    }


}








