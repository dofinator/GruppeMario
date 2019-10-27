package marios.pizza;

import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class MenuLine {

    Scanner myScan;

    private final MenuCard menuCard;
    private final OrganizeOrders orders;
    private final OrderHistory history;

    private int PizzaNo;
    private int answer;

    public MenuLine() throws IOException {
        myScan = new Scanner(System.in);
        menuCard = new MenuCard();
        orders = new OrganizeOrders();
        history = new OrderHistory();

        printMainMenu();

        while (true) {

            System.out.print("\nChoose option: ");
            answer = myScan.nextInt();

            if (answer == 9) {
                clearConsole();
                history.revenueFile();
                System.out.println("Creating revenue file ...");
                System.out.println("System ending ...");

                exit(0);

            }
            getInput(answer);

        }

    }

    public static void printMainMenu() {

        System.out.println("🍕 Marios Pizzaria 🍕");
        System.out.println("\n" + "Press 1 to see menu");
        System.out.println("\n" + "Press 2 to add a order");
        System.out.println("\n" + "Press 3 to see current orders or remove a order");
        System.out.println("\n" + "Press 4 to see revenue and order history");
        System.out.println("\n" + "Press 5 to make file with revenues and order history");
        System.out.println("\n" + "Press 9 to TURN OFF system");
    }

    public void clearConsole() {
        for (int i = 0; i <= 100; i++) {
            System.out.println("");
        }
    }

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
                System.out.print("Enter pizzaNr: ");

                int pizzaNo = myScan.nextInt();

                clearConsole();

                if (pizzaNo >= 1 && pizzaNo <= 14) {
                    orders.getOrders().add(menuCard.getMenuCard().get(pizzaNo));
                    history.getPizzaHistory().add(menuCard.getMenuCard().get(pizzaNo));
                    clearConsole();
                    printMainMenu();
                } else {
                    System.out.println("Pizza does not exist in menu card, please press 0 to return to main menu and try again ...");
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
                    System.out.print("\nChoose order to remove:");
                    pizzaNo = myScan.nextInt();

                    try {
                        orders.getOrders().remove(pizzaNo - 1);
                    } catch (IndexOutOfBoundsException e) {
                        clearConsole();
                        System.out.println("Order does not exist!!\n");

                        clearConsole();
                        printMainMenu();

                    }
                }
                clearConsole();
                printMainMenu();

                break;

            case 4:
                System.out.println("The total salary is: " + history.calculateRevenue() + " kr" + "\n");
                System.out.println(history.pizzaHistory());
                System.out.println("press 0 to return to main menu");
                break;
            case 5:
                history.revenueFile();

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

}
