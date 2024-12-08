package com.ticketing;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final String CONFIG_FILE = "src/main/resources/config.json";

    public static void main(String[] args) {
        // Load previous configuration or input new configuration
        Config config = loadConfig();

        Scanner scanner = new Scanner(System.in);
        // Take user input for configuration (if not using loaded config)
        System.out.print("Enter total number of tickets: ");
        config.setTotalTickets(scanner.nextInt());

        System.out.print("Enter ticket release rate (tickets per second): ");
        config.setTicketReleaseRate(scanner.nextInt());

        System.out.print("Enter customer retrieval rate (tickets per second): ");
        config.setCustomerRetrievalRate(scanner.nextInt());

        System.out.print("Enter maximum ticket capacity: ");
        config.setMaxTicketCapacity(scanner.nextInt());

        // Save the configuration to a file
        saveConfig(config);

        // Initialize the ticket pool with the maximum capacity
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Start vendor and customer threads
        Thread vendorThread = new Thread(new Vendor(ticketPool, config.getTicketReleaseRate()));
        Thread customerThread = new Thread(new Customer(ticketPool, config.getCustomerRetrievalRate()));

        vendorThread.start();
        customerThread.start();
    }

    // Load configuration from JSON file
    private static Config loadConfig() {
        File file = new File(CONFIG_FILE);
        if (file.exists()) {
            try (Reader reader = new FileReader(file)) {
                Gson gson = new Gson();
                JsonObject configJson = gson.fromJson(reader, JsonObject.class);
                int totalTickets = configJson.get("totalTickets").getAsInt();
                int ticketReleaseRate = configJson.get("ticketReleaseRate").getAsInt();
                int customerRetrievalRate = configJson.get("customerRetrievalRate").getAsInt();
                int maxTicketCapacity = configJson.get("maxTicketCapacity").getAsInt();

                return new Config(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Default config if no config file exists
        return new Config(100, 5, 2, 100);
    }

    // Save configuration to JSON file
    private static void saveConfig(Config config) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(CONFIG_FILE)) {
            gson.toJson(config, writer);
            System.out.println("Configuration saved to " + CONFIG_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}