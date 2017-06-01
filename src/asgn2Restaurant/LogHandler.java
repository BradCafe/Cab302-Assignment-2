package asgn2Restaurant;


import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person B - Bradley Caferra
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		
		ArrayList<Customer> customerList = new ArrayList<>();
		
		try (Stream<String> fileLines = Files.lines(Paths.get(new File(filename).toURI()))) {
			for (String line : fileLines.collect(Collectors.toList())) {
				customerList.add(createCustomer(line));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LogHandlerException("Cannot read file: " + filename);
		}
				
				
		return customerList;
		
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		
		ArrayList<Pizza> pizzaList = new ArrayList<>();
		
		try (Stream<String> fileLines = Files.lines(Paths.get(new File(filename).toURI()))) {
			for (String line : fileLines.collect(Collectors.toList())) {
				pizzaList.add(createPizza(line));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LogHandlerException("Cannot read file: " + filename);
		}
				
				
		return pizzaList;
		
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		
		String[] lineValues;
		
		try{
			lineValues = line.split(",");
		} catch(Exception ex) {
			throw new LogHandlerException("Encountered problem pasring line" + ex);
		}
		
		try{
			return CustomerFactory.getCustomer(lineValues[4], lineValues[2], lineValues[3], Integer.parseInt(lineValues[5]), Integer.parseInt(lineValues[6]));
		} catch(CustomerException ex){
			throw new LogHandlerException("Invalid Customer code" + ex);
		}
		catch (Exception ex){
			throw new LogHandlerException("Line input:" + line + " is not valid " + ex);
		}
		
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		
		String[] lineValues;
		try{
			lineValues = line.split(",");
		} catch(Exception ex) {
			throw new LogHandlerException("Encountered problem pasring line" + ex);
		}
		
		String pizzaCode = null;
		try{
			pizzaCode = lineValues[7];
		}catch (Exception ex){
			throw new LogHandlerException("Line input:" + line + " is not valid " + ex);
		}
		
				
		int quantity = 0;
		try {
			quantity = Integer.parseInt(lineValues[8]);
		} catch (Exception ex) {	
			throw new LogHandlerException("Line input:" + line + " is not valid " + ex);
		}
		
		//Order Time as Local Time
		String[] time = lineValues[0].split(":");
		if (time.length < 3) {
			throw new LogHandlerException("Not enough time passed");
		}
		LocalTime orderTime = null;
		try {
			int timeHour = Integer.parseInt(time[0]);
			int timeMinute = Integer.parseInt(time[1]);
			int timeSecond = Integer.parseInt(time[2]);
			orderTime = LocalTime.of(timeHour, timeMinute, timeSecond);
		} catch (Exception ex) {
			throw new LogHandlerException("Line input:" + line + " is not valid " + ex);
		}
		
		//Delivery Time as Local Time
		time = lineValues[1].split(":");
		if (time.length < 3) {
			throw new LogHandlerException("Not enough time passed");
		}
		LocalTime deliveryTime = null;
		try {
			int timeHour = Integer.parseInt(time[0]);
			int timeMinute = Integer.parseInt(time[1]);
			int timeSecond = Integer.parseInt(time[2]);
			deliveryTime = LocalTime.of(timeHour, timeMinute, timeSecond);
		} catch (Exception ex) {
			throw new LogHandlerException("Line input:" + line + " is not valid " + ex);
		}

		return PizzaFactory.getPizza(pizzaCode, quantity, orderTime, deliveryTime);		
		
		
		
	}

}
