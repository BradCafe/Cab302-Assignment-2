package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.CustomerFactory;
import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A - Dietriche Rausim
 *
 */
public class CustomerFactoryTests {
	
	Customer testPickUp;
	Customer testDriver;
	Customer testDrone;
	
	@Before
	public void setup() throws CustomerException{
		testPickUp = CustomerFactory.getCustomer("PUC", "James Monroe", "0566666666", 0, 0);
		testDriver = CustomerFactory.getCustomer("DVC", "Jackie Monroe", "0777777777", 2, 6);
		testDrone = CustomerFactory.getCustomer("DNC", "Tiger Monroe", "0588888888", -5, -2);
	}
	
	@Test(expected = CustomerException.class)
	public void wrongTypeTest() throws CustomerException {
		CustomerFactory.getCustomer("NOT", "Lily Monroe", "0411111111", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void nullTypeTest() throws CustomerException {
		CustomerFactory.getCustomer(null, "Lily Monroe", "0411111111", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void missingTypeTest() throws CustomerException {
		CustomerFactory.getCustomer("", "Lily Monroe", "0411111111", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void longNameTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Lily Monroe Monroe Monroe", "0411111111", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void nullNameTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", null, "0411111111", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void longNumberTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Lily Monroe", "04111111111", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void nullNumberTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Lily Monroe", null, 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void noZeroNumberTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Lily Monroe", "1411111111", 0, 0);
	}
	
	
	@Test
	public void pickUpTest(){
		assertEquals("PUC", testPickUp.getCustomerType());
		assertEquals("James Monroe", testPickUp.getName());
		assertEquals("0566666666", testPickUp.getMobileNumber());
		assertEquals(0, testPickUp.getLocationX());
		assertEquals(0, testPickUp.getLocationY());
	}
	
	@Test(expected = CustomerException.class)
	public void locationXPickupTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Lily Monroe", "0411111111", 1, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void locationYPickupTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Lily Monroe", "0411111111", 0, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void locationBothPickupTest() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Lily Monroe", "0411111111", 1, 1);
	}
	
	
	@Test
	public void driverTest(){
		assertEquals("DVC", testDriver.getCustomerType());
		assertEquals("Jackie Monroe", testDriver.getName());
		assertEquals("0777777777", testDriver.getMobileNumber());
		assertEquals(2, testDriver.getLocationX());
		assertEquals(6, testDriver.getLocationY());
	}
	
	@Test(expected = CustomerException.class)
	public void locationDriverTest() throws CustomerException {
		CustomerFactory.getCustomer("DVC", "Lily Monroe", "0411111111", 0, 0);
	}
	
	@Test
	public void droneTest(){
		assertEquals("DNC", testDrone.getCustomerType());
		assertEquals("Tiger Monroe", testDrone.getName());
		assertEquals("0588888888", testDrone.getMobileNumber());
		assertEquals(-5, testDrone.getLocationX());
		assertEquals(-2, testDrone.getLocationY());
	}
	
	@Test(expected = CustomerException.class)
	public void locationDroneTest() throws CustomerException {
		CustomerFactory.getCustomer("DNC", "Lily Monroe", "0411111111", 0, 0);
	}
	

	
}
