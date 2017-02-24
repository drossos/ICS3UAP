package com.bayviewglen.game;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//TODO MAKE AUDIO WORK





public class HorseRacing {
   
                 
    

	static Scanner keyboard = new Scanner(System.in);
	public static int upperBoundHorses = 9;
	public static int lowerBoundHorses = 6;
	public static int lengthRace = 40;
	static int movementHigh =7;
	static int movementLow = 1;
	public static String numbers = "1234567890";
	public static int betRounds = 2;

	public static void main(String[] args) {
		
		introMessage();
        
		String[] horses = getHorses();
		String[] playerNames = getPlayers();
		int[] playerWallets = getPlayerWallets();

		boolean gameOver = false;

		while (!gameOver) {
			//leads to pre-race options
			menuScreen(horses, playerNames, playerWallets);
			//update this again incase changes to roster was made in the menu
			horses = getHorses();
			playerNames = getPlayers();
			playerWallets = getPlayerWallets();
			displayPlayersAndWallets(playerNames, playerWallets);
			//leads into getting horses, running race and betting
			doRace(horses, playerNames, playerWallets);
			displayPlayersAndWallets(playerNames, playerWallets);
			gameOver = promptForGameOver();
			updatePlayerData(playerNames, playerWallets);

		}
		

		closingMessage();
	}

// makes sure there is enough horses to run the race
	private static void checkHorsesEmpty(ArrayList<String> horseList, ArrayList<String> playerList, int option) {
		boolean empty = true;
		while (empty) {
			if (horseList.size() > 7)
				break;
			displayRoster(horseList);
			System.out.println("Keep adding horses until your horse roster has at least 8 horses");
			addRoster(horseList, playerList, option);
		}

	}
//TODO THROWS FILE NOT FOUND BEFORE CHECK IF WALLET EMPTY is because of music
	private static void menuScreen(String[] horses, String[] playerNames, int[] playerWallets) {
		ArrayList<String> horseList = horseArrayToList(horses);
		ArrayList<String> playerList = playerArrayToList(playerNames, playerWallets);
		//makes sure that if wallet is empty removes your from the list
		playerList = checkWalletEmpty(playerList,playerWallets, playerNames);
		checkHorsesEmpty(horseList, playerList, 1);
		checkPlayersEmpty(horseList, playerList, 2);
		
		// keeps brining to menu screen until you choose to race
		boolean passed = true;
		while (passed) {
			int response = getMenuRepsonse();
			if (response == 1 || response == 2)
				editRosters(horseList, playerList, response);
			if (response == 3)
				passed = false;

		}

	}
// boots anyone out of game if no money
	private static ArrayList<String> checkWalletEmpty(ArrayList<String> playerList, int[] playerWallets, String[] playerNames) {
		for (int i = 0; i < playerWallets.length; i++){
			if (playerWallets[i] == 0){
				System.out.println(playerNames[i] + ", you have no money so your names has been removed from the roster. Should have bet smarter");
				playerList.remove(i);
			}
				
		}
		return playerList;
		
	}

//makes sure at least one player to play
	private static void checkPlayersEmpty(ArrayList<String> horseList, ArrayList<String> playerList, int option) {
		boolean empty = true;
		while (empty) {
			if (playerList.size() > 0)
				break;
			displayRoster(playerList);
			System.out.println("Keep adding players until your player roster has at least 1 player");
			addRoster(horseList, playerList, option);
		}

	}

	// converts the array into a temp array list to manipulate
	private static ArrayList<String> playerArrayToList(String[] playerNames, int[] playerWallets) {
		ArrayList<String> playerList = new ArrayList<String>();
		// line is to make a string to combine the wallet and the name
		String line = "";
		for (int i = 0; i < playerNames.length; i++) {
			line = playerNames[i] + " " + playerWallets[i];
			playerList.add(line);
		}
		return playerList;
	}

	private static ArrayList<String> horseArrayToList(String[] horses) {
		ArrayList<String> horseList = new ArrayList<String>();
		for (int i = 0; i < horses.length; i++)
			horseList.add(horses[i]);
		return horseList;
	}

