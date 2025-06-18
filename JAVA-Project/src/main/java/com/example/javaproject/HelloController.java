package com.example.javaproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Label welcomeText;

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
    private List<SongInfo> songInfos = new ArrayList<>();

    private int index = 0;

    @FXML
    private void initialize() {
        songs.add("/com/example/javaproject/NextToYou.mp3");
        songs.add("/com/example/javaproject/EdSheeranPerfect.mp3");
        songs.add("/com/example/javaproject/AlexanderStewartBlame'sOnMe.mp3");
        songs.add("/com/example/javaproject/AlexanderStewartiwishyoucheated.mp3");

        songInfos.add(new SongInfo("Next To You", "320", "44", "Stereo"));
        songInfos.add(new SongInfo("Perfect", "256", "44", "Stereo"));
        songInfos.add(new SongInfo("Blame Is On Me", "320", "44", "Stereo"));
        songInfos.add(new SongInfo("I Wish You Cheatad", "192", "44", "Stereo"));

        loadMedia(index);
    }

    private void loadMedia(int index) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        String path = songs.get(index);
        URL mp3 = getClass().getResource(path);

        if (mp3 == null) {
            System.out.println("❌ Nie znaleziono pliku: " + path);
            return;
        }

        try {
            Media media = new Media(mp3.toExternalForm());
            mediaPlayer = new MediaPlayer(media);

            SongInfo info = songInfos.get(index);
            songTitle.setText(info.getTitle());
            bitrateText.setText(info.getBitrate());
            mixrateText.setText(info.getSampleRate());
            monoText.setText(info.getChannels());

            mediaPlayer.setOnReady(() -> {
                double durationSeconds = media.getDuration().toSeconds();
                timeText.setText(String.format("Czas: 0.0 / %.1f s", durationSeconds));
            });

            mediaPlayer.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                double elapsed = newTime.toSeconds();
                double total = mediaPlayer.getTotalDuration().toSeconds();
                timeText.setText(String.format("Czas: %.1f / %.1f s", elapsed, total));
            });

            volumeBar.valueProperty().addListener((obs, oldVal, newVal) -> {
                mediaPlayer.setVolume(newVal.doubleValue() / 100.0);
            });

            mediaPlayer.play();

        } catch (Exception e) {
            System.out.println("⚠ Błąd MediaPlayer: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    protected void onPreviousButtonClick() {
        if (mediaPlayer != null) {
            index = (index - 1 + songs.size()) % songs.size();
            loadMedia(index);
        }
    }

    @FXML
    protected void onPlayButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    @FXML
    protected void onPauseButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @FXML
    protected void onStopButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @FXML
    protected void onNextButtonClick() {
        if (mediaPlayer != null) {
            index = (index + 1) % songs.size();
            loadMedia(index);
        }
    }

    @FXML
    protected void onShuffleButtonClick() {
        if (mediaPlayer != null) {
            index = (int) (Math.random() * songs.size());
            loadMedia(index);
        }
    }

    // Klasa wewnętrzna dla danych o utworze
    public static class SongInfo {
        private final String title;
        private final String bitrate;
        private final String sampleRate;
        private final String channels;

        public SongInfo(String title, String bitrate, String sampleRate, String channels) {
            this.title = title;
            this.bitrate = bitrate;
            this.sampleRate = sampleRate;
            this.channels = channels;
        }

        public String getTitle() { return title; }
        public String getBitrate() { return bitrate; }
        public String getSampleRate() { return sampleRate; }
        public String getChannels() { return channels; }
    }
}
