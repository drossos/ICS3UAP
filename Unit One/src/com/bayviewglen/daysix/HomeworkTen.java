package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkTen {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Length");
		double length = keyboard.nextInt();
		
		System.out.print("Width");
		double width = keyboard.nextInt();
		
		double area = length * width;
		
		System.out.print(area);

	}

}
