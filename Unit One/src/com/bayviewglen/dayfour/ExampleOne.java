package com.bayviewglen.dayfour;

public class ExampleOne {

	public static void main(String[] args) {
		
			System.out.println(3*6);	// 18
			System.out.println(3+6);	// 9
			System.out.println(3/6);	// 0 - both operands are integers
			
			System.out.println(3.0*6);	// 18.0
			System.out.println(3+6.0);	// 9.0
			System.out.println(3.0/6);	// 0.5 - one operand is a double so I get double division
			
			System.out.println(3%6);	// 3 - the remainder is 3
			System.out.println(23%2);	// 1 - this is how we can find out if it is an even or an odd
			System.out.println(458548%10);	// 8 mod it by 10 to get the last digit
			
			//mod anything by 10 get what is in ones place 
			//mod by 100 get in tens place 
			
			int num= 123321;
			int digit6 = num % 10;
			int digit5 = (num % 100) / 10;
			int digit4 = (num % 1000) / 100;
			int digit3 = (num % 10000) / 1000;
			int digit2 = (num % 100000) / 10000;
			int digit1 = num / 100000; 		//don't need to mod since gives interger of thousands 
			
			
			int sum = digit1 + digit2 + digit3 + digit4 + digit5 + digit6;
			
			System.out.println(sum);

	}

}
