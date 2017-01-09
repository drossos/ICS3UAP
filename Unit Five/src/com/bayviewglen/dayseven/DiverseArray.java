package com.bayviewglen.dayseven;

public class DiverseArray {
static int[] arr = {1,2,3,4,5,6,9};
static int[][] arr2D = {
		
		{1,2,3,4,8},
		{1,3},
		{10,23,-1,23,56}
};

	public static void main(String[] args) {
		int sum = arraySum(arr);
		int [] sum2D = rowSums(arr2D);
		
		System.out.println(isDiverse(arr2D));
		
		
	}
	
	private static boolean isDiverse(int [] [] rogueTwo) {
		boolean diverse = true;
		int [] sum2D = rowSums(arr2D);
		for (int i = 0; i < sum2D.length; i ++){
			for (int j = i+1 ; j < sum2D.length ; j ++ ){
				if (sum2D[i] == arr[j])
					return false;
			}
		}
		
		return diverse;
	}

	private static int[] rowSums(int[][] rogueOne) {
		int [] sums = new int [rogueOne.length];
		for (int i = 0; i <rogueOne.length; i++){
			sums[i] = arraySum(rogueOne[i]);
		}
		
		return sums;
		
	}

	private static int arraySum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i ++){
			sum += arr[i];
		}
		
		return sum;
	}
	
	
	
	
	
	

}
