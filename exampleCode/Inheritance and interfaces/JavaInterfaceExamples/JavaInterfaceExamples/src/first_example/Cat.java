package first_example;

public class Cat implements Audible {
	private String name;

	public Cat(String name) {
		this.name = name;
	}

	public void makeSound() {
		System.out.println(name +" says meow!");
	}
}