package Main;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Create Scanner object to take user inputs
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the required parameters

        // Total number of tickets (simulating the total number of tickets available for sale)
        System.out.print("Enter the total number of tickets: ");
        int totalTickets = scanner.nextInt();

        // Ticket release rate (time interval for vendors to release tickets)
        System.out.print("Enter the ticket release rate (in milliseconds, e.g., 2000 ms): ");
        int ticketReleaseRate = scanner.nextInt();

        // Customer retrieval rate (time interval for customers to retrieve tickets)
        System.out.print("Enter the customer retrieval rate (in milliseconds, e.g., 3000 ms): ");
        int customerRetrievalRate = scanner.nextInt();

        // Maximum ticket capacity (upper limit for tickets in the pool at any time)
        System.out.print("Enter the maximum ticket capacity in the pool: ");
        int maxTicketCapacity = scanner.nextInt();

        // Create Configuration object with user inputs
        Configuration config = new Configuration(maxTicketCapacity, ticketReleaseRate, customerRetrievalRate);

        System.out.println("\nSystem Configuration Loaded:");
        System.out.println("Max Ticket Capacity: " + config.getMaxTicketCapacity());
        System.out.println("Ticket Release Rate: " + config.getVendorReleaseRate());
        System.out.println("Customer Retrieval Rate: " + config.getCustomerRetrievalRate());
        System.out.println("Total Tickets Available: " + totalTickets);

        // Create the TicketPool based on maxTicketCapacity
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Create and start vendor and customer threads
        Vendor vendor1 = new Vendor(ticketPool, 5, config.getVendorReleaseRate());  // Vendor releasing 5 tickets at the given rate
        Customer customer1 = new Customer(ticketPool, config.getCustomerRetrievalRate());  // Customer retrieving tickets at the given rate

        executorService.execute(vendor1);  // Start vendor thread
        executorService.execute(customer1);  // Start customer thread

        // Graceful shutdown of the system when the program is terminated
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");
            executorService.shutdownNow();
        }));

        // Close scanner to prevent resource leakage
        scanner.close();
    }
}
