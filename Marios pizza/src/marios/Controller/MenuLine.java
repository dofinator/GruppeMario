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

}
