module com.example.lmbk {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires java.sql;
    requires spring.data.jpa;

    opens com.example.lmbk to javafx.fxml, spring.core;
    exports com.example.lmbk;

    opens com.example.lmbk.squrcontroller to javafx.fxml;
    exports com.example.lmbk.squrcontroller;

    opens com.example.lmbk.trcontroller to javafx.fxml;
    exports com.example.lmbk.trcontroller;

    opens com.example.lmbk.circlecontroller to javafx.fxml;
    exports com.example.lmbk.circlecontroller;

}