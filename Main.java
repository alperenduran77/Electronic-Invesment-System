import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import Scanner class to read user input

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        Inventory inventory = new Inventory(); // Create an Inventory object
        TV Tv1 = new TV("TV", "LG Oled", 1200, 10);
        SmartPhone phone1 = new SmartPhone("Smart Phone", "Iphone 15", 800, 5);
        Headphones headphone1 = new Headphones("Headphones", "Sony WH-CH520", 200, 20);
        Laptop laptop1 = new Laptop("Laptop", "Dell G3 15", 1500, 15);
        SmartWatch watch1 = new SmartWatch("Smart Watch", "Huawei Watch GT", 300, 10);
        inventory.addDevice(Tv1);
        inventory.addDevice(phone1);
        inventory.addDevice(headphone1);
        inventory.addDevice(laptop1);
        inventory.addDevice(watch1);
        int choice;
        do {
            // Display the menu system
            System.out.println("Welcome to the Electronics Inventory Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new device");
            System.out.println("2. Remove a device");
            System.out.println("3. Update device details");
            System.out.println("4. List all devices");
            System.out.println("5. Find the cheapest device");
            System.out.println("6. Sort devices by price");
            System.out.println("7. Calculate total inventory value");
            System.out.println("8. Restock a device");
            System.out.println("9. Export inventory report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's choice
            choice = scanner.nextInt();

            // Process the user's choice
            switch (choice) {
                case 1:
                    System.out.print("Enter category name: ");
                    scanner.nextLine(); // Clear buffer
                    String category = scanner.nextLine().trim();

                    // List of allowed categories
                    List<String> allowedCategories = Arrays.asList("Headphones", "TV", "Smart Phone", "Laptop",
                            "Smart Watch");

                    // Check if the entered category is allowed
                    if (!allowedCategories.contains(category)) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("Category '" + category
                                + "' is not allowed. Please choose from the allowed categories.");
                        System.out.println("Allowed categories: " + allowedCategories);
                        System.out.println("-------------------------------------------------------");

                        break;
                    }

                    // Prompt for device name
                    System.out.print("Enter device name: ");
                    String name = scanner.nextLine().trim();

                    if (inventory.deviceExists(name)) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("A device with name '" + name + "' already exists. Please enter a different name.");
                         System.out.println("-------------------------------------------------------");
                        break;
                    }

                    // Prompt for device price including currency symbol
                    System.out.print("Enter price (e.g., 1000$): ");
                    String priceWithCurrency = scanner.nextLine().trim();

                    // Remove any non-numeric characters except the dot (.)
                    String priceString = priceWithCurrency.replaceAll("[^\\d.]", "").trim();
                    double price = 0;
                    try {
                        price = Double.parseDouble(priceString);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Invalid price format. Please enter a number followed by currency symbol (e.g., 1000$)");
                        break;
                    }

                    // Prompt for device quantity
                    System.out.print("Enter quantity: ");
                    String quantityString = scanner.nextLine().trim();
                    int quantity = 0;
                    try {
                        quantity = Integer.parseInt(quantityString);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity format. Please enter a numeric quantity.");
                        break;
                    }

                    // Create a new device instance based on the category
                    Device newDevice = null;
                    switch (category) {
                        case "Smart Phone":
                            newDevice = new SmartPhone(category, name, price, quantity);
                            break;
                        case "TV":
                            newDevice = new TV(category, name, price, quantity);
                            break;
                        case "Headphones":
                            newDevice = new Headphones(category, name, price, quantity);
                            break;
                        case "Laptop":
                            newDevice = new Laptop(category, name, price, quantity);
                            break;
                        case "Smart Watch":
                            newDevice = new SmartWatch(category, name, price, quantity);
                            break;
                        default:
                            System.out.println("Category not recognized.");
                            break;
                    }

                    if (newDevice != null) {
                        // Add the device to the inventory
                        inventory.addDevice(newDevice);
                        // Confirmation message
                        System.out.println("-------------------------------------------------------");
                        System.out.println(category + ", " + name + ", " + priceWithCurrency + ", " + quantity
                                + " amount added...");
                        System.out.println("-------------------------------------------------------");
                    }
                    break;

                case 2:

                    // Prompt for the device name to remove
                    System.out.print("Enter the name of the device to remove: ");
                    scanner.nextLine(); // Clear buffer
                    String deviceNameToRemove = scanner.nextLine();

                    // Call the removeDevice method with the provided name
                    inventory.removeDevice(deviceNameToRemove);
                    break;

                case 3:
                
                    System.out.print("Enter the name of the device to update: ");
                    scanner.nextLine(); // Clear buffer
                    String deviceToUpdate = scanner.nextLine().trim();

                    // Check if the device exists before asking for more details
                    if (inventory.deviceExists(deviceToUpdate)) {
                        // Prompt for new price
                        System.out.print("Enter new price (leave blank to keep current price): ");
                        String newPriceInput = scanner.nextLine().trim();
                        double newPrice = -1;
                        if (!newPriceInput.isEmpty()) {
                            newPrice = Double.parseDouble(newPriceInput.replaceAll("[^\\d.]", ""));
                        }

                        // Prompt for new quantity
                        System.out.print("Enter new quantity (leave blank to keep current quantity): ");
                        String newQuantityInput = scanner.nextLine().trim();
                        int newQuantity = -1;
                        if (!newQuantityInput.isEmpty()) {
                            newQuantity = Integer.parseInt(newQuantityInput);
                        }

                        // Update the device details
                        inventory.updateDeviceDetails(deviceToUpdate, newPrice, newQuantity);
                    } else {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("Device " + deviceToUpdate + " not found.");
                        System.out.println("-------------------------------------------------------");
                    }
                    break;

                case 4:
                    // Code to list all devices
                    inventory.listAllDevices();
                    break;
                case 5:
                    // Code to find the cheapest device

                    Device cheapestDevice = inventory.findCheapestDevice();
                    if (cheapestDevice != null) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("The cheapest device is:");
                        System.out.println("Category: " + cheapestDevice.getCategory() +
                                ", Name: " + cheapestDevice.getName() +
                                ", Price: " + String.format("%.2f$", cheapestDevice.getPrice()) +
                                ", Quantity: " + cheapestDevice.getQuantity());
                        System.out.println("-------------------------------------------------------");
                    } else {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("No devices found in the inventory.");
                        System.out.println("-------------------------------------------------------");
                    }
                    break;

                case 6:

                    inventory.sortDevicesByPrice();
                    break;
                case 7:
                    // Code to calculate total inventory value
                    double totalValue = inventory.calculateTotalInventoryValue();
                    System.out.println("-------------------------------------------------------");
                    System.out.printf("The total inventory value is: %.2f$\n", totalValue);
                    System.out.println("-------------------------------------------------------");
                    break;

                case 8:

                    System.out.print("Enter the name of the device to restock: ");
                    scanner.nextLine(); // Clear buffer in case there's a newline character left
                    String deviceNameToRestock = scanner.nextLine().trim();

                    if (inventory.deviceExists(deviceNameToRestock)) {
                        System.out.print("Do you want to add or remove stock? (Add/Remove): ");
                        String action = scanner.nextLine().trim();

                        int quantityChange = 0;
                        if (action.equalsIgnoreCase("Add")) {
                            System.out.print("Enter the quantity to add: ");
                            quantityChange = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over
                            inventory.restockDevice(deviceNameToRestock, quantityChange, true);
                        } else if (action.equalsIgnoreCase("Remove")) {
                            System.out.print("Enter the quantity to remove: ");
                            quantityChange = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over
                            inventory.restockDevice(deviceNameToRestock, quantityChange, false);
                        } else {
                            System.out.println("Invalid action. Please enter 'Add' or 'Remove'.");
                            System.out.println("-------------------------------------------------------");
                        }
                    } else {
                        System.out.println("Device " + deviceNameToRestock + " not found in the inventory.");
                        System.out.println("-------------------------------------------------------");
                    }
                   
                    break;

                case 9:
                    System.out.println("-------------------------------------------------------");
                    inventory.exportInventoryToFile();
                    System.out.println("-------------------------------------------------------");
                    break;

                case 0:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.");
                    break;
            }
        } while (choice != 0);

        scanner.close(); // Close the scanner
    }
}