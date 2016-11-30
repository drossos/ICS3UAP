package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleOne {

	public static void main(String[] args) {
		
		int x = 25;
		int y = sum(x);
		System.out.println(y);
		
		int z=3;
		System.out.println(cube(z));
		
		
		String goodString = getAlphaNumericString();
		System.out.println("The good String is: " + goodString);
		
		int n = 100;
		System.out.println("You rolled a: " + roll(n));

		}
	
	
	
	
	//accepts an integer n and sums the numbers [1,n]
	public static int sum (int n){
		int sum =0;
		for (int i = 1; i <= n; i++){
			sum += i;
		}
		
		return sum;
	}
	public static double cube (double x){
		return x * x * x;
	}
	
	public static String getAlphaNumericString(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a sentence:");
		String valid = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890 ";
		String sentence = "";
		boolean isValid = false;
		while (!isValid){
			isValid = true;
			sentence = scanner.nextLine().toUpperCase();
			for (int i = 0; i < sentence.length() && isValid; i++){
				if(valid.indexOf(sentence.charAt(i)) == -1)
					isValid = false;
			}
			if (!isValid)
				System.out.println("Come on... enter valid sentence: ");
		}
		return sentence;
	}
	
	public static int roll (int numSides){
		if (numSides<3)
			throw new IllegalArgumentException("Number of sides must be at least 3...");
		return (int)(Math.random()*numSides) + 1;
		
	}


}
