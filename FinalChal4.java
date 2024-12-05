import javax.swing.JOptionPane;

// Class to represent a single song node in the circular doubly linked list
class SongNode {
    String songName; // The name of the song
    SongNode next;   // Pointer to the next song in the playlist
    SongNode prev;   // Pointer to the previous song in the playlist

    // Constructor to initialize a song node
    public SongNode(String songName) {
        this.songName = songName;
        this.next = null;
        this.prev = null;
    }
}

// Main class for managing the circular doubly linked list (music playlist)
public class FinalChal4 {
    private SongNode head;    // Pointer to the head (start) of the playlist
    private SongNode current; // Pointer to the current song being played

    // Constructor to initialize an empty playlist
    public FinalChal4() {
        head = null;    // Head starts as null (empty playlist)
        current = null; // No current song when the playlist is empty
    }

    // Add a new song to the playlist
    public void addSong(String songName) {
        SongNode newSong = new SongNode(songName); // Create a new song node
        if (head == null) { // If the playlist is empty
            head = newSong; // The new song becomes the head
            head.next = head; // Point the next of the head to itself
            head.prev = head; // Point the prev of the head to itself
        } else { // If the playlist is not empty
            SongNode tail = head.prev; // Get the last song in the playlist
            tail.next = newSong; // Set the current last song's next to the new song
            newSong.prev = tail; // Set the new song's prev to the current last song
            newSong.next = head; // Point the new song's next to the head
            head.prev = newSong; // Update the head's prev to the new song
        }
        if (current == null) { // If no current song, set it to the head
            current = head;
        }
        JOptionPane.showMessageDialog(null, "Song added: " + songName);
    }

    // Remove a song from the playlist
    public void removeSong(String songName) {
        if (head == null) { // If the playlist is empty
            JOptionPane.showMessageDialog(null, "The playlist is empty!");
            return;
        }
        SongNode temp = head;
        do {
            if (temp.songName.equals(songName)) { // Song found
                if (temp == head && head.next == head) { // Only one song in the playlist
                    head = null; // Playlist becomes empty
                    current = null; // No current song
                } else { // More than one song in the playlist
                    temp.prev.next = temp.next; // Adjust the previous node's next pointer
                    temp.next.prev = temp.prev; // Adjust the next node's prev pointer
                    if (temp == head) { // If the song to remove is the head
                        head = temp.next; // Update the head to the next song
                    }
                    if (temp == current) { // If the song to remove is the current song
                        current = temp.next; // Update the current to the next song
                    }
                }
                JOptionPane.showMessageDialog(null, "Song removed: " + songName);
                return; // Exit after removing the song
            }
            temp = temp.next; // Move to the next song
        } while (temp != head); // Stop when we've looped back to the start
        JOptionPane.showMessageDialog(null, "Song not found: " + songName);
    }

    // Move to the next song
    public void nextSong() {
        if (current == null) { // If the playlist is empty
            JOptionPane.showMessageDialog(null, "The playlist is empty!");
        } else {
            current = current.next; // Move to the next song
            JOptionPane.showMessageDialog(null, "Now playing: " + current.songName);
        }
    }

    // Move to the previous song
    public void previousSong() {
        if (current == null) { // If the playlist is empty
            JOptionPane.showMessageDialog(null, "The playlist is empty!");
        } else {
            current = current.prev; // Move to the previous song
            JOptionPane.showMessageDialog(null, "Now playing: " + current.songName);
        }
    }

    // Display the current song
    public void displayCurrentSong() {
        if (current == null) { // If the playlist is empty
            JOptionPane.showMessageDialog(null, "The playlist is empty!");
        } else {
            JOptionPane.showMessageDialog(null, "Current song: " + current.songName);
        }
    }

    // Display all songs in the playlist
    public void displayPlaylist() {
        if (head == null) { // If the playlist is empty
            JOptionPane.showMessageDialog(null, "The playlist is empty!");
            return;
        }
        StringBuilder playlist = new StringBuilder("Playlist:\n");
        SongNode temp = head;
        do {
            playlist.append(temp.songName).append("\n"); // Append song name to the list
            temp = temp.next; // Move to the next song
        } while (temp != head); // Stop when we've looped back to the start
        JOptionPane.showMessageDialog(null, playlist.toString());
    }

    // Main method for user interaction
    public static void main(String[] args) {
        FinalChal4 playlist = new FinalChal4(); // Create a new playlist
        while (true) { // Infinite loop for the menu
            // Options for the user
            String[] options = {
                "Add Song", "Remove Song", "Next Song", "Previous Song",
                "Current Song", "Show Playlist", "Exit"
            };
            // Display menu and get user's choice
            int choice = JOptionPane.showOptionDialog(
                null, "Choose an option:", "Music Playlist",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]
            );

            switch (choice) {
                case 0: // Add Song
                    String songToAdd = JOptionPane.showInputDialog("Enter the song name:");
                    if (songToAdd != null && !songToAdd.isEmpty()) {
                        playlist.addSong(songToAdd);
                    }
                    break;

                case 1: // Remove Song
                    String songToRemove = JOptionPane.showInputDialog("Enter the song name to remove:");
                    if (songToRemove != null && !songToRemove.isEmpty()) {
                        playlist.removeSong(songToRemove);
                    }
                    break;

                case 2: // Next Song
                    playlist.nextSong();
                    break;

                case 3: // Previous Song
                    playlist.previousSong();
                    break;

                case 4: // Current Song
                    playlist.displayCurrentSong();
                    break;

                case 5: // Show Playlist
                    playlist.displayPlaylist();
                    break;

                case 6: // Exit
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0); // Exit the program
                    break;

                default: // Invalid choice
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }
}
