package com.bayviewglen.binarysearch;

public class pract {

	public static void main(String[] args) {
		int [] help = {1,5,3,5,7,8};
		int [] arr = selectSort(help);
		
		for (int i : arr)
			System.out.print(i + "");
	}

	private static int[] selectSort(int[] help) {
		for (int i = 0; i < help.length-1; i++){
			int bigIndex = i;
			for (int j = i+1; j < help.length; j++){
				if (help[j] > help[bigIndex])
					bigIndex = j;
			}
			int temp = help[i];
			help[i] = help[bigIndex];
			help[bigIndex] = temp;
				
		}
		return help;
	}

	private static int[] insertionSort(int[] help) {
		
		for (int i = 1; i < help.length; i++){
			int temp = help[i];
			int j = i;
			for (; j > 0; j--){
				if (help[j-1] > temp)
					help[j] = help[j-1];
				else 
					break;
			}
			help[j] = temp;
		}
		return help;
	}
	
	
	

}
