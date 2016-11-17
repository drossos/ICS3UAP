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
				String letterBank = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
				// selecting phrase

				String onePhraseHidden = "";
				System.out.print(playerOne + ", select a phrase");
				String playerOnePhrase = keyboard.nextLine().toUpperCase();

				// seeing if phrase works
				while (invalid) {

					// seeing if phrase works
					for (int i = 0; i < playerOnePhrase.length(); i++) {
						if (ACCEPTED_CHARACTERS.indexOf(playerOnePhrase.charAt(i)) == -1) {
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
				for (int i = TOTAL_POINTS; i > 1; i--) {

					System.out.println(onePhraseHidden);
					System.out.println(letterBank);
					System.out.println("\nIf you guess the right answer you get " + i + " points");
					System.out.println(playerTwo + " Are you going to guess a letter(1) or the phrase(2)");
					String choice = keyboard.nextLine().toUpperCase();

					if (choice.equals("1")) {
						System.out.println("What letter are you going to guess" + playerTwo);
						String guessLong = keyboard.nextLine().toUpperCase();
						char guess = guessLong.charAt(0);
						if (ACCEPTED_GUESSES.indexOf(guess) == -1){
							System.out.print("\nInvalid character, please choose a valid alpha-numerical character.");
							i++;
						}
						
						if (guessLong.length() > 1) {
							System.out.println("\nChoose only one character when guessing");
							i++;
						}
						if (letterBank.indexOf(guess) == -1 && ACCEPTED_GUESSES.indexOf(guess) != -1){
							System.out.println("\nPlease pick a letter that you have not already picked");
							i++;
						}
						if (guessLong.length() == 1 && letterBank.indexOf(guess) != -1 && ACCEPTED_GUESSES.indexOf(guess) != -1 ) {
							for (int h = 0; h < playerOnePhrase.length(); h++) {
								

								if (guess == playerOnePhrase.charAt(h)) {

									for (int k = 0; k < playerOnePhrase.length(); k++) {
										if (playerOnePhrase.charAt(k) == guess)
											onePhraseHidden = onePhraseHidden.substring(0,k) + guess + onePhraseHidden.substring(k+1);
									}
								}
							}
						}

					} else if (choice.equals("2")) {
						System.out.println("What do you think the phrase is?");
						String guess = keyboard.nextLine().toUpperCase();
					}

				}

			}
		}
	}
}
