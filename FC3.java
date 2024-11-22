public class FC3 {
    public static void main (String [] args) {
        //An Array for the Name of Students
        String [] sNames = {
            "Shin",
            "Yuri",
            "Aki",
            "Zed",
            "Ken"
        };

        //Array for Grades in 3 Subjects
        int [][] sGrades = {
            {89, 98, 80}, //Grade of Shin
            {87, 88, 89}, //Grade of Yuri
            {90, 87, 88}, //Grade of Aki
            {91, 87, 83}, //Grade of Zed
            {90, 92, 91}, //Grade of Ken
        };

        //Loop that Shows the Name and Grade of Students
        for (int i = 0; i < sNames.length; i++) {
            System.out.print("Grade of " + (sNames[i])); //this Shows the Name
                for (int g = 0; g < sGrades[i].length ; g++) {
                System.out.print(" " + sGrades[i][g]); //This Shows the Grades
            }

            // Calculate the Sum of Grades for Each Students
            int tGrades = 0;
                for (int g = 0; g < sGrades[i].length; g++) {
                    tGrades += sGrades[i][g]; // Adds the Total of Grades to tGrades
                }

            //Calculate the Average Grade
            double averageG = tGrades / (double) sGrades[i].length; // Use double for Division to get more Accurate Answer
            //Display the Average Grade
            System.out.println("  \nAverage: " + averageG);
            System.out.println(); //An Enmty Line for Readability
        }

    }
}
