package com.bayviewglen.daysix;

public class PartiallyFilledArrays {
	static int[] data = new int[10];
	static int howMany = 0;
	public static void main(String[] args) {
		
		add(6);
		add(16);
		add(63);
		add(23);
		add(-61);
		
		display();
		
		deleteAtIndex(2);
		display();
		deleteAtIndex(2);
		display();
		
		insert(76,3);
		display();
		
		insert(-76,1);
		display();
		
		deleteAtIndexOrdered(2);
		display();
	}
	
	private static void deleteAtIndexOrdered(int index) {
		for (int i = index; i < howMany-1; i++){
			data[i] = data[i+1];
		}
		
		howMany--;
	}
	
	private static void insert(int value, int index) {
		for (int i = howMany; i > index; i--){
			data[i] = data[i-1];
		}
		data[index] = value;
		howMany++;
	}


	private static void deleteAtIndex(int index) {
		data[index] = data[--howMany];
		
	}


	private static void add(int value) {
		data[howMany ++] = value;
		
	}


	private static void display() {
		System.out.println("The partialy arrary with " + howMany + " elements:");
		for (int i = 0; i < howMany; i ++){
			System.out.print(data[i] + " ");
		}
		
		System.out.println();
		System.out.println();
	}
	
	 
	
}
