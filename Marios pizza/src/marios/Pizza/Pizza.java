package marios.Pizza;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class Pizza {

    private String pizzaName;
    private String pizzaTopping;
    private double price;

    public Pizza(String pizzaName, String pizzaTopping, double price) {
        this.pizzaName = pizzaName;
        this.pizzaTopping = pizzaTopping;
        this.price = price;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getPizzaTopping() {
        return pizzaTopping;
    }

    public double getPrice() {
        return price;
    }

}
