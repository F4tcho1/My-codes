import java.util.Arrays;
import java.util.Scanner;

public class Practice1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        double [] grades = new double[5];
        double sum = 0, average = 0;
        for (int ctr = 0; ctr < grades.length; ctr++)  {
            System.out.print("Enter Grade Student[" + (ctr + 1) + "] : " );
            grades[ctr] =sc.nextDouble();

            sum = sum + grades[ctr];
            average = sum / grades.length;

        }
        System.out.println();
        System.out.println("Sum: " + sum);
        System.out.println("Average:" + average);
        
        Arrays.sort(grades);
        System.out.println("Lowest Grade: " + grades[0]); 
        System.out.println("Highest Grade: " + grades[grades.length-1]);
        
        sc.close();
    }

}
