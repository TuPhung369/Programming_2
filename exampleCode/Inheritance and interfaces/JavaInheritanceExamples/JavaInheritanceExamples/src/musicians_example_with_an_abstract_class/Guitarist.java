package musicians_example_with_an_abstract_class;

public class Guitarist extends Musician {

	public Guitarist(String name) {
		super(name);
	}

	// Here we implement the concrete play method
	@Override
	public void play() {
		System.out.println("Guitarist " + getName() + " plays: pling");
	}
	
	public void changeBrokenString() {
		System.out.println(getName() + " changes a string");
	}
}
