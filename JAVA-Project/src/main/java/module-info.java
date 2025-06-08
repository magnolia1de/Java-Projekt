module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.javaproject to javafx.fxml;
    exports com.example.javaproject;
}