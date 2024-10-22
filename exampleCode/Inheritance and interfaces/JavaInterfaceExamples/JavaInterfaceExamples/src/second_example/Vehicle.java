package second_example;

public abstract class Vehicle implements Weighable {
	
	private double weight;
	
	public Vehicle(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return "Vehicle: weight = " + weight + "kg" ;
	}
}
