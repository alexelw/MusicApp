package com.example;

import java.util.Objects;

public class Song {
    private String title;   // Title of the song
    private String artist;  // Artist of the song
    private int playCount;  // Number of times the song has been played

    // Constructor to initialize a song with title, artist, and play count
    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    // Getter for the title of the song
    public String getTitle() {
        return title;
    }

    // Getter for the artist of the song
    public String getArtist() {
        return artist;
    }

    // Getter for the play count of the song
    public int getPlayCount() {
        return playCount;
    }

    // Overriding toString method for better string representation of the song
    @Override
    public String toString() {
        return title + " - " + artist + " (" + playCount + " plays)";
    }

    // Overriding equals to compare two songs based on their title and artist
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Same object comparison
        if (o == null || getClass() != o.getClass()) return false; // Check for null or different class
        Song song = (Song) o;
        return title.equals(song.title) && artist.equals(song.artist); // Compare title and artist
    }

    // Overriding hashCode to generate a unique hash code for songs based on title and artist
    @Override
    public int hashCode() {
        return Objects.hash(title, artist); // Using title and artist to generate hash code
    }
}
