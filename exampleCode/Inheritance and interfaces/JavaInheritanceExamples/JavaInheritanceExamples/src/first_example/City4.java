package first_example;

public class City4 extends Object {
	private String name;

	public City4(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
