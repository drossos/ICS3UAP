package com.bayviewglen.daytwo;

public class MergeSort {

	public static void main(String[] args) {
		
		int [] arr = {7,8,9};
		int [] arr2 ={1,2,3,4,5,6};
		
		int [] arrSort = sort(arr,arr2);
		
		for (int i :arrSort )
			System.out.print(" " + i);
	}

	private static int[] sort(int[] arr, int[] arr2) {
		
		int [] newArr = new int [arr.length + arr2.length];
		int arrIndex = 0;
		int arr2Index = 0;
		int i = 0;
		while (arrIndex < arr.length && arr2Index < arr2.length){
			if (arr[arrIndex] < arr2[arr2Index])
				newArr[i++] = arr[arrIndex ++];
			
			else
				newArr[i++] = arr2[arr2Index ++];
		}
		
		while (arrIndex < arr.length){
			newArr[i++] = arr[arrIndex++];
		}
		
		while (arr2Index < arr2.length){
			newArr[i++] = arr2[arr2Index++];
		}
		
		return newArr;
		
	}
	

}
