package com.bayviewglen.daysix;

public class HomeworkFour {

	public static void main(String[] args) {
		
		int speedLight = 3 * ( 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 );
		int lightMinute = speedLight * 60;
		
		int minutesHour = 60;
		int hourDay = 24;
		int dayYear = 365;
		int finalMins = minutesHour * hourDay * dayYear;
		
		int lightYear = lightMinute * finalMins;
		
		System.out.print(finalMins);

	}

}