	//goes into removing and adding to roster
	private static void editRosters(ArrayList<String> horseList, ArrayList<String> playerList, int option) {
		chooseRoster(horseList, playerList, option);
		System.out.println("Would you like to 1: add or 2: remove from the roster");
		String response = validateResponse(keyboard.nextLine());
		int answer = Integer.parseInt(response);
		if (answer == 1)
			addRoster(horseList, playerList, option);
		if (answer == 2)
			removeRoster(horseList, playerList, option);

	}
//chooses which roster to display
	private static void chooseRoster(ArrayList<String> horseList, ArrayList<String> playerList, int option) {
		if (option == 1)
			displayRoster(horseList);
		if (option == 2)
			displayRoster(playerList);
	}
//makes the table that displays player names and horse names
	private static void displayRoster(ArrayList<String> roster) {
		for (int i = 0; i < roster.size(); i++){
			System.out.printf("%-20s %5s", roster.get(i), "|");
			if ((i + 1) % 3 == 0 )
				System.out.print("\n");
		}
		System.out.print("\n");

	}
//removes from roster than updates list
	private static void removeRoster(ArrayList<String> horseList, ArrayList<String> playerList, int option) {
		String whatList = whatList(option);

		System.out.println("Which " + whatList + " do you want to remove. Enter the name of the " + whatList
				+ " you want to remove. Make sure you type it out just as it appears.");
		String itemToRemove = "";
		if (option == 1) {
			itemToRemove = validHorse(horseList);
			horseList.remove(horseList.indexOf(itemToRemove));
		}
		if (option == 2) {
			itemToRemove = validPlayer(playerList, "remove");
			playerList.remove(playerList.indexOf(itemToRemove));
		}

		updateListData(horseList, playerList, option);

	}
//makes list you chose into a string to be passed into add and remove methods
	private static String whatList(int option) {
		String whatList = "";
		if (option == 1)
			whatList = "horse";
		if (option == 2)
			whatList = "player";
		return whatList;
	}
//makes sure the player name is valid with money and spacing "Test 45" and when removing player is actualy in the array list
	private static String validPlayer(ArrayList<String> playerList, String addOrRemove) {
		boolean valid = false;
		String playerToRemove = "";
		//keeps asking to add or remove until valid option
		while (!valid) {
			playerToRemove = keyboard.nextLine().trim();
			if (playerList.indexOf(playerToRemove) != -1 && addOrRemove.equals("remove")
					|| addOrRemove.equals("add") && playerToRemove.lastIndexOf(" ") == playerToRemove.indexOf(" ")
					&& numbers.indexOf(playerToRemove.charAt(playerToRemove.indexOf(" ") + 1)) != -1
							)
				valid = true;
			//this has two conditions for fail where if the player tries to remove a player not on list or tries to add invalid format for player
			if (playerList.indexOf(playerToRemove) == -1 && addOrRemove.equals("remove"))
				System.out.println(
						"Please choose a player that is in the roster. Type it out exactly as it appears in the roster.");
			if (playerToRemove.lastIndexOf(" ") != playerToRemove.indexOf(" ")
					|| numbers.indexOf(playerToRemove.charAt(playerToRemove.indexOf(" ") + 1)) == -1
							&& addOrRemove.equals("add"))
				System.out.println("Please use valid a valid name and wallet line. Name followed by a space with the amount of money. Example \"Ryan 50\" ");
		}
		return playerToRemove;
	}
//makes sure horse is in roster to be removed
	private static String validHorse(ArrayList<String> horseList) {
		boolean valid = false;
		String horseToRemove = "";
		while (!valid) {
			horseToRemove = keyboard.nextLine().trim();
			if (horseList.indexOf(horseToRemove) != -1)
				valid = true;
			if (horseList.indexOf(horseToRemove) == -1)
				System.out.println(
						"Please choose a horse that is in the roster. Type it out exactly as it appears in the roster.");
		}
		return horseToRemove;
	}

