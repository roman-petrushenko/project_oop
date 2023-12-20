module com.example.geometricobjects {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geometricobjects to javafx.fxml;
    exports com.example.geometricobjects;
}