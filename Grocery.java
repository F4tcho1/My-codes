import java.util.Scanner;
    
public class Grocery {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        double item1, item2, item3;
        int qty1, qty2, qty3;
        
        System.out.print("Price: ");
        item1 = obj.nextDouble();
        System.out.print("Quantity: ");
        qty1 = obj.nextInt();

        System.out.print("Price: ");
        item2 = obj.nextDouble();
        System.out.print("Quantity: ");
        qty2 = obj.nextInt();

        System.out.print("Price: ");
        item3 = obj.nextDouble();
        System.out.print("Quantity: ");
        qty3 = obj.nextInt();
        
        double subtotal = (item1 * qty1 + item2 * qty2 + item3 * qty3);
        double discount = (subtotal * 0.05);
        double st = (subtotal - discount);
        double salestax = (st * 0.12);
        double finaltotal = (st + salestax);
        
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount (5%): " + discount);
        System.out.println("Sales Tax (12%): " + salestax);
        System.out.println("Final Total: " + finaltotal);
        
        System.out.println("Thank You");
        
        obj.close();
    }
}
