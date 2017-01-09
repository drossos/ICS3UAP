package com.bayviewglen.daythree;

public class ExampleOne {

	public static void main(String[] args) {
		/*Comparable Interface
		equals method checks char at each to see if is same
		== checks if address is the same
		*/
		String s1 = "Hello";
		String s2 = "Goodbye";
		String s3 = "Hello";
		String s4 = s3;
		/*
		 s1.equals(s2) false
		 s1 == s2 false
		 
		 s1.equals(s3) true
		 s1 == s3 false
		 
		 s3.equals(s4) true
		 s3 == s4 true
		 */
		
		// compareTo(String) compares which one is bigger, goes char by char and only goes until one char is bigger than other
		
		
		s1.compareTo(s2); //returns 1
		s1.compareTo(s3); // returns 0
		s1.compareTo(s1); // returns -1
		
		System.out.println(s3 == s4);

	}

}
