package guitars_example_with_inheritance;

public class Guitar {
	private String model;

	public Guitar(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return model;
	}
}
