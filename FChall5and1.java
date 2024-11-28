import javax.swing.JOptionPane; // Import JOptionPane for graphical user interface dialogs

// Custom Exception for Insufficient Funds
class InsufficientFundsException extends Exception {
    // Constructor to initialize the exception with a custom error message
    public InsufficientFundsException(String message) {
        super(message); // Pass the error message to the base Exception class
    }
}

public class FChall5and1 {
    public static void main(String[] args) {
        double bal = 100000.0; // Initialize account balance to PHP 100,000

        // Loop to keep the program running until the user chooses to exit
        while (true) {
            try {
                // Display menu options for the user
                String[] options = {"Withdraw", "Check Balance", "Exit"}; // Menu options
                int choice = JOptionPane.showOptionDialog(
                        null, // Parent component (null for default)
                        "Select Option", // Message to display
                        "Banking System", // Title of the dialog
                        JOptionPane.DEFAULT_OPTION, // Type of options (custom buttons)
                        JOptionPane.INFORMATION_MESSAGE, // Type of message (informational)
                        null, // No custom icon
                        options, // Array of button labels
                        options[0] // Default selected option
                );

                if (choice == 0) { // User selected "Withdraw"
                    // Prompt the user to enter the withdrawal amount
                    String input = JOptionPane.showInputDialog("Current Balance " + bal +  "\n Enter amount to withdraw:");
                    if (input == null) continue; // If the user cancels, return to the menu

                    double amount = Double.parseDouble(input); // Convert input to a double

                    // Check if the withdrawal amount exceeds the balance
                    if (amount > bal) {
                        // Throw a custom exception with a detailed message
                        throw new InsufficientFundsException("Insufficient funds. Your balance is: PHP" + bal);
                    }

                    bal -= amount; // Deduct the withdrawal amount from the balance
                    // Inform the user that the withdrawal was successful
                    JOptionPane.showMessageDialog(null, "Withdrawal successful! New balance: PHP" + bal);

                } else if (choice == 1) { // User selected "Check Balance"
                    // Display the current balance to the user
                    JOptionPane.showMessageDialog(null, "Your current balance is: PHP" + bal);

                } else if (choice == 2) { // User selected "Exit"
                    // Show a goodbye message and exit the loop
                    JOptionPane.showMessageDialog(null, "Thank you for using the Banking System. ");
                    break; // Exit the loop to end the program
                }

            } catch (InsufficientFundsException e) {
                // Handle custom exception for insufficient funds
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                // Handle invalid if the input is not a number
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
