package marios.Controller;

import java.io.IOException;
import static java.lang.System.exit;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import mario.Display.MyUtils;
import marios.Connection.DataConnector;
import marios.Connection.DataConnectorOrder;
import marios.Orders.Order;
import marios.Orders.OrderHistory;
import marios.Pizza.MenuCard;
import marios.Pizza.Pizza;

public class GetInput {

    Scanner myScan;
    private final MenuCard menuCard;
    private final OrderHistory history;
    private final MyUtils myUtils;
    private Order currentOrder;
    private int pizzaNo;
    private int answer;
    private int customerId;
    private String pickUpTime;
    private DataConnectorOrder connectOrderDatabase;

    public GetInput() {
        connectOrderDatabase = new DataConnectorOrder();
        myScan = new Scanner(System.in);
        menuCard = new MenuCard();
        history = new OrderHistory();
        myUtils = new MyUtils();

    }

    public void getUserInput() throws IOException {

        myUtils.clearConsole();
        myUtils.printMainMenu();

        System.out.println("Choose option: ");

        switch (myScan.nextInt()) {
            case 1:
                System.out.println(menuCard.toString());
                System.out.println("Press 0 to return to main menu");
                myUtils.splitDisplay();
                break;

            case 2:
                
                this.currentOrder = null;

                while (true) {
                    myUtils.clearConsole();
                    System.out.println(menuCard.toString());
                    System.out.println("Press 0 to return to main menu\n");
                    System.out.println("Which pizza from the menu card would you like to add as a order, enter a number 1-14, ");
                    System.out.print("Enter pizza number: ");

                    int pizzaNo = myScan.nextInt();

                    myUtils.clearConsole();

                    if (pizzaNo >= 1 && pizzaNo <= 14) {

                        if (currentOrder == null) {
                            this.currentOrder = new Order(new ArrayList<>(), pickUpTime, customerId);

                        }
                        this.currentOrder.getPizzas().add(menuCard.getMenuCard().get(pizzaNo));

                    } else {
                        System.out.println("Pizza does not exist in menu card, please press 0 to return to main menu and try again ...");
                        break;
                    }

                    if (pizzaNo == 0) {

                        myUtils.clearConsole();

                        break;
                    }
                    
                    // lave database kald, hvor jeg gemmer orderen med pizzaer før jeg nulstiller ordren.
                   
                    // this.currentOrder = null; nulstil orderen
                }
                

                if (this.currentOrder != null) {
                    myUtils.clearConsole();
                    System.out.println("Enter a customer id for this order");
                    customerId = myScan.nextInt();
                    myScan.nextLine();
                    System.out.println("Enter a pick up time");
                    String pickUpTime = myScan.nextLine();
                    myUtils.clearConsole();

                }
                
                connectOrderDatabase.insertOrder(customerId, pizzaNo, pickUpTime);
                /*for(int i = 0; i < currentOrder.getPizzas().size(); i++ ){
                connectOrderDatabase.insertOrder(customerId, menuCard.getMenuCard().get(i), pickUpTime);*/
                
               
                break;

            case 3:
                
                
                myUtils.clearConsole();
                System.out.println(this.currentOrder.toString());
                System.out.println("For order remove press 1 or to remove all orders press 2, else press 0 to return to main menu");

                int remove = myScan.nextInt();
                myUtils.clearConsole();

                if (remove == 0) {
                    myUtils.clearConsole();
                    myUtils.printMainMenu();
                    break;
                }
                if (remove == 2) {
                    myUtils.clearConsole();
                    
                    myUtils.printMainMenu();
                    orders.getOrders().clear();
                }
                if (remove == 1) {

                    System.out.println("Which order would you like to remove?\n");
                    System.out.println(orders.toString());
                    System.out.println("Press 0 to return to main menu");
                    System.out.print("\nChoose order to remove:");
                    pizzaNo = myScan.nextInt();

                    try {
                        orders.getOrders().remove(pizzaNo - 1);
                    } catch (IndexOutOfBoundsException e) {
                        myUtils.clearConsole();
                        System.out.println("Order does not exist!!\n");

                        myUtils.clearConsole();
                        myUtils.printMainMenu();
                    }
                }
                if (remove > 3) {
                    System.out.println("!!Invalid option!!\n");
                    System.out.println("Press 0 to returnt to main menu");
                }
                break;

            case 4:
                myUtils.clearConsole();
                System.out.println("The total salary is: " + history.calculateRevenue() + " kr" + "\n");
                System.out.println(history.pizzaHistory());

                if (history.getPizzaHistory().size() > 0) {
                    System.out.println(history.mostPopularPizza());
                }
                System.out.println("press 0 to return to main menu");
                break;

            case 5:
                history.revenueFile();
                history.makeHTML();
                break;

            case 0:
                myUtils.clearConsole();

                myUtils.printMainMenu();

                break;

            default:
                if (answer == 9) {
                    myUtils.clearConsole();
                    history.revenueFile();
                    history.makeHTML();
                    System.out.println("Creating revenue file ...");
                    System.out.println("System ending ...");
                    exit(0);
                }
                myUtils.clearConsole();
                myUtils.printMainMenu();
                break;
        }

    }
}
