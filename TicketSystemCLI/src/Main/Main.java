package Main;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Create Scanner object to take user inputs
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for configuration values
        System.out.print("Enter the maximum ticket capacity: ");
        int maxTicketCapacity = scanner.nextInt();

        System.out.print("Enter the vendor release rate (in ms): ");
        int vendorReleaseRate = scanner.nextInt();

        System.out.print("Enter the customer retrieval rate (in ms): ");
        int customerRetrievalRate = scanner.nextInt();

        // Create Configuration object with user inputs
        Configuration config = new Configuration(maxTicketCapacity, vendorReleaseRate, customerRetrievalRate);

        System.out.println("\nSystem Configuration Loaded:");
        System.out.println("Max Ticket Capacity: " + config.getMaxTicketCapacity());
        System.out.println("Vendor Release Rate: " + config.getVendorReleaseRate());
        System.out.println("Customer Retrieval Rate: " + config.getCustomerRetrievalRate());

        // Create TicketPool and start vendor/customer threads
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());
        ExecutorService executorService = Executors.newCachedThreadPool();
        Vendor vendor1 = new Vendor(ticketPool, 5, config.getVendorReleaseRate());
        Customer customer1 = new Customer(ticketPool, config.getCustomerRetrievalRate());

        // Execute vendor and customer tasks
        executorService.execute(vendor1);
        executorService.execute(customer1);

        // Graceful shutdown of executor service
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down...");
            executorService.shutdownNow();
        }));

        // Close scanner
        scanner.close();
    }
}
