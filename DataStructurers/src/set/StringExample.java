package set;

import java.util.HashSet;
import java.util.Set;

public class StringExample {

	public static void main(String[] args) {
		String[] words = {"hello", "there", "little", "hello"};
		Set<String> mySet = new HashSet<String>();
		
		for (String s : words) {
			mySet.add(s);
		}
		
		for (String p : mySet) {
			System.out.println(p);
		}

	}

}
