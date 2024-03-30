/**
 * Concrete class representing a Headphones device, implementing the Device interface.
 * It encapsulates details about the device such as category, name, price, and quantity.
 * All methods in this class operate in O(1) time complexity, indicating constant time operations.
 */
public class Headphones implements Device {
    private String category;
    private String name;
    private double price;
    private int quantity;
    
    /**
     * Constructs a new Headphones with the specified details.
     * Time complexity: O(1) - Constant time complexity for assignment operations.
     * @param category The category of the Headphones.
     * @param name The name of the Headphones.
     * @param price The price of the Headphones.
     * @param quantity The quantity of the Headphones in inventory.
     */
    public Headphones(String category, String name, double price, int quantity) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    /**
     * Gets the category of this Headphones.
     * Time complexity: O(1) - Constant time complexity as it directly returns a value.
     * @return A string representing the category of the Headphones.
     */
    public String getCategory() { return category; }

    /**
     * Gets the name of this Headphones.
     * Time complexity: O(1) - Constant time complexity as it directly returns a value.
     * @return A string representing the name of the Headphones.
     */
    public String getName() { return name; }

    /**
     * Gets the price of this Headphones.
     * Time complexity: O(1) - Constant time complexity as it directly returns a value.
     * @return A double value representing the price of the Headphones.
     */
    public double getPrice() { return price; }

    /**
     * Gets the quantity of this Headphones in inventory.
     * Time complexity: O(1) - Constant time complexity as it directly returns a value.
     * @return An integer representing the quantity of the Headphones.
     */
    public int getQuantity() { return quantity; }
    
    /**
     * Sets the category of this Headphones.
     * Time complexity: O(1) - Constant time complexity as it directly assigns a value.
     * @param category A string to set as the category of this Headphones.
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * Sets the name of this Headphones.
     * Time complexity: O(1) - Constant time complexity as it directly assigns a value.
     * @param name A string to set as the name of this Headphones.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Sets the price of this Headphones.
     * Time complexity: O(1) - Constant time complexity as it directly assigns a value.
     * @param price A double value to set as the price of this Headphones.
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Sets the quantity of this Headphones in inventory.
     * Time complexity: O(1) - Constant time complexity as it directly assigns a value.
     * @param quantity An integer to set as the quantity of this Headphones.
     */
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
