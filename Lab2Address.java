import java.util.Scanner;

public class Lab2Address {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Dimension: ");
        int d = sc.nextInt();
        if (d <= 0) {
            System.out.println("Error: Dimension must be greater than zero");
            return;
        }
        
        int [][] bounds =new int[d][2];
        for (int i = 0; i < d; i++ ) {
            System.out.print("Enter lower bound for dimension " + (i + 1) + ": ");
            bounds[i][0] = sc.nextInt();
            System.out.print("Enter upper bound for dimension " + (i + 1) + ": ");
            bounds[i][1] = sc.nextInt();

            if (bounds[i][0] > bounds[i][1]) {
                System.out.println("Error: Lower bound must be less than or equal to upper bound.");
                return; 
            }
        }        
        
        System.out.print("Enter the Base Address : ");
        int bAddress = sc.nextInt();
        System.out.print("Enter Size of Element : ");
        int eSize = sc.nextInt();
        if (eSize <= 0) {
            System.out.println("Error: Element Size must be Greater than Zero");
        }

        int indices [] = new int [d];
        for (int i = 0; i < d; i++) {
            System.out.print("Enter the index for dimension " + (i + 1) + ": ");
            indices[i] = sc.nextInt();
        
            if (indices[i] < bounds[i][0] || indices[i] > bounds[i][1]) {
                System.out.println("Error: Index for dimension " + (i + 1) + " is out of bounds.");
                return;
            }
        }

        int totalElements = 1;
        for (int i = 0; i < d; i++) {
            int dimensionSize = bounds[i][1] - bounds[i][0] + 1;
            totalElements *= dimensionSize;
        }
        System.out.println("Total number of elements in the array: " + totalElements);

        int address = bAddress; 
        for (int i = 0; i < d; i++) {
            int offset = (indices[i] - bounds[i][0]); 
            for (int j = i + 1; j < d; j++) {
                offset *= (bounds[j][1] - bounds[j][0] + 1);
            }
            address += offset * eSize; 
        }
        System.out.println("The address of the specified element is: " + address);

        sc.close();
    }

}
