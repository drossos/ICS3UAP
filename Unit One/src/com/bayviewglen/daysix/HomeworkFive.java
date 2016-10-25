package com.bayviewglen.daysix;

public class HomeworkFive {

	public static void main(String[] args) {
		
		double wins = 110;
		double loses = 44;
		
		double average = wins / (wins + loses);
		double averageRounded = (int)(average * 100000) ;
		double average1 = averageRounded / 1000;
		
		
		
		System.out.print(average1);

	}

}
