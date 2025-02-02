import java.util.Scanner;

public class Lab2Records {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Fields");
        int numFields = sc.nextInt();

        int [] fieldSize = new int [numFields];
        for (int i = 0; i < numFields; i++) {
            System.out.print("Enter the size of field " + (i + 1) + " (in bytes): ");
            fieldSize[i] = sc.nextInt();
        }

            System.out.print("Enter the base address of the record: ");
            int baseAddress = sc.nextInt();
    
            System.out.print("Enter the index of the field to calculate its address: ");
            int targetField = sc.nextInt();
    
            int totalSize = 0;
            for (int size : fieldSize) {
                totalSize += size;
            }
            System.out.println("Total size of the record: " + totalSize + " bytes");
    
            int address = baseAddress; 
            for (int i = 0; i < targetField - 1; i++) {
                address += fieldSize[i]; 
            }
    
            System.out.println("The address of the target field is: " + address);
    
            sc.close();
    } 
}
