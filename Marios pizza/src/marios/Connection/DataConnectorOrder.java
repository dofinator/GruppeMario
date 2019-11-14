package marios.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import marios.Pizza.Pizza;

public class DataConnectorOrder {

    public void insertOrder(int CustomerId, int pizzaId, String time) {

        try (Connection conn = DataConnector.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO Orders(Pizza_ID_FK, Customer_ID, Order_Time ) values(?,?,?)");) {
            stmt.setInt(1, pizzaId);
            stmt.setInt(2, CustomerId);
            stmt.setString(3, time);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Could not insert values into database Orders!!");
        }

    }

    public void getCurrentOrders() {

        try (
                Connection conn = DataConnector.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT Customer_ID, Pizza_Name, Order_Time FROM orders as o INNER JOIN pizza as p on o.Pizza_ID_FK = p.Pizza_ID where is_Active = true");) {

            while (resultSet.next()) {

                int customerId = resultSet.getInt("Customer_Id");
                String pizzaId = resultSet.getString("Pizza_ID_FK");
                String orderTime = resultSet.getString("Order_Time");

                System.out.print(customerId + " " + pizzaId + " " + orderTime);

            }

        } catch (SQLException ex) {

            System.out.println("Could not connect to database !!");
        }

    }

    public void showOrderHistory() {
        int revenueSum = 0;
        try (
                Connection conn = DataConnector.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT Customer_ID, Pizza_Name, Order_Time, Pizza_Price FROM orders as o INNER JOIN pizza as p on o.Pizza_ID_FK = p.Pizza_ID");) {

            while (resultSet.next()) {

                int customerId = resultSet.getInt("Customer_Id");
                String pizzaId = resultSet.getString("Pizza_ID_FK");
                String orderTime = resultSet.getString("Order_Time");
                revenueSum += resultSet.getInt("Pizza_Price");

                System.out.print(customerId + " " + pizzaId + " " + orderTime);

            }

            System.out.println(revenueSum);

        } catch (SQLException ex) {

            System.out.println("Could not connect to database !!");
        }

    }

    public void Statistics() {

        try (
                Connection conn = DataConnector.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT count(Pizza_ID_FK) as pizzaAmountSold, Pizza_name from orders as o INNER JOIN pizza as p ON o.Pizza_Id_FK = p.Pizza_id group by Pizza_ID_FK order by pizzaAmountSold DESC");) {

            while (resultSet.next()) {

                int pizzaAmount = resultSet.getInt("count(Pizza_ID_FK)");
                String pizzaName = resultSet.getString("Pizza_name");

                System.out.print(pizzaAmount + " " + pizzaName);

            }

        } catch (SQLException ex) {

            System.out.println("Could not connect to database !!");
        }

    }

    public void updateOrdner(int customerId) {

        try (Connection conn = DataConnector.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE orders SET is_Active = false where customer_Id = ?");) {
            stmt.setInt(1, customerId);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Could not insert values into database Orders!!");
        }

    }

    public void setAllOrdersInActive() {

        try (Connection conn = DataConnector.getConnection();
                Statement stmt = conn.createStatement();) {
            stmt.executeUpdate("DELETE FROM Orders");

        } catch (SQLException ex) {
            System.out.println("Could not insert values into database Orders!!");
        }

    }

}
