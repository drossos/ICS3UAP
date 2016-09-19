package com.bayviewglen.daysix;

import java.util.Scanner;

public class HomeworkEleven {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter Mass");
		double mass = keyboard.nextDouble();
		
		System.out.print("Enter Speed");
		double speed = keyboard.nextDouble();
		
		double kE = 0.5 * mass * (speed * speed);
		
		System.out.print("Kinetic engergy is " + kE);
		

	}

}
