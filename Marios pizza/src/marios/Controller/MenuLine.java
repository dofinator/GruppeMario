package marios.Controller;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;
import mario.Display.MyUtils;
import marios.Orders.OrderHistory;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class MenuLine {

    private MyUtils myUtils;
    private GetInput getInput;
  
    

    public MenuLine() throws IOException {

        myUtils = new MyUtils();
        getInput = new GetInput();
       

        myUtils.printMainMenu();
        System.out.print("Choose option: ");
        while (true) {

           
            getInput.getUserInput();
             
        }
    }

<<<<<<< HEAD
    public void getInput(int number) throws IOException {
        clearConsole();
        switch (answer) {

            case 1:

                System.out.println(menuCard.toString());

                System.out.println("Press 0 to return to main menu");
                break;

            case 2:
                clearConsole();

                System.out.println(menuCard.toString());
                System.out.println("Press 0 to return to main menu\n");
                System.out.println("Which pizza from the menu card would you like to add as a order, enter a number 1-14, ");
                System.out.print("Enter pizza number: ");

                int pizzaNo = myScan.nextInt();
                clearConsole();
                System.out.println("How many would you like to add?");
                int pizzaAmount = myScan.nextInt();

                if (pizzaNo >= 1 && pizzaNo <= 14) {
                    ArrayList<Pizza> oneOrder = new ArrayList();

                    
                    
                    
                    /*orders.getOrders().add(menuCard.getMenuCard().get(pizzaNo));*/
                    /*history.getPizzaHistory().add(menuCard.getMenuCard().get(pizzaNo));*/
                    clearConsole();
                    printMainMenu();
                } else {
                    System.out.println("Pizza does not exist in menu card, please press 0 to return to main menu and try again ...");
                }

                if (pizzaNo == 0) {
                    clearConsole();
                    printMainMenu();

                }

                break;

            case 3:
                System.out.println(orders.toString());

                System.out.println("For order remove press 1 or to remove all orders press 2, else press 0 to return to main menu");

                int remove = myScan.nextInt();
                clearConsole();

                if (remove == 0) {
                    clearConsole();
                    printMainMenu();
                    break;
                }

                if (remove == 2) {
                    clearConsole();
                    printMainMenu();
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
                        clearConsole();
                        printMainMenu();
                    } catch (IndexOutOfBoundsException e) {
                        clearConsole();
                        System.out.println("Order does not exist, please press 0 and try again!!\n");

                    }
                }
<<<<<<< HEAD:Marios pizza/src/marios/Controller/MenuLine.java

                if (remove > 3) {
                    System.out.println("!!Invalid option!!\n");
                    System.out.println("Press 0 to returnt to main menu");
                }
=======
>>>>>>> 59b6f5ed1797b6c5fdaa7d66355a6a16bcf2eb9f:Marios pizza/src/marios/pizza/MenuLine.java

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

            case 0:
                clearConsole();

                printMainMenu();

                break;

            default:

                clearConsole();
                printMainMenu();

                break;
        }

    }

=======
>>>>>>> DenRigtige
}
