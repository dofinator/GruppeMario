

package mario.Display;


public class MyUtils {

    
    public void printMainMenu() {

        System.out.println("🍕 Marios Pizzaria 🍕");
        System.out.println("\n" + "Press 1 to see menu");
        System.out.println("\n" + "Press 2 to add a order");
        System.out.println("\n" + "Press 3 to see current orders or remove a order");
        System.out.println("\n" + "Press 4 to see revenue and order history");
        System.out.println("\n" + "Press 5 to make HTML and text file with revenues and order history");
        System.out.println("\n" + "Press 9 to TURN OFF system");
        splitDisplay();
    }
    
    public void clearConsole() {
            for (int i = 0; i <= 100; i++) {
            System.out.println("");
            }
    }    
    
    public void splitDisplay(){
         System.out.println("==============================================================================================================");
    }
}
