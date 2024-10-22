package second_example;

public class Student extends Person {
	private String studentNumber;
	
	public Student(String studentNumber, String name, double weight) {
		super(name, weight);
		this.studentNumber = studentNumber;
	}
	
	@Override
	public String toString() {
		return "Student: " + studentNumber + ", " + 
				getName() + ", " + getWeight() + "kg";
	}
}
