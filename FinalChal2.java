import java.util.Scanner;

public class FinalChal2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        
        //2D array to store temperatures for 3 cities over 7 days
        double [][] temp = new double[3][7];

        for (int city = 0;  city < 3; city++) {
            System.out.print("Enter Temperature for City " + (city + 1) + ": ");
            sc.nextLine();
                for (int day = 0; day < 7; day++) {
                    System.out.print("Day " + (day + 1 ) + ": ");
                    temp[city][day] = sc.nextDouble();
                }
                System.out.println();
        }

        //Calculate an display the average temperature and highest temperature each city
        for (int city = 0; city < 3; city++) {
            double tTemp = 0;//Total Temperature
            double hTemp = temp[city][0];//Highest Temperature

            for (int day = 0; day < 7; day++) {
                tTemp = temp[city][day];

                //Get the Highest Temperature
                if(temp[city][day] > hTemp) {
                    hTemp = temp[city][day];
                }
            }
        

        //Calculate Average Temperature
        double aTemp = tTemp / 7;//aTemp = Average Temperature

        System.out.println("City " + (city + 1) + " - Average Temperature: " + aTemp);
        System.out.println("City " + (city + 1) + " - Highest Temperature: " + hTemp);
        }

        sc.close();

    }
}