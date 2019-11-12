

package marios.Controller;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import mario.Display.MyUtils;
import marios.Orders.OrderHistory;
import marios.Orders.OrganizeOrders;
import marios.Pizza.MenuCard;
import marios.Pizza.Pizza;


public class GetInput {
    
    Scanner myScan;
    private final MenuCard menuCard;
    private final OrganizeOrders orders;
    private final OrderHistory history;
    private final MyUtils myUtils;
    private int PizzaNo;
    private int answer;

    public GetInput() {
        myScan = new Scanner(System.in);
        menuCard = new MenuCard();
        orders = new OrganizeOrders();
        history = new OrderHistory();
        myUtils = new MyUtils();
    }

        
        
     public void getUserInput() throws IOException {
        
        answer = myScan.nextInt(); 
        
        myUtils.clearConsole();
        myUtils.printMainMenu();
        
        
        switch (answer) {
            case 1:
                System.out.println(menuCard.toString());
                System.out.println("Press 0 to return to main menu");
                myUtils.splitDisplay();
                break;

            case 2:
                myUtils.clearConsole();
                
                System.out.println(menuCard.toString());
                System.out.println("Press 0 to return to main menu\n");
                System.out.println("Which pizza from the menu card would you like to add as a order, enter a number 1-14, ");
                myUtils.splitDisplay();
                System.out.print("Enter pizza number: ");

                int pizzaNo = myScan.nextInt();
                
                myUtils.clearConsole();
                
                System.out.println("How many would you like to add?");
                
                int pizzaAmount = myScan.nextInt();

                if (pizzaNo >= 1 && pizzaNo <= 14) {
                    ArrayList<Pizza> oneOrder = new ArrayList();
                    myUtils.clearConsole();
                    myUtils.printMainMenu();
                } else {
                    System.out.println("Pizza does not exist in menu card, please press 0 to return to main menu and try again ...");
                }
                if (pizzaNo == 0) {
                    myUtils.clearConsole();
                    myUtils.printMainMenu();
                }
                break;

            case 3:
                System.out.println(orders.toString());

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
                    }catch (IndexOutOfBoundsException e) {
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
