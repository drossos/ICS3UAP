package com.bayviewglen.dayfive;

import java.util.Scanner;

public class HomeworkFour {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter inital velocity");
		int vInitial = keyboard.nextInt();
		
		System.out.println("Enter time ");
		int time = keyboard.nextInt();
		
		System.out.println("Enter acceleration");
		int acceleration = keyboard.nextInt();
		
		int vFinal = vInitial + time*acceleration;
		
		System.out.println(vFinal);
		

	}

}
