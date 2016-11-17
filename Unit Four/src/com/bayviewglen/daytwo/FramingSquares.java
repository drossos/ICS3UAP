package com.bayviewglen.daytwo;

public class FramingSquares {

	public static void main(String[] args) {
		
		int m = 1;
		int n = 1;
		int p = 1;
		int q = 2;
		
		for (int i = 0 ; i < n + 2 *p + 2 *q; i ++){
			System.out.print("#");
		}
		
		System.out.println();
		 
		for (int i = 0 ; i < m + 2*p + q; i ++){
			 for (int h = 0 ; h <  q; h++){
				 System.out.print("#");
			 }
			 for (int j = 0; j <n + 2*p; j++){
					System.out.print("+");
			 }
			 for (int k = 0 ; k <  q; k++){
				 System.out.print("#");
			 }
			 
			 
			 
			
			System.out.println(); 
		 }
		
		 
		 for (int i = 0 ; i < n + 2 *p + 2 *q; i ++){
				System.out.print("#");
		 }

	}

}

/*
 * for (int i = 0 ; i < m + 2*p  ; i ++){
			 System.out.print("#");
			 for (int j = 0; j <p; j++){
					System.out.print("*");
			 }
			
			System.out.println(); 
		 }
		 */
