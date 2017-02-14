package com.bayviewglen.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;




public class HorseRacing {
	
	static Scanner keyboard = new Scanner (System.in);
	public static int upperBoundHorses = 9;
	public static int lowerBoundHorses = 6;
	public static int lengthRace = 20;
	public static void main(String[] args) {
		introMessage();
		String [] horses = getHorses();
		String [] playerNames = getPlayers();
		int [] playerWallets = getPlayerWallets();
		
		
		
		
		boolean gameOver = false;
		
		while (!gameOver){
			displayPlayersAndWallets(playerNames,playerWallets);
			doRace(horses, playerNames, playerWallets);
			displayPlayersAndWallets(playerNames,playerWallets);
			gameOver = promptForGameOver();
			
			
		}
		
		updatePlayerData(playerNames, playerWallets);
		closingMessage();
	}
	
	private static void displayPlayersAndWallets(String[] playerNames, int[] playerWallets) {
		System.out.println("Here are the players and their wallets:");
		for (int i = 0; i < playerNames.length; i++){
			System.out.println(playerNames[i] + ": " + playerWallets[i]);
		}
		System.out.println();
		
	}

	private static void closingMessage() {
		System.out.println("Hope you had fun at horse racing, come back");
		
	}

	private static void introMessage() {
		System.out.println("WELCOME TO HORSE RACING, HIGH STAKES, NO BABY BETS");
		
	}

	private static void updatePlayerData(String[] playerNames, int[] playerWallets) {
		// TODO Auto-generated method stub
		
	}

	private static boolean promptForGameOver() {
		
		System.out.println("Is your day at the races already over or do you want to keep betting? Type 1 to quit and 2 to continue playing.");
		//Checks if the choice is valid or not
		String playerResponse = validateResponse(keyboard.nextLine().trim());
		
		if (playerResponse.equals("1"))
		return true; //means game over
		else 
			return false; //means game continues
	}

	private static String validateResponse(String response) {
		//to check and make sure that a valid answer is given
		boolean invalid = true;
		while (invalid){
			
			if (response.equals("1") || response.equals("2"))
				break;
		
			if (!response.equals("1") && !response.equals("2")){
			System.out.println("That is not a valid phrase. Please choose either 1 or 2");
			response = keyboard.nextLine().trim();
		}
		}
			
		
		return response;
	}

	private static void doRace(String[] horses, String[] playerNames, int[] playerWallets) {
		//horsesInRace contains of index of the horses from the master horse list array
		int[] horsesInRace = getHorsesInRace(horses);
		displayHorsesInRace(horsesInRace, horses);
		//2D array with col1 = bet amount and col1 = horseIndex(from horsesInRace)
		int[][] playerBets = getPlayerBets(playerNames, playerWallets, horsesInRace, horses);
		
		int winningHorse = startRace(horsesInRace);
		winningHorseMessage(winningHorse, horses);
		
		playerWallets = payOutBets(playerBets, playerWallets, playerNames, winningHorse);
	}

	private static void winningHorseMessage(int winningHorse, String[] horses) {
		System.out.println("CONGRATUALTIONS TO NUMBER "+ winningHorse + ", " + horses[winningHorse]);
		
	}

	private static void displayHorsesInRace(int[] horsesInRace, String[] horses) {
		//method prints out every horse that is going to be in the next race
		//TODO make the odds system, mulitplyer for the horse, change payout as well to give more money or take away more
		System.out.println("The horses who will be in the race are: ");
		int [] oddsForHorse = new int[horsesInRace.length];
		for (int i = 0; i < horsesInRace.length; i++){
			System.out.println("In lane " + i + " " + horses[horsesInRace[i]]);
		}
		
	}

	private static int[] payOutBets(int[][] playerBets, int[] playerWallets, String[] playerNames, int winningHorse) {
		//adds or subtracts money based off if you guessed the winning horse
		for (int i = 0; i < playerWallets.length; i++){
			if (playerBets[i][0] == winningHorse ){
				playerWallets[i] += playerBets[i][1];
				System.out.println("Congratulations " + playerNames[i] + " you have won $" + playerBets[i][1]);
			}
			if (playerBets[i][0] != winningHorse){
				playerWallets[i] -= playerBets[i][1];
				System.out.println("Sorry " + playerNames[i] + " you have not won and lost $" + playerBets[i][1] );
			}
			
			if (playerBets[i][2] == winningHorse ){
				playerWallets[i] += playerBets[i][2];
				System.out.println("Congratulations " + playerNames[i] + " you have won $" + playerBets[i][2]);
			}
			
			if (playerBets[i][2] != winningHorse){
				playerWallets[i] -= playerBets[i][3];
				System.out.println("Sorry " + playerNames[i] + " you have not won and lost $" + playerBets[i][3] );
			}
		}
		return playerWallets;
	}

