package week3.day2.assignments.java;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Need to ceck with Saheel
		String input = "PayPal India";
		char[] charArray = input.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		Set<Character> dupCharSet = new HashSet<Character>();
		for (int i = 0; i < charArray.length; i++) {
			charSet.add(charArray[i]);
			if (charSet.contains(charArray[i])) {
				dupCharSet.add(charArray[i]);
				if(dupCharSet.isEmpty())
				{
					dupCharSet.clear();
			}

		}
		
	}
		System.out.println(dupCharSet);
	}
}
