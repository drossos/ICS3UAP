package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkOne {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.print("Enter a number ");
		double num = keyboard.nextDouble();
		
		double numSqr = num * num;
		
		System.out.println(num + " and " + numSqr);

	}

}
 