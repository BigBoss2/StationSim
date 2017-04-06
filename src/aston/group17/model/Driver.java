package aston.group17.model;
import java.util.Random;

public class Driver {
	private boolean shopping, wait, queueing, done, wantsToShop;
	private int  totalTime, shoppingTime, minShoppingTime;
	private double moneySpent;
	private Vehicle vehicle;
	private String vehicleType;
	
	/**
	 * constructs a new Driver object
	 * @param type
	 * the type of vehicle the Driver owns: "Car", "Sedan", "Bike", "Truck"
	 */
	public Driver(String type)
	{
		totalTime = 0;
		moneySpent = 0;
		shopping = false;
		wait = true;
		queueing = true;
		
		switch(type){
			case "Car":
				vehicle = new Car();
				vehicleType = "Car";
				break;
			case "Sedan":
				vehicle = new Sedan();
				vehicleType = "Sedan";
				break;
			case "Truck":
				vehicle = new Truck();
				vehicleType = "Truck";
				break;
			case "Bike":
				vehicle = new Bike();
				vehicleType = "Bike";
				break;
			default:
				vehicle = new Car();
				vehicleType = "Car";
		}
	}
	
	/**
	 * What the driver will do each tick
	 */
	public void act(double fuelCost)
	{
		if(wait)
		{
			wait = !wait;
			System.out.println("Driver is waiting");
		}
		else if(!shopping)
		{
			if(!queueing)
			{
				if(!getVehicle().isFull())
				{
						fillTank();
						moneySpent += fuelCost;
						System.out.println("money Spend on fuel: " + moneySpent);
				}
				else
				{
					System.out.println("Tank full");
					wait = true;
					wantsToShop = true;
					minShoppingTime = getShoppingTime();
				}
			}
		}
//		else
//		{
//			//shopping code
//			if(!queueing)
//			{
//				if(!(shoppingTime < minShoppingTime))
//				{
//					shoppingTime++;
//				}
//				else
//				{
//					toggleQueueing();
//				}
//			}
//			else
//			{
//				
//			}
//		}
	}
	
	/**
	 * This returns the vehicle the driver is driving.
	 * @return
	 * Returns the Driver's Vehicle object
	 */
	public Vehicle getVehicle()
	{	
		return vehicle;
	}
	
	/**
	 * This calculates the money a driver could spend shopping.
	 * @return
	 * returns the amount of money the Driver has spent at the station
	 */
	
	public double getMoneySpent()
	{
		return moneySpent;
		
	}
	
	public double getShopSpendingAmount()
	{
		return vehicle.moneySpentForShopping();
	}
	
	/**
	 * This calculates the time a driver could potentially spend shopping.
	 * @return
	 * returns int of the amount of time the driver would spend shopping
	 */
	public int setShoppingTime()
	{
		totalTime = vehicle.timeToSpendShopping();
		
		return totalTime;
	}
	
	/**
	 * Checks if the driver wants to shop, only true if wait is false and shopping is true
	 * @return
	 * Boolean
	 */
	public boolean wantsToShop()
	{
		return wantsToShop;
	}
	
	/**
	 * Returns if the Driver is queueing or not
	 * @return
	 * true if driver is still queueing
	 */
	public boolean isQueueing()
	{
		return queueing;
	}
	
	/**
	 * Returns true if the Driver is still shopping
	 * @return
	 * true if driver is still shopping
	 */
	public boolean stillShopping()
	{
		if(shoppingTime < minShoppingTime)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Returns if the Driver is in the Shop
	 * @return
	 * Boolean true if the driver is shopping
	 */
	public boolean isInShop()
	{
		return shopping;
	}
	
	/**
	 * Returns if the Driver is in the Shop
	 * @return
	 * true if the driver is done shopping
	 */
	public boolean isDone()
	{
		return done;
	}
	
	/**
	 * The driver shops, incrementing shoppingTime
	 */
	public void shop()
	{
		shoppingTime++;
	}
	
	/**
	 * Returns vehicle type the driver owns
	 * @return
	 * vehicle type the driver owns
	 */
	public String getVehicleType()
	{
		return vehicleType;
	}
	
	/**
	 * Changes the driver's shopping state
	 */
	public void toggleShopping()
	{
		shopping = !shopping;
	}
	
	/**
	 * Changes the Driver's queueing state
	 */
	public void toggleQueueing()
	{
		queueing = !queueing;
	}
	
	/**
	 * Returns length of shopping in ticks
	 * @return
	 * shoppingTime
	 */
	public int getShoppingTime()
	{
		return shoppingTime;
	}

	/**
	 * Calls the vehicle fill tank method
	 */
	public void fillTank()
	{
		vehicle.fill();
	}
	
	/**
	 * Returns a text representation of Driver
	 * @return
	 * Text representation of Driver
	 */
	public String toString()
	{
		return vehicle.toString();
	}
}
