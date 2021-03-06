package asgn2Pizzas;

import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Person A - Dietriche Rausim
 *
 */
public abstract class Pizza  {
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if quantity is below 0 or above 10
	 * @throws PizzaException if order is placed before store open time
	 * @throws PizzaException if delivery is ordered before pizza cook time
	 * @throws PizzaException if deliver is placed before order
	 * @throws PizzaException if Pizza has waited more then an hour to deliver
	 * @throws PizzaException if Pizza is not of required type
	 * 
	 */
	
	   int quantity;
       LocalTime orderTime,deliveryTime;
       String type;
       double price;
       double totalPrice;
       double cost=0.0;
       
       ArrayList<PizzaTopping> pizzaTopping;
  
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		
		if(quantity <1 || quantity > 10){
			throw new PizzaException("Not a valid quantity of pizza.");
		}
		
		if(deliveryTime.isBefore(orderTime)){
			throw new PizzaException("Cannot deliver before order is placed.");
		}
		if(deliveryTime.isBefore(orderTime.plusMinutes(10))){
			throw new PizzaException("Pizza not ready.");
		}
		if(deliveryTime.isAfter(orderTime.plusHours(1).plusMinutes(10))){
			throw new PizzaException("Pizza thrown order to long.");
		}
		if(orderTime.getHour() > 23 || orderTime.getHour() < 19){
			throw new PizzaException("Order cannot be places outside of operating hours.");
		}
		if(!(type.equals("Margherita Pizza") | type.equals("Vegetarian Pizza")| type.equals("Meat Lovers Pizza"))){
			throw new PizzaException("Invalid type of pizza.");
		}
		
		
		this.quantity = quantity;
        this.orderTime = orderTime;
        this.deliveryTime = deliveryTime;
        this.type = type;
        this.price = price;
        this.totalPrice = this.price * this.quantity;
              
        pizzaTopping = new ArrayList<PizzaTopping>();
              
	}
	

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		// TO DO
		 for(PizzaTopping p:pizzaTopping){
             cost += p.getCost();
         }
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		// TO DO
		return cost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		// TO DO
		return price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		// TO DO
		return cost*quantity;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		// TO DO
		return price*quantity;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		// TO DO
		return ((price*quantity)-(cost*quantity));
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		// TO DO
		for(PizzaTopping p : pizzaTopping){
            if(p == topping)
                return true;
        }                
        return false;
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		// TO DO
		return quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		// TO DO
		return type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
