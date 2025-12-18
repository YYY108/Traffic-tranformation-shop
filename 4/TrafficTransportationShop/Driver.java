package TrafficTransportationShop;

import java.util.Scanner;

public class Driver {
    private Scanner input = new Scanner(System.in);
    private Store store;

    // 主方法
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.runDriverMenu();
        // 修改点2: 移除不必要的printProduct()调用，因为runDriverMenu()已经包含了所有功能
        // driver.printProduct(); // 已注释掉
    }

    private void initializeStore() {
        store = new Store(5);

        // 添加一些示例产品

    }

    private void runDriverMenu() {
        initializeStore();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Traffic Transportation Shop ===");
            System.out.println("1. === Customer Menu ===");
            System.out.println("2. === Salesperson Menu ===");
            System.out.println("3. === Exit ==="); // 修改点3: 添加退出选项
            System.out.print("Enter your choice (1-3): ");

            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // 清除缓冲区

                if (choice == 1) {
                    CustomerMenu();
                } else if (choice == 2) {
                    SalespersonMenu();
                } else if (choice == 3) { // 修改点3: 添加退出处理
                    System.out.println("Goodbye!");
                    exit = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                }
            } else {
                System.out.println("Please enter a number (1, 2 or 3).");
                input.next(); // 清除无效输入
            }
        }
    }

    private void viewProductList() {
        System.out.println("\n=== Product List ===");

        // 调用Store类的listProducts方法
        String productList = store.listProducts();

        if (productList.equals("No products")) {
            System.out.println("Sorry, there are no products available at the moment.");
        } else {
            System.out.println(productList);
        }

        System.out.print("Press Enter to return to the menu...");
        input.nextLine(); // 等待用户按Enter
    }

    // 处理订单：询问用户要存储多少产品
    private void processOrder() {
        System.out.print("How many traffic/transportation products would you like to have in your Store? ");
        int numberProducts = input.nextInt();
        input.nextLine(); // 修改点4: 添加这行来清除缓冲区
        store = new Store(numberProducts);

        for (int i = 0; i < numberProducts; i++) {
            addProduct();
        }
    }

    // 添加一个产品
    private void addProduct() {
        // 修改点5: 添加换行符清除之前的输入
        System.out.println();

        System.out.print("Enter the Product Name (e.g., Bicycle, Train, Car): ");
        String productName = input.nextLine();

        System.out.print("Enter the Product Code: ");
        int productCode = input.nextInt();

        System.out.print("Enter the Unit Cost: ");
        double unitCost = input.nextDouble();

        System.out.print("Is this product in your current line (y/n): ");
        char currentProduct = input.next().charAt(0);
        boolean inCurrentProductLine = false;
        if ((currentProduct == 'y') || (currentProduct == 'Y')) {
            inCurrentProductLine = true;
        }

        input.nextLine(); // 修改点6: 添加这行来清除缓冲区

        // 创建 Product 对象并尝试添加到 Store
        boolean isAdded = store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
        if (isAdded) {
            System.out.println("Product Added Successfully");
        } else {
            System.out.println("No Product Added - Store is full");
        }
    }

    // 打印所有产品 - 这个方法不再从main调用
    private void printProduct() {
        System.out.println("=== Product List ===");
        System.out.println(store.listProducts());
    }

    private void CustomerMenu() {
        boolean exit = false; // 修改点7: 移动exit变量的声明

        while (!exit) { // 修改点7: 添加循环以便用户可以进行多个操作
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. View Product List");
            System.out.println("2. Back to Main Menu");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // 清除缓冲区
                if (choice == 1) {
                    viewProductList();
                } else if (choice == 2) {
                    exit = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Please enter a number (1 or 2).");
                input.next(); // 清除无效输入
            }
        }
    }

    private void SalespersonMenu() {
        boolean exit = false; // 修改点8: 移动exit变量的声明

        while (!exit) { // 修改点8: 添加循环以便用户可以进行多个操作
            System.out.println("\n=== Salesperson Menu ===");
            System.out.println("1. View Product List");
            System.out.println("2. Add Product");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine(); // 清除缓冲区

                if (choice == 1) {
                    viewProductList();
                } else if (choice == 2) {
                    processOrder();
                } else if (choice == 3) {
                    exit = true;
                } else {
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
                }
            } else {
                System.out.println("Please enter a number (1, 2 or 3).");
                input.next(); // 清除无效输入
            }
        }
    }
}