package Practical_17;

public class Order {

    private String id;
    private String productName;
    private float unitPrice;
    private int quantity;
    private StatusType status;

    enum StatusType {Pending, Paid, Shipped, Delivered, Refunded};

    Order(String id, String name, float price, int quantity){

        this.id = id;
        productName = name;
        unitPrice = price;
        this.quantity = quantity;

        status = StatusType.Pending;

    }

    @Override
    public String toString() {
        return id + ": " + quantity + " x " + productName + "("+ unitPrice +")";
    }
}
