package TrafficTransportationShop;

/**
 * Represents a store that can hold multiple products.
 * This class manages an array of Product objects.
 */
public class Store {
    // Array to store Product objects
    private Product[] products;

    // Tracks how many products are currently in the store
    private int total = 0;

    /**
     * Constructor to create a new Store with a fixed size.
     *
     * @param numberItems The maximum number of products this store can hold
     */
    public Store(int numberItems) {
        products = new Product[numberItems];
    }

    /**
     * Checks if the store is completely full.
     *
     * @return true if no more products can be added, false otherwise
     */
    private boolean isFull() {
        return (total == products.length);
    }

    /**
     * Checks if the store is empty (has no products).
     *
     * @return true if there are no products, false otherwise
     */
    private boolean isEmpty() {
        return (total == 0);
    }

    /**
     * Adds a new product to the store.
     *
     * @param product The Product object to add to the store
     * @return true if the product was added successfully, false if the store is full
     */
    public boolean add(Product product) {
        if (isFull()) {
            return false;  // Store is full, cannot add more products
        } else {
            products[total] = product;  // Add product to the next available position
            total++;  // Increase the count of products
            return true;  // Product added successfully
        }
    }

    /**
     * Creates a list of all products in the store.
     *
     * @return A string containing all products, or "No products" if store is empty
     */
    public String listProducts() {
        if (isEmpty()) {
            return "No products";  // Store has no products
        } else {
            String listOfProducts = "";

            // Loop through all products in the store
            for (int i = 0; i < total; i++) {
                // Add each product to the list with a number
                listOfProducts += (i + 1) + ": " + products[i] + "\n";
            }
            return listOfProducts;  // Return the complete list
        }
    }
}