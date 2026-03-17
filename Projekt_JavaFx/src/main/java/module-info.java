module com.example.projekt_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projekt_javafx to javafx.fxml;
    exports com.example.projekt_javafx;
}