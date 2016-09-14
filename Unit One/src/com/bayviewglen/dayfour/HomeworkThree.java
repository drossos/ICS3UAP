package com.bayviewglen.dayfour;

public class HomeworkThree {

	public static void main(String[] args) {
		
		int num = 123456;
		
		int digit2 = (num % 100000) / 10000;
		int digit5 = (num % 100) / 10;
		
		int numFinal = digit5 + digit2;
		
		
		System.out.println(numFinal);

	}

}
