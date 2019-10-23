package marios.pizza;

/**
 *
 * @author Jonas
 */
public class Pizza {
    private String pizzaName;
    private String pizzaTopping;
    private int price;

    public Pizza(String pizzaName, String pizzaTopping, int price) {
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

    public int getPrice() {
        return price;
    }
    
    
}
