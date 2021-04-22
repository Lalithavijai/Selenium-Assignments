package week1.day2.assignment;

import java.text.CharacterIterator;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "MADAM";
		char[] charArray = input.toCharArray();
		String rev="";
		for (int i = charArray.length-1; i >= 0; i--) {
			rev= rev+charArray[i];
		}
			//System.out.println(rev);
			if(input.equalsIgnoreCase(rev))
			{
				System.out.println(input +" :This is a palindrome");
			}
			
			else {
			System.out.println(input +" :This is not a palindrome");
			}
		}
		
		
	}

