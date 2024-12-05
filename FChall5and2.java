import javax.swing.JOptionPane;

class NoSeatsAvailableException extends Exception {
    public NoSeatsAvailableException(String message) { // Constructor to Initialize the Exception
        super(message); // Pass the Error Message to the Exception
    }
}

public class FChall5and2 {
    public static void main(String[] args) {
        int totalSeats = 5; // Total number of available seats
        int available = totalSeats; // Initially all seats are available

        // Loop until the user chooses to exit
        while (true) {
            try {
                
                // Display options to the user
                String[] options = { "Book Seat", "View Available Seats", "Exit" };
                int choice = JOptionPane.showOptionDialog(null, "Select Option", "Booking System", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (choice == 0) { // User selects to book a seat
                    
                    // Check the available seats
                    if (available <= 0) {
                        throw new NoSeatsAvailableException("No seats available. Please try again later.");
                    }
                    
                    // Warn the user if there are fewer than 3 seats remaining
                    if (available <= 3) {
                        JOptionPane.showMessageDialog(null, "Warning: Only " + available + " seats left!");
                    }
                    
                    // Confirmation dialog before booking
                    int confirmation = JOptionPane.showConfirmDialog(null, 
                            "Are you sure you want to book a seat?", 
                            "Confirm Booking", 
                            JOptionPane.YES_NO_OPTION);
                    
                    if (confirmation == JOptionPane.YES_OPTION) {
                        // Decrease available seats
                        available--;
                        
                        // Inform the user that the booking was successful
                        JOptionPane.showMessageDialog(null, "Booking successful! Seats remaining: " + available);
                    } else {
                        JOptionPane.showMessageDialog(null, "Booking cancelled.");
                    }
                    
                } else if (choice == 1) { // User chooses to view available seats
                    // Display the total and available seats to the user
                    JOptionPane.showMessageDialog(null, "Total seats: " + totalSeats + "\nAvailable seats: " + available);
                
                } else if (choice == 2) { // User selects to exit
                    JOptionPane.showMessageDialog(null, "Thank you! Have a great day.");
                    break; // Exit the loop and end the program
                }

            } catch (NoSeatsAvailableException e) {
                // Handle the custom exception for no seats available
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
