package com.bayviewglen.dayone;

public class ExampleThree {

	public static void main(String[] args) {
		int sum = 0;
		
		int current = 1;
		
		while(current < 1001){
			sum += current;
			current ++;
		}

		System.out.print("The sum is " + sum);
	}

}
