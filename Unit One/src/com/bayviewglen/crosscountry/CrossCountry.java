package com.bayviewglen.crosscountry;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountry {
		static final int SECONDS_IN_MINUTE = 60;
	public static void main(String[] args) {
		
		//----------------------------------All FOR FIRST RUNNER----------------------------------------
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Runner One's name:");
		String runnerOneName = scanner.nextLine();
		
		System.out.print("Enter a time of first mile: ");
		String runnerOneMile1 = scanner.nextLine();
		int runnerOneMile1Mins = Integer.parseInt(runnerOneMile1.split(":")[0]);
		double runnerOneMile1Secs = Double.parseDouble(runnerOneMile1.split(":")[1]);
		
		
		System.out.print("Enter a time for second mile: ");
		String runnerOneMile2 = scanner.nextLine();
		int runnerOneMile2Mins = Integer.parseInt(runnerOneMile2.split(":")[0]);
		double runnerOneMile2Secs = Double.parseDouble(runnerOneMile2.split(":")[1]);
		
		
		System.out.print("Enter a time for thrid mile: ");
		String runnerOneMile3 = scanner.nextLine();
		int runnerOneMile3Mins = Integer.parseInt(runnerOneMile3.split(":")[0]);
		double runnerOneMile3Secs = Double.parseDouble(runnerOneMile3.split(":")[1]);
		
		DecimalFormat formatter = new DecimalFormat("00.000");
		
		//converting all the times to seconds to make calculating spits easier
		int runnerOneMile1SecsOfMins =(runnerOneMile1Mins * SECONDS_IN_MINUTE);
		double runnerOneTotalSecsMile1 = (runnerOneMile1SecsOfMins + runnerOneMile1Secs);
		
		int runnerOneMile2SecsOfMins =(runnerOneMile2Mins * SECONDS_IN_MINUTE);
		double runnerOneTotalSecsMile2 = (runnerOneMile2SecsOfMins + runnerOneMile2Secs);
		
		int runnerOneMile3SecsOfMins =(runnerOneMile3Mins * SECONDS_IN_MINUTE);
		double runnerOneTotalSecsMile3 = (runnerOneMile3SecsOfMins + runnerOneMile3Secs);
		
		//time of first spit 
		int runnerOneMinsFirstSpit = (int)(runnerOneTotalSecsMile1 / SECONDS_IN_MINUTE);
		double runnerOneSecsFirstSpit = runnerOneTotalSecsMile1 % SECONDS_IN_MINUTE;
		String runnerOneFinalSecsFirstSpit = formatter.format(runnerOneSecsFirstSpit);
		
		//time of second spit 
		double runnerOneSecondSpitSecsTotal = runnerOneTotalSecsMile2 - runnerOneTotalSecsMile1; 
		int runnerOneMinsSecondSpit = (int)(runnerOneSecondSpitSecsTotal / SECONDS_IN_MINUTE );
		double runnerOneSecsSecondSpit = runnerOneSecondSpitSecsTotal % SECONDS_IN_MINUTE;
		String runnerOneFinalSecsSecondSpit = formatter.format(runnerOneSecsSecondSpit);
		
		//time of third spit 
		double runnerOneThirdSpitSecsTotal = runnerOneTotalSecsMile3 - runnerOneTotalSecsMile2; 
		int runnerOneMinsThirdSpit = (int)(runnerOneThirdSpitSecsTotal / SECONDS_IN_MINUTE );
		double runnerOneSecsThirdSpit = runnerOneThirdSpitSecsTotal % SECONDS_IN_MINUTE;
		String runnerOneFinalSecsThirdSpit = formatter.format(runnerOneSecsThirdSpit);
		
		
		
		System.out.println("RUNNER ONE SUMMARY");
		System.out.println("-------------------\n");
		System.out.printf("Runner Name: %4s",runnerOneName);
		System.out.printf("\nTime of first spit %4d:" + runnerOneFinalSecsFirstSpit, runnerOneMinsFirstSpit );
		System.out.printf("\nTime of second spit %4d:" + runnerOneFinalSecsSecondSpit, runnerOneMinsSecondSpit);
		System.out.printf("\nTime of third spit %4d:" + runnerOneFinalSecsThirdSpit, runnerOneMinsThirdSpit );
		
		
		
		//-----------------------------------------------------SECOND RUNNER-------------------------------------------- 
		/*
		
		System.out.print("Enter a time of first mile: ");
		String runnerTwoMile1 = scanner.nextLine();
		int runnerTwoMile1Mins = Integer.parseInt(runnerTwoMile1.split(":")[0]);
		double runnerTwoMile1Secs = Double.parseDouble(runnerTwoMile1.split(":")[1]);
		
		
		System.out.print("Enter a time for second mile: ");
		String runnerTwoMile2 = scanner.nextLine();
		int runnerTwoMile2Mins = Integer.parseInt(runnerTwoMile2.split(":")[0]);
		double runnerTwoMile2Secs = Double.parseDouble(runnerTwoMile2.split(":")[1]);
		
		
		System.out.print("Enter a time for thrid mile: ");
		String runnerTwoMile3 = scanner.nextLine();
		int runnerTwoMile3Mins = Integer.parseInt(runnerTwoMile3.split(":")[0]);
		double runnerTwoMile3Secs = Double.parseDouble(runnerTwoMile3.split(":")[1]);
		
		
		//converting all the times to seconds to make calculating spits easier
		int runnerTwoMile1SecsOfMins =(runnerTwoMile1Mins * SECONDS_IN_MINUTE);
		double runnerTwoTotalSecsMile1 = (runnerTwoMile1SecsOfMins + runnerTwoMile1Secs);
		
		int runnerTwoMile2SecsOfMins =(runnerTwoMile2Mins * SECONDS_IN_MINUTE);
		double runnerTwoTotalSecsMile2 = (runnerTwoMile2SecsOfMins + runnerTwoMile2Secs);
		
		int runnerTwoMile3SecsOfMins =(runnerTwoMile3Mins * SECONDS_IN_MINUTE);
		double runnerTwoTotalSecsMile3 = (runnerTwoMile3SecsOfMins + runnerTwoMile3Secs);
		
		//time of second spit 
		double runnerTwoSecondSpitSecsTotal = runnerTwoTotalSecsMile2 - runnerTwoTotalSecsMile1; 
		int runnerTwoMinsSecondSpit = (int)(runnerTwoSecondSpitSecsTotal / SECONDS_IN_MINUTE );
		double runnerTwoSecsSecondSpit = runnerTwoSecondSpitSecsTotal % SECONDS_IN_MINUTE;
		String runnerTwoFinalSecsSecondSpit = formatter.format(runnerTwoSecsSecondSpit);
		
		//time of third spit 
		double runnerTwoThirdSpitSecsTotal = runnerTwoTotalSecsMile3 - runnerTwoTotalSecsMile2; 
		int runnerTwoMinsThirdSpit = (int)(runnerTwoThirdSpitSecsTotal / SECONDS_IN_MINUTE );
		double runnerTwoSecsThirdSpit = runnerTwoThirdSpitSecsTotal % SECONDS_IN_MINUTE;
		String runnerTwoFinalSecsThirdSpit = formatter.format(runnerTwoSecsThirdSpit);
		
		System.out.print("Time of second spit " + runnerTwoMinsSecondSpit + ":" + runnerTwoFinalSecsSecondSpit );
		System.out.println("Time of third spit " + runnerTwoMinsThirdSpit + ":" + runnerTwoFinalSecsThirdSpit );

		//-------------------------------------- Third Runner---------------------------
		System.out.print("Enter a time of first mile: ");
		String runnerThreeMile1 = scanner.nextLine();
		int runnerThreeMile1Mins = Integer.parseInt(runnerThreeMile1.split(":")[0]);
		double runnerThreeMile1Secs = Double.parseDouble(runnerThreeMile1.split(":")[1]);
		
		
		System.out.print("Enter a time for second mile: ");
		String runnerThreeMile2 = scanner.nextLine();
		int runnerThreeMile2Mins = Integer.parseInt(runnerThreeMile2.split(":")[0]);
		double runnerThreeMile2Secs = Double.parseDouble(runnerThreeMile2.split(":")[1]);
		
		
		System.out.print("Enter a time for thrid mile: ");
		String runnerThreeMile3 = scanner.nextLine();
		int runnerThreeMile3Mins = Integer.parseInt(runnerThreeMile3.split(":")[0]);
		double runnerThreeMile3Secs = Double.parseDouble(runnerThreeMile3.split(":")[1]);
		
		
		//converting all the times to seconds to make calculating spits easier
		int runnerThreeMile1SecsOfMins =(runnerThreeMile1Mins * SECONDS_IN_MINUTE);
		double runnerThreeTotalSecsMile1 = (runnerThreeMile1SecsOfMins + runnerThreeMile1Secs);
		
		int runnerThreeMile2SecsOfMins =(runnerThreeMile2Mins * SECONDS_IN_MINUTE);
		double runnerThreeTotalSecsMile2 = (runnerThreeMile2SecsOfMins + runnerThreeMile2Secs);
		
		int runnerThreeMile3SecsOfMins =(runnerThreeMile3Mins * SECONDS_IN_MINUTE);
		double runnerThreeTotalSecsMile3 = (runnerThreeMile3SecsOfMins + runnerThreeMile3Secs);
		
		//time of second spit 
		double runnerThreeSecondSpitSecsTotal = runnerThreeTotalSecsMile2 - runnerThreeTotalSecsMile1; 
		int runnerThreeMinsSecondSpit = (int)(runnerThreeSecondSpitSecsTotal / SECONDS_IN_MINUTE );
		double runnerThreeSecsSecondSpit = runnerThreeSecondSpitSecsTotal % SECONDS_IN_MINUTE;
		String runnerThreeFinalSecsSecondSpit = formatter.format(runnerThreeSecsSecondSpit);
		
		//time of third spit 
		double runnerThreeThirdSpitSecsTotal = runnerThreeTotalSecsMile3 - runnerThreeTotalSecsMile2; 
		int runnerThreeMinsThirdSpit = (int)(runnerThreeThirdSpitSecsTotal / SECONDS_IN_MINUTE );
		double runnerThreeSecsThirdSpit = runnerThreeThirdSpitSecsTotal % SECONDS_IN_MINUTE;
		String runnerThreeFinalSecsThirdSpit = formatter.format(runnerThreeSecsThirdSpit);
		
		System.out.print("Time of second spit " + runnerThreeMinsSecondSpit + ":" + runnerThreeFinalSecsSecondSpit );
		System.out.println("Time of third spit " + runnerThreeMinsThirdSpit + ":" + runnerTwoFinalSecsThirdSpit ); 
*/
		
		
		
		
		

	}

}
