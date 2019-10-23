package marios.pizza;

import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public class OrganizeOrders {
    private static int count;
    private ArrayList<Pizza> orders = new ArrayList<>();

    public ArrayList<Pizza> getOrders() {
        return orders;
    }
    
    public void addOrder(Pizza pizza){
        orders.add(pizza);
        count++;
    }
    public void removeOrder(Pizza pizza){
        orders.remove(pizza);
    }
    
    
    public String toString() {
        String result = "";
        
        for (Pizza pizzas : orders){
            result += count + "order: " + pizzas.getPizzaName() + " pizza" + "\n";
            
        }
        return result;
        
    }
    
}
