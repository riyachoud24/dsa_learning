package dsa_learning;

import java.util.Random;
import java.util.Scanner;

class C4_SuperMarket {
    private C4_Queue[] checkoutLines; // Array of queues (checkout lines)
    private int[] serviceTimes; // Array of items at checkout line
    private Random rand; // Random object for generating numbers
    private int numberOfLines; // Number of checkout lines

 // Constructor to initialize the supermarket with a certain number of checkout lines
    public C4_SuperMarket(int numberOfLines) {
        this.numberOfLines = numberOfLines;
        checkoutLines = new C4_Queue[numberOfLines];
        serviceTimes = new int[numberOfLines];
        rand = new Random();

        for (int i = 0; i < numberOfLines; i++) {
            checkoutLines[i] = new C4_Queue(10); 
        }
    }

    // Method to add a new customer to the shortest queue
    public void addCustomer() {
        int shortestLine = findShortestLine();
        checkoutLines[shortestLine].insert(rand.nextInt(100));
        if (checkoutLines[shortestLine].size() == 1) {
            serviceTimes[shortestLine] = rand.nextInt(5) + 1; 
        }
    }

 // Helper method to find the checkout line with the least number of customers
    private int findShortestLine() {
        int minSize = checkoutLines[0].size();
        int shortestLine = 0;

        for (int i = 1; i < numberOfLines; i++) {
            if (checkoutLines[i].size() < minSize) {
                minSize = checkoutLines[i].size();
                shortestLine = i;
            }
        }
        return shortestLine;
    }

 // Method to simulate the passage of one minute in all checkout lines
    public void simulateMinute() {
        for (int i = 0; i < numberOfLines; i++) {
            if (!checkoutLines[i].isEmpty()) {
                serviceTimes[i]--;
                if (serviceTimes[i] <= 0) {
                    checkoutLines[i].remove();
                    if (!checkoutLines[i].isEmpty()) {
                        serviceTimes[i] = rand.nextInt(5) + 1;
                    }
                }
            }
        }
    }
    // Method to display the current state of all checkout lines
    public void displayCheckoutLines() {
        for (int i = 0; i < numberOfLines; i++) {
            System.out.print("Line " + (i + 1) + ": ");
            checkoutLines[i].displayQueue();
            System.out.println();
        }
    }
    
 // Main method to run the supermarket simulation
    public static void main(String[] args) {
        C4_SuperMarket superMarket = new C4_SuperMarket(3); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPress 'a' to add a new customer, 't' to simulate a minute, or 'q' to quit:");
            char input = scanner.nextLine().charAt(0);

            switch (input) {
                case 'a':
                    superMarket.addCustomer();
                    break;
                case 't':
                    superMarket.simulateMinute();
                    break;
                case 'q':
                    System.out.println("Exiting Supermarket Simulation.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input!");
            }

            superMarket.displayCheckoutLines();
        }
    }
}
