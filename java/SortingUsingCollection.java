package week3.day2.assignments.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] input = {"HCL","Wipro","Aspire Systems","CTS","AMAZON","PAYPAL"};
		Arrays.sort(input);
		List<String> list=new ArrayList<String>();
		for (int i = (input.length)-1; i >=0; i--) {
			list.add(input[i]);
		}
			System.out.println(list);
		}
		
		
	}
		
		
	
		
		
		
		
		
		
	

