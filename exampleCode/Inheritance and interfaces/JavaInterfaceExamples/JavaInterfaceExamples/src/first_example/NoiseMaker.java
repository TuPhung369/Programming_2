package first_example;

public class NoiseMaker {
	
	public static void makeNoise(Audible[] array) {
		
		for (Audible audibleObject : array) {
			audibleObject.makeSound();
		}
	}
}
