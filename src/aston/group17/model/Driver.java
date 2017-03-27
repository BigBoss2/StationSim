package aston.group17.model;
import java.util.Random;

public class Driver {
	private boolean shopping;
	private int minRefill, minShop, seed, totalTime;
	private double moneySpent;
	private Random rnd;
	private Station station;
	private Vehicle vehicle;
	
	public Driver()
	{
		totalTime = 0;
		moneySpent = 0;
		rnd = new Random();
		shopping = false;
		
		
	}
	/**
	 * This sets a vehicle to each driver. 
	 */
	public void setVehicleOfDriver(Vehicle v){
		vehicle = v;
		
	}
	
	/**
	 * This returns the vehicle the driver is driving.
	 */
	public Vehicle getVehicleOfDriver(){	
		return vehicle;
		
	}
	
	/**
	 * This adds the driver to the station and to the pump initially.
	 */
	public void addVehicleToPump(){
		station.addVehicleToPumpQueue(vehicle);	
	}
		
	
	
	/**
	 * This calculates the money a driver could spend shopping.
	 */
	
	public int moneySpent(){
		moneySpent = vehicle.moneySpent();
		
		return moneySpent;
		
	}
	
	/**
	 * This calculates the time a driver could potentially spend shopping.
	 */
	public int shoppingTime(){
		
		totalTime = vehicle.timeSpent();
		
		return totalTime;	
	}
	
}
