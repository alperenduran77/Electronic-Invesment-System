import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * The Inventory class represents a collection of electronic devices.
 * Devices are organized into categories, each represented as an ArrayList
 * within a LinkedList.
 * This allows for categorization and management of devices within an inventory
 * system.
 */
public class Inventory {

    private LinkedList<ArrayList<Device>> deviceLists;

    /**
     * Constructs a new, empty Inventory.
     * Time Complexity: O(1) - Instantiation of a new LinkedList is a constant time
     * operation.
     */
    public Inventory() {
        deviceLists = new LinkedList<>();
    }

    /**
     * Adds a new device to the inventory, with time complexity O(n) where n is the
     * number of categories in the inventory.
     * It may iterate through all categories to find or create a matching category
     * list for the device.
     * Time Complexity: O(n)
     *
     * @param device The device to be added to the inventory.
     */
    public void addDevice(Device device) {
        // List of allowed categories
        List<String> allowedCategories = Arrays.asList("Headphones", "TV", "Smart Phone", "Laptop", "Smart Watch");

        // Check if the category of the device is allowed
        if (!allowedCategories.contains(device.getCategory())) {
            System.out.println("Category '" + device.getCategory() + "' is not allowed.");
            return;
        }

        // Find if there is already an ArrayList for this category
        for (ArrayList<Device> categoryList : deviceLists) {
            if (!categoryList.isEmpty() && categoryList.get(0).getCategory().equals(device.getCategory())) {
                categoryList.add(device);
                return;
            }
        }
        // No ArrayList for this category exists, so create one and add it
        ArrayList<Device> newCategoryList = new ArrayList<>();
        newCategoryList.add(device);
        deviceLists.add(newCategoryList);
    }

    /**
     * Removes a device from the inventory based on the device name.
     * Time Complexity: O(n*m) - In the worst-case scenario, where n is the number
     * of device categories and m is
     * the average number of devices per category. This accounts for iterating
     * through all categories and, within each,
     * potentially searching through all devices to find and remove the specified
     * device, including the cost of shifting elements in the ArrayList.
     *
     * @param deviceName The name of the device to be removed.
     */
    public void removeDevice(String deviceName) {
        boolean deviceRemoved = false;
        System.out.println("-------------------------------------------------------");
        for (ArrayList<Device> deviceList : deviceLists) {
            for (int i = 0; i < deviceList.size(); i++) {
                if (deviceList.get(i).getName().equalsIgnoreCase(deviceName)) {
                    deviceList.remove(i);
                    System.out.println("Device " + deviceName + " removed.");
                    deviceRemoved = true;
                    break; // Break out of the inner loop
                }
            }

            if (deviceRemoved) {
                System.out.println("-------------------------------------------------------");
                break; // Break out of the outer loop if the device was removed
            }
        }

        if (!deviceRemoved) {
            System.out.println("Device " + deviceName + " not found.");
            System.out.println("-------------------------------------------------------");
        }

    }

