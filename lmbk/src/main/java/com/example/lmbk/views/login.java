package com.example.lmbk.views;

import com.example.lmbk.HelloApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


import javafx.stage.Stage;

import java.io.IOException;


public class login{




    public static void loadView(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 871);
        stage.setTitle("Geometric Objects Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }







}