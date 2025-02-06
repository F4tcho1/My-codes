// Queue Operations using 1D Array
import java.util.Scanner;

public class Queues {
    private int[] queue;
    private int front, rear, size;

    public Queues(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    public void enqueue(int element) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow! Cannot ENQUEUE.");
        } else {
            if (front == -1) front = 0;
            queue[++rear] = element;
            System.out.println(element + " enqueued into the queue.");
        }
    }

    public void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty! Cannot DEQUEUE.");
        } else {
            System.out.println("Dequeued: " + queue[front++]);
            if (front > rear) { // Reset when queue is empty
                front = -1;
                rear = -1;
            }
        }
    }

    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Current Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        int size = scanner.nextInt();
        Queues queue = new Queues(size);
        int option;

        do {
            System.out.println("\nQueue Operations:");
            System.out.println("1. ENQUEUE");
            System.out.println("2. DEQUEUE");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter element to ENQUEUE: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
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
