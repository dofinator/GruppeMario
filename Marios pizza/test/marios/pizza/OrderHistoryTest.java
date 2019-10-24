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
 * @author Jonas, Mads, Christoffer og Phillip
 */
public class OrderHistoryTest {

    Pizza pizza1;
    Pizza pizza2;
    OrderHistory history;

    public OrderHistoryTest() {

        pizza1 = new Pizza("Visuvio", "tomatsauce, ost , skinke og oregano", 57);
        pizza2 = new Pizza("Visuvio", "tomatsauce, ost , skinke og oregano", 61);
        history = new OrderHistory();
    }

    @Test
    public void testCalculateRevenue() {
        int expected = 118;

        history.getPizzaHistory().add(pizza1);
        history.getPizzaHistory().add(pizza2);

        int actual = history.calculateRevenue();

        assertEquals(expected, actual);

    }

}
