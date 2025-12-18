package TrafficTransportationShop;

import java.util.Scanner;

/**
 * Main driver class for the Traffic Transportation Shop program.
 * This class handles user interaction and menu navigation.
 */
public class Driver {
    // Scanner object to read user input from keyboard
    private Scanner input = new Scanner(System.in);

    // Store object to manage all products
    private Store store;

    /**
     * Main method - starting point of the program.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Driver driver = new Driver();  // Create a Driver object
        driver.runDriverMenu();  // Start the main menu
    }

    /**
     * Initializes the store with an empty array of products.
     * Currently creates a store that can hold 5 products.
     */
    private void initializeStore() {
        store = new Store(5);
        // Store is created but empty - no products added yet
    }

    /**
     * Displays and manages the main menu of the program.
     * Users can choose between customer and salesperson menus.
     */
    private void runDriverMenu() {
        initializeStore();  // Set up the store before showing menu

        boolean exit = false;  // Controls when to exit the program

        // Keep showing the menu until user chooses to exit
        while (!exit) {
            System.out.println("\n=== Traffic Transportation Shop ===");
            System.out.println("1. === Customer Menu ===");
            System.out.println("2. === Salesperson Menu ===");
            System.out.println("3. === Exit ===");
            System.out.print("Enter your choice (1-3): ");

            // Check if user entered a number
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine();  // Clear the input buffer

                // Process user's choice
                if (choice == 1) {
                    CustomerMenu();  // Go to customer menu
                } else if (choice == 2) {
                    SalespersonMenu();  // Go to salesperson menu
                } else if (choice == 3) {
                    System.out.println("Goodbye!");  // Exit message
                    exit = true;  // Stop the loop and exit program
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                }
            } else {
                System.out.println("Please enter a number (1, 2 or 3).");
                input.next();  // Clear invalid input from scanner
            }
        }
    }

    /**
     * Displays all products currently in the store.
     */
    private void viewProductList() {
        System.out.println("\n=== Product List ===");

        // Get the list of products from the store
        String productList = store.listProducts();

        // Check if store is empty
        if (productList.equals("No products")) {
            System.out.println("Sorry, there are no products available at the moment.");
        } else {
            System.out.println(productList);  // Show all products
        }

        System.out.print("Press Enter to return to the menu...");
        input.nextLine();  // Wait for user to press Enter
    }

    /**
     * Creates a new store and adds multiple products.
     * Asks user how many products they want to add, then adds them one by one.
     */
    private void processOrder() {
        System.out.print("How many traffic/transportation products would you like to have in your Store? ");
        int numberProducts = input.nextInt();
        input.nextLine();  // Clear the input buffer

        // Create a new store with the requested size
        store = new Store(numberProducts);

        // Add the specified number of products
        for (int i = 0; i < numberProducts; i++) {
            addProduct();
        }
    }

    /**
     * Adds a single product to the store.
     * Asks user for all product details and creates a new Product object.
     */
    private void addProduct() {
        System.out.println();  // Add blank line for better readability

        System.out.print("Enter the Product Name (e.g., Bicycle, Train, Car): ");
        String productName = input.nextLine();

        System.out.print("Enter the Product Code: ");
        int productCode = input.nextInt();

        System.out.print("Enter the Unit Cost: ");
        double unitCost = input.nextDouble();

        System.out.print("Is this product in your current line (y/n): ");
        char currentProduct = input.next().charAt(0);
        boolean inCurrentProductLine = false;

        // Check if user entered 'y' or 'Y' for yes
        if ((currentProduct == 'y') || (currentProduct == 'Y')) {
            inCurrentProductLine = true;
        }

        input.nextLine();  // Clear the input buffer

        // Create new Product object with user's input
        boolean isAdded = store.add(new Product(productName, productCode,
                unitCost, inCurrentProductLine));

        // Check if product was added successfully
        if (isAdded) {
            System.out.println("Product Added Successfully");
        } else {
            System.out.println("No Product Added - Store is full");
        }
    }

    /**
     * Displays the customer menu with available options.
     * Customers can only view products, not add them.
     */
    private void CustomerMenu() {
        boolean exit = false;  // Controls when to return to main menu

        // Keep showing customer menu until user chooses to go back
        while (!exit) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. View Product List");
            System.out.println("2. Back to Main Menu");
            System.out.print("Enter your choice: ");

            // Check if user entered a number
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine();  // Clear the input buffer

                // Process user's choice
                if (choice == 1) {
                    viewProductList();  // Show all products
                } else if (choice == 2) {
                    exit = true;  // Return to main menu
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Please enter a number (1 or 2).");
                input.next();  // Clear invalid input from scanner
            }
        }
    }

    /**
     * Displays the salesperson menu with more options.
     * Salespeople can view products and add new products.
     */
    private void SalespersonMenu() {
        boolean exit = false;  // Controls when to return to main menu

        // Keep showing salesperson menu until user chooses to go back
        while (!exit) {
            System.out.println("\n=== Salesperson Menu ===");
            System.out.println("1. View Product List");
            System.out.println("2. Add Product");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            // Check if user entered a number
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine();  // Clear the input buffer

                // Process user's choice
                if (choice == 1) {
                    viewProductList();  // Show all products
                } else if (choice == 2) {
                    processOrder();  // Add new products
                } else if (choice == 3) {
                    exit = true;  // Return to main menu
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                }
            } else {
                System.out.println("Please enter a number (1, 2 or 3).");
                input.next();  // Clear invalid input from scanner
            }
        }
    }
}