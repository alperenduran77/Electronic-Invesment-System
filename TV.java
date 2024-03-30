/**
 * Concrete class representing a TV device, implementing the Device interface.
 * It encapsulates details about the device such as category, name, price, and quantity.
 * All accessors and mutators (getters and setters) have a time complexity of O(1).
 */
public class TV implements Device {
    private String category;
    private String name;
    private double price;
    private int quantity;
    
    /**
     * Constructs a new TV with the specified details.
     * Time complexity: O(1)
     * @param category The category of the TV.
     * @param name The name of the TV.
     * @param price The price of the TV.
     * @param quantity The quantity of the TV in inventory.
     */
    public TV(String category, String name, double price, int quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    /**
     * Gets the category of this TV.
     * Time complexity: O(1)
     * @return A string representing the category of the TV.
     */
    public String getCategory() { return category; }

    /**
     * Gets the name of this TV.
     * Time complexity: O(1)
     * @return A string representing the name of the TV.
     */
    public String getName() { return name; }

    /**
     * Gets the price of this TV.
     * Time complexity: O(1)
     * @return A double value representing the price of the TV.
     */
    public double getPrice() { return price; }

    /**
     * Gets the quantity of this TV in inventory.
     * Time complexity: O(1)
     * @return An integer representing the quantity of the TV.
     */
    public int getQuantity() { return quantity; }
    
    /**
     * Sets the category of this TV.
     * Time complexity: O(1)
     * @param category A string to set as the category of this TV.
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * Sets the name of this TV.
     * Time complexity: O(1)
     * @param name A string to set as the name of this TV.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Sets the price of this TV.
     * Time complexity: O(1)
     * @param price A double value to set as the price of this TV.
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Sets the quantity of this TV in inventory.
     * Time complexity: O(1)
     * @param quantity An integer to set as the quantity of this TV.
     */
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
