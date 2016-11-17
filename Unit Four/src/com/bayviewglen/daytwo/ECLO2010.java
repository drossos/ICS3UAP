package com.bayviewglen.daytwo;

public class ECLO2010 {

	public static void main(String[] args) {
		
		String str = "CANADA";
		
		System.out.println("*" + str + "*");
		for (int i = 0; i <= str.length()-1; i++){
			// a letter
			System.out.print(str.charAt(str.length()-i-1));
			//middle stars 
			for (int j = 0; j <str.length(); j++){
				System.out.print("*");
			}
			// a letter
			System.out.print(str.charAt(i));
			System.out.println();
		}
		
		System.out.print("*");
		for (int i = str.length()-1; i >= 0; i--){
			System.out.print(str.charAt(i));
		}
		System.out.println("*");
	}

}
