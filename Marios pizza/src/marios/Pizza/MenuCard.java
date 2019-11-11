package marios.Pizza;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import marios.Connection.DataConnector;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class MenuCard {

    private HashMap<Integer, Pizza> menuCard = new HashMap<>();

    public MenuCard() {

        try (
                Connection conn = DataConnector.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM pizza");) {

            while (resultSet.next()) {

                int pizzaID = resultSet.getInt("Pizza_ID");
                String pizzaName = resultSet.getString("Pizza_Name");
                String PizzaTopping = resultSet.getString("Pizza_Topping");
                double pizzaPrice = resultSet.getDouble("Pizza_Price");

                Pizza pizza = new Pizza(pizzaName, PizzaTopping, pizzaPrice);

                menuCard.put(pizzaID, pizza);

            }

        } catch (SQLException ex) {

            System.out.println("Could not connect to database !!");
        }

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
