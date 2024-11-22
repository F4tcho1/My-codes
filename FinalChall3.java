import java.util.Scanner;

public class FinalChall3 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Define the number of students and subjects
        int names = 5; // Number of students
        int sub = 3;   // Number of subjects

        // Array to store the names of students
        String[] name = new String[names];

        // Array to store students' grades for each subject
        float[][] grades = new float[names][sub];

        // Prompt user to input the names of the students
        System.out.println("Please Enter The Name Of 5 Students");

        // User inputs the names of the students
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Student " + (i + 1) + " Name: ");
            name[i] = sc.nextLine();  // Store each student's name in the 'name' array
        }
        
        // Subjects
        String[] subjects = {"CC1", "CC2", "CC7"};  // Array of subjects

        // User inputs the grades for each student
        for (int i = 0; i < names; i++) {
            System.out.println("\nName: " + name[i]);  // Display student's name
            for (int s = 0; s < sub; s++) {
                // Ask the user to input the grade for each subject
                System.out.print("Enter Grade for " + subjects[s] + ": ");
                
                grades[i][s] = sc.nextFloat();  // Store the grade in the 2D array

                // Check if the grade is outside the valid range (0 to 100)
                if (grades[i][s] > 100 || grades[i][s] < 0) {
                    // If grade is invalid, print an error message and ask for re-entry
                    System.out.println("Grades should not be greater than 100 or less than 0.");
                    s--;  //System asks the user to re-input the grade if it is grater than 100 or less than 0
                }
            }
        }

        // Calculate and display the average grades for each student
        System.out.println("\nAverage Grades:");
        for (int i = 0; i < names; i++) {
            int sum = 0;  // Variable to store the sum of grades for the student

            // Loop to calculate the sum of grades
            for (int j = 0; j < sub; j++) {
                sum += grades[i][j];  // Add the grade to the sum
            }

            // Calculate the average by dividing the sum by the number of subjects
            double average = sum / (double) sub;

            // Display the student's name and their average grade
            System.out.println(name[i] + "'s average grade: " + average);
        }

        // Close the scanner
        sc.close();
    }
}
