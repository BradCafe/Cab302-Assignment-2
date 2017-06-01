package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.Pizza;
import asgn2Exceptions.PizzaException;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B - Bradley Caferra
 * 
 */
public class PizzaFactoryTests {
	
	Pizza margheritaTest;
	Pizza vegetarianTest;
	Pizza meatloversTest;
	
	@Before
	public void setup() throws PizzaException{
		margheritaTest = PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:10:00"), LocalTime.parse("21:21:00"));
		vegetarianTest = PizzaFactory.getPizza("PZV", 3, LocalTime.parse("19:10:00"), LocalTime.parse("19:21:00"));
		meatloversTest = PizzaFactory.getPizza("PZL", 6, LocalTime.parse("20:10:00"), LocalTime.parse("20:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void wrongTypeTest() throws PizzaException {
		PizzaFactory.getPizza("POM", 1, LocalTime.parse("21:10:00"), LocalTime.parse("21:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void nullTypeTest() throws PizzaException {
		PizzaFactory.getPizza(null, 1, LocalTime.parse("21:10:00"), LocalTime.parse("21:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void missingTypeTest() throws PizzaException {
		PizzaFactory.getPizza("", 1, LocalTime.parse("21:10:00"), LocalTime.parse("21:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void noQuantityTest() throws PizzaException {
		PizzaFactory.getPizza("PZM", 0, LocalTime.parse("21:10:00"), LocalTime.parse("21:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void overQuantityTest() throws PizzaException {
		PizzaFactory.getPizza("PZM", 11, LocalTime.parse("21:10:00"), LocalTime.parse("21:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void beforeOderTimeTest() throws PizzaException {
		PizzaFactory.getPizza("PZM", 1, LocalTime.parse("01:10:00"), LocalTime.parse("21:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void deliverBeforeOrderTest() throws PizzaException {
		PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:10:00"), LocalTime.parse("20:21:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void noCookTimeTest() throws PizzaException {
		PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:10:00"), LocalTime.parse("21:11:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void nullOrderTimeTest() throws PizzaException {
		PizzaFactory.getPizza("PZM", 1, null, LocalTime.parse("21:11:00"));
	}
	
	@Test(expected = PizzaException.class)
	public void nullDeliveryTimeTest() throws PizzaException {
		PizzaFactory.getPizza("PZM", 1, LocalTime.parse("21:10:00"),null);
	}
	
	
	@Test
	public void margheritaTest(){
		assertEquals("PZM", margheritaTest.getPizzaType());
		assertEquals(1, margheritaTest.getQuantity());
	}
	
	@Test
	public void vegetarianTest(){
		assertEquals("PZV", margheritaTest.getPizzaType());
		assertEquals(3, margheritaTest.getQuantity());
	}
	
	
	@Test
	public void meatloversTest(){
		assertEquals("PZL", margheritaTest.getPizzaType());
		assertEquals(6, margheritaTest.getQuantity());
	}

	
}


