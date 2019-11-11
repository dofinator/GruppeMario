package marios.pizza;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class MenuCard {

    private HashMap<Integer, Pizza> menuCard = new HashMap<>();

    public MenuCard() {
        menuCard.put(1, new Pizza("Visuvio", "tomatsauce, ost , skinke og oregano", 57));
        menuCard.put(2, new Pizza("Amerikaner", "tomatsauce, ost, oksefars og oregano", 53));
        menuCard.put(3, new Pizza("Cacciatore", "tomatsauce, ost, pepperoni og oregano", 57));
        menuCard.put(4, new Pizza("Carbona", "tomatsauce, ost, kødsauce, spaghetti, coctailpølser og oregano", 63));
        menuCard.put(5, new Pizza("Dennis", " tomatsauce, ost, skinke, pepperoni, coctailpølser og oregano", 65));
        menuCard.put(6, new Pizza("Bertil", "tomatsauce, ost, bacon og oregano", 57));
        menuCard.put(7, new Pizza("Silvia", "tomatsauce, ost, pepperoni, rød peber,løg, oliven og oregano", 61));
        menuCard.put(8, new Pizza("Victoria", "tomatsauce, ost, skinke, ananas, champignon, løg og oregano", 61));
        menuCard.put(9, new Pizza("Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61));
        menuCard.put(10, new Pizza("Capricciosa", "tomatsauce, ost, skinke, champignon og oregano", 61));
        menuCard.put(11, new Pizza("Hawai", " tomatsauce, ost, skinke, champignon og oregano", 61));
        menuCard.put(12, new Pizza("Le Blissola", " tomatsauce, ost skinke, rejer og oregano", 61));
        menuCard.put(13, new Pizza("Venezia", "tomatsauce, ost, skinke, bacon og oregano", 61));
        menuCard.put(14, new Pizza("Mafia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61));

    }

    public HashMap<Integer, Pizza> getMenuCard() {
        return menuCard;
    }

    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<Integer, Pizza> menuCard1 : menuCard.entrySet()) {
            result += menuCard1.getKey() + ": " + menuCard1.getValue().getPizzaName() + " - " + " " + menuCard1.getValue().getPizzaTopping() + " " + menuCard1.getValue().getPrice() + " kr." + "\n";
        }
        return result;
    }

}
