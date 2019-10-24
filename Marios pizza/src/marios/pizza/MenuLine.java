package marios.pizza;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class MenuLine {

    Scanner myScan;

    private final menuCard menuCard;
    private final OrganizeOrders orders;
    private final OrderHistory history;
    private int PizzaNr;
    private int answer;

    public MenuLine() throws IOException {
        myScan = new Scanner(System.in);
        menuCard = new menuCard();
        orders = new OrganizeOrders();
        history = new OrderHistory();

        printMainMenu();

        while (true) {

            answer = myScan.nextInt();
            getInput(answer);

        }

    }

    public static void printMainMenu() {

        System.out.println("\n" + "Press 1 to see menu");
        System.out.println("\n" + "Press 2 to add a order");
        System.out.println("\n" + "Press 3 to see current orders or remove a order");
        System.out.println("\n" + "Press 4 to see revenue and order history");
        System.out.println("\n" + "Press 5 to make file with revenues and order history");
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

                System.out.println("Press 6 to return to main menu");
                break;

            case 2:
                clearConsole();
                System.out.println("Press 1 to continue, else press 6 to return to main menu");

                int order = myScan.nextInt();
                clearConsole();
                if (order == 6) {
                    clearConsole();
                    printMainMenu();
                    break;
                }

                System.out.println("Which pizza from the menu card would you like to add as a order, enter a number 1-14 ");

                int pizzaNr = myScan.nextInt();

                clearConsole();
                orders.getOrders().add(menuCard.getMenuCard().get(pizzaNr));
                history.getPizzaHistory().add(menuCard.getMenuCard().get(pizzaNr));

                clearConsole();
                printMainMenu();

                break;

            case 3:
                System.out.println(orders.toString());

                System.out.println("For order remove press 1, else press 6 to return to main menu");

                int remove = myScan.nextInt();
                clearConsole();

                if (remove == 6) {
                    clearConsole();
                    printMainMenu();
                    break;
                }

                System.out.println("Which order would you like to remove?\n");
                System.out.println(orders);
                pizzaNr = myScan.nextInt();

                clearConsole();
                printMainMenu();

                orders.getOrders().remove(pizzaNr - 1);

                break;

            case 4:
                System.out.println("The total salary is: " + history.calculateRevenue() + " kr" + "\n");
                System.out.println(history.pizzaHistory());
                System.out.println("press 6 to return to main menu");
                break;
            case 5:
                history.revenueFile();
            case 6:
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
