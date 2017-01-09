package com.bayviewglen.hangmantest;

import java.util.Scanner;

public class AlexCode {

	public static void main(String[] args) {
        boolean gameOver = false;
        String currentPhraseMaker = "";
        String currentPhraseGuesser = "";
        int playerOneScore = 0;
        int playerTwoScore = 0;
        int round = 1;
        boolean valid = true;
        final int MAX_GUESSES = 7;
        final String VALID_CHARACTERS = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0 ";
        final String VALID_CHARACTERS_NO_SPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String temp = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0";

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Player one, please enter your name:");
        String player1Name = keyboard.nextLine();
        System.out.println("Player two, please enter your name:");
        String player2Name = keyboard.nextLine();
        System.out.println(player1Name + " and " + player2Name + " lets play some competitave hangman.....");

        while (!gameOver) {
               for (int a = 0; a < 2; a++) {
                     if (round%2 == 0){
                            // player 1 is the phrase maker
                            currentPhraseMaker = player1Name;
                            // player 2 is the guesser
                            currentPhraseGuesser = player2Name;
                     } else {
                            // player 2 is the phrase maker
                            currentPhraseMaker = player2Name;
                            // player 1 is the guesser
                            currentPhraseGuesser = player1Name;
                     }

                     }

                     boolean roundOver = false;
                     while (!roundOver) { // two rounds are needed to complete an
                            // ACTUAL round (you pick phrase and I
                            // guess and then we switch) - this does
                            // one of those
                            // choose a phrase
                    	 String phrase = "";
                    	 boolean validPhrase = false;
                    	 while (!validPhrase) {
                            System.out.println( "\n" + "\n" +
                                         currentPhraseMaker + " Please enter a phrase for " + currentPhraseGuesser + " to solve");
                           phrase = keyboard.nextLine().toUpperCase();
                           if (phrase.trim().isEmpty()){
                        	   System.out.println("Please enter something and not just spaces");
                           }
                                  // ensure it is valid
                                  for (int b = 0; b < phrase.length(); b++) {
                                         if (VALID_CHARACTERS.indexOf(phrase.charAt(b)) != -1) {
                                               validPhrase = true;
                                         }
                                  }
                                  if (!validPhrase)
                                         System.out.print(currentPhraseMaker
                                                      + "you must enter a word or phrase using only alphanumeric characters ");

                            }
                            // put some blank lines
                            for (int c = 0; c <= 50; c++) {
                                  System.out.println();
                            }

                            // display encrypted phrase
                            String encryptedPhrase = "";
                            for (int d = 0; d < phrase.length(); d++) {
                                  if (phrase.charAt(d) != ' ')
                                         encryptedPhrase += "_ ";
                                  else
                                         encryptedPhrase += "/ ";
                            }
                            System.out.println(encryptedPhrase);
                            
                            int numberOfGuesses = 0;

                            while (numberOfGuesses < MAX_GUESSES && !roundOver) {
                                  // let guesser choose 1 or 2
                                  System.out.println("");
                                  System.out.println("");

                                  String guessOrSolve = "";

                                  // for (int q = 1; q <= MAX_GUESSES; q++) {
                                  boolean validOption = false;
                                  // ensure it is valid (1 or 2)
                                  
                                  valid = false;
                                  while (!valid) {
                                         String guessedCharacter = "";
                                         validOption = false;
                                         
                                         guessOrSolve="";
                                         while (!validOption) {
                                                System.out.println(currentPhraseGuesser + ", " + "you have used " + numberOfGuesses
                                                             + " guesses, please press 1 if you would like to guess a character or 2 to solve the word. then hit enter:");
                                               
                                               guessOrSolve = keyboard.nextLine().toUpperCase();
                                               if (!guessOrSolve.equals("1") && !guessOrSolve.equals("2")) {
                                                      System.out.println(
                                                                   "please press 1 if you would like to guess a character or 2 to solve the word. then hit enter:");
                                               } else {
                                                      validOption = true;
                                               }
                                         }
                                         
                                         
                                         if (guessOrSolve.equals("1")) {
                                            boolean invalidChar = true;
                                        	 while (invalidChar){
                                        	 System.out.println(currentPhraseGuesser + ", your available guesses are: " + temp + ""
                                                             + " please enter the character you would like to guess: ");

                                                guessedCharacter = keyboard.nextLine().toUpperCase();
                                                
                                                if (guessedCharacter.trim().length() > 1 || guessedCharacter.trim().isEmpty()){
                                                	System.out.println("Please only enter one letter. No more, no less");
                                                }
                                              if (guessedCharacter.trim().length() == 1 ||! guessedCharacter.trim().isEmpty())  {
                                            	  if (VALID_CHARACTERS_NO_SPACE.indexOf(guessedCharacter.charAt(0)) == -1)
                                            		  System.out.println("Please only guess an alpha-numeric character");
                                            	  if (VALID_CHARACTERS_NO_SPACE.indexOf(guessedCharacter.charAt(0)) != -1)
                                            		  invalidChar = false;
                                            	  
                                            	  }
                                              }
                                            	  
                                        	 
                                               valid = true;
                                               for (int i =0; i < guessedCharacter.length(); i++){
                                               if (temp.indexOf(guessedCharacter.charAt(i)) == -1) {
                                                      System.out
                                                                   .print("Please enter an alphanumeric charachtor that you havent guessed: ");
                                                      break;
                                                      
                                               }

                                               }
                                        	 
                                               temp = temp.substring(0, temp.indexOf(guessedCharacter)) + "_"
                                                             + temp.substring(temp.indexOf(guessedCharacter) + 1);
                                                System.out.println(temp);
                                                numberOfGuesses++;

                                               if (phrase.indexOf(guessedCharacter) == -1) {
                                                      System.out.println(encryptedPhrase);
                                                      System.out.println("Unfortunatly your guess was incorrect");
                                               } else {
                                                      /*
                                                      * encryptedPhrase =
                                                      * encryptedPhrase.substring(0,
                                                      * phrase.indexOf(guessedCharacter)*2) +
                                                      * guessedCharacter +
                                                      * encryptedPhrase.substring(phrase.indexOf(
                                                      * guessedCharacter)*2 + 1);
                                                      */
                                                      String tempEncrypted = "";
                                                      for (int i = 0; i < phrase.length(); i++) {
                                                             if (guessedCharacter.charAt(0) == phrase.charAt(i)) {
                                                                   tempEncrypted += guessedCharacter + ' ';
                                                             } else {
                                                                   tempEncrypted += encryptedPhrase.charAt(i * 2) + " ";
                                                             }
                                                      }
                                                      encryptedPhrase = tempEncrypted;
                                                      System.out.println(encryptedPhrase);
                                                      System.out.println(
                                                                   "The character " + "\"" + guessedCharacter + "\"" + " was in the phrase");
                                               }
                                                System.out.println("");

                                               if (encryptedPhrase.indexOf('_') == -1)
                                                      roundOver = true;
                                               round++; 
                                         }

                                         // else if 2 then to solve stuff /* update
                                         // if
                                         // round is over and how many guesses they
                                         // have
                                         // done
                                         // (!guessedPhrase.equals(phrase)) }

                                         if (guessOrSolve.equals("2")) {
                                            boolean invalidGuess = true;
                                            String guessedPhrase = "";
                                        	 while (invalidGuess){
                                        	 if (!roundOver)System.out.println("Please enter the phrase : ");
                                                guessedPhrase = keyboard.nextLine();
                                                guessedPhrase = guessedPhrase.toUpperCase();
                                                
                                                if (guessedPhrase.trim().isEmpty()){
                                                	System.out.println("Please actualy enter a phrase, not just spaces");
                                                }
                                                
                                                if (!guessedPhrase.trim().isEmpty()){
                                                for (int i = 0; i < guessedPhrase.length(); i++){
                                                	if (VALID_CHARACTERS.indexOf(guessedPhrase.charAt(i)) == -1)
                                                		System.out.println("Please only use valid alpha-numeric characters");
                                                	if (VALID_CHARACTERS.indexOf(guessedPhrase.charAt(i)) != -1)
                                                		invalidGuess = false;
                                                }
                                                
                                                
                                        	 }
                                        	 }
                                               if (guessedPhrase.equals(phrase)) {
                                                      System.out.println("congratulations you are correct.");
                                                      if (player1Name == currentPhraseGuesser)
                                                    	  playerOneScore += numberOfGuesses+1;
                                                      if (player2Name == currentPhraseGuesser)
                                                    	  playerTwoScore += numberOfGuesses+1;
                                                      roundOver = true;
                                                      round++;
                                                      break;
                                               } else {
                                                      System.out.println("unfortunatly, you are incorrect " + "");
                                                      numberOfGuesses++;
                                               }
                                         }

                                  }
                            }

                            if (!roundOver && numberOfGuesses == MAX_GUESSES) {
                                  System.out.println("You have ran out of guesses, please guess the phrase: ");
                                  String forcedGuess = keyboard.nextLine();
                                  if (forcedGuess.equals(phrase)) {
                                         System.out.println("congratulations you are correct.");
                                         roundOver = true;
                                         if (player1Name == currentPhraseGuesser) playerOneScore++; 
                                         else playerTwoScore++;
                                  }
                                  
                                  if (numberOfGuesses == MAX_GUESSES && forcedGuess != phrase) {
                                  System.out.println(currentPhraseGuesser +
                                  ", you have lost this round"); round++;
                                  roundOver = true;
                                  }
                                  else 
                                          System.out.println(currentPhraseGuesser + ", you have won this round");
                            }
                            
                            
                            
                            if (player1Name == currentPhraseGuesser) {
                                           playerOneScore += MAX_GUESSES - numberOfGuesses; }
                                           else { playerTwoScore += MAX_GUESSES -
                                           numberOfGuesses; } System.out.println(player1Name +
                                           "'s score is " + playerOneScore + " and " +
                                           player2Name + "'s score is " + playerTwoScore);

                                  gameOver = (round > 5 && playerOneScore != playerTwoScore);

                            
                     }
               
        }


	}

}
