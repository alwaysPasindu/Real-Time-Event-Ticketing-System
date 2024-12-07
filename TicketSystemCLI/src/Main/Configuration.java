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

    // Getters and Setters
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getVendorReleaseRate() {
        return vendorReleaseRate;
    }

    public void setVendorReleaseRate(int vendorReleaseRate) {
        this.vendorReleaseRate = vendorReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }
}
