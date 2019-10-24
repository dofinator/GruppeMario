package marios.pizza;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class OrganizeOrders {

   // private static int count;

    private ArrayList<Pizza> orders = new ArrayList<>();

    private final LocalTime time = LocalTime.now();

    public ArrayList<Pizza> getOrders() {
        return orders;
    }

    public void addOrder(Pizza pizza) {
        orders.add(pizza);

    }

    public void removeOrder(Pizza pizza) {
        orders.remove(pizza);

    }

    public String toString() {
        String result = "";

        for (Pizza pizzas : orders) {

            result += "Order " + (orders.indexOf(pizzas)+1)  + ": " + pizzas.getPizzaName() + " pizza, Time of order: " + +time.getHour() + ":" + time.getMinute() + "\n";

        }
        return result;

    }

}