    /**
     * Checks if a device exists in the inventory based on the device name.
     * Time Complexity: O(n*m) - Reflects iterating through all categories (n) and
     * devices per category (m) in the worst case.
     *
     * @param deviceName The name of the device to be checked.
     * @return true if the device exists, false otherwise.
     */
    public boolean deviceExists(String deviceName) {
        for (ArrayList<Device> deviceList : deviceLists) {
            for (Device device : deviceList) {
                if (device.getName().equalsIgnoreCase(deviceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Updates the details of a device identified by its name, setting a new price
     * and quantity if specified.
     * Time Complexity: O(n*m) - Requires iterating through all categories (n) and
     * potentially all devices within those categories (m) to find the matching
     * device.
     *
     * @param deviceName  The name of the device to be updated.
     * @param newPrice    The new price to be set for the device. If less than or
     *                    equal to 0, the price is not updated.
     * @param newQuantity The new quantity to be set for the device. If less than 0,
     *                    the quantity is not updated.
     */
    public void updateDeviceDetails(String deviceName, double newPrice, int newQuantity) {
        System.out.println("-------------------------------------------------------");
        boolean found = false;
        for (ArrayList<Device> deviceList : deviceLists) {
            for (Device device : deviceList) {
                if (device.getName().equalsIgnoreCase(deviceName)) {
                    found = true;
                    if (newPrice > 0) {
                        device.setPrice(newPrice);
                    }
                    if (newQuantity >= 0) {
                        device.setQuantity(newQuantity);
                    }
                    System.out.println(device.getName() + " details updated: Price - " +
                            String.format("%.2f$", device.getPrice()) + ", Quantity - " + device.getQuantity());
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Device " + deviceName + " not found.");
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * Displays all devices, with a detailed list.
     * Time Complexity: O(n*m) - Requires iterating through all categories (n) and
     * potentially all devices within those categories (m) to list each device.
     */
    public void listAllDevices() {
        int counter = 1; // Initialize a counter for the devices
        System.out.println("-------------------------------------------------------");
        System.out.println("Device List:");
        for (ArrayList<Device> deviceList : deviceLists) {
            for (Device device : deviceList) {
                System.out.println(counter + ". Category: " + device.getCategory() +
                        ", Name: " + device.getName() +
                        ", Price: " + String.format("%.2f$", device.getPrice()) + // Formatted to show two decimal
                                                                                  // places
                        ", Quantity: " + device.getQuantity());
                counter++; // Increment the counter for each device listed
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * Finds and returns the device with the minimum price in the inventory.
     * Time Complexity: O(n*m) - Requires iterating through all categories (n) and
     * potentially all devices within those categories (m) to find the device with
     * the lowest price.
     *
     * @return The device with the lowest price, or null if the inventory is empty.
     */
    public Device findCheapestDevice() {
        Device cheapestDevice = null;
        double cheapestPrice = Double.MAX_VALUE; // Start with the max possible value

        for (ArrayList<Device> deviceList : deviceLists) {
            for (Device device : deviceList) {
                if (device.getPrice() < cheapestPrice) {
                    cheapestDevice = device;
                    cheapestPrice = device.getPrice();
                }
            }
        }

        return cheapestDevice; // This could be null if no devices are in the inventory
    }

    /**
     * Sorts the devices in the inventory by their price in ascending order.
     * Time Complexity: O(n*m log(n*m)) - Collects all devices into a single list to
     * sort,
     * where n is the number of categories and m is the average number of devices
     * per category.
     */
    public void sortDevicesByPrice() {
        // Create a list to hold all devices
        List<Device> allDevices = new ArrayList<>();

        // Collect all devices from each category into allDevices
        for (ArrayList<Device> deviceList : deviceLists) {
            allDevices.addAll(deviceList);
        }

        // Sort allDevices by price
        allDevices.sort(Comparator.comparingDouble(Device::getPrice));

        // Print sorted devices
        System.out.println("Devices sorted by price:");
        System.out.println("-------------------------------------------------------");
        int count = 1;
        for (Device device : allDevices) {

            System.out.println(count + ". Category: " + device.getCategory() +
                    ", Name: " + device.getName() +
                    ", Price: " + String.format("%.2f$", device.getPrice()) +
                    ", Quantity: " + device.getQuantity());
            count++;
        }
        System.out.println("-------------------------------------------------------");
    }

    /**
     * Calculates and returns the total value of all the devices in the inventory.
     * Time Complexity: O(n*m) - Requires iterating through all categories (n) and
     * each device within those categories (m) to sum the value of every device.
     *
     * @return The total inventory value as a double.
     */
    public double calculateTotalInventoryValue() {
        double totalValue = 0;

        // Iterate through each category
        for (ArrayList<Device> deviceList : deviceLists) {
            // Iterate through each device in the category
            for (Device device : deviceList) {
                // Add the device's value (price * quantity) to the total
                totalValue += device.getPrice() * device.getQuantity();
            }
        }

        return totalValue;
    }

    /**
     * Updates the quantity of a device in the inventory, either adding or removing
     * stock as specified.
     * Time Complexity: O(n*m) - Requires searching through all categories (n) and
     * potentially all devices within those categories (m) to find the specific
     * device to restock.
     *
     * @param deviceName     The name of the device to be restocked.
     * @param quantityChange The amount of quantity to add or remove.
     * @param addStock       True to add stock, false to remove stock.
     */
    public void restockDevice(String deviceName, int quantityChange, boolean addStock) {
        for (ArrayList<Device> deviceList : deviceLists) {
            for (Device device : deviceList) {
                if (device.getName().equalsIgnoreCase(deviceName)) {
                    int currentQuantity = device.getQuantity();
                    if (addStock) {
                        device.setQuantity(currentQuantity + quantityChange);
                        System.out.println(deviceName + " restocked. New quantity: " + device.getQuantity());
                        System.out.println("-------------------------------------------------------");
                    } else {
                        // Check to prevent removing more stock than available
                        if (quantityChange <= currentQuantity) {
                            device.setQuantity(currentQuantity - quantityChange);
                            System.out.println(deviceName + " stock reduced. New quantity: " + device.getQuantity());
                            System.out.println("-------------------------------------------------------");
                        } else {
                            System.out.println("Error: Attempt to remove more stock than available.");
                            System.out.println("-------------------------------------------------------");
                        }
                    }
                    return;
                }
            }
        }
        System.out.println("Device " + deviceName + " not found in the inventory.");
    }

    /**
     * Exports the inventory list to a file named "inventory.txt".
     * Time Complexity: O(n*m) - Iterates through all categories (n) and devices
     * within those categories (m) to write every device's details to the file,
     * where n is the number of categories and m is the average number of devices
     * per category.
     */
    public void exportInventoryToFile() {
        String filename = "inventory.txt"; // Fixed filename
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder reportContent = new StringBuilder();

            // Header of the report
            String header = "Electronics Shop Inventory Report\n" +
                    "Generated on: " + LocalDate.now() + "\n" +
                    "-------------------------------------------------\n" +
                    "| No. | Category | Name | Price | Quantity |\n" +
                    "-------------------------------------------------\n";
            reportContent.append(header);

            // Numbering for the list of devices
            int count = 1;

            // Device list
            for (ArrayList<Device> deviceList : deviceLists) {
                for (Device device : deviceList) {
                    String deviceInfo = String.format("| %d | %s | %s | $%.2f | %d |\n",
                            count++,
                            device.getCategory(),
                            device.getName(),
                            device.getPrice(),
                            device.getQuantity());
                    reportContent.append(deviceInfo);
                }
            }

            // Summary
            String summary = "Summary:\n";
            double totalValue = calculateTotalInventoryValue(); // Use your method to calculate this
            summary += String.format("- Total Number of Devices: %d\n", count - 1);
            summary += String.format("- Total Inventory Value: $%,.2f\n", totalValue);
            summary += "End of Report\n";

            reportContent.append(summary);

            // Write to file
            writer.write(reportContent.toString());


            // Feedback
            System.out.println("Inventory report exported to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
