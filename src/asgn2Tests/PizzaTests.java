package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.VegetarianPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Exceptions.PizzaException;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B - Bradley Caferra
 *
 */
public class PizzaTests {
	
	MargheritaPizza testMargherita;
	VegetarianPizza testVegetarian;
	MeatLoversPizza testMeatLovers;
	MargheritaPizza pizzaTest;
	
	@Before
	public void setup() throws PizzaException{
		testMargherita = new MargheritaPizza(2, LocalTime.parse("19:30:00"), LocalTime.parse("20:00:00"));
		testVegetarian = new VegetarianPizza(1, LocalTime.parse("20:30:00"), LocalTime.parse("21:00:00"));
		testMeatLovers = new MeatLoversPizza(5, LocalTime.parse("21:30:00"), LocalTime.parse("22:00:00"));

	}
	
	@Test
	public void margheritaTest(){
		assertEquals(testMargherita.getQuantity(), 2);
		assertEquals(testMargherita.getPizzaType(), "Margherita Pizza");
	}
	
	@Test
	public void vegetarianTest(){
		assertEquals(testVegetarian.getQuantity(), 1);
		assertEquals(testVegetarian.getPizzaType(), "Vegetarian Pizza");
	}
	
	@Test
	public void meatloversTest(){
		assertEquals(testMeatLovers.getQuantity(), 5);
		assertEquals(testMeatLovers.getPizzaType(), "Meat Lovers Pizza");
	}
	
	
	@Test(expected = PizzaException.class)
	public void lowQuantityTest() throws PizzaException{		
		pizzaTest = new MargheritaPizza(0, LocalTime.parse("19:30:00"), LocalTime.parse("20:00:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void highQuantityTest() throws PizzaException{		
		pizzaTest = new MargheritaPizza(11, LocalTime.parse("19:30:00"), LocalTime.parse("20:00:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void orderBeforeOpenTest() throws PizzaException{		
		pizzaTest = new MargheritaPizza(1, LocalTime.parse("13:30:00"), LocalTime.parse("20:00:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void deliveryBeforeOrderTest() throws PizzaException{		
		pizzaTest = new MargheritaPizza(1, LocalTime.parse("19:30:00"), LocalTime.parse("19:10:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void shortCookTimeTest() throws PizzaException{		
		pizzaTest = new MargheritaPizza(1, LocalTime.parse("19:30:00"), LocalTime.parse("19:35:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void nullOrderTimeTest() throws PizzaException{		
		pizzaTest = new MargheritaPizza(1, null, LocalTime.parse("29:10:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void nullDeliveryTimeTest() throws PizzaException{		
		pizzaTest = new MargheritaPizza(1, LocalTime.parse("29:10:00"), null);
	}
	
	
}
