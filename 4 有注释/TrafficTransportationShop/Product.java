package TrafficTransportationShop;

/**
 * Represents a product in the traffic and transportation shop.
 * This class stores information about products like name, code, cost, and availability.
 */
public class Product {
    // Private fields to store product information
    private String productName;      // Name of the product
    private int productCode;         // Unique code for the product
    private double unitCost;         // Price of one unit of this product
    private boolean inCurrentProductLine; // Is this product currently available?

    /**
     * Constructor to create a new Product object.
     *
     * @param productName The name of the product
     * @param productCode The unique code for the product
     * @param unitCost The price of one unit
     * @param inCurrentProductLine Whether the product is currently available
     */
    public Product(String productName, int productCode,
                   double unitCost, boolean inCurrentProductLine) {
        this.productName = productName;
        this.productCode = productCode;
        this.unitCost = unitCost;
        this.inCurrentProductLine = inCurrentProductLine;
    }

    // Getter methods (accessors) - these let us read the private fields

    /**
     * Gets the product name.
     *
     * @return The name of the product
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Gets the product code.
     *
     * @return The unique code of the product
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * Gets the unit cost (price).
     *
     * @return The price of one unit of this product
     */
    public double getUnitCost() {
        return unitCost;
    }

    /**
     * Checks if the product is currently available.
     *
     * @return true if the product is available, false otherwise
     */
    public boolean isInCurrentProductLine() {
        return inCurrentProductLine;
    }

    // Setter methods (mutators) - these let us change the private fields

    /**
     * Sets a new name for the product.
     *
     * @param productName The new name for the product
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Sets a new code for the product.
     *
     * @param productCode The new unique code for the product
     */
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    /**
     * Sets a new price for the product.
     *
     * @param unitCost The new price for one unit of this product
     */
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    /**
     * Changes whether the product is currently available.
     *
     * @param inCurrentProductLine true to make product available, false otherwise
     */
    public void setInCurrentProductLine(boolean inCurrentProductLine) {
        this.inCurrentProductLine = inCurrentProductLine;
    }

    /**
     * Creates a string with all product information.
     * This method is automatically called when we print a Product object.
     *
     * @return A string containing all product details
     */
    public String toString() {
        return "Product description: " + productName
                + ", product code: " + productCode
                + ", unit cost: " + unitCost
                + ", currently in product line: " + inCurrentProductLine;
    }
}