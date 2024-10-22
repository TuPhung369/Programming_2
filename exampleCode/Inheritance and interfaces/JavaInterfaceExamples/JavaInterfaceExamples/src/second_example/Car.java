package second_example;

public class Car extends Vehicle {
	
	private String licencePlate;
	
	public Car (String licencePlate, double weight) {
		super(weight);
		this.licencePlate = licencePlate;
	}
	
	@Override
	public String toString() {
		return "Car: " + licencePlate + ", " + getWeight() + "kg" ;
	}
}
