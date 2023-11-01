module com.example.newyeargreetings {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.newyeargreetings to javafx.fxml;
    exports com.example.newyeargreetings;
}