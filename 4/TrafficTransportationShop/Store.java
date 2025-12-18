package TrafficTransportationShop;

public class Store {
    private Product[] products;
    private int total = 0;

    // 构造函数
    public Store(int numberItems) {
        products = new Product[numberItems];
    }

    // 检查数组是否已满
    private boolean isFull() {
        return (total == products.length);
    }

    // 检查数组是否为空
    private boolean isEmpty() {
        return (total == 0);
    }

    // 添加产品到数组
    public boolean add(Product product) {
        if (isFull()) {
            return false;
        } else {
            products[total] = product;
            total++;
            return true;
        }
    }

    // 列出所有产品
    public String listProducts() {
        if (isEmpty()) {
            return "No products";
        } else {
            String listOfProducts = "";
            // 修改点1: 循环应该从0开始，而不是从1开始
            for (int i = 0; i < total; i++) {
                listOfProducts += (i + 1) + ": " + products[i] + "\n";
            }
            return listOfProducts;
        }
    }
}