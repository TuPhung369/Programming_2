package shapes_example_with_an_abstract_class;

public class Rectangle extends Shape {
	private double height;
	private double width;
	
	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(int x, int y, double height, double width) {
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	@Override
	public double getArea() {
		return height * width;
	}

	@Override
	public String toString() {
		return "Rectangle: (" + getX() + ", " + getY() + "), area = " + getArea();
	}
}
