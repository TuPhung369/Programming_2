package musicians_example_with_an_abstract_class;

public class Drummer extends Musician {

	public Drummer(String name) {
		super(name);
	}

	// Here we implement the concrete play method
	@Override
	public void play() {
		System.out.println("Drummer " + getName() + " plays: ba-dum-bum");
	}
}
