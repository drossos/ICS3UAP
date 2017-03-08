package com.bayviewglen.daytwo;

public class Recursion {

	public static void main(String[] args) {
		
		System.out.print(fib(4));

	}
	
	public static int factorial (int n){
		if (n==1|| n ==0)
			return 1;
		else 
			return n*factorial(n-1);
	}
	
	public static int fib (int n){
		if (n==1 || n == 2)
			return 1;
		else
			return fib(n-1) + fib(n-2);
		
	}

}

