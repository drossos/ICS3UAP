package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkTwo {

	public static void main(String[] args) {
		
		Scanner mark = new Scanner(System.in);
		
		System.out.print("Give mark ");
		
		double studentMark = mark.nextDouble();
		
		System.out.println("Total of test ");
		
		double totalMark = mark.nextDouble();
		
		
		
			
		
		int averageMark = (int)(100 * (studentMark / totalMark));
		
		System.out.println("You got " + averageMark + "%");

	}

}
