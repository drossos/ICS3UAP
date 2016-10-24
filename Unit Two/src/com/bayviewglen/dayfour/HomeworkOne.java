package com.bayviewglen.dayfour;

import java.util.Scanner;

public class HomeworkOne {
	
	static final int FIRST_LIMIT = 100;

	public static void main(String[] args) {
		
		System.out.println((int)(Math.random()*FIRST_LIMIT) + 1);
		
		System.out.println((int)(Math.random() * 101) - 50);
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Pick a number");
		int firstNumber = keyboard.nextInt();
		System.out.println("Pick an other number");
		int secondNumber = keyboard.nextInt();
		
		System.out.println((int)(Math.random() * (secondNumber + 1) - firstNumber));
		
		
		

	}

}
