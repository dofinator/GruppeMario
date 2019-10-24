package marios.pizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class OrderHistory {

    private static int count;
    private ArrayList<Pizza> pizzaHistory = new ArrayList<>();

    public int calculateRevenue() {
        int revenue = 0;
        for (Pizza pizzas : pizzaHistory) {
            revenue += pizzas.getPrice();

        }
        return revenue;
    }

    public void revenueFile() {

        try {
            FileWriter fw = new FileWriter("Revenues.txt");

            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Order history and revenues: " + "\n");

            bw.write("Total salary in krones is: " + calculateRevenue() + "\n");

            bw.write("Most popular orders" + "\n");

            bw.write(pizzaHistory());

            bw.close();
        } catch (IOException ex) {
            System.out.println("lol");
        }
    }

    public ArrayList<Pizza> getPizzaHistory() {
        return pizzaHistory;
    }

    public String pizzaHistory() {
        String result = "";
        for (Pizza pizzas : pizzaHistory) {
            count++;
            result += "Order: " + count + ": " + pizzas.getPizzaName() + "\n";
            
        }
        return result;
    }
}
