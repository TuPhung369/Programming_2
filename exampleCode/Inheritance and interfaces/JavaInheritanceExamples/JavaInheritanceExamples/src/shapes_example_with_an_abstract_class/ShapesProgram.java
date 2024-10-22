package shapes_example_with_an_abstract_class;

import java.util.ArrayList;
import java.util.List;

public class ShapesProgram {

	public static void main(String[] args) {
		List<Shape> shapeList = new ArrayList<Shape>();

		Circle circle = new Circle(1, 1, 3);
		Rectangle rectangle = new Rectangle(2, 2, 4, 6);
		AcuteTriangle triangle = new AcuteTriangle(3, 3, 2, 4);
		
		shapeList.add(circle);
		shapeList.add(rectangle);
		shapeList.add(triangle);
				
		for (Shape shape : shapeList) {
			System.out.println(shape);
		}
	}
}
