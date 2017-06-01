package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A - Dietriche Rausim
 */
public class LogHandlerCustomerTests {
	
	String normalCustomer;
	String emptyNameCustomer;
	String longNameCustomer;
	String typeEmptyCustomer;
	String typeWrongCustomer;
	String locationXEmptyCustomer;
	String locationYEmptyCustomer;
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	@Before
	public void setup() throws CustomerException, LogHandlerException{
		normalCustomer = new String("PZV" + "19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "2");
		emptyNameCustomer = new String("PZV" + "19:30:00" + "19:50:00" + "" + "0433333333" + "DVC" + "2" + "2");
		longNameCustomer = new String("PZV" + "19:30:00" + "19:50:00" + "Lilly Monroe Monroe Monroe" + "0433333333" + "DVC" + "2" + "2");
		typeEmptyCustomer = new String("PZV" + "19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "" + "2" + "2");
		typeWrongCustomer = new String("PZV" + "19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "BAD" + "2" + "2");
		locationXEmptyCustomer = new String("PZV" + "19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "" + "2");
		locationYEmptyCustomer = new String("PZV" + "19:30:00" + "19:50:00" + "Lilly Monroe" + "0433333333" + "DVC" + "2" + "");
	}
	
	@Test
	public void normalTest() throws CustomerException, LogHandlerException{
		
		LogHandler.createCustomer(normalCustomer);
	}
	
	@Test(expected = LogHandlerException.class)
	public void emptyNameTest() throws CustomerException, LogHandlerException{
		
		LogHandler.createCustomer(emptyNameCustomer);
	}
	
	@Test(expected = LogHandlerException.class)
	public void longNameTest() throws CustomerException, LogHandlerException{
		
		LogHandler.createCustomer(longNameCustomer);
	}
	
	@Test(expected = LogHandlerException.class)
	public void typeEmptyTest() throws CustomerException, LogHandlerException{
		
		LogHandler.createCustomer(typeEmptyCustomer);
	}
	
	@Test(expected = LogHandlerException.class)
	public void typeWrongTest() throws CustomerException, LogHandlerException{
		
		LogHandler.createCustomer(typeWrongCustomer);
	}
	
	@Test(expected = LogHandlerException.class)
	public void locationXEmptyTest() throws CustomerException, LogHandlerException{
		
		LogHandler.createCustomer(locationXEmptyCustomer);
	}
	
	@Test(expected = LogHandlerException.class)
	public void locationYEmptyTest() throws CustomerException, LogHandlerException{
		
		LogHandler.createCustomer(locationYEmptyCustomer);
	}
	
	
	@Test(expected = LogHandlerException.class)
	public void testLogFile() throws CustomerException, LogHandlerException{
		customerList = LogHandler.populateCustomerDataset("test not logFile");
		
	}
	
}
