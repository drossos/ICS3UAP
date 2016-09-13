package com.bayviewglen.daythree;

public class HomeworkFive {

	public static void main(String[] args) {
		
		double pennyValue = .01, nickleValue = .05, dimeValue = .1, quarterValue = .25;
		int loonieValue = 1, toonieValue = 2;
		int numberPennies = 5, numberNickles = 50, numberDimes = 10, numberQuarters = 4, numberLoonies = 15, numberToonies = 7;
		double totalMoney;
		
		totalMoney = pennyValue * numberPennies + nickleValue * numberNickles + dimeValue * numberDimes + numberQuarters * quarterValue + numberLoonies * loonieValue + numberToonies *toonieValue;
		
		System.out.print(totalMoney);
		
		
		
	}

}
