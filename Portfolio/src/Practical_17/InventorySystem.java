package Practical_17;

import java.util.HashMap;

public class InventorySystem {

    private HashMap<String, Order> orders;

    // TODO: get total revenue

    InventorySystem(){
        orders = new HashMap<String, Order>();
    }

    /**
     * Add new order to orders hashmap
     * @param o order to add
     */
    public void addOrder(Order o){
        orders.put(o.getId(), o);
    }

    /**
     * Change ID of an order
     * @param id old id to change
     * @param newid id to replace old id with
     */
    public void updateOrderId(String id, String newid){
        Order o = orders.get(id);
        orders.remove(id);

        o.setId(newid);
        orders.put(newid, o);
    }

    /**
     * Change the product name of an order
     * @param id id of order to change
     * @param name new product name
     */
    public void updateOrderProductName(String id, String name){
        orders.get(id).setProductName(name);
    }

    /**
     * Change the quantity of an order
     * @param id id of order to change
     * @param quantity new quantity
     */
    public void updateOrderQuantity(String id, int quantity){
        orders.get(id).setQuantity(quantity);
    }

    /**
     * Change unit price of product in an order
     * @param id id of order to change
     * @param price new price
     */
    public void updateOrderPrice(String id, double price){
        orders.get(id).setUnitPrice(price);
    }

    /**
     * Change status of order
     * @param id order to change
     * @param status new status
     */
    public void updateOrderStatus(String id, Order.StatusType status){
        orders.get(id).setStatus(status);
    }

    /**
     * @param o order to cancel
     */
    public void cancelOrder(Order o){
        orders.remove(o.getId());
    }

    /**
     * @param id id of order to cancel
     */
    public void cancelOrder(String id){
        orders.remove(id);
    }

    /**
     * @param orderId id of order to find
     * @return order with matching id
     */
    public Order getOrder(String orderId){
        return orders.get(orderId);
    }

    /**
     * @return total revenue of all orders in system
     */
    public double getRevenue(){
        double rev = 0.0;

        for (Order o: orders.values()){
            // Add revenue as long as status is not pending (money not paid yet) or refunded (money returned)
            if(o.getStatus() != Order.StatusType.Refunded  &&o.getStatus() != Order.StatusType.Pending) {
                rev += (o.getQuantity() * o.getUnitPrice());

            }
        }

        return rev;
    }

    public String toString(Order.StatusType status){

        StringBuilder s = new StringBuilder();

        s.append(status.toString()).append(" Orders:");

        for(Order o: orders.values()){

            if(o.getStatus() == status) {
                s.append(o).append("\n");
            }
        }

        return s.toString();
    }

    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();

        s.append("Orders: \n");

        for(Order o: orders.values()){
            s.append(o).append("\n");
        }

        return s.toString();
    }

}
