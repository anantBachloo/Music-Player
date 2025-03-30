🎵 Music Player Manager – Detailed Explanation
📌 Overview
The Music Player Manager is a Java-based console application that simulates a simple playlist manager using Linked List and Object-Oriented Programming (OOP) concepts. It allows users to perform essential operations on a playlist, such as adding, removing, moving, and displaying songs.

🏗️ Project Breakdown
1️⃣ Song Class (Song.java)
The Song class represents a single song in the playlist.

Attributes:
title (String) → Stores the song title.

artist (String) → Stores the artist's name.

duration (int) → Stores the song duration in seconds.

next (Song) → Points to the next song in the playlist (used for the linked list).

Constructor:
java
Copy
Edit
Song(String title, String artist, int duration) {
    this.title = title;
    this.artist = artist;
    this.duration = duration;
}
Initializes a song with a title, artist, and duration.

2️⃣ LinkedList Class (LinkedList.java)
This class manages the playlist using a singly linked list.

Attributes:
head → Points to the first song in the list.

tail → Points to the last song in the list.

size → Keeps track of the total number of songs.

Key Methods:
insertEnd(String title, String artist, int duration)

Adds a song to the end of the playlist.

If the playlist is empty, it sets both head and tail to the new song.

Otherwise, the new song is linked at the end.

insertBig(String title, String artist, int duration)

Adds a song to the beginning of the playlist.

insert(int position, String title, String artist, int duration)

Inserts a song at a specific position in the playlist.

Updates pointers to maintain the linked list structure.

remove(int position)

Removes a song from a specific position in the playlist.

If the song is at the beginning, updates the head.

If it’s the last song, updates the tail.

moving(int place1, int place2)

Moves a song from position place1 to position place2.

Removes the song and reinserts it at the new position.

display()

Prints the current playlist with song details.

If the playlist is empty, it notifies the user.

3️⃣ Music Player (MusicPlayer.java)
This is the main program that interacts with the user via a menu-driven system.

Features & Functionality:
🔹 Displays a menu with options.
🔹 Takes user input to perform actions.
🔹 Uses a while (true) loop to keep running until the user exits.

Menu Options:
java
Copy
Edit
System.out.println("\n1. Add Song at End");
System.out.println("2. Remove Song");
System.out.println("3. Display Playlist");
System.out.println("4. Move Song");
System.out.println("5. Insert Song in Middle");
System.out.println("6. Exit");
Choice 1 → Adds a song to the end.

Choice 2 → Removes a song from a given position.

Choice 3 → Displays the entire playlist.

Choice 4 → Moves a song to a different position.

Choice 5 → Inserts a song at a given position.

Choice 6 → Exits the program.

⚡ Code Execution Flow
1️⃣ User selects an option.
2️⃣ The program processes the request.
3️⃣ The linked list structure updates accordingly.
4️⃣ The playlist reflects the changes.

📂 Project Structure
bash
Copy
Edit
Music-Player-Manager/
│── Project/
│   │── MusicPlayer.java  # Main program with user interaction  
│   │── LinkedList.java   # Manages playlist using linked list  
│   │── Song.java         # Represents a single song  
Project/ → Contains all Java files.

MusicPlayer.java → Main file for user interaction.

LinkedList.java → Manages the playlist logic.

Song.java → Represents individual songs.

🎯 Why Use Linked Lists for Playlists?
✅ Efficient Insertions & Deletions – No need to shift elements (unlike arrays).
✅ Dynamic Size – The playlist grows as needed.
✅ Flexible Rearrangement – Easy to move or remove songs.

🛠️ How to Run the Project
🔹 Prerequisites
Install Java (JDK 8 or later).

A Java-compatible IDE (e.g., IntelliJ, VS Code, Eclipse) or a command-line terminal.

🚀 Future Enhancements
🔹 Add shuffle functionality.
🔹 Implement search for songs by title or artist.
🔹 Enable save/load feature to persist playlist data.
🔹 GUI version using JavaFX or Swing.

