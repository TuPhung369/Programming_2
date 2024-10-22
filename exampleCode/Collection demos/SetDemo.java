package collectiondemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		String[] array = {"b", "a", "l", "l", "o", "o", "n"};
			
		List<String> letterList = Arrays.asList(array);
		System.out.println(letterList);
		
		Set<String> treeSet = new TreeSet<String>(letterList);
		System.out.println(treeSet);
		
		Set<String> hashSet = new HashSet<String>(letterList);
		System.out.println(hashSet);
	}
}




