package marios.pizza;

import java.io.BufferedWriter;
import java.io.File;
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

            bw.write("Most popular orders" + "\n\n");

            bw.write(pizzaHistory());

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

            FileWriter fw = new FileWriter("RevenuesHTML.html");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(head);
            bw.write(income);
            bw.write(pizzas);
            bw.close();

        } catch (IOException ex) {
            System.out.println("Could not make html file");
        }

    }

    public String pizzaHistory() {
        String result = "";
        for (Pizza pizzas : pizzaHistory) {

            result += pizzas.getPizzaName() + "\n";

        }
        return result;
    }
}
