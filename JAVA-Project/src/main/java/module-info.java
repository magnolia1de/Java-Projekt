module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaproject to javafx.fxml;
    exports com.example.javaproject;
}