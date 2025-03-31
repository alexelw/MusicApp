package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicService {
    private List<Song> songs;  // List to store all the songs
    private Map<String, List<Song>> playlists;  // Map to store playlists, each containing a list of songs

    // Constructor to initialize songs and playlists
    public MusicService() {
        songs = new ArrayList<>();
        playlists = new HashMap<>();
        
        // Pre-populating with 10 songs
        prePopulateSongs();
        
        // Pre-populating playlists with example songs
        prePopulatePlaylists();
    }

    // Method to pre-populate songs
    private void prePopulateSongs() {
        addSong(new Song("Shape of You", "Ed Sheeran", 127191452));
        addSong(new Song("Blinding Lights", "The Weeknd", 130000000));
        addSong(new Song("Levitating", "Dua Lipa", 45000000));
        addSong(new Song("Save Your Tears", "The Weeknd", 90000000));
        addSong(new Song("Bad Habits", "Ed Sheeran", 140000000));
        addSong(new Song("Watermelon Sugar", "Harry Styles", 90000000));
        addSong(new Song("Good 4 U", "Olivia Rodrigo", 55000000));
        addSong(new Song("Peaches", "Justin Bieber", 100000000));
        addSong(new Song("Kiss Me More", "Doja Cat", 70000000));
        addSong(new Song("Stay", "The Kid LAROI & Justin Bieber", 70000000));
    }

    // Method to pre-populate playlists with example songs
    private void prePopulatePlaylists() {
        playlists.put("Playlist 1", new ArrayList<>());
        playlists.put("Playlist 2", new ArrayList<>());
        playlists.put("Playlist 3", new ArrayList<>());
        
        // Adding some songs to playlists
        playlists.get("Playlist 1").add(songs.get(0)); // Add "Shape of You" to Playlist 1
        playlists.get("Playlist 2").add(songs.get(1)); // Add "Blinding Lights" to Playlist 2
        playlists.get("Playlist 3").add(songs.get(2)); // Add "Levitating" to Playlist 3
    }

    // Method to get all songs in the service
    public List<Song> getAllSongs() {
        return songs;
    }

    // Method to get all playlist names
    public List<String> getAllPlaylists() {
        return new ArrayList<>(playlists.keySet());
    }

    // Method to add a new song to the service
    public void addSong(Song song) {
        songs.add(song);
    }

    // Method to add a new playlist
    public void addPlaylist(String playlistName) {
        playlists.putIfAbsent(playlistName, new ArrayList<>());
    }

    // Method to add a song to a specific playlist
    public void addSongToPlaylist(Song song, String playlistName) {
        List<Song> playlist = playlists.get(playlistName);
        if (playlist != null && song != null && !playlist.contains(song)) {
            playlist.add(song);  // Add the song to the playlist
            System.out.println("Added song: " + song + " to playlist: " + playlistName);
        }
    }

    // Method to remove a song from a specific playlist
    public void removeSongFromPlaylist(Song song, String playlistName) {
        List<Song> playlist = playlists.get(playlistName);
        if (playlist != null) {
            // Debugging: Check if the song exists before trying to remove
            for (Song s : playlist) {
                System.out.println("Checking song: " + s.getTitle() + " by " + s.getArtist());
            }
    
            // Removing song based on title and artist match
            boolean removed = playlist.removeIf(s -> s.getTitle().equals(song.getTitle()) && s.getArtist().equals(song.getArtist()));
    
            if (removed) {
                System.out.println("Song removed successfully: " + song.getTitle());
            } else {
                System.out.println("Song not found in playlist: " + song.getTitle());
            }
        }
    }

    // Method to get all songs in a specific playlist
    public List<Song> getSongsInPlaylist(String playlistName) {
        return playlists.getOrDefault(playlistName, new ArrayList<>());
    }
}
