package com.bayviewglen.crosscountry;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountry {
	static final int SECONDS_IN_MINUTE = 60;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("00.000");
		// --------ALL FIRST RUNNER----
		

		// getting the data for runner one
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

		System.out.print("Enter a time for third mile: ");
		String runnerOneMile3 = scanner.nextLine();
		int runnerOneMile3Mins = Integer.parseInt(runnerOneMile3.split(":")[0]);
		double runnerOneMile3Secs = Double.parseDouble(runnerOneMile3.split(":")[1]);

		// converting all the times to seconds to make calculating splits easier
		int runnerOneMile1SecsOfMins = (runnerOneMile1Mins * SECONDS_IN_MINUTE);
		double runnerOneTotalSecsMile1 = (runnerOneMile1SecsOfMins + runnerOneMile1Secs);

		int runnerOneMile2SecsOfMins = (runnerOneMile2Mins * SECONDS_IN_MINUTE);
		double runnerOneTotalSecsMile2 = (runnerOneMile2SecsOfMins + runnerOneMile2Secs);

		int runnerOneMile3SecsOfMins = (runnerOneMile3Mins * SECONDS_IN_MINUTE);
		double runnerOneTotalSecsMile3 = (runnerOneMile3SecsOfMins + runnerOneMile3Secs);

		// time of first split
		int runnerOneMinsFirstSplit = (int) (runnerOneTotalSecsMile1 / SECONDS_IN_MINUTE);
		double runnerOneSecsFirstSplit = runnerOneTotalSecsMile1 % SECONDS_IN_MINUTE;
		String runnerOneFinalTimeFirstSplit = runnerOneMinsFirstSplit + ":" + formatter.format(runnerOneSecsFirstSplit);

		// time of second split
		double runnerOneSecondSplitSecsTotal = runnerOneTotalSecsMile2 - runnerOneTotalSecsMile1;
		int runnerOneMinsSecondSplit = (int) (runnerOneSecondSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerOneSecsSecondSplit = runnerOneSecondSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerOneFinalTimeSecondSplit = runnerOneMinsSecondSplit + ":" + formatter.format(runnerOneSecsSecondSplit);

		// time of third split
		double runnerOneThirdSplitSecsTotal = runnerOneTotalSecsMile3 - runnerOneTotalSecsMile2;
		int runnerOneMinsThirdSplit = (int) (runnerOneThirdSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerOneSecsThirdSplit = runnerOneThirdSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerOneFinalTimeThirdSplit = runnerOneMinsThirdSplit + ":" + formatter.format(runnerOneSecsThirdSplit);

		// time total
		String runnerOneFinalTimeTotal = runnerOneMile3Mins + ":" + formatter.format(runnerOneMile3Secs);

		System.out.println("RUNNER ONE SUMMARY");
		System.out.println("-------------------\n");
		System.out.printf("Runner Name: %4s", runnerOneName);
		System.out.printf("\nTime of first split %4s:", runnerOneFinalTimeFirstSplit);
		System.out.printf("\nTime of second split %4s:", runnerOneFinalTimeSecondSplit);
		System.out.printf("\nTime of third split %4s:", runnerOneFinalTimeThirdSplit);
		System.out.printf("\nTotal Time %4s:", runnerOneFinalTimeTotal);

		// --------ALL SECOND RUNNER----

		System.out.print("\n\nEnter Runner Two's name:");
		String runnerTwoName = scanner.nextLine();

		System.out.print("Enter a time of first mile: ");
		String runnerTwoMile1 = scanner.nextLine();
		int runnerTwoMile1Mins = Integer.parseInt(runnerTwoMile1.split(":")[0]);
		double runnerTwoMile1Secs = Double.parseDouble(runnerTwoMile1.split(":")[1]);

		System.out.print("Enter a time for second mile: ");
		String runnerTwoMile2 = scanner.nextLine();
		int runnerTwoMile2Mins = Integer.parseInt(runnerTwoMile2.split(":")[0]);
		double runnerTwoMile2Secs = Double.parseDouble(runnerTwoMile2.split(":")[1]);

		System.out.print("Enter a time for third mile: ");
		String runnerTwoMile3 = scanner.nextLine();
		int runnerTwoMile3Mins = Integer.parseInt(runnerTwoMile3.split(":")[0]);
		double runnerTwoMile3Secs = Double.parseDouble(runnerTwoMile3.split(":")[1]);

		// converting all the times to seconds to make calculating splits easier
		int runnerTwoMile1SecsOfMins = (runnerTwoMile1Mins * SECONDS_IN_MINUTE);
		double runnerTwoTotalSecsMile1 = (runnerTwoMile1SecsOfMins + runnerTwoMile1Secs);

		int runnerTwoMile2SecsOfMins = (runnerTwoMile2Mins * SECONDS_IN_MINUTE);
		double runnerTwoTotalSecsMile2 = (runnerTwoMile2SecsOfMins + runnerTwoMile2Secs);

		int runnerTwoMile3SecsOfMins = (runnerTwoMile3Mins * SECONDS_IN_MINUTE);
		double runnerTwoTotalSecsMile3 = (runnerTwoMile3SecsOfMins + runnerTwoMile3Secs);

		// time of first split
		int runnerTwoMinsFirstSplit = (int) (runnerTwoTotalSecsMile1 / SECONDS_IN_MINUTE);
		double runnerTwoSecsFirstSplit = runnerTwoTotalSecsMile1 % SECONDS_IN_MINUTE;
		String runnerTwoFinalTimeFirstSplit = runnerTwoMinsFirstSplit + ":" + formatter.format(runnerTwoSecsFirstSplit);

		// time of second split
		double runnerTwoSecondSplitSecsTotal = runnerTwoTotalSecsMile2 - runnerTwoTotalSecsMile1;
		int runnerTwoMinsSecondSplit = (int) (runnerTwoSecondSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerTwoSecsSecondSplit = runnerTwoSecondSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerTwoFinalTimeSecondSplit = runnerTwoMinsSecondSplit + ":"+ formatter.format(runnerTwoSecsSecondSplit);

		// time of third split
		double runnerTwoThirdSplitSecsTotal = runnerTwoTotalSecsMile3 - runnerTwoTotalSecsMile2;
		int runnerTwoMinsThirdSplit = (int) (runnerTwoThirdSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerTwoSecsThirdSplit = runnerTwoThirdSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerTwoFinalTimeThirdSplit = runnerTwoMinsThirdSplit + ":" + formatter.format(runnerTwoSecsThirdSplit);

		// time total
		String runnerTwoFinalTimeTotal = runnerTwoMile3Mins + ":" + formatter.format(runnerTwoMile3Secs);

		System.out.println("\nRUNNER TWO SUMMARY");
		System.out.println("-------------------\n");
		System.out.printf("Runner Name: %4s", runnerTwoName);
		System.out.printf("\nTime of first split %4s:", runnerTwoFinalTimeFirstSplit);
		System.out.printf("\nTime of second split %4s:", runnerTwoFinalTimeSecondSplit);
		System.out.printf("\nTime of third split %4s:", runnerTwoFinalTimeThirdSplit);
		System.out.printf("\nTotal Time %4s:", runnerTwoFinalTimeTotal);

		// --------ALL THIRD RUNNER----

		System.out.print("\n\nEnter Runner Three's name:");
		String runnerThreeName = scanner.nextLine();

		System.out.print("Enter a time of first mile: ");
		String runnerThreeMile1 = scanner.nextLine();
		int runnerThreeMile1Mins = Integer.parseInt(runnerThreeMile1.split(":")[0]);
		double runnerThreeMile1Secs = Double.parseDouble(runnerThreeMile1.split(":")[1]);

		System.out.print("Enter a time for second mile: ");
		String runnerThreeMile2 = scanner.nextLine();
		int runnerThreeMile2Mins = Integer.parseInt(runnerThreeMile2.split(":")[0]);
		double runnerThreeMile2Secs = Double.parseDouble(runnerThreeMile2.split(":")[1]);

		System.out.print("Enter a time for third mile: ");
		String runnerThreeMile3 = scanner.nextLine();
		int runnerThreeMile3Mins = Integer.parseInt(runnerThreeMile3.split(":")[0]);
		double runnerThreeMile3Secs = Double.parseDouble(runnerThreeMile3.split(":")[1]);

		// converting all the times to seconds to make calculating splits easier
		int runnerThreeMile1SecsOfMins = (runnerThreeMile1Mins * SECONDS_IN_MINUTE);
		double runnerThreeTotalSecsMile1 = (runnerThreeMile1SecsOfMins + runnerThreeMile1Secs);

		int runnerThreeMile2SecsOfMins = (runnerThreeMile2Mins * SECONDS_IN_MINUTE);
		double runnerThreeTotalSecsMile2 = (runnerThreeMile2SecsOfMins + runnerThreeMile2Secs);

		int runnerThreeMile3SecsOfMins = (runnerThreeMile3Mins * SECONDS_IN_MINUTE);
		double runnerThreeTotalSecsMile3 = (runnerThreeMile3SecsOfMins + runnerThreeMile3Secs);

		// time of first split
		int runnerThreeMinsFirstSplit = (int) (runnerThreeTotalSecsMile1 / SECONDS_IN_MINUTE);
		double runnerThreeSecsFirstSplit = runnerThreeTotalSecsMile1 % SECONDS_IN_MINUTE;
		String runnerThreeFinalTimeFirstSplit = runnerThreeMinsFirstSplit + ":" + formatter.format(runnerThreeSecsFirstSplit);

		// time of second split
		double runnerThreeSecondSplitSecsTotal = runnerThreeTotalSecsMile2 - runnerThreeTotalSecsMile1;
		int runnerThreeMinsSecondSplit = (int) (runnerThreeSecondSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerThreeSecsSecondSplit = runnerThreeSecondSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerThreeFinalTimeSecondSplit = runnerThreeMinsSecondSplit + ":" + formatter.format(runnerThreeSecsSecondSplit);

		// time of third split
		double runnerThreeThreeSplitSecsTotal = runnerThreeTotalSecsMile3 - runnerThreeTotalSecsMile2;
		int runnerThreeMinsThreeSplit = (int) (runnerThreeThreeSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerThreeSecsThreeSplit = runnerThreeThreeSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerThreeFinalTimeThirdSplit = runnerThreeMinsThreeSplit + ":" + formatter.format(runnerThreeSecsThreeSplit);

		// time total
		String runnerThreeFinalTimeTotal = runnerThreeMile3Mins + ":" + formatter.format(runnerThreeMile3Secs);

		System.out.println("\nRUNNER THREE SUMMARY");
		System.out.println("-------------------\n");
		System.out.printf("Runner Name: %4s", runnerThreeName);
		System.out.printf("\nTime of first split %4s:", runnerThreeFinalTimeFirstSplit);
		System.out.printf("\nTime of second split %4s:", runnerThreeFinalTimeSecondSplit);
		System.out.printf("\nTime of third split %4s:", runnerThreeFinalTimeThirdSplit);
		System.out.printf("\nTotal Time %4s:", runnerThreeFinalTimeTotal);

		// --------ALL FOURTH RUNNER----
		
		System.out.print("\n\nEnter Runner Four's name:");
		String runnerFourName = scanner.nextLine();

		System.out.print("Enter a time of first mile: ");
		String runnerFourMile1 = scanner.nextLine();
		int runnerFourMile1Mins = Integer.parseInt(runnerFourMile1.split(":")[0]);
		double runnerFourMile1Secs = Double.parseDouble(runnerFourMile1.split(":")[1]);

		System.out.print("Enter a time for second mile: ");
		String runnerFourMile2 = scanner.nextLine();
		int runnerFourMile2Mins = Integer.parseInt(runnerFourMile2.split(":")[0]);
		double runnerFourMile2Secs = Double.parseDouble(runnerFourMile2.split(":")[1]);

		System.out.print("Enter a time for third mile: ");
		String runnerFourMile3 = scanner.nextLine();
		int runnerFourMile3Mins = Integer.parseInt(runnerFourMile3.split(":")[0]);
		double runnerFourMile3Secs = Double.parseDouble(runnerFourMile3.split(":")[1]);

		// converting all the times to seconds to make calculating splits easier
		int runnerFourMile1SecsOfMins = (runnerFourMile1Mins * SECONDS_IN_MINUTE);
		double runnerFourTotalSecsMile1 = (runnerFourMile1SecsOfMins + runnerFourMile1Secs);

		int runnerFourMile2SecsOfMins = (runnerFourMile2Mins * SECONDS_IN_MINUTE);
		double runnerFourTotalSecsMile2 = (runnerFourMile2SecsOfMins + runnerFourMile2Secs);

		int runnerFourMile3SecsOfMins = (runnerFourMile3Mins * SECONDS_IN_MINUTE);
		double runnerFourTotalSecsMile3 = (runnerFourMile3SecsOfMins + runnerFourMile3Secs);

		// time of first split
		int runnerFourMinsFirstSplit = (int) (runnerFourTotalSecsMile1 / SECONDS_IN_MINUTE);
		double runnerFourSecsFirstSplit = runnerFourTotalSecsMile1 % SECONDS_IN_MINUTE;
		String runnerFourFinalTimeFirstSplit = runnerFourMinsFirstSplit + ":" + formatter.format(runnerFourSecsFirstSplit);

		// time of second split
		double runnerFourSecondSplitSecsTotal = runnerFourTotalSecsMile2 - runnerFourTotalSecsMile1;
		int runnerFourMinsSecondSplit = (int) (runnerFourSecondSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerFourSecsSecondSplit = runnerFourSecondSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerFourFinalTimeSecondSplit = runnerFourMinsSecondSplit + ":" + formatter.format(runnerFourSecsSecondSplit);

		// time of third split
		double runnerFourThirdSplitSecsTotal = runnerFourTotalSecsMile3 - runnerFourTotalSecsMile2;
		int runnerFourMinsThirdSplit = (int) (runnerFourThirdSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerFourSecsThirdSplit = runnerFourThirdSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerFourFinalTimeThirdSplit = runnerFourMinsThirdSplit + ":" + formatter.format(runnerFourSecsThirdSplit);

		// time total
		String runnerFourFinalTimeTotal = runnerFourMile3Mins + ":" + formatter.format(runnerFourMile3Secs);

		System.out.println("\nRUNNER FOUR SUMMARY");
		System.out.println("-------------------\n");
		System.out.printf("Runner Name: %4s", runnerFourName);
		System.out.printf("\nTime of first split %4s:", runnerFourFinalTimeFirstSplit);
		System.out.printf("\nTime of second split %4s:", runnerFourFinalTimeSecondSplit);
		System.out.printf("\nTime of third split %4s:", runnerFourFinalTimeThirdSplit);
		System.out.printf("\nTotal Time %4s:", runnerFourFinalTimeTotal);

		// --------ALL FIFTH RUNNER----

		System.out.print("\n\nEnter Runner Five's name:");
		String runnerFiveName = scanner.nextLine();

		System.out.print("Enter a time of first mile: ");
		String runnerFiveMile1 = scanner.nextLine();
		int runnerFiveMile1Mins = Integer.parseInt(runnerFiveMile1.split(":")[0]);
		double runnerFiveMile1Secs = Double.parseDouble(runnerFiveMile1.split(":")[1]);

		System.out.print("Enter a time for second mile: ");
		String runnerFiveMile2 = scanner.nextLine();
		int runnerFiveMile2Mins = Integer.parseInt(runnerFiveMile2.split(":")[0]);
		double runnerFiveMile2Secs = Double.parseDouble(runnerFiveMile2.split(":")[1]);

		System.out.print("Enter a time for third mile: ");
		String runnerFiveMile3 = scanner.nextLine();
		int runnerFiveMile3Mins = Integer.parseInt(runnerFiveMile3.split(":")[0]);
		double runnerFiveMile3Secs = Double.parseDouble(runnerFiveMile3.split(":")[1]);

		// converting all the times to seconds to make calculating splits easier
		int runnerFiveMile1SecsOfMins = (runnerFiveMile1Mins * SECONDS_IN_MINUTE);
		double runnerFiveTotalSecsMile1 = (runnerFiveMile1SecsOfMins + runnerFiveMile1Secs);

		int runnerFiveMile2SecsOfMins = (runnerFiveMile2Mins * SECONDS_IN_MINUTE);
		double runnerFiveTotalSecsMile2 = (runnerFiveMile2SecsOfMins + runnerFiveMile2Secs);

		int runnerFiveMile3SecsOfMins = (runnerFiveMile3Mins * SECONDS_IN_MINUTE);
		double runnerFiveTotalSecsMile3 = (runnerFiveMile3SecsOfMins + runnerFiveMile3Secs);

		// time of first split
		int runnerFiveMinsFirstSplit = (int) (runnerFiveTotalSecsMile1 / SECONDS_IN_MINUTE);
		double runnerFiveSecsFirstSplit = runnerFiveTotalSecsMile1 % SECONDS_IN_MINUTE;
		String runnerFiveFinalTimeFirstSplit = runnerFiveMinsFirstSplit + ":"
				+ formatter.format(runnerFiveSecsFirstSplit);

		// time of second split
		double runnerFiveSecondSplitSecsTotal = runnerFiveTotalSecsMile2 - runnerFiveTotalSecsMile1;
		int runnerFiveMinsSecondSplit = (int) (runnerFiveSecondSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerFiveSecsSecondSplit = runnerFiveSecondSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerFiveFinalTimeSecondSplit = runnerFiveMinsSecondSplit + ":"
				+ formatter.format(runnerFiveSecsSecondSplit);

		// time of third split
		double runnerFiveThirdSplitSecsTotal = runnerFiveTotalSecsMile3 - runnerFiveTotalSecsMile2;
		int runnerFiveMinsThirdSplit = (int) (runnerFiveThirdSplitSecsTotal / SECONDS_IN_MINUTE);
		double runnerFiveSecsThirdSplit = runnerFiveThirdSplitSecsTotal % SECONDS_IN_MINUTE;
		String runnerFiveFinalTimeThirdSplit = runnerFiveMinsThirdSplit + ":"
				+ formatter.format(runnerFiveSecsThirdSplit);

		// time total
		String runnerFiveFinalTimeTotal = runnerFiveMile3Mins + ":" + formatter.format(runnerFiveMile3Secs);

		System.out.println("\nRUNNER FIVE SUMMARY");
		System.out.println("-------------------\n");
		System.out.printf("Runner Name: %4s", runnerFiveName);
		System.out.printf("\nTime of first split %4s:", runnerFiveFinalTimeFirstSplit);
		System.out.printf("\nTime of second split %4s:", runnerFiveFinalTimeSecondSplit);
		System.out.printf("\nTime of third split %4s:", runnerFiveFinalTimeThirdSplit);
		System.out.printf("\nTotal Time %4s:", runnerFiveFinalTimeTotal);

		// --------------------------------table of times----------------------
		
		System.out.println("\n\n Press enter to see table of all runners");
		String blank = scanner.nextLine();
		scanner.close();
		//the reason for the weird numbers on the spacing is because it is to compensate for the size of the heading. The numbers used are those that will give a consistent amount of space between each heading
		//the negative numbers initially are to keep the front word/name of runner irrelevant. Otherwise the length of the name would affect the spacing of all the other time it shares a row with 
		//when the length of the times differs from the space between the headings it is to compensate for the change in length of header. Makes it so the times line up at back of heading
		System.out.printf("\n %-20s %27s %34s %34s %23s", "Name of Runner", "Time of first Split","Time of second split", "Time of Third Split ", "Time total"); 
		System.out.printf("\n %-20s %27s %34s %33s %24s", runnerOneName, runnerOneFinalTimeFirstSplit,runnerOneFinalTimeSecondSplit, runnerOneFinalTimeThirdSplit, runnerOneFinalTimeTotal);
		System.out.printf("\n %-20s %27s %34s %33s %24s", runnerTwoName, runnerTwoFinalTimeFirstSplit,runnerTwoFinalTimeSecondSplit, runnerTwoFinalTimeThirdSplit, runnerTwoFinalTimeTotal);
		System.out.printf("\n %-20s %27s %34s %33s %24s", runnerThreeName, runnerThreeFinalTimeFirstSplit,runnerThreeFinalTimeSecondSplit, runnerThreeFinalTimeThirdSplit, runnerThreeFinalTimeTotal);
		System.out.printf("\n %-20s %27s %34s %33s %24s", runnerFourName, runnerFourFinalTimeFirstSplit,runnerFourFinalTimeSecondSplit, runnerFourFinalTimeThirdSplit, runnerFourFinalTimeTotal);
		System.out.printf("\n %-20s %27s %34s %33s %24s", runnerFiveName, runnerFiveFinalTimeFirstSplit,runnerFiveFinalTimeSecondSplit, runnerFiveFinalTimeThirdSplit, runnerFiveFinalTimeTotal);

	}

}
