package first_example;

public class City3 {
	private String name;

	public City3(String name) {
		this.name = name;
	}
		
	@Override
	public String toString() {
		return name + "\n" + super.toString();
	}
}
