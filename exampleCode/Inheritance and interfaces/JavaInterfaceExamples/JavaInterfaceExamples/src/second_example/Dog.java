package second_example;

public class Dog implements Weighable {
	private String name;
	private double weight;
	
	public Dog(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return "Dog: " + name + ", " + weight + "kg";
	}
}
