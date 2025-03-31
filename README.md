# Music Streaming App

## Overview
This project is a **Music Streaming App Emulator** built using **Java**, **JavaFX**, and **Maven**. The app allows users to manage songs, artists, and playlists. It features a graphical user interface (GUI) where you can add new songs, view songs by artists, add songs to playlists, and much more.

---

## Prerequisites

Before running the project, make sure you have the following software installed:

- **Java** (JDK 11 or higher)
- **Maven** (to manage dependencies)
- **JavaFX SDK** (to create the graphical user interface)
- **Visual Studio Code** (or another Java IDE like IntelliJ IDEA or Eclipse)

### Installing Java and Maven

1. **Install Java (JDK 11 or higher):**
   - Download and install the JDK from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
   - After installation, ensure that the `JAVA_HOME` environment variable is set, and the `java` command is available in your terminal or command prompt.

2. **Install Maven:**
   - Download and install Maven from [Maven's official website](https://maven.apache.org/download.cgi).
   - After installation, set the `MAVEN_HOME` environment variable and ensure the `mvn` command is accessible from your terminal or command prompt.

### Installing JavaFX

1. Download the **JavaFX SDK** from [OpenJFX](https://openjfx.io/).
2. Add the JavaFX SDK to your project using Maven (as shown in the `pom.xml` file).

---

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/music-streaming-app.git
   cd music-streaming-app
   
2. **Install project dependencies using Maven:**
This will download and install all necessary dependencies, including JavaFX.

   ```bash
   Copy
   Edit
   mvn clean install

3. **Setup JavaFX with Maven:**
Ensure your pom.xml file includes the necessary dependencies for JavaFX. Example:

   ```bash
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

4. **Run the project:**
If using Visual Studio Code with the Java Extension Pack:

Open the project folder.

Open the terminal and run the following command:

   ```bash
   bash
   Copy
   Edit
   mvn javafx:run

If using IntelliJ IDEA or Eclipse:

Import the project as a Maven project.

Run the Main class which launches the JavaFX application.
