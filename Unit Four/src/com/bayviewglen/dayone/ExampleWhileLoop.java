package com.bayviewglen.dayone;

public class ExampleWhileLoop {

	public static void main(String[] args) {
/*4 types of loops
		
		while  (<boolean expression>) 'condition is before the code is executed'{
	
			} repeats while boolean expression is true
			minimum number of times code can execute is 0
			
			*/
		int x = 7;
		while (x>10){
			System.out.println(x);
			x ++; // x++ same as x = x + 1 
		}
		// print nothing since the condition is not met
		
		int y = 7;
		while (y <10){
			System.out.println(y);
			y ++; 
		}
		// condition met so will run until y is less than 10
		
		int z = 93;
		while (z > 10){
			z /= 2; // divides by two and reasigns
			System.out.println(z);
			
		
	}

	}

}
