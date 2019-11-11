/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marios.pizza;

import marios.Pizza.Pizza;
import marios.Pizza.MenuCard;
import marios.Orders.OrganizeOrders;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class OrganizeOrdersTest {

    Pizza pizza;
    OrganizeOrders or;
    MenuCard mc;
    private int tempPizzaNr;

    public OrganizeOrdersTest() {
        or = new OrganizeOrders();
        mc = new MenuCard();
        pizza = new Pizza("Visuvio", "tomatsauce, ost , skinke og oregano", 57);
        tempPizzaNr = 1;

        or.addOrder(pizza);
    }

    @Test
    public void testAddOrder() {
        or.addOrder(mc.getMenuCard().get(tempPizzaNr));

    }

    @Test
    public void testRemoveOrder() {

        or.getOrders().remove(tempPizzaNr - 1);

    }

}
