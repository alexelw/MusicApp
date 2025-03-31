package com.example;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MusicApp extends Application {
    private final MusicService musicService = new MusicService();
    private final ListView<String> listView = new ListView<>();
    private final TextField searchField = new TextField();
    private final TextField titleField = new TextField();
    private final TextField artistField = new TextField();
    private final VBox addSongFields = new VBox(10);
    private HBox topButtons;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Music Streaming App");

        initializeUI(primaryStage);
        addExampleSongs(); // Pre-populate with example songs
    }

    /**
     * Initializes the UI elements and layout.
     */
    private void initializeUI(Stage primaryStage) {
        // Search Field
        searchField.setPromptText("Search...");
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterList(newValue));

        // Buttons
        Button songsButton = new Button("Songs");
        Button artistsButton = new Button("Artists");
        Button playlistsButton = new Button("Playlists");
        Button addSongButton = new Button("+");
        Button addPlaylistButton = new Button("Add Playlist");
        Button faveSongsButton = new Button("Fave Songs");
        Button doneButton = new Button("Done");
        doneButton.setVisible(false);

        // Button Event Handlers
        songsButton.setOnAction(e -> showSongsList());
        artistsButton.setOnAction(e -> showArtistsList());
        playlistsButton.setOnAction(e -> showPlaylistsList());
        addPlaylistButton.setOnAction(e -> showAddPlaylistForm());
        addSongButton.setOnAction(e -> showAddSongFields(doneButton));
        doneButton.setOnAction(e -> addNewSong(doneButton));
        faveSongsButton.setOnAction(e -> showFaveSongsList());

        // Layout Setup
        topButtons = new HBox(10, songsButton, artistsButton, playlistsButton, addSongButton, addPlaylistButton, faveSongsButton);
        Label songLabel = new Label("Song Name:");
        Label artistLabel = new Label("Artist Name:");
        addSongFields.getChildren().addAll(songLabel, titleField, artistLabel, artistField, doneButton);
        addSongFields.setVisible(false);

        VBox layout = new VBox(10, topButtons, searchField, listView, addSongFields);
        layout.setPadding(new Insets(10));
        VBox.setVgrow(listView, javafx.scene.layout.Priority.ALWAYS);

        primaryStage.setScene(new Scene(layout, 600, 600));
        primaryStage.show();
    }

    /**
     * Filters the displayed list based on search query.
     */
    private void filterList(String query) {
        List<String> filteredSongs = new ArrayList<>();
        for (Song song : musicService.getAllSongs()) {
            if (song.getTitle().toLowerCase().contains(query.toLowerCase()) || song.getArtist().toLowerCase().contains(query.toLowerCase())) {
                filteredSongs.add(song.toString());
            }
        }
        listView.getItems().setAll(filteredSongs);
    }

    /**
     * Displays all favorite songs with more than 1000 listens.
     */
    private void showFaveSongsList() {
        listView.getItems().clear();
        addSongFields.setVisible(false);
        List<String> faveSongs = new ArrayList<>();
        for (Song song : musicService.getAllSongs()) {
            if (song.getPlayCount() > 1000) {
                faveSongs.add(song.toString());
            }
        }
        listView.getItems().setAll(faveSongs.isEmpty() ? List.of("No favorite songs found.") : faveSongs);
    }

    /**
     * Displays all artists in the music library.
     */
    private void showArtistsList() {
        listView.getItems().clear();
        addSongFields.setVisible(false);
        List<String> artists = new ArrayList<>();
        for (Song song : musicService.getAllSongs()) {
            if (!artists.contains(song.getArtist())) {
                artists.add(song.getArtist());
            }
        }
        listView.getItems().setAll(artists.isEmpty() ? List.of("No artists found.") : artists);
    }

    /**
     * Displays all playlists.
     */
    private void showPlaylistsList() {
        listView.getItems().setAll(musicService.getAllPlaylists().isEmpty() ? List.of("No playlists found.") : musicService.getAllPlaylists());
    }

    /**
     * Shows the add playlist form in a modal window.
     */
    private void showAddPlaylistForm() {
        Stage playlistStage = new Stage();
        playlistStage.setTitle("Add New Playlist");
        VBox formLayout = new VBox(10);
        TextField playlistNameField = new TextField();
        Button createButton = new Button("Create Playlist");
        formLayout.getChildren().addAll(new Label("Playlist Name:"), playlistNameField, createButton);
        createButton.setOnAction(e -> {
            if (!playlistNameField.getText().isEmpty()) {
                musicService.addPlaylist(playlistNameField.getText());
                playlistStage.close();
            }
        });
        playlistStage.setScene(new Scene(formLayout, 300, 200));
        playlistStage.initModality(Modality.APPLICATION_MODAL);
        playlistStage.show();
    }

    /**
     * Adds example songs to the music library.
     */
    private void addExampleSongs() {
        musicService.addSong(new Song("Shape of You", "Ed Sheeran", 127191452));
        musicService.addSong(new Song("Blinding Lights", "The Weeknd", 130000000));
        musicService.addSong(new Song("Levitating", "Dua Lipa", 45000000));
        musicService.addSong(new Song("Save Your Tears", "The Weeknd", 90000000));
        showSongsList();
    }

    /**
     * Displays all songs in the library.
     */
    private void showSongsList() {
        listView.getItems().setAll(musicService.getAllSongs().stream().map(Song::getTitle).toList());
    }

    /**
     * Displays input fields for adding a new song.
     */
    private void showAddSongFields(Button doneButton) {
        addSongFields.setVisible(true);
        listView.setVisible(false);
        titleField.clear();
        artistField.clear();
        doneButton.setVisible(true);
    }

    /**
     * Adds a new song to the music library.
     */
    private void addNewSong(Button doneButton) {
        if (!titleField.getText().isEmpty() && !artistField.getText().isEmpty()) {
            musicService.addSong(new Song(titleField.getText(), artistField.getText(), 0));
            showSongsList();
            doneButton.setVisible(false);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