	//to make race to get which horse wins the race
	private static int startRace(int[] horsesInRace) {
		
		int winner;
		countDown();
			winner  = runRace(horsesInRace);
	
		return winner;
	}
	
private static void countDown() {
		for (int i  = 5; i > 0; i--){
			System.out.printf("%20d\n\n", i);
			addDelay();
		}
		System.out.println("GO!");
		
	}

private static void addDelay() {
	try {
		Thread.sleep(750);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
}

//**********************MAKE THE VISIUAL RACE ******************************
private static int runRace(int[] horsesInRace) {
	//keeps track of how far each horse has moved
		int [] movement = new int [horsesInRace.length]; 
		int winner;
		//keeps running until the race is over
		boolean raceOver = false;
		//TODO make better header
		printHeader();
		while (!raceOver){
			
		addLongDelay();
		//prints each horses in the race and goes through until a horses reach the end
		for (int i = 0; i < horsesInRace.length; i++){
			printLine();
			printSpaces();
			movement = printRow(i, movement);
			printSpaces();
			
		}
		winner = checkWinner(movement);
		if (winner > -1){
			raceOver = true;
			return winner;
		}
		}
		return -1;
		
	}

private static void printHeader() {
	System.out.println("LET THE RACE BEGIN");
	
}

private static int checkWinner(int[] movement) {
	boolean isTie = checkTie(movement);
	if (isTie){
		//randomly resolves the winner of the tie
		int winner = decideTie(movement);
		return winner;
	}
	for (int i = 0; i < movement.length; i++){
		if (movement[i] >= 20)
			return i;
	}
	//if no horse has won yet return -1 so you cant leave loop
	return -1;
}
private static int decideTie(int[] movement) {
	//tie winners will contain the lane of each of the winners
	int [] tieWinners = new int [checkHowManyWinners(movement)];
	int k = 0; //this is a index counter for the smaller array of tie winners. Keeps track of where to put winners in the smaller array
	for (int i = 0; i < movement.length; i++){
		if (movement[i] == lengthRace){
			tieWinners [k] = i;
			k++;
		}
	}
	displayTieMessage(tieWinners);
	int winner = pickWinner(tieWinners);
	return winner;
}

private static int pickWinner(int[] tieWinners) {
	int winner = tieWinners[(int)(Math.random() * tieWinners.length-1)];
	System.out.println("The booth has made a decision");
	addDelay();
	return winner;
}

private static int checkHowManyWinners(int[] movement) {
	int winners = 0;
	for (int i = 0; i < movement.length; i++){
		if (movement[i] == 20)
			winners++;
	}
	return winners;
}

private static void displayTieMessage(int [] tieWinners) {
	System.out.println("It seem there was a photo finish between:");
	for (int i: tieWinners){
		System.out.println("lane " + i);
	}
	System.out.println("We will now go to the booth to decide the winner");
	addLongDelay();
	
}

private static void addLongDelay() {
	try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
}

private static boolean checkTie(int[] movement) {
	int numberWhoWon = 0;
	for (int i = 0; i < movement.length; i++){
		if (movement[i] >= 20)
			numberWhoWon ++;
	}
	if (numberWhoWon > 1)
		return true;
	return false;
}

//+++++FIX UPPER BOUND OF RANDOM NUMBER++++++++++++++++
private static int[] printRow(int whichLane, int[] movement) {
	//makes the image and randomly makes the horses move less than race
	//consider adding limit to how fast the horses can race
	int movesThisTurn = getMovesForTurn(whichLane, movement);
	movement[whichLane] += movesThisTurn;
	for (int i = 0; i <movement[whichLane]; i++){
		System.out.print("+ ");
	}
	System.out.print(whichLane + "");
	for (int i = 0; i < lengthRace - movement[whichLane]; i++){
		System.out.print("- " );
	}
	return movement;
	
	
}

private static int getMovesForTurn(int whichLane, int[] movement) {
	int moves = (int)(Math.random() * (4) + (1));
	if (movement[whichLane] + moves > lengthRace)
		moves = 20 - movement[whichLane];
	return moves;
}

private static void printSpaces() {
	for (int i = 0; i < 4; i++)
		System.out.println();
	
}

private static void printLine() {
	for (int i = 0; i < 21; i++)
		System.out.print("- ");
	
}

	/*while (invalidBet){
			displayPlayerName(playerNames, i);
			String playerBetLine = keyboard.nextLine().trim();
			//get which lane you are going to bet on
			int betLane = getBetResponse(playerBetLine);
			//check if is a valid lane
			invalidBet = checkBetLane(betLane, horsesInRace);
			playerBets[i][0] = betLane;
		}
		*/
	private static int[][] getPlayerBets(String[] playerNames, int[] playerWallets, int[] horsesInRace, String [] horses) {
		//makes a array with each person and a spot for their bet
		int [][] playerBets = new int [playerNames.length][4];
		System.out.println("We are now taking bets on the next race. Each player can bet twice on different horses or the same horse.");
		//this outloop contains which bet they are on
		for (int j = 0; j < 2; j++){
		for (int i = 0; i < playerNames.length; i++){
			
			displayPlayerName(playerNames, i);
			//get which lane you are going to bet on
			String validBetPhrase = validateBetPhrase(horsesInRace, playerWallets, i);
			int playerBetLane = getBetLane(validBetPhrase);
			int playerBetAmount = getBetAmount(validBetPhrase);
			if (j==0){
			playerBets[i][0] = playerBetLane;
			playerBets[i][1] = playerBetAmount; 
			}
			if (j == 1){
				playerBets[i][2] = playerBetLane;
				playerBets[i][3] = playerBetAmount; 
			}
		}
			//if this doesn't work, the whole validation is fucked
		
		}
			
		
		return playerBets;
	}

	private static String validateBetPhrase(int[] horsesInRace, int[] playerWallets, int player) {
	boolean numeric = false;
	String betLine = "";
	while (!numeric){
		betLine = keyboard.nextLine().trim();
		numeric = checkNumeric(betLine, horsesInRace, playerWallets, player);
	}
	return betLine;
}

	private static boolean checkNumeric(String betLine, int[] horsesInRace, int[] playerWallets, int player) {
		if (betLine.indexOf(" ") == -1){
			invalidPrompt();
			return false;
		}
		try {
			Integer.parseInt((betLine).split(" ")[0]);
		}catch (NumberFormatException e){
			invalidPrompt();
			return false;
	}
		if (Integer.parseInt((betLine).split(" ")[0]) >= horsesInRace.length || Integer.parseInt((betLine).split(" ")[0]) < 0){
				invalidNumber();
				return false;
		}
		try {
			Integer.parseInt((betLine).split(" ")[1]);
		}catch (NumberFormatException e){
			invalidPrompt();
			return false;
	}
		if (Integer.parseInt((betLine).split(" ")[1]) > playerWallets[player] || Integer.parseInt((betLine).split(" ")[1]) < 0){
			invalidNumber();
			return false;
	}
		return true;
	}

	private static void invalidNumber() {
		System.out.println("Please only use valid lane numbers and don't bet more money than you have. Type the lane of the horse and the amount of money you want to bet seperated by a space");
		
	}

	private static void invalidPrompt() {
		System.out.println("Please use the proper formtating when making a bet. Type the lane of the horse and the amount of money you want to bet seperated by a space");
	}

	private static int getBetAmount(String response) {
		return Integer.parseInt((response).split(" ")[1]);

}

	private static int getBetLane(String response) {
		return Integer.parseInt((response).split(" ")[0]);
		
	}

	private static void displayPlayerName(String[] playerNames, int whoName) {
		System.out.println(playerNames[whoName] + " how much money are you going to bet and on which horse? Type the lane of the horse and the amount of money you want to bet seperated by a space");
	}

	private static int[] getHorsesInRace(String[] horses) {
		int [] horsesInRace = randomArrayLength();
		horsesInRace = initializeWithNegative(horsesInRace);
		horsesInRace = fillHorsesInRace(horsesInRace,horses);
		
		return horsesInRace;
	}
	
	private static int[] fillHorsesInRace(int[] horsesInRace, String [] horses) {
		//this is used to fill the array with horses
		for (int i = 0; i < horsesInRace.length; i++){
			boolean horseIn = false;
			//keeps trying to until adds different horse to array
			while (!horseIn){
			int horse  = (int)(Math.random() * horses.length);
			if (!alreadyInRace(horse, horsesInRace)){
				horsesInRace[i] = horse;
				horseIn = true;
			}
			}
	}
		return horsesInRace;
	}

	private static int[] initializeWithNegative(int[] horsesInRace) {
		for (int i = 0; i < horsesInRace.length; i++)
			horsesInRace[i] = -1;
		return horsesInRace;
	}

	private static int[] randomArrayLength() {
		int [] horsesInRace = new int[(int)(Math.random() * (upperBoundHorses - lowerBoundHorses)) + lowerBoundHorses];
		return horsesInRace;
	}

	private static int[] getPlayerWallets() {
		int [] playerWallets = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numWallets = Integer.parseInt(scanner.nextLine());
			playerWallets = new int[numWallets];
			for (int i = 0; i<numWallets; i++){
				playerWallets[i] = Integer.parseInt(scanner.nextLine().split(" ")[1]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return playerWallets;
	}

	private static String[] getPlayers() {
		String [] playerNames = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			playerNames = new String[numPlayers];
			
			for (int i = 0; i<numPlayers; i++){
				playerNames[i] = scanner.nextLine().split(" ")[0];
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return playerNames;
	}

	public static String[] getHorses(){
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horse.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];
			
			for (int i = 0; i<numHorses; i++){
				horses[i] = scanner.nextLine();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return horses;
	}
	
	
	public static boolean alreadyInRace(int horse, int[] horsesInRace){
		
		for (int i = 0; i < horsesInRace.length; i++){
			if (horsesInRace[i] == horse){
				return true;
			}
		}
			
		return false;
	}

}
