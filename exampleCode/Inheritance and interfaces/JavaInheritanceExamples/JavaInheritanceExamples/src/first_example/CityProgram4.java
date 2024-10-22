package first_example;

public class CityProgram4 {
  
	public static void main(String[] args) {
		
		City4 firstCity = new City4("Helsinki");
		
		System.out.println(firstCity);
		System.out.println(firstCity.getName());
		
		
		Object secondCity = new City4("London");
		
		System.out.println(secondCity);
		
		System.out.println(secondCity.getName());
		
	}
}