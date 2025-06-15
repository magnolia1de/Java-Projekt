package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

    private List<String> songs = new ArrayList<>();
    private int index = 0;

    @FXML
    private void initialize() {
        songTitle.setText("Title");

        songs.add("/com/example/javaproject/NextToYou.mp3" + "/com/example/javaproject/EdSheeranPerfect.mp3");

        loadMedia(index);

    }

    private void loadMedia(int index) {
        String path = "/com/example/javaproject/EdSheeranPerfect.mp3";
        URL mp3 = getClass().getResource(path);
        System.out.println("Próbuję załadować plik: " + path);
        System.out.println("mp3 URL: " + mp3);

        if (mp3 == null) {
            System.out.println("❌ Nie znaleziono pliku: " + path);
        } else {
            try {
                Media media = new Media(mp3.toExternalForm());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                System.out.println("✅ Odtwarzanie rozpoczęte: " + mp3.toExternalForm());
            } catch (Exception e) {
                System.out.println("⚠ Błąd MediaPlayer: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }








    @FXML
    protected void onPrevoiusButtonClick() {
        if (mediaPlayer != null) {
            System.out.println("poprzedni");
        }
    }

    @FXML
    protected void onPlayButtonClick() {
        if (mediaPlayer != null) {
            System.out.println("odtwarzam");
            mediaPlayer.play();
        }
    }

    @FXML
    protected void onPauseButtonClick() {
        if (mediaPlayer != null) {
            System.out.println("zatrzymane");
            mediaPlayer.pause();
        }
    }

    @FXML
    protected void onStopButtonClick() {
        if (mediaPlayer != null) {
            System.out.println("zatrzymane");
            mediaPlayer.pause();
        }
    }

    @FXML
    protected void onNextButtonClick() {
        if (mediaPlayer != null) {
            System.out.println("następne");
        }
    }

    @FXML
    protected  void onShuffleButtonClick() {
        if (mediaPlayer != null) {
            System.out.println("mieszamy");
        }
    }


}