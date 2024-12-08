package Main;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketingSystem {
    public static void main(String[] args) {
        // Create Scanner object to take user inputs
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the required parameters
        System.out.print("Enter the total number of tickets: ");
        int totalTickets = scanner.nextInt();

        System.out.print("Enter the ticket release rate (in milliseconds, e.g., 2000 ms): ");
        int ticketReleaseRate = scanner.nextInt();

        System.out.print("Enter the customer retrieval rate (in milliseconds, e.g., 3000 ms): ");
        int customerRetrievalRate = scanner.nextInt();

        System.out.print("Enter the maximum ticket capacity in the pool: ");
        int maxTicketCapacity = scanner.nextInt();

        // Create Configuration object with user inputs
        Configuration config = new Configuration(maxTicketCapacity, ticketReleaseRate, customerRetrievalRate);

        // Create the TicketPool based on maxTicketCapacity
        TicketPool ticketPool = new TicketPool(maxTicketCapacity);

        // Create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Create and start vendor and customer threads
        Vendor vendor = new Vendor(ticketPool, 5, ticketReleaseRate);  // Vendor releasing 5 tickets at the given rate
        Customer customer = new Customer(ticketPool, customerRetrievalRate);  // Customer retrieving tickets at the given rate

        executorService.execute(vendor);  // Start vendor thread
        executorService.execute(customer);  // Start customer thread

        // Save the configuration and ticket pool to JSON files
        JsonUtil.saveConfigurationToJson(config, "config.json");
        JsonUtil.saveTicketPoolToJson(ticketPool, "ticketPool.json");

        // Graceful shutdown of the system when the program is terminated
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");
            executorService.shutdownNow();
        }));

        // Close scanner to prevent resource leakage
        scanner.close();
    }
}
