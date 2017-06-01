package asgn2Tests;

import java.util.ArrayList;

import asgn2Exceptions.PizzaException;
import asgn2Exceptions.LogHandlerException;

import org.junit.Before;
import org.junit.Test;


import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B - Bradley Caferra
* 
*/
public class LogHandlerPizzaTests {
	
	String normalPizza;
	String emptyTypePizza;
	String wrongTypePizza;
	String lowQuauntityPizza;
	String highQuantityPizza;
	String orderBeforeTimePizza;
	String deliveryBeforeOrderTimePizza;
	String notEnoughCookTimePizza;
	
	ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
	
	@Before
	public void setup() throws PizzaException, LogHandlerException{
		normalPizza = new String("19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "PZV" + "1");
		emptyTypePizza = new String("19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "" + "1");
		wrongTypePizza = new String("19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "QWS" + "1");
		lowQuauntityPizza = new String("19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "PZV" + "0");
		highQuantityPizza = new String("19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "PZV" + "11");
		orderBeforeTimePizza = new String("16:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "PZV" + "1");
		deliveryBeforeOrderTimePizza = new String("19:30:00" + "16:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "PZV" + "1");
		notEnoughCookTimePizza = new String("19:30:00" + "19:31:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2" + "PZV" + "1");
	}
	
	@Test
	public void normalTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(normalPizza);
	}
	
	@Test(expected = LogHandlerException.class)
	public void emptyTypeTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(emptyTypePizza);
	}
	
	@Test(expected = LogHandlerException.class)
	public void wrongTypeTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(wrongTypePizza);
	}
	
	@Test(expected = LogHandlerException.class)
	public void lowQuauntityTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(lowQuauntityPizza);
	}
	
	@Test(expected = LogHandlerException.class)
	public void highQuantityTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(highQuantityPizza);
	}
	
	@Test(expected = LogHandlerException.class)
	public void orderBeforeTimeTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(orderBeforeTimePizza);
	}
	
	@Test(expected = LogHandlerException.class)
	public void deliveryBeforeOrderTimeTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(deliveryBeforeOrderTimePizza);
	}
	
	@Test(expected = LogHandlerException.class)
	public void notEnoughCookTimeTest() throws PizzaException, LogHandlerException{
		
		LogHandler.createPizza(notEnoughCookTimePizza);
	}
	
	
	@Test(expected = LogHandlerException.class)
	public void testLogFile() throws PizzaException, LogHandlerException{
		pizzaList = LogHandler.populatePizzaDataset("test not logFile");
		
	}
	
}

	
