package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.io.File;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Text timeText;

    @FXML
    private Text songTitle;

    @FXML
    private Text bitrateText;

    @FXML
    private Text mixrateText;

    @FXML
    private Text monoText;

    @FXML
    private ScrollBar volumeBar;

    @FXML
    private Button shuffleSong;

    @FXML
    private Button shuffleSongTwo;

    @FXML
    private Button previousSong;

    @FXML
    private Button playSong;

    @FXML
    private Button pauseSong;

    @FXML
    private Button stopSong;

    @FXML
    private Button nextSong;

    private MediaPlayer mediaPlayer;

    @FXML
    private void initialize() {
        songTitle.setText("Title");

        String path=new File("../src/main/resources/EdSheeranPerfect.mp3").toURI().toString();
        Media media=new Media(path);

        mediaPlayer = new MediaPlayer(media);
    }

    @FXML
    protected void onPrevoiusButtonClick() {
        System.out.println("poprzedni");
    }

    @FXML
    protected void onPlayButtonClick() {
        System.out.println("odtwarzam");
    }

    @FXML
    protected void onPauseButtonClick() {
        System.out.println("zatrzymane");
    }

    @FXML
    protected void onStopButtonClick() {
        System.out.println("zatrzymane");
    }

    @FXML
    protected void onNextButtonClick() {
        System.out.println("następne");
    }

    @FXML
    protected  void onShuffleButtonClick() {
        System.out.println("mieszamy");
    }


}