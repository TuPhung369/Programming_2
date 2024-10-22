package first_example;

public class InterfaceExampleProgram {

	public static void main(String[] args) {

		Audible[] audiblesArray = { new Cat("Misty"), new Cat("Patch"), new Motorbike(), new DoorBell() };

		NoiseMaker.makeNoise(audiblesArray);
	}
}
