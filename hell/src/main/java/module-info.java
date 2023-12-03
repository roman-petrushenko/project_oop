module com.example.test {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.security.core;
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires lombok;
    requires spring.security.crypto;
    requires spring.context;
    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.webmvc;
    requires spring.security.config;
    requires spring.security.web;


    opens com.example.hell to javafx.fxml;
    exports com.example.hell;
    exports com.example.hell.AdminController ;
    opens com.example.ct.squrcontroller to javafx.fxml;
}