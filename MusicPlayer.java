package Project;
import java.util.Scanner;

class Song {
    Song next;
    String title;
    String artist;
    int duration;

    Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
}

class LinkedList {
    Song head = null;
    Song tail = null;
    int size = 0;

    void insertEnd(String title, String artist, int duration) {
        Song temp = new Song(title, artist, duration);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    void insertBig(String title, String artist, int duration) {
        Song temp = new Song(title, artist, duration);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    void moving(int place1, int place2) {
        if (place1 == place2 || place1 < 1 || place1 > size || place2 < 1 || place2 > size) {
            System.out.println("Invalid positions for moving.");
            return;
        }

        // Step 1: Remove song at place1
        Song prev = null, current = head;
        for (int i = 1; i < place1; i++) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = current.next;
        }
        if (current == tail) {
            tail = prev;
        }
        size--;

        // Step 2: Insert song at place2
        insert(place2, current.title, current.artist, current.duration);
    }

    void insert(int number, String title, String artist, int duration) {
        if (number < 1 || number > size + 1) {
            System.out.println("Invalid position.");
            return;
        }

        Song temp = new Song(title, artist, duration);
        if (number == 1) {
            temp.next = head;
            head = temp;
            if (tail == null) tail = temp;
        } else {
            Song t = head;
            for (int i = 1; i < number - 1; i++) {
                t = t.next;
            }
            temp.next = t.next;
            t.next = temp;
            if (temp.next == null) tail = temp;
        }
        size++;
    }

    void remove(int number) {
        if (number < 1 || number > size) {
            System.out.println("Invalid position.");
            return;
        }

        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (number == 1) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            Song temp = head;
            for (int i = 1; i < number - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (number == size) tail = temp;
        }
        size--;
    }

    void display() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.title + " | " + temp.artist + " | " + temp.duration + " sec");
            temp = temp.next;
            index++;
        }
    }
}

public class MusicPlayer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList playlist = new LinkedList();

        while (true) {
            System.out.println("\n1. Add Song at End");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Move Song");
            System.out.println("5. Insert Song in Middle");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

            int ch = input.nextInt();
            input.nextLine();

            if (ch == 6) break;

            switch (ch) {
                case 1:
                    System.out.print("Enter the title of the song: ");
                    String title = input.nextLine();
                    System.out.print("Enter the name of the artist: ");
                    String artist = input.nextLine();
                    System.out.print("Enter the duration of the song (in seconds): ");
                    int duration = input.nextInt();
                    playlist.insertEnd(title, artist, duration);
                    System.out.println();
                    System.out.println("Song added to the playlist!");
                    break;

                case 2:
                    System.out.print("Enter the song number to remove: ");
                    int number = input.nextInt();
                    playlist.remove(number);
                    System.out.println();
                    System.out.println("song removed successfully!");
                    break;

                case 3:
                    System.out.println("Current Playlist:");
                    playlist.display();
                    break;

                case 4:
                    System.out.print("Enter the song number to move: ");
                    int place1 = input.nextInt();
                    System.out.print("Enter the new position: ");
                    int place2 = input.nextInt();
                    playlist.moving(place1, place2);
                    System.out.println();
                    System.out.println("Song moved successfully!");
                    break;

                case 5:
                    System.out.println();
                    System.out.print("Enter the position where you want to insert the song: ");
                    int place3 = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter the title of the song: ");
                    String title1 = input.nextLine();
                    System.out.print("Enter the name of the artist: ");
                    String artist1 = input.nextLine();
                    System.out.print("Enter the duration of the song (in seconds): ");
                    int duration1 = input.nextInt();
                    playlist.insert(place3, title1, artist1, duration1);
                    System.out.println();
                    System.out.println("Song inserted into the playlist!");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
        input.close();
    }
}


