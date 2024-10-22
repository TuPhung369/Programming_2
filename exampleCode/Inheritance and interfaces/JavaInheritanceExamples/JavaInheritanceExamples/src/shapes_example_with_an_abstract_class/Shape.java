package shapes_example_with_an_abstract_class;

public abstract class Shape {
	private int x;
	private int y;
	
	public Shape() {
		x = 0;
		y = 0;
	}	
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}	
		
	// Abstract method!
	public abstract double getArea();
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Some shape: (" + x + ", " + y + "), area = " + getArea();
	}
}
