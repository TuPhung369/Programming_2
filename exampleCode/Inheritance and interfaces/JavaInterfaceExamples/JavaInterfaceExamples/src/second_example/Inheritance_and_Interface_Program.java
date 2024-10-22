package second_example;

public class Inheritance_and_Interface_Program {

	public static void main(String[] args) {
		double totalWeight = 0;
		
		Weighable[] myArray = {
			new Car("ABC-123", 1000), 
			new Student("a12", "Frank", 85), new Student("a15", "Susan", 62), 
			new Dog("Spot", 10), new Dog("Lassie", 14) };
		
		for (Weighable weighableObject : myArray) {
			System.out.println(weighableObject);
		}
		
		totalWeight = WeightCalculator.computeTotalWeight(myArray);
		
		System.out.println("----------------------------");
		System.out.println("The total weight is " + totalWeight + "kg");
	}
}
