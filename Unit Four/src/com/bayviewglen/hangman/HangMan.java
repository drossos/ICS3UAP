package com.bayviewglen.hangman;

import java.util.Scanner;

public class HangMan {

	static final String ACCEPTED_CHARACTERS = ("QWERTYUIOPASDFGHJKLZXCVBNM1234567890 ");
	static final String ACCEPTED_GUESSES = ("QWERTYUIOPASDFGHJKLZXCVBNM");
	static final int TOTAL_POINTS = 8;
	static final int SPACES = 50;

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		// asking for names and words

		System.out.print("Name of first player: ");
		String playerOne = keyboard.nextLine();

		System.out.print("Name of second player: ");
		String playerTwo = keyboard.nextLine();

		int playerOnePoints = 0;
		int playerTwoPoints = 0;

		int roundCounter = 0;

		boolean gameOver = false;
		boolean playerOneTurn = true;
		boolean invalid = true;
		while (!gameOver) {
			// for player one choose line, player two guess
			while (playerOneTurn) {
				String letterBank = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 0 1 2 3 4 5 6 7 8 9");
				// selecting phrase

				String onePhraseHidden = "";
				System.out.print(playerOne + ", select a phrase");
				String playerOnePhrase = keyboard.nextLine().toUpperCase();

				// seeing if phrase works
				while (invalid) {

					// seeing if phrase works
					for (int i = 0; i < playerOnePhrase.length(); i++) {
						if (ACCEPTED_CHARACTERS.indexOf(playerOnePhrase.charAt(i)) == -1
								|| playerOnePhrase.trim().length() == 0) {
							System.out.println("That is an invalid input");
							System.out.print(playerOne + ", select a phrase");
							playerOnePhrase = keyboard.nextLine().toUpperCase();
						}
						if (ACCEPTED_CHARACTERS.indexOf(playerOnePhrase.charAt(i)) != -1)
							invalid = false;

					}
				}
				// if the phrase is valid
				// to make a version of the word that is hidden
				for (int i = 0; i < playerOnePhrase.length(); i++) {
					if (playerOnePhrase.charAt(i) == ' ')
						onePhraseHidden += '/';
					if (playerOnePhrase.charAt(i) != ' ')
						onePhraseHidden += '-';
				}

				// spaces so they don't see word
				for (int i = 0; i < SPACES; i++) {
					System.out.println();
				}

				// loop for amount of guesses and points
				for (int i = TOTAL_POINTS; i > 0; i--) {
					// this is so they will be able to exit the loop if they
					// guess the write answer and after they get the final guess

					// this is for the initial parts of the guess
					System.out.println(onePhraseHidden);
					System.out.println(letterBank);

					// this is for if the player is being forced to guessed
					if (i == 1) {
						System.out.print("Out of guesses" + playerTwo
								+ ". Time to guess what the phrase is.\nWhat do you think the phrase is?");
						String guess = keyboard.nextLine().toUpperCase();
						//if you get right answer
						if (guess.equals(playerOnePhrase)) {

							playerTwoPoints += i;
							System.out.println("Good job" + playerTwo + ". You have earned " + i
									+ " points. You currently have " + playerTwoPoints + " points");
							i = 0; //exits loop of guessing
						}

						if (!guess.equals(playerOnePhrase)) {

							System.out.println("Too bad" + playerTwo
									+ ". You have not guessed right so you have gotten 0 points. You currently have "
									+ playerTwoPoints + " points");
							i = 0; //exits loop of guessing
						}

					}
					//for when it is not the final guess
					if (i != 1) {
						System.out.println("\nIf you guess the right answer you get " + i + " points");
						System.out.println(playerTwo + " Are you going to guess a letter(1) or the phrase(2)");
						String choice = keyboard.nextLine().toUpperCase();

						// checking if it is a valid choice
						if (!choice.equals("1") && !choice.equals("2")) {
							System.out.println("That is not a valid choice. Please select 1 or 2\n");
							i++;

						}
						// if the player chooses to guess a letter
						if (choice.equals("1")) {
							System.out.println("What letter are you going to guess" + playerTwo);
							String guessLong = keyboard.nextLine().toUpperCase();
							char guess = guessLong.charAt(0);
							if (guessLong.length() > 1) {
								System.out.println("\nChoose only one character when guessing");
								i++;
							}
							if (ACCEPTED_GUESSES.indexOf(guess) == -1) {
								System.out
										.print("\nInvalid character, please choose a valid alpha-numerical character.");
								i++;
							}

							if (letterBank.indexOf(guess) == -1 && ACCEPTED_GUESSES.indexOf(guess) != -1) {
								System.out.println("\nPlease pick a letter that you have not already picked");
								i++;
							}
							// this are is for if the guess is valid
							if (guessLong.length() == 1 && letterBank.indexOf(guess) != -1
									&& ACCEPTED_GUESSES.indexOf(guess) != -1) {
								boolean correct = true;
								for (int h = 0; h < playerOnePhrase.length(); h++) {
									// if the letter is in the word
									if (guess == playerOnePhrase.charAt(h)) {
										// making the new hidden phrase
										for (int k = 0; k < playerOnePhrase.length(); k++) {
											if (playerOnePhrase.charAt(k) == guess) {
												onePhraseHidden = onePhraseHidden.substring(0, k) + guess
														+ onePhraseHidden.substring(k + 1);
												correct = true;
											}
										}

									}
									// this is if the letter guessed is not in
									// the phrase
									if (onePhraseHidden.indexOf(guess) == -1)
										correct = false;

								}
								if (!correct)
									System.out.println("Sorry " + playerTwo + ", that letter is not in the phrase\n");
								if (correct)
									System.out.println("Correct " + playerTwo + ", that letter is in the phrase\n");

							}
							// for if they want to guess the phrase -----ADD A
							// COUNTER SO AT 1 POINT THEY HAVE TO GUESS
						} else if (choice.equals("2")) {
							System.out.println("What do you think the phrase is?");
							String guess = keyboard.nextLine().toUpperCase();
							boolean invalidGuess = true;
							while (invalidGuess) {

								// seeing if the guess if only made up of valid chars
								for (int h = 0; h < playerOnePhrase.length(); h++) {
									//keeps looping if not a valid guess ***might add way to exit***
									if (ACCEPTED_CHARACTERS.indexOf(guess.charAt(h)) == -1
											|| guess.trim().length() == 0) {
										System.out.println("That is an invalid guess");
										System.out.print(playerTwo + ", please make a valid guess");
										guess = keyboard.nextLine().toUpperCase();
									}
									//makes it exit choice loop if it is a valid guess 
									if (ACCEPTED_CHARACTERS.indexOf(guess.charAt(h)) != -1)
										invalidGuess = false;

								}
							}
							//checked if the guess is write or wrong
							if (guess.equals(playerOnePhrase)) {
								playerTwoPoints += i;
								System.out.println("Good job" + playerTwo + ". You have earned " + i
										+ " points. You currently have " + playerTwoPoints + " points");
								i = 0;
							}
							//if wrong will exit back to the start of the guess loop
							if (!guess.equals(playerOnePhrase)){
								System.out.println("Nice try, " + playerTwo + "not right still. Don't worry you stil have " + i + "chances.");
							}
						}
					}

				} //exits the playerOneTurn loop
				playerOneTurn = false;

			}
		}

	}
}
