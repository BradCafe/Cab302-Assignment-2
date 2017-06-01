package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;


/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A - Dietriche Rausim
 * 
 *
 */
public class CustomerTests {
	
	PickUpCustomer testPickUp;
	DriverDeliveryCustomer testDriver;
	DroneDeliveryCustomer testDrone;
	
	@Before
	public void setup() throws CustomerException{
		testPickUp = new PickUpCustomer("James Monroe", "0566666666", 0, 0);
		testDriver = new DriverDeliveryCustomer("Jackie Monroe", "0777777777", 2, 6);
		testDrone = new DroneDeliveryCustomer("Tiger Monroe", "0588888888", -5, -2);
	}
	
	@Test
	public void pickUpTest(){
		assertEquals(testPickUp.getCustomerType(), "Pick Up");
		assertEquals(testPickUp.getName(), "James Monroe");
		assertEquals(testPickUp.getMobileNumber(), "0566666666");
		assertEquals(testPickUp.getLocationX(), 0);
		assertEquals(testPickUp.getLocationY(), 0);
	}
	
	@Test
	public void deliveryTest(){
		assertEquals(testDriver.getCustomerType(), "Driver Delivery");
		assertEquals(testDriver.getName(), "Jackie Monroe");
		assertEquals(testDriver.getMobileNumber(), "0777777777");
		assertEquals(testDriver.getLocationX(), 2);
		assertEquals(testDriver.getLocationY(), 6);
	}
	
	@Test
	public void droneTest(){
		assertEquals(testDrone.getCustomerType(), "Drone Delivery");
		assertEquals(testDrone.getName(), "Tiger Monroe");
		assertEquals(testDrone.getMobileNumber(), "0588888888");
		assertEquals(testDrone.getLocationX(), -5);
		assertEquals(testDrone.getLocationY(), -2);
	}
	
}