	// TODO CONSIDER ADDING A VALIDATION FOR HORSE
	private static void addRoster(ArrayList<String> horseList, ArrayList<String> playerList, int option) {
		String whatList = whatList(option);
		System.out.println("Type the name of the " + whatList + " you want to add.");
		if (whatList.equals("player")) {
			System.out.println(
					"Remember to format the name and wallet amount properly. Name followed by a space with the amount of money. Example \"Ryan 50\"");
			playerList.add(validPlayer(playerList, "add"));
		} else
			horseList.add(keyboard.nextLine());

		updateListData(horseList, playerList, option);

	}
//writes the player/horse list to the appropriate file
	private static void updateListData(ArrayList<String> horseList, ArrayList<String> playerList, int option) {
		String whatList = whatList(option);
		
		FileWriter fw;
		try {
			fw = new FileWriter(new File("input/" + whatList + ".dat"));
			if (option == 1) 
				updateList(horseList,whatList,fw);
				
			if (option == 2)
				updateList(playerList, whatList,fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
				
				
			

			
		

	}
//does the actual writing
	private static void updateList(ArrayList<String> list, String whatList, FileWriter fw) {
		try {
			fw.write("" + list.size() + "\n");
			for (int i = 0; i < list.size(); i++) {
				fw.write(list.get(i) + "\n");
		} 
			fw.close();
		}catch (IOException e) {
			
			e.printStackTrace();
		} 
		
		}
		
	

//gets choice from menu
	private static int getMenuRepsonse() {
		displayOptions();
		String response = validateResponseMenu(keyboard.nextLine());
		return Integer.parseInt(response);
	}
//makes sure it is a valid response
	private static String validateResponseMenu(String response) {
		boolean invalid = true;
		while (invalid) {

			if (response.equals("1") || response.equals("2") || response.equals("3"))
				break;

			if (!response.equals("1") && !response.equals("2") && !response.equals("3")) {
				System.out.println("That is not a valid phrase. Please choose either 1,2 or 3");
				response = keyboard.nextLine().trim();
			}
		}

		return response;
	}
//menu options
	private static void displayOptions() {
		System.out.println("Select which option you would like to do: ");
		System.out.println("1: Add or remove horses from list");
		System.out.println("2: Add or remove players from the list");
		System.out.println("3: Start the race the race");

	}
//shows player name and wallet
	private static void displayPlayersAndWallets(String[] playerNames, int[] playerWallets) {
		System.out.println("Here are the players and their wallets:");
		for (int i = 0; i < playerNames.length; i++) {
			System.out.println(playerNames[i] + ": " + playerWallets[i]);
		}
		System.out.println();

	}
//when games ends display
	private static void closingMessage() {
		System.out.println("Hope you had fun at horse racing, come back");

	}
//on start up display message
	private static void introMessage() {
		System.out.println("WELCOME TO HORSE RACING, HIGH STAKES, NO BABY BETS");

	}
//updates player data to text, unlike previous method for updating data, this one takes from array rather than ArrayList<String>
	private static void updatePlayerData(String[] playerNames, int[] playerWallets) {
		try {
			FileWriter fw = new FileWriter(new File("input/player.dat"));
			fw.write("" + playerNames.length + "\n");
			for (int i = 0; i < playerNames.length; i++) {
				fw.write(playerNames[i] + " " + playerWallets[i] + "\n");
			}
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
//asks if they want to do another round and ends if they dont
	private static boolean promptForGameOver() {

		System.out.println(
				"Is your day at the races already over or do you want to keep betting? Type 1 to quit and 2 to continue playing.");
		// Checks if the choice is valid or not
		String playerResponse = validateResponse(keyboard.nextLine().trim());

		if (playerResponse.equals("1"))
			return true; // means game over
		else
			return false; // means game continues
	}
//makes sure end game option is either 1 or 2
	private static String validateResponse(String response) {
		// to check and make sure that a valid answer is given
		boolean invalid = true;
		while (invalid) {

			if (response.equals("1") || response.equals("2"))
				break;

			if (!response.equals("1") && !response.equals("2")) {
				System.out.println("That is not a valid phrase. Please choose either 1 or 2");
				response = keyboard.nextLine().trim();
			}
		}

		return response;
	}
//runs all parts do with race
	private static void doRace(String[] horses, String[] playerNames, int[] playerWallets) {
		// horsesInRace contains of index of the horses from the master horse
		// list array
		int[] horsesInRace = getHorsesInRace(horses);
		displayHorsesInRace(horsesInRace, horses);
		
		//PERSONAL TWIST add a weather effect that will either make the horses run faster
		getWeather();
		// 2D array with col1 = bet amount and col1 = horseIndex(from
		// horsesInRace)
		int[][] playerBets = getPlayerBets(playerNames, playerWallets, horsesInRace, horses);
		
		//starts the race to get winning horse after
		int winningHorse = startRace(horsesInRace, horses);
		//displays the name of winning horse
		winningHorseMessage(winningHorse, horses);
		//changes wallet amounts in accordance with the betting system and displays losses and gains
		playerWallets = payOutBets(playerBets, playerWallets, playerNames, winningHorse);
	}
private static void getWeather() {
	int weather =(int)(Math.random()*4);
	
	if (weather % 2 == 0){
		System.out.println("The weather is average today. The horses will be running at regular speed");
		movementHigh =  7;
		movementLow = 1;
	}
	else if (weather == 1 ){
		
		System.out.println("The weather is rainy today. The horses will be running slower than usual");
		movementHigh =  4;
		movementLow = 0;
	}
	
	else {
		System.out.println("The weather is perfect today. The horses will be running faster than usual");
		movementHigh = 10;
		movementLow = 2;
	}
	
		
	
}

//winning horse message
	private static void winningHorseMessage(int winningHorse, String[] horses) {
		System.out.println("CONGRATUALTIONS TO NUMBER " + winningHorse + ", " + horses[winningHorse]);

	}
//displays who will be in the race and and what lane they will be running in
	private static void displayHorsesInRace(int[] horsesInRace, String[] horses) {
		// method prints out every horse that is going to be in the next race
		
		// well to give more money or take away more
		
		System.out.println("The horses who will be in the race are: ");
		for (int i = 0; i < horsesInRace.length; i++) {
			System.out.println("In lane " + i + " " + horses[horsesInRace[i]]);
		}

	}
//checks every bet they each player made and if they won on either and pays out in accordance
	private static int[] payOutBets(int[][] playerBets, int[] playerWallets, String[] playerNames, int winningHorse) {
		// adds or subtracts money based off if you guessed the winning horse
		for (int i = 0; i < playerWallets.length; i++) {
			if (playerBets[i][0] == winningHorse) {
				playerWallets[i] += 2 * (playerBets[i][1]);
				System.out.println("Congratulations " + playerNames[i] + " you have won $" + playerBets[i][1]);
			}
			if (playerBets[i][0] != winningHorse) {
				System.out.println("Sorry " + playerNames[i] + " you have not won and lost $" + playerBets[i][1]);
			}

			if (playerBets[i][2] == winningHorse) {
				playerWallets[i] += 2 * (playerBets[i][2]);
				System.out.println("Congratulations " + playerNames[i] + " you have won $" + playerBets[i][2]);
			}

			if (playerBets[i][2] != winningHorse) {
				System.out.println("Sorry " + playerNames[i] + " you have not won and lost $" + playerBets[i][3]);
			}
		}
		return playerWallets;
	}

	// to make race to get which horse wins the race
	private static int startRace(int[] horsesInRace, String[] horses) {

		int winner;
		countDown();
		winner = runRace(horsesInRace, horses);

		return winner;
	}

	private static void countDown() {
		for (int i = 5; i > 0; i--) {
			System.out.printf("%20d\n\n", i);
			addDelay();
		}
		System.out.println("GO!");

	}
//count down in real time(ish)
	private static void addDelay() {
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	//holds loop that keeps running race rounds
	private static int runRace(int[] horsesInRace, String[] horses) {
		// keeps track of how far each horse has moved to see when a horse wins
		int[] movement = new int[horsesInRace.length];
		int winner;
		// keeps running until the race is over
		boolean raceOver = false;
		printHeader();
		while (!raceOver) {

			addLongDelay();
			// prints each horses in the race and goes through until a horses
			// reach the end
	
			for (int i = 0; i < horsesInRace.length; i++) {
				printLine();
				printHorseName(horsesInRace, i, horses);
				movement = printRow(i, movement);

			}
			System.out.println();
			winner = checkWinner(movement);
			if (winner > -1) {
				raceOver = true;
				return winner;
			}
		}
		return -1;

	}
//makes a table for when displaying all horse names
	private static void printHorseName(int[] horsesInRace, int i, String[] horses) {
		System.out.printf("%-20s", horses[horsesInRace[i]]);
		System.out.printf("%1s", "|");

	}
//TITLE BEFORE RACE
	private static void printHeader() {
		System.out.println("LET THE RACE BEGIN");

	}
//sees if any horses have reached the finish line yet, also has tie condition
	private static int checkWinner(int[] movement) {
		//checks tie and ties decided randomly
		boolean isTie = checkTie(movement);
		if (isTie) {
			// randomly resolves the winner of the tie
			int winner = decideTie(movement);
			return winner;
		}
		for (int i = 0; i < movement.length; i++) {
			if (movement[i] >= lengthRace)
				return i;
		}
		// if no horse has won yet return -1 so you cant leave loop
		return -1;
	}
//randomly chooses who winds the tie
	private static int decideTie(int[] movement) {
		// tie winners will contain the lane of each of the winners
		int[] tieWinners = new int[checkHowManyWinners(movement)];
		int k = 0; // this is a index counter for the smaller array of tie
					// winners. Keeps track of where to put winners in the
					// smaller array
		for (int i = 0; i < movement.length; i++) {
			if (movement[i] == lengthRace) {
				tieWinners[k] = i;
				k++;
			}
		}
		displayTieMessage(tieWinners);
		int winner = pickWinner(tieWinners);
		return winner;
	}
//radnom generates tie winner
	private static int pickWinner(int[] tieWinners) {
		int winner = tieWinners[(int) (Math.random() * tieWinners.length - 1)];
		System.out.println("The booth has made a decision");
		addDelay();
		return winner;
	}
//checks how many people won, if 0 race continues, if 1 have winner, >1 goes to tie condition
	private static int checkHowManyWinners(int[] movement) {
		int winners = 0;
		for (int i = 0; i < movement.length; i++) {
			if (movement[i] == lengthRace)
				winners++;
		}
		return winners;
	}
//displays which horses have tied
	private static void displayTieMessage(int[] tieWinners) {
		System.out.println("It seem there was a photo finish between:");
		for (int i : tieWinners) {
			System.out.println("lane " + i);
		}
		System.out.println("We will now go to the booth to decide the winner");
		addLongDelay();

	}
//adds a delay for between horse rounds and between count down to start
	private static void addLongDelay() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
//checks if number of won if >1 || ==1|| <1
	private static boolean checkTie(int[] movement) {
		int numberWhoWon = 0;
		for (int i = 0; i < movement.length; i++) {
			if (movement[i] >= lengthRace)
				numberWhoWon++;
		}
		if (numberWhoWon > 1)
			return true;
		return false;
	}

	//in the race prints the row with the horse moving and how far it has to go
	private static int[] printRow(int whichLane, int[] movement) {
		// makes the image and randomly makes the horses move less than race
		// consider adding limit to how fast the horses can race
		int movesThisTurn = getMovesForTurn(whichLane, movement);
		movement[whichLane] += movesThisTurn;
		for (int i = 0; i < movement[whichLane]; i++) {
			System.out.print(" ");
		}
		System.out.print(whichLane + "");
		for (int i = 0; i < lengthRace - movement[whichLane]; i++) {
			System.out.print(" ");
		}
		System.out.println();
		return movement;

	}
// random generates moves per turn
	private static int getMovesForTurn(int whichLane, int[] movement) {
		int moves = (int) (Math.random() * (movementHigh) + (movementLow));
		if (movement[whichLane] + moves > lengthRace)
			moves = lengthRace - movement[whichLane];
		return moves;
	}

	private static void printLine() {
		for (int i = 0; i < 61; i++)
			System.out.print("-");

		System.out.println("");

	}
//gets bets for everyplayer for the two round which 
	private static int[][] getPlayerBets(String[] playerNames, int[] playerWallets, int[] horsesInRace,
			String[] horses) {
		// makes a array with each person and a spot for their bet
		int[][] playerBets = new int[playerNames.length][4];
		System.out.println(
				"We are now taking bets on the next race. Each player can bet twice on different horses or the same horse.");
		// this outloop contains which bet they are on
		for (int j = 0; j < betRounds; j++) {
			for (int i = 0; i < playerNames.length; i++) {

				displayPlayerName(playerNames, i);
				// get which lane you are going to bet on
				String validBetPhrase = validateBetPhrase(horsesInRace, playerWallets, i);
				int playerBetLane = getBetLane(validBetPhrase);
				int playerBetAmount = getBetAmount(validBetPhrase);
				if (j == 0) {
					playerBets[i][0] = playerBetLane;
					playerBets[i][1] = playerBetAmount;
					playerWallets[i] = playerWallets[i] - playerBetAmount;
				}
				if (j == 1) {
					playerBets[i][2] = playerBetLane;
					playerBets[i][3] = playerBetAmount;
					playerWallets[i] = playerWallets[i] - playerBetAmount;
				}
			}

		}

		return playerBets;
	}
// makes sure both number are numberic and valid
	private static String validateBetPhrase(int[] horsesInRace, int[] playerWallets, int player) {
		boolean numeric = false;
		String betLine = "";
		while (!numeric) {
			betLine = keyboard.nextLine().trim();
			numeric = checkNumeric(betLine, horsesInRace, playerWallets, player);
		}
		return betLine;
	}

	
	private static boolean checkNumeric(String betLine, int[] horsesInRace, int[] playerWallets, int player) {
		if (betLine.indexOf(" ") == -1) {
			invalidPrompt();
			return false;
		}
		try {
			Integer.parseInt((betLine).split(" ")[0]);
		} catch (NumberFormatException e) {
			invalidPrompt();
			return false;
		}
		if (Integer.parseInt((betLine).split(" ")[0]) >= horsesInRace.length
				|| Integer.parseInt((betLine).split(" ")[0]) < 0) {
			invalidNumber();
			return false;
		}
		try {
			Integer.parseInt((betLine).split(" ")[1]);
		} catch (NumberFormatException e) {
			invalidPrompt();
			return false;
		}
		if (Integer.parseInt((betLine).split(" ")[1]) > playerWallets[player]
				|| Integer.parseInt((betLine).split(" ")[1]) < 0) {
			invalidNumber();
			return false;
		}
		return true;
	}

	private static void invalidNumber() {
		System.out.println(
				"Please only use valid lane numbers and don't bet more money than you have. Type the lane of the horse and the amount of money you want to bet seperated by a space");

	}

	private static void invalidPrompt() {
		System.out.println(
				"Please use the proper formtating when making a bet. Type the lane of the horse and the amount of money you want to bet seperated by a space");
	}
//parses bet phrase for money bet
	private static int getBetAmount(String response) {
		return Integer.parseInt((response).split(" ")[1]);

	}
//parses bet phrase for which lane they are betting on
	private static int getBetLane(String response) {
		return Integer.parseInt((response).split(" ")[0]);

	}
//asks each player how much they are to bet
	private static void displayPlayerName(String[] playerNames, int whoName) {
		System.out.println(playerNames[whoName]
				+ " how much money are you going to bet and on which horse? Type the lane of the horse and the amount of money you want to bet seperated by a space");
	}
//makes a random array of index from the master horse list
	private static int[] getHorsesInRace(String[] horses) {
		int[] horsesInRace = randomArrayLength();
		horsesInRace = initializeWithNegative(horsesInRace);
		horsesInRace = fillHorsesInRace(horsesInRace, horses);
		;

		return horsesInRace;
	}
//fills horsesInRace with random indexes of master horses
	private static int[] fillHorsesInRace(int[] horsesInRace, String[] horses) {
		// this is used to fill the array with horses
		for (int i = 0; i < horsesInRace.length; i++) {
			boolean horseIn = false;
			// keeps trying to until adds different horse to array
			while (!horseIn) {
				int horse = (int) (Math.random() * horses.length);
				if (!alreadyInRace(horse, horsesInRace)) {
					horsesInRace[i] = horse;
					horseIn = true;
				}
			}
		}
		return horsesInRace;
	}
//fills out the initial horses in array so array starts with no horse indexes
	private static int[] initializeWithNegative(int[] horsesInRace) {
		for (int i = 0; i < horsesInRace.length; i++)
			horsesInRace[i] = -1;
		return horsesInRace;
	}
//makes radom array of size range for horsesInRace
	private static int[] randomArrayLength() {
		int[] horsesInRace = new int[(int) (Math.random() * (upperBoundHorses - lowerBoundHorses)) + lowerBoundHorses];
		return horsesInRace;
	}
//parses player.dat for wallet amounts
	private static int[] getPlayerWallets() {
		int[] playerWallets = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numWallets = Integer.parseInt(scanner.nextLine());
			playerWallets = new int[numWallets];
			for (int i = 0; i < numWallets; i++) {
				playerWallets[i] = Integer.parseInt(scanner.nextLine().split(" ")[1]);
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		return playerWallets;
	}
//parses player.dat for player names
	private static String[] getPlayers() {
		String[] playerNames = null;
		try {
			Scanner scanner = new Scanner(new File("input/player.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			playerNames = new String[numPlayers];

			for (int i = 0; i < numPlayers; i++) {
				playerNames[i] = scanner.nextLine().split(" ")[0];
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return playerNames;
	}
// reads dat file for all horses
	public static String[] getHorses() {
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horse.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];

			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine();
			}

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		return horses;
	}
//checks to make sure that the horse you are adding to the race is not already there
	public static boolean alreadyInRace(int horse, int[] horsesInRace) {

		for (int i = 0; i < horsesInRace.length; i++) {
			if (horsesInRace[i] == horse) {
				return true;
			}
		}

		return false;
	}

}
