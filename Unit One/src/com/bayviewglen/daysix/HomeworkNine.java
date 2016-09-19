package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkNine {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Put in your sales");
		int sales = keyboard.nextInt();
		
		double cost = 0.27;
		double salesEarnings = sales * cost;
		
		System.out.print("$" + salesEarnings);

	}

}
