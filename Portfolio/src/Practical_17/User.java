package Practical_17;

public class User {

    public static void main(String[] args) {

        InventorySystem i1 = new InventorySystem();
        InventorySystem i2 = new InventorySystem();

        i1.addOrder(new Order("BR", "Bread Rolls", 0.6, 30));
        i1.addOrder(new Order("CR", "Croissant", 0.8, 20));
        i1.addOrder(new Order("PC", "Pain au Chocolat", 0.75, 25));

        System.out.println(i1);

        i1.updateOrderStatus("BR", Order.StatusType.Paid);
        i1.updateOrderId("PC", "PAC");

        System.out.println(i1);

        i2.addOrder(new Order("WM", "Whole Milk", 0.65, 50));
        i2.addOrder(new Order("SSM", "Semi Skimmed Milk", 0.62, 50));
        i2.addOrder(new Order("SM", "2% Milk", 0.70, 40));

        System.out.println(i2);

        i2.cancelOrder("SM");

        System.out.println(i2);

        System.out.println("Inventory system 1 revenue: " + i1.getRevenue());
        System.out.println("Inventory system 2 revenue: " + i2.getRevenue());
    }
}
