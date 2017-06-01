package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B - Bradley Caferra
 *
 */
public class RestaurantPizzaTests {
	
	PizzaRestaurant restaurantTest;
	
	@Before
	public void setup() throws CustomerException, PizzaException, LogHandlerException{
		restaurantTest = new PizzaRestaurant();
		restaurantTest.processLog(".//logs/20170101.txt");
	}
	
	@Test
	public void processLogsTest() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant processLogsTest = new PizzaRestaurant();
		
		assert(processLogsTest.processLog(".//logs/20170101.txt"));
		assert(processLogsTest.processLog(".//logs/20170102.txt"));
		assert(processLogsTest.processLog(".//logs/20170103.txt"));
	}
	
	@Test(expected = LogHandlerException.class)
	public void nullLogTest() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant processNullTest = new PizzaRestaurant();
		
		assert(processNullTest.processLog(null));
		
	}
	
	@Test(expected = LogHandlerException.class)
	public void wrongLogTest() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant processWrongTest = new PizzaRestaurant();
		
		assert(processWrongTest.processLog("notlog.file"));
	}
	
	@Test
	public void getPizzaTypeByIndexTest() throws CustomerException, PizzaException, LogHandlerException{
		String pizzaType = null;
		pizzaType = restaurantTest.getPizzaByIndex(0).getPizzaType();
		assertEquals(pizzaType, "Vegetarian Pizza");
	}
	
	@Test(expected = CustomerException.class)
	public void indexExceptionTest() throws CustomerException,PizzaException, LogHandlerException{
		restaurantTest.getCustomerByIndex(4);
	}
	
	@Test
	public void getPizzaQuantityTest() throws CustomerException, PizzaException, LogHandlerException{
		int quantity = 0;
		quantity = restaurantTest.getPizzaByIndex(0).getQuantity();	
		assertEquals(quantity, 2);
	}
	
	@Test
	public void numberOfPizzaOrdersTest() throws CustomerException,PizzaException, LogHandlerException{
		int number = 0;
		number = restaurantTest.getNumPizzaOrders();
		assertEquals(number, 3);
	}		
	
	@Test
	public void profitTest() throws CustomerException, PizzaException, LogHandlerException{
		assertTrue(restaurantTest.getTotalProfit() == 1);
	}
	
}
