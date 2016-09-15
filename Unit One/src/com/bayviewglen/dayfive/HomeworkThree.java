package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkThree {

	public static void main(String[] args) {
		
		Scanner numGrabber = new Scanner(System.in);
		
		System.out.println("Enter a 6 digit number ");
		int num = numGrabber.nextInt();
		
		int digit2 = (num % 100000) / 10000;
		int digit5 = (num % 100) / 10;
		
		int numFinal = digit5 + digit2;
		
		
		System.out.println(numFinal);

	}

}
