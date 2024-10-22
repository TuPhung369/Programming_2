package guitars_example_with_inheritance;

public class GuitarsProgram {

	public static void main(String[] args) {
		
		Guitar guitar_1 = new Guitar("Martin 000-18");
		Guitar guitar_2 = new ElectricGuitar("Fender CS Stratocaster 1960", "three single-coil pickups");
		ElectricGuitar guitar_3 = new ElectricGuitar("Gibson ES-175T", "two humbucker pickups");
		
		System.out.println(guitar_1);
		System.out.println(guitar_2);
		System.out.println(guitar_3);
		
		System.out.println("---");
		// guitar_1.plugIntoAnAmplifier();  // Not possible!
		// guitar_2.plugIntoAnAmplifier();  // Not possible!
		
		guitar_3.plugIntoAnAmplifier();
		
	}
}
