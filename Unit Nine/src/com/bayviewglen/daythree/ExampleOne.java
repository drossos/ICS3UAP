package com.bayviewglen.daythree;

import java.util.ArrayList;

public class ExampleOne {

	public static void main(String[] args) {
		
		/* ArrayList impliments the List <<Interface>>
		   ARRAY LIST (METHODS) a list implemented with an array
		 + int size()
		 +  boolean add(Object) - adds object to end of list, is true if it changes
		 +  void add(int, Object) - add object at index, 
		 +  Object remove(int)  - removes at specified index
		 +  Object set(int, Object) - replaces index with Object, returns original 
		 
		   ARRAY LIST CAN NOT HOLD PRIMITIVES
		   
		   Primitive type		Wrapper Classes
		   int 					Interger
		   double				Double
		   boolean 				Boolean
		   char					Character
		   
		 */

		ArrayList<Integer> marks = new ArrayList<Integer>();
		
		
		marks.add(new Integer(7));
		marks.add(29);  //auto boxing
		
		int x = 3 + new Integer(9);  //auto unboxing
		
		marks.add(0,100);  //inserts at index 0
		
		System.out.println(marks);
		
		int y = marks.set(1, 200);
		
		System.out.println(marks);
		System.out.println(y);
		
		int z = marks.remove(1);
		
		System.out.println(marks);
		System.out.println(z);
		
		marks.add(1, 200);
		marks.add(200);
		
		System.out.println(marks);
		marks.remove(new Integer (200));
		
		System.out.println(marks);
		
		
		
	}

	

}
