import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {
    private static final String CONFIG_FILE = "config.json";
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        // Load configuration from JSON
        JsonObject config = loadConfig();
        int totalTickets = config.has("totalTickets") ? config.get("totalTickets").getAsInt() : 100;
        int ticketReleaseRate = config.has("ticketReleaseRate") ? config.get("ticketReleaseRate").getAsInt() : 5;
        int customerRetrievalRate = config.has("customerRetrievalRate") ? config.get("customerRetrievalRate").getAsInt() : 1;
        int maxTicketCapacity = config.has("maxTicketCapacity") ? config.get("maxTicketCapacity").getAsInt() : 100;

        // Initialize Ticket Pool
        TicketPool ticketPool = new TicketPool(maxTicketCapacity);

        // Add initial tickets to the pool (simulating a full pool to start with)
        ticketPool.addTickets(totalTickets);

        // Create Vendor and Customer threads
        Vendor vendor = new Vendor(ticketPool, ticketReleaseRate);
        Customer customer = new Customer(ticketPool);

        // Start threads for Vendor and Customer
        Thread vendorThread = new Thread(vendor);
        Thread customerThread = new Thread(customer);

        vendorThread.start();
        customerThread.start();

        // User input loop to save configuration or exit
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 'exit' to stop the simulation, or 'save' to save the current configuration:");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Stopping the simulation...");
                break;
            } else if ("save".equalsIgnoreCase(input)) {
                saveConfig(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
            }
        }

        scanner.close();
    }

    // Load configuration from a JSON file
    private static JsonObject loadConfig() {
        File file = new File(CONFIG_FILE);
        if (!file.exists()) {
            System.out.println("No config file found, using default settings.");
            return new JsonObject();
        }

        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonObject();  // Return empty config if error occurs
        }
    }

    // Save configuration to JSON
    private static void saveConfig(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        JsonObject config = new JsonObject();
        config.addProperty("totalTickets", totalTickets);
        config.addProperty("ticketReleaseRate", ticketReleaseRate);
        config.addProperty("customerRetrievalRate", customerRetrievalRate);
        config.addProperty("maxTicketCapacity", maxTicketCapacity);

        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            gson.toJson(config, writer);
            System.out.println("Configuration saved to " + CONFIG_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
