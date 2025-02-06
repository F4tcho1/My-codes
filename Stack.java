// Stack Operations using 1D Array
import java.util.Scanner;

public class Stack {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int element) {
        if (top == size - 1) {
            System.out.println("Stack Overflow! Cannot PUSH.");
        } else {
            stack[++top] = element;
            System.out.println(element + " pushed onto the stack.");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Cannot POP.");
        } else {
            System.out.println("Popped: " + stack[top--]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Current Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);
        int option;

        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. PUSH");
            System.out.println("2. POP");
            System.out.println("3. Display Stack");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter element to PUSH: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}