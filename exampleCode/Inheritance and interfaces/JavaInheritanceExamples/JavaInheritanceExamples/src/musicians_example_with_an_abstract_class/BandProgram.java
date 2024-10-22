package musicians_example_with_an_abstract_class;

import java.util.List;
import java.util.ArrayList;

public class BandProgram {

	public static void main(String[] args) {

		List<Musician> bandMembers = new ArrayList<Musician>();


		bandMembers.add(new Guitarist("Megan Lowell"));
		bandMembers.add(new Guitarist("Rebecca Lowell"));
		bandMembers.add(new Drummer("Sheila E"));

		System.out.println("=== The band members ===");
		for (Musician musician : bandMembers) {
			System.out.println(musician.getName());
		}		
		
		System.out.println("\n === The band plays as below ===");
		
		for (Musician musician : bandMembers) {
			musician.play();
		}

		// This we can't do because not all musicians can change broken strings
//		for (Musician musician : bandMembers) {
//			musician.changeBrokenString();
//		}
	}
}
