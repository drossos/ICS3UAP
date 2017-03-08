package com.bayviewglen.binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		int [] arr = {0,2,4,6};
		System.out.print(binarySearch(arr,4,0,4));

	}
	
	public static int binarySearch (int [] arr, int search, int low, int high){
		int mid = (low + high) / 2;
		if (low > high)
			return -1;
		else if (arr[mid] == search)
			return mid;
		else if (arr[mid] > search)
			return binarySearch(arr, search, low, mid -1);
		else
			return binarySearch (arr, search, mid + 1, high);
			
		
		
	}

}
