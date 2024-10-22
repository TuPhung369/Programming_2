package collectiondemo;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(358, "Finland");			// Add an entry
		map.put(49, "Germany");
		map.put(46, "Sweden");
		map.put(47, "Norway");
		map.put(33, "Ranska");
		
		map.put(33, "France");				// Replace existing value 
		map.remove(47);						// Remove
		
		String countryName = map.get(46);	// Get a value 
		System.out.println(countryName);
		
		System.out.println();
		for (String name : map.values()) {	// Iterate all values
			System.out.println(name);
		}
		
		System.out.println();
		for (Integer countryCode : map.keySet()) {	// Iterate all keys
			System.out.println(countryCode);
		}
		
		System.out.println();						// Iterate all entries
		for (Entry<Integer, String> mapEntry : map.entrySet()) {
			System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
		}
				
		System.out.println();
		System.out.println(map);
	}
}
