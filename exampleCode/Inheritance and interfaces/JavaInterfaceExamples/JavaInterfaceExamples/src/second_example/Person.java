package second_example;

public class Person implements Weighable {
	private String name;
	private double weight;
	
	public Person(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
}
