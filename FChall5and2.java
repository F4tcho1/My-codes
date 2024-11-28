// Custom Exception for No Seats Available

import javax.swing.JOptionPane;

class NoSeatsAvailableException extends Exception{
    public NoSeatsAvailableException (String message){ //Constructor to Initialize the Exception
        super (message); // Pass the Error Message to the Exception
    }
}

public class FChall5and2 {
    public static void main (String [] args) {
        int available = 5; // Number of Available Seats

        // Loop Until The User Choose to Exit
        while (true) {
            try {
                
                //Display Options to the User
                String [] optios = { "Book Seat","View Available Seat", "Exit"};
                int choice = JOptionPane.showOptionDialog(null, "Select Options", "Booking System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optios, optios[0]);
                
                if (choice == 0) { // User Selects to Book a Seat
                    
                    // Check the Available Seats
                    if (available <=0 ) {
                        throw new NoSeatsAvailableException("No Seats Available"); // Throw Custom Exception if no Seats Available
                    }
                    // Decrease Seats Available
                    available --;
                    
                    // Inform The User that the Booking was Successfull
                    JOptionPane.showMessageDialog(null, "Booking Successfull!");
                    
                } else if (choice == 1) { // User Chooses to View Available Seat
                    JOptionPane.showMessageDialog(null, "Seats Avai;able " + available); // Display the Seats Available
                
                } else if (choice == 2) { // User Selets to Exit
                JOptionPane.showMessageDialog(null, "Thank You! Have a Grat Day "); // Shows a Exiting Message
                break; // Stops the Loop and Exit the Program
                }

            } catch (NoSeatsAvailableException e) {
                // Handle the Custom Exception for No Seats Available
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
            }
        }
    }
}
