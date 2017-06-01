package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;


/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A - Dietriche Rausim
 */
public class RestaurantCustomerTests {
	
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
	public void getCustomerByIndexTest() throws CustomerException, PizzaException, LogHandlerException{
		String customer = null;
		customer = restaurantTest.getCustomerByIndex(0).getName();
		assertEquals(customer, "Casey Jones");
	}
	
	
	@Test(expected = CustomerException.class)
	public void indexExceptionTest() throws CustomerException,PizzaException, LogHandlerException{
		restaurantTest.getCustomerByIndex(4);
	}
	
	@Test
	public void numberOfCustomerOrdersTest() throws CustomerException,PizzaException, LogHandlerException{
		int number = 0;
		number = restaurantTest.getNumCustomerOrders();
		assertEquals(number, 3);
	}
	
	@Test
	public void distanceTest() throws CustomerException, PizzaException, LogHandlerException{
		assertTrue(restaurantTest.getTotalDeliveryDistance() == 15.0);
	}
	

}
