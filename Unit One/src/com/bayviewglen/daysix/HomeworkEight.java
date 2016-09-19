package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkEight {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("choose a numbber");
		int x = keyboard.nextInt();
		
		int xDouble = x * x;
		double xSquared = Math.sqrt(x);
		
		System.out.print("Your number squared is " + xDouble + "and the square of your number is " + xSquared);

	}

}
