package marios.pizza;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class OrganizeOrders {

    private static int count;
    private int orderNo;
    private ArrayList<Pizza> orders = new ArrayList<>();

    private final LocalTime time = LocalTime.now();

    public ArrayList<Pizza> getOrders() {
        return orders;

    }

    public void addOrder(Pizza pizza) {
        orders.add(pizza);
        count++;
    }
    public int orderNo(Pizza pizza){
        
        orderNo = count++;
        return orderNo;
    }
    public void removeOrder(Pizza pizza) {
        orders.remove(pizza);

    }

    public String toString() {
        String result = "";

        for (int i = 0; i < orders.size(); i++) {

<<<<<<< HEAD
            result += "Order " + (i + 1) + ": " + orders.get(i).getPizzaName() + " pizza, Time of order: " + +time.getHour() + ":" + time.getMinute() + "\n";
=======
            result += "Order " + (orderNo(pizzas)+1)  + ": " + pizzas.getPizzaName() + " pizza, Time of order: " + +time.getHour() + ":" + time.getMinute() + "\n";
>>>>>>> 430c6fb28a30a636cee3796fcc65beb260ea7770

        }
        return result;
    }

}
