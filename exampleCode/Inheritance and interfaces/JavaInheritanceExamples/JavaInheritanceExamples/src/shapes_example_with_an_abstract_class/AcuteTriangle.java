package shapes_example_with_an_abstract_class;

public class AcuteTriangle extends Shape {
	private double base;
	private double side;
	
	public AcuteTriangle(double base, double side) {
		super();
		this.base = base;
		this.side = side;
	}
	
	public AcuteTriangle(int x, int y, double base, double side) {
		super(x, y);
		this.base = base;
		this.side = side;
	}
	
	@Override
	public double getArea() {
		return 0.5 * base * side;
	}

	@Override
	public String toString() {
		return "AcuteTriangle: (" + getX() + ", " + getY() + "), area = " + getArea();
	}
}
