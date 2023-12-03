package com.example.hell;

import com.example.hell.controller.UserController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @Autowired
    private UserController userController;

    @FXML
    private StackPane root;

    @FXML
    public void initialize() {

    }

    @FXML
    public void showRegistrationForm() {
        Stage stage = new Stage();
        stage.setScene(userController.getScene());
        stage.show();
    }

    @FXML
    public void exit() {
        Platform.exit();
    }
}