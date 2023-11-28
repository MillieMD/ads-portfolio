package Practical_17;

public class Order {

    private final String id;
    private String productName;
    private float unitPrice;
    private int quantity;
    private StatusType status;

    enum StatusType {Pending, Paid, Shipped, Delivered, Refunded}

    Order(String id, String name, float price, int quantity){

        this.id = id;
        productName = name;
        unitPrice = price;
        this.quantity = quantity;

        status = StatusType.Pending;
    }

    // Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public StatusType getStatus() {
        return status;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return id + ": " + quantity + " x " + productName + "("+ unitPrice +")";
    }
}
