import javax.swing.JOptionPane;

public class JOptionDrill {
    public static void main (String [] args) {
            // Step 1: Ask for the user's name
            String name, color;

            while(true){
            name = JOptionPane.showInputDialog("What is your name?");
            
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Name.");
                break;
            }
            
            color = JOptionPane.showInputDialog("What is your favorite color?");
            
            if (color == null || color.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You didn't enter a color.");
                break;
            }
            int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "You entered the name: " + name + "\nYour favorite color is: " + color + ".\nIs this correct?",
                    "Confirm Information",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.NO_OPTION) {
                continue;
            }
            if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,"goodbye" );
                break;
            }
        }
    }
}
