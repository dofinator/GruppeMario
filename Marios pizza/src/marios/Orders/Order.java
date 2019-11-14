/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marios.Orders;

import java.time.LocalTime;
import java.util.ArrayList;
import marios.Pizza.Pizza;

public class Order {

    private ArrayList<Pizza> pizzas;
    private String pickUpTime;
    private int customerId;

    public Order(ArrayList<Pizza> pizzas, String pickUpTime, int customerId) {
        this.pizzas = pizzas;
        this.pickUpTime = pickUpTime;
        this.customerId = customerId;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < pizzas.size(); i++) {

            result += "Pizza " + (i + 1) + ": " + pizzas.get(i).getPizzaName() + " pizza, Time of pick up: " + pickUpTime + "\n";

        }

        return result;
    }
}
