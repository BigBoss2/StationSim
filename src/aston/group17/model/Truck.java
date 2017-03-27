package aston.group17.model;
import java.util.Random;

class Truck extends Vehicle{
	
	private static final double UNIT_SIZE = 2.0;
	private Random rand;
	
	public Truck(){
		super(30, 10);
		vehicleType = "Truck";
	}

	public double getUnitSpace() {
		return UNIT_SIZE;
	}

	public int timeSpent() {
		int timeSpent = rand.nextInt(2)+4;
		return timeSpent;
	}

	public double moneySpent() {
		double moneySpent = rand.nextInt(5)+15;
		return moneySpent;
	}

}
