import java.util.Scanner;

public class CC2F1 {
    public static void main (String[] args) {

            // Arrays for stock levels and prices
            int[] stock = new int[10]; //stock arrray
            double[] price = new double[10]; //price array
    
            Scanner scanner = new Scanner(System.in);
    
            // Collect stock levels and prices
            for (int i = 0; i < 10; i++) {
                // Get stock level
                System.out.print("Enter stock level for product " + (i + 1) + ": ");
                stock[i] = scanner.nextInt();
                while (stock[i] < 0) {
                    System.out.print("Stock level must be more than or equal to 0. Try again: ");
                    stock[i] = scanner.nextInt();
                }
    
                // Get price
                System.out.print("Enter price for product " + (i + 1) + ": PHP ");
                price[i] = scanner.nextDouble();
                while (price[i] <= 0) {
                    System.out.print("Price must more than or 0. Try again: PHP ");
                    price[i] = scanner.nextDouble();
                }
            }
    
            // Calculate total value of stock
            double totalValue = 0;
            for (int i = 0; i < 10; i++) {
                totalValue += stock[i] * price[i];
            }
    
            // Output total value
            System.out.println("\nTotal value of all products in stock: PHP " + totalValue);
    
            scanner.close();
        }
    }