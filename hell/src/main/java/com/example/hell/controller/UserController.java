package com.example.hell.controller;

import com.example.hell.domain.User;
import com.example.hell.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    @Autowired
    private UserService userService;

    @FXML
    private TextField UserTextField;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private PasswordField RegButton;

    @FXML
    private TextField EmailTextField;

    @FXML
    public void register() {

        String username = UserTextField.getText();
        String password = PasswordTextField.getText();
        String confirmPassword = RegButton.getText();
        String email = EmailTextField.getText();

        if (!password.equals(confirmPassword)) {

            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userService.registerUser(user);

    }
}