package marios.pizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas
 */
public class OrderHistory {

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
            for (Pizza pizzar : pizzaHistory) {
                int revenues = 0;
                revenues += pizzar.getPrice();
                bw.write("Revenues " + revenues + " kr." + "\n");
            }

            bw.write("Most popular orders" + "\n");

            for (Pizza pizzas : pizzaHistory) {
                String orders = "";

                orders += pizzaHistory.indexOf(pizzas) + 1 + ": " + pizzas.getPizzaName() + "\n";
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println("lol");
        }
    }

    public ArrayList<Pizza> getPizzaHistory() {
        return pizzaHistory;
    }

    public String toString() {
        String result = "";
        for (Pizza pizzas : pizzaHistory) {
            result += pizzaHistory.indexOf(pizzas) + 1 + ": " + pizzas.getPizzaName() + "\n";
        }
        return result;
    }
}
