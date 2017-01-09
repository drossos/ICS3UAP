package com.bayviewglen.hangmantest;

import java.util.Scanner;

public class SydneyCode {

	public static void main(String[] args) {
	      
	           

        Scanner keyboard = new Scanner(System.in);
        boolean roundOver = false;
        int playerOneScore = 0;
        int playerTwoScore = 0;
        int turns = 1;
        int round = 1;
        final int BLANK_LINES = 30;
        final int MAX_POINTS = 8;
        final int MAX_ROUNDS = 5;
        final int MAX_GUESSES = 7;
        final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 ";
        final String VALID_CHARACTERS_NO_SPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String phraseMaker = "";
        String phraseGuesser = "";
        String possibleCharacters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9";
        String coded = "";
        String solutionPhrase = "";

        // start of game
        System.out.println("Please enter player one's name: ");
        String playerOneName = keyboard.nextLine().trim();

        System.out.println("Please enter player two's name: ");
        String playerTwoName = keyboard.nextLine().trim();

        System.out.println(
                   playerOneName + " and " + playerTwoName + " let's begin a fiercely competitive game of Hangman...");

        String guessedCharacter = "";
        boolean gameOver = false;
        while (!gameOver) {

              System.out.println("*******");
              System.out.println("Round " + round);
              System.out.println("*******");

              if (turns % 2 == 1) {
                   phraseMaker = playerTwoName;
                   phraseGuesser = playerOneName;
              } else {
                   phraseMaker = playerOneName;
                   phraseGuesser = playerTwoName;
                   // second half of round
              }
              System.out.println(phraseMaker + ", please enter a phrase for " + phraseGuesser + " to solve:");

              String phrase = "";

              /// makes sure it's alphanumeric

              boolean validPhrase = false;
              while (!validPhrase) {
                   phrase = keyboard.nextLine().toUpperCase().trim();

                   validPhrase = true;
                   if (phrase.length() < 1) {
                         System.out.println(phraseMaker
                                    + "please enter a valid phrase with only alpha numberic characters (NOT JUST SPACES): ");
                         validPhrase = false;
                   }
                   for (int j = 0; j < phrase.length(); j++) {
                         if (VALID_CHARACTERS.indexOf(phrase.charAt(j)) == -1) {
                               System.out.println(phraseMaker
                                         + "please enter a valid phrase with only alpha numberic characters (spaces are allowed): ");
                              validPhrase = false;
                              break;
                         }
                   }
              }

              for (int i = 0; i < BLANK_LINES; i++) {
                   System.out.println("");
              }
              for (int k = 0; k < phrase.length(); k++) {
                   if (phrase.charAt(k) == ' ') {
                         coded += ("/ ");
                   } else {
                         coded += ("_ ");
                   }
              }
              

              // to guess
              int guessesMade = 0;
              roundOver = false;
              //================FIX HERE==============
              while (!roundOver && guessesMade < MAX_GUESSES) {
            	  System.out.println(coded);
            	  System.out.println("Unused Characters: ");
                  System.out.println(possibleCharacters);

                    System.out.println(phraseGuesser + ", you have used " + guessesMade
                              + " guesses, would you like to [1] solve or [2] guess a character: ");

                   guessesMade++;

                   String choice = keyboard.nextLine().trim();
                   while (!(choice.equals("1") || choice.equals("2"))) {
                         System.out.println(phraseGuesser + ", you must enter [1] or [2]: ");

                         choice = keyboard.nextLine().trim();
                   }

                   // if they pick [1]

                   if (choice.equals("1")) {
                         System.out.println(phraseGuesser + ", please enter your solution: ");
                         validPhrase = true;
                         while (validPhrase) {

                              solutionPhrase = keyboard.nextLine().toUpperCase().trim();
                              validPhrase = false;
                              for (int n = 0; n < solutionPhrase.length(); n++) {
                                    if (VALID_CHARACTERS.indexOf(solutionPhrase.charAt(n)) == -1) {
                                          System.out.println(phraseGuesser
                                                     + ", please enter a valid solution with only alpha numberic characters (spaces are allowed): ");
                                          validPhrase = true;
                                    }
                              }
                         }
                         if (solutionPhrase.equals(phrase)) {
                               System.out.println(phraseGuesser + ", you are CORRECT!!!");
                              roundOver = true;
                              round++;
                         } else {
                               System.out.println(phraseGuesser + ", you are INCORRECT...");
                              roundOver = false;
                              round++;
                         }

                         // if they pick [2]

                   } else if (choice.equals("2")) {
                         System.out.println(phraseGuesser + ", please enter a single character: ");
                         guessedCharacter = keyboard.nextLine().toUpperCase().trim();

                   } else if (choice.length() < 1 || choice.length() > 1) {
                         System.out.print(phraseGuesser
                                    + ", please enter a single valid character that is alpha numberic (not including spaces):");

                   } else if (possibleCharacters.indexOf(guessedCharacter) == -1) {
                         System.out.print(phraseGuesser + ",  you already guessed the character "
                                    + guessedCharacter.charAt(0) + ", please select again:");

                   } else {
                         boolean validCharacter = true;
                         for (int q = 0; q < phrase.length() && validCharacter; q++) {
                              if (guessedCharacter.equals(phrase.charAt(q))) {
                                    System.out.print(
                                               phraseGuesser + " the character '" + guessedCharacter + "' is in the phrase.");
                              }
                         }

                         /// code for used characters

                         for (int s = 0; s < possibleCharacters.length(); s++) {
                              if (possibleCharacters.charAt(s) == guessedCharacter.charAt(0))
                                    possibleCharacters = possibleCharacters.substring(0, s) + "_"
                                               + possibleCharacters.substring(s + 1);
                               System.out.println(possibleCharacters);
                              guessesMade++;
                         }

                         ///
                         for (int p = 0; p < solutionPhrase.length(); p++) {
                              if (solutionPhrase.charAt(p) == choice.charAt(0)) {
                                    coded = coded.substring(0, p * 2) + choice + coded.substring(p * 2 + 1);
                              }
                         }

                         /// checks if they got all the characters needed to
                         /// solve
                         /// the phrase
                         if (coded.indexOf("_") == -1) {
                               System.out.print("Congratulations, " + phraseGuesser + ", you have won this round!");
                              guessesMade--;
                              roundOver = true;
                         }

                         System.out.print(coded);

                         // max guesses
                         if (guessesMade == MAX_GUESSES) {
                               System.out.print(phraseGuesser
                                         + ", you have used up all your guesses. Please enter your final solution: ");
                              validPhrase = false;
                              while (!validPhrase) {
                                    solutionPhrase = keyboard.nextLine().toUpperCase().trim();
                                    validPhrase = true;
                                    for (int m = 0; m < solutionPhrase.length() && validPhrase; m++) {
                                         if (VALID_CHARACTERS.indexOf(solutionPhrase.charAt(m)) == -1) {
                                               System.out.print(phraseGuesser
                                                          + ", please enter a valid solution with only alpha numeric characters (spaces are allowed): ");

                                               validPhrase = false;
                                         }
                                    }

                                    if (solutionPhrase.equals(phrase)) {
                                          System.out.print("");
                                          System.out.print(phraseGuesser + ", you are CORRECT!!!");
                                          guessesMade--;
                                         roundOver = true;
                                         round++;

                                    } else {
                                          System.out.print("");
                                          System.out.print(phraseGuesser + ", you are INCORRECT...");
                                          guessesMade++;
                                    }

                                    //// Scores after each round
                                    if (turns % 2 == 1) {
                                          playerOneScore += MAX_POINTS - guessesMade;
                                    } else {
                                          playerTwoScore += MAX_POINTS - guessesMade;

                                    }
                                    // players scores after each round
                                    System.out.print("SCOREBOARD");
                                    System.out.print("*********");
                                    System.out.print(playerOneName + ": " + playerOneScore);
                                    System.out.print(playerTwoName + ": " + playerTwoScore);

                                    /// total scores after done 5 rounds
                                    while (round > MAX_ROUNDS) {
                                         if (playerOneScore > playerTwoScore) {
                                               System.out.print(playerOneName + " WINS!!!");
                                               gameOver = true;
                                         } else if (playerTwoScore > playerOneScore) {
                                               System.out.print(playerTwoName + " WINS!!!");
                                               gameOver = true;
                                         } else {
                                               System.out.print("IT'S A TIE GAME, LOOKS LIKE WE HAVE TO PLAY ANOTHER ROUND...");
                                               gameOver = false;
                                               round--;
                                         }

                                    }
                              }
                         }
                   }
              }



	}

}
}
