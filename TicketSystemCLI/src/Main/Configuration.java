package Main;

public class Configuration {
    private int maxTicketCapacity;
    private int vendorReleaseRate;
    private int customerRetrievalRate;

    // Constructor
    public Configuration(int maxTicketCapacity, int vendorReleaseRate, int customerRetrievalRate) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.vendorReleaseRate = vendorReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    // Getters
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getVendorReleaseRate() {
        return vendorReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }
}
