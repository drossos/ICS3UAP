package com.bayviewglen.daythree;

public class HomeworkSix {

	public static void main(String[] args) {
		 
		double a = 5, b = 20, c = 3;
		double discrimainant; 
		double root1, root2;
		
		discrimainant = b * b - 4 * a * c;
		
		
		//root1 = (-b + Math.sqrt(discrimainant)) / 2 * a;  HW answer 
		//root2 = (-b - Math.sqrt(discrimainant)) / 2 * a;  HW answer 
		
		root1 = (-b + Math.sqrt(b*b - 4*a*c))/2*a;
		root2 = (-b - Math.sqrt(b*b - 4*a*c))/2*a;
		
		System.out.println(root1);
		System.out.println(root2);
		


		
		
		
		
	}

}
