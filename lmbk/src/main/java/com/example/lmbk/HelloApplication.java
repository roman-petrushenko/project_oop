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

import java.io.*;
import java.util.Scanner;

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
    private PasswordField pr;


    @FXML
    private TextField User_lgTextField;

    @FXML
    private Button close_lg;

    @FXML
    private Button LoginButton;

    @FXML
    private Button ReglogButton1;


    @FXML
    public void Reg(ActionEvent event) throws IOException {
        String enteredPassword = password.getText();
        String enteredUsername = UserTextField.getText();
        String enteredEmail = EmailTextField.getText();

        if (!enteredPassword.isEmpty() && !enteredUsername.isEmpty() && !enteredEmail.isEmpty()) {
            File file = new File("userdata.txt");

            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error creating userdata.txt");
                    return;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

                writer.write(enteredUsername + "," + enteredPassword + "," + enteredEmail);
                writer.newLine();

                System.out.println("Registration successful");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error writing to userdata.txt");
            }
        } else {
            System.out.println("Please fill in all fields");
        }

        //new sceneswtch(str, "menu.fxml");

    }



    @FXML
    public void log(ActionEvent event) throws IOException{
        String enteredPassword = pr.getText();
        String enteredUsername = User_lgTextField.getText();

        if (!enteredPassword.isEmpty() && !enteredUsername.isEmpty()) {
            File file = new File("userdata.txt");

            if (!file.exists()) {
                System.out.println("No registered users yet");
                return;
            }

            try (Scanner scanner = new Scanner(file)) {
                boolean found = false;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");
                    String username = parts[0];
                    String password = parts[1];

                    if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
                        System.out.println("Login successful");
                        found = true;
                        new sceneswtch(str, "menu.fxml");//reframe to menu
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Invalid login credentials");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error creating userdata.txt");
            }
        } else {
            System.out.println("Please fill in all fields");
        }


    }

    @FXML
    public void close_l(ActionEvent event){
        LoginButton.getScene().getWindow().hide();

    }



    @FXML
    public void Reg_lg(ActionEvent event) throws IOException {

        new sceneswtch(str, "lg.fxml");
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








