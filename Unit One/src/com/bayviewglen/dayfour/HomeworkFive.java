package com.bayviewglen.dayfour;

public class HomeworkFive {

	public static void main(String[] args) {
		
		double x = 5.5, y = -3.0, z = -2.0;
		int i = 5, j = 4, k = 3;
		
		//int firstTest = ( i-(i-(i-(i-j))));
		int first1 = i - j;
		int first2 = i - (first1);
		int first3 = i - (first2);
		int first4 = i - (first3);
		
		//double secondTest = ((x-y) * (x + ( i - j )));
		double second1 = i - j;
		double second2 = x + (second1);
		double second3 = x - y;
		double second4 = second3 * second2;
		
		//double thirdTest = ((x-y) - (y-x) - (x-y) - (y-x));
		double third1 = x-y;
		double third2 = y-x;
		double third3 = third1 - third2 - third1 - third2;
		
		//double eigthTest = ((double) i + j / k); 
		int eigth1 = j / k;
		int eigth2 = i + eigth1;
		double eigth3 = (double) eigth2;
		
		//double ninthTest = ((int) x / k - x	/ k);
		double ninth1 = x / k;
		double ninth2 = (int)ninth1 - ninth1;
		
		double tenthTest = ((double) i / j - (double) (i / j));
		double tenth1 = (double) i / j;
		double tenth2 = (double) (i / j);
		double tenth3 = tenth1 - tenth2;
		
		
		System.out.println(tenth3);

	}

}
