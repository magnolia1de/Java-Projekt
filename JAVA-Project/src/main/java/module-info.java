module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires mp3agic;


    opens com.example.javaproject to javafx.fxml;
    exports com.example.javaproject;
}