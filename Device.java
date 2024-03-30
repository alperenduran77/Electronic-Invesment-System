/**
 * The Device interface defines the contract for electronic devices
 * that can be managed in an inventory system. It specifies methods
 * for retrieving and updating the device's category, name, price, and quantity.
 */
public interface Device {
    
    /**
     * Retrieves the category of the device.
     * This method is intended to return the category to which the device belongs.
     * 
     * @return The device category as a String.
     */
    String getCategory();
    
    /**
     * Retrieves the name of the device.
     * This method is intended to return the name of the device.
     * 
     * @return The device name as a String.
     */
    String getName();
    
    /**
     * Retrieves the price of the device.
     * This method is intended to return the selling price of the device.
     * 
     * @return The device price as a double.
     */
    double getPrice();
    
    /**
     * Retrieves the quantity of the device in inventory.
     * This method is intended to return the current stock quantity of the device.
     * 
     * @return The quantity of the device as an integer.
     */
    int getQuantity();
    
    /**
     * Sets the category of the device.
     * This method is intended to assign a category to the device.
     * 
     * @param category The category to be set for the device.
     */
    void setCategory(String category);
    
    /**
     * Sets the name of the device.
     * This method is intended to assign a name to the device.
     * 
     * @param name The name to be set for the device.
     */
    void setName(String name);
    
    /**
     * Sets the price of the device.
     * This method is intended to assign a selling price to the device.
     * 
     * @param price The price to be set for the device.
     */
    void setPrice(double price);
    
    /**
     * Sets the quantity of the device in inventory.
     * This method is intended to update the stock quantity of the device.
     * 
     * @param quantity The quantity to be set for the device.
     */
    void setQuantity(int quantity);
}
