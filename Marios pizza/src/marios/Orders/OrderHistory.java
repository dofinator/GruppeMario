package marios.Orders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marios.Pizza.Pizza;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class OrderHistory {

    private ArrayList<Pizza> pizzaHistory = new ArrayList<>();

    public ArrayList<Pizza> getPizzaHistory() {
        return pizzaHistory;
    }

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

            bw.write("Order history and revenues: " + "\n\n");

            bw.write("Total salary in Kr. is: " + calculateRevenue() + "\n");

            bw.write("Pizzas that has been sold:" + "\n\n");

            bw.write(pizzaHistory());

            bw.write(mostPopularPizza());

            bw.close();
        } catch (IOException ex) {
            System.out.println("Could not create file");
        }
    }

    public void makeHTML() {

        try {
            String result = "";
            for (Pizza pizzas : pizzaHistory) {

                result += "<li>" + pizzas.getPizzaName() + "</li>";
            }

            String head = "<div><h1>Orders history</h1><p>";
            String pizzas = "<h3> Pizza history </h3>" + result + "<br/><br/>";
            String income = "<h3> Revenues </h3><li>" + "Total income: " + calculateRevenue() + " kr" + "</li>";
            String popular = "<h3>Most popular pizza </h3><li>" + mostPopularPizza() + "</li>";
            FileWriter fw = new FileWriter("RevenuesHTML.html");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(head);
            bw.write(income);
            bw.write(pizzas);
            bw.write(popular);
            bw.close();

        } catch (IOException ex) {
            System.out.println("Could not make html file");
        }
    }

    public String mostPopularPizza() {
        String popular = "";
        int maxCounter = 0;
        for (int i = 0; i < pizzaHistory.size(); i++) {
            int counter = 1;
            for (int j = i + 1; j < pizzaHistory.size(); j++) {
                if (pizzaHistory.get(i) == pizzaHistory.get(j)) {

                    counter++;
                }

            }
            if (maxCounter < counter) {
                maxCounter = counter;
                popular = pizzaHistory.get(i).getPizzaName();
            }
        }

        return "Most popular pizza is: " + popular + ", it has been sold " + maxCounter + " times";
    }

    public String pizzaHistory() {
        String result = "";
        for (Pizza pizzas : pizzaHistory) {

            result += pizzas.getPizzaName() + "\n";

        }
        return result;
    }
}
