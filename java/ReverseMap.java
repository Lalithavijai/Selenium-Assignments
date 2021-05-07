package week3.day2.assignments.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReverseMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	TreeMap<Integer, String> revmap=new TreeMap<Integer, String>();
		revmap.put(200, "Sai");
		revmap.put(100, "Lalitha");
		revmap.put(300, "Vijai");
		revmap.put(400,"dak");
		Set<Integer> keySet = revmap.descendingKeySet();	
		for (Integer integer : keySet) {
		System.out.print(integer);	
		System.out.println(" "+revmap.get(integer));
		}
		
		}
			
		}
		
	
		



