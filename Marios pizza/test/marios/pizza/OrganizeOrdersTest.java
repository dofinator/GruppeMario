/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marios.pizza;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phill
 */
public class OrganizeOrdersTest {

    Pizza pizza;
    OrganizeOrders or;
    menuCard mc;
    private int tempPizzaNr;
    public OrganizeOrdersTest() {
        or = new OrganizeOrders();
        mc = new menuCard();
        pizza = new Pizza("Dennis", "tomatsauce", 57);
        tempPizzaNr = 0;
        
        or.addOrder(pizza);
    }

    @Test
    public void testAddOrder() {
        or.addOrder(mc.getMenuCard().get(tempPizzaNr));

    }

    @Test
    public void testRemoveOrder() {

       or.getOrders().remove(tempPizzaNr);

    }

}
