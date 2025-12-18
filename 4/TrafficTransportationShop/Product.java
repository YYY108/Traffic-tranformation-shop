package TrafficTransportationShop;
public class Product {
    // 私有
    private String productName;
    private int productCode;
    private double unitCost;
    private boolean inCurrentProductLine;

    // 构造函数
    public Product(String productName, int productCode,
                   double unitCost, boolean inCurrentProductLine) {
        this.productName = productName ;
        this.productCode = productCode ;
        this.unitCost = unitCost;
        this.inCurrentProductLine = inCurrentProductLine;
    }

    // 访问器（getters）
    public String getProductName() {
        return productName;
    }

    public int getProductCode() {
        return productCode;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public boolean isInCurrentProductLine() {
        return inCurrentProductLine;
    }

    // 修改器（setters）
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public void setInCurrentProductLine(boolean inCurrentProductLine) {
        this.inCurrentProductLine = inCurrentProductLine;
    }

    // toString 方法
    public String toString() {
        return "Product description: " + productName
                + ", product code: " + productCode
                + ", unit cost: " + unitCost
                + ", currently in product line: " + inCurrentProductLine;
    }
}


