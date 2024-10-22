package second_example;

public class WeightCalculator {

	public static double computeTotalWeight(Weighable[] array) {
		double totalWeight = 0;

		for (Weighable weighableObject : array) {
			totalWeight += weighableObject.getWeight();
		}

		return totalWeight;
	}
}
