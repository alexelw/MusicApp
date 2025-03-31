# MusicApp
Overview
This project is a Music Streaming App Emulator built using Java, JavaFX, and Maven. The app allows users to manage songs, artists, and playlists. It features a graphical user interface (GUI) where you can add new songs, view songs by artists, add songs to playlists, and much more.

Prerequisites
To run this project, you need the following software installed:

Java (JDK 11 or higher)

Maven (to manage dependencies)

JavaFX SDK (to create the graphical user interface)

Visual Studio (or another Java IDE like IntelliJ IDEA or Eclipse)

Installing Java and Maven
Install Java (JDK 11 or higher):

Download and install the JDK from the official Oracle website.

After installation, ensure that the JAVA_HOME environment variable is set, and the java command is available in your terminal or command prompt.

Install Maven:

Download and install Maven from Maven's official website.

After installation, set the MAVEN_HOME environment variable and ensure the mvn command is accessible from your terminal or command prompt.

Installing JavaFX
Download the JavaFX SDK from OpenJFX.

Add the JavaFX SDK to your project using Maven (as shown in the pom.xml file).

Setup
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/music-streaming-app.git
cd music-streaming-app
Install project dependencies using Maven:

bash
Copy
Edit
mvn clean install
This will download and install all necessary dependencies, including JavaFX.

Setup JavaFX with Maven: Ensure your pom.xml file includes the necessary dependencies for JavaFX. For example:

xml
Copy
Edit
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>17</version>
    </dependency>
</dependencies>
Run the project:

If using Visual Studio Code with the Java Extension Pack:

Open the project folder.

Open the terminal and run the following command:

bash
Copy
Edit
mvn javafx:run
If using IntelliJ IDEA or Eclipse:

Import the project as a Maven project.

Run the Main class which launches the JavaFX application.

Features
Add Songs: Users can add new songs by providing the title, artist, and play count.

Create Playlists: Users can create custom playlists and add songs to them.

View Playlists: Users can view the songs in any of their playlists.

View Artist's Songs: Double-click on an artist to see all songs from that artist.

Add Songs to Playlists: Easily add songs to existing playlists via the GUI.

Interactive GUI: The app has a user-friendly graphical interface built using JavaFX.

File Structure
Main.java: Entry point for the application, responsible for launching the JavaFX UI.

MusicService.java: Manages the songs and playlists, allowing adding/removing songs and playlists.

Song.java: Represents a song with properties like title, artist, and play count.

GUI components: JavaFX components for displaying songs, artists, and playlists.

Usage
Add a New Song:

Click on the Add Song button.

Enter the title, artist, and play count.

Click Done to add the song to the list.

View Songs by Artist:

Double-click on an artist name.

A list of all songs by that artist will appear.

Add Song to Playlist:

Double-click on a song.

Select a playlist from the list to add the song.

Create a New Playlist:

Click on the Create Playlist button.

Enter a name for the new playlist and it will be added.

Troubleshooting
JavaFX not found: If you encounter issues with JavaFX not being found, ensure that the JavaFX SDK is correctly added to your Maven dependencies and that your system is properly configured to recognize JavaFX.

Maven build errors: Run mvn clean install to ensure all dependencies are correctly downloaded and installed.

