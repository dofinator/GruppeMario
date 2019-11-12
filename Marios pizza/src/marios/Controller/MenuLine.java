package marios.Controller;

import java.io.IOException;
import static java.lang.System.exit;
import mario.Display.MyUtils;
import marios.Orders.OrderHistory;


/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class MenuLine {
    
    private final OrderHistory history;
    private MyUtils myUtils;
    private GetInput getInput;
    public MenuLine() throws IOException {
        
        history = new OrderHistory();
        myUtils = new MyUtils();
        getInput = new GetInput();
        
        myUtils.printMainMenu();

        while (true) {
            
            System.out.print("Choose option: ");
          
            getInput.getUserInput();
            
        }
    }

    

 
    
}