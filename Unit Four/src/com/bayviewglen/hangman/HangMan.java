package com.bayviewglen.hangman;

import java.util.Scanner;

public class HangMan {
    //enter blank phrase, no message pops up
    static final String ACCEPTED_CHARACTERS = ("QWERTYUIOPASDFGHJKLZXCVBNM1234567890 ");
    static final String ACCEPTED_GUESSES = ("QWERTYUIOPASDFGHJKLZXCVBNM1234567890");
    static final int TOTAL_POINTS = 8;
    static final int SPACES = 50;
    static final int TOTAL_TURNS = 5;
    static final int EMPTY = 0;

    public static void main(String[] args) {
    	System.out.printf("%120s\n","Welcome to Hangman, where freind turns on freind all for the sweet reward of victory!");
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
       
        System.out.printf("%110s\n","IT IS TIME FOR " + playerOne + " AND " + playerTwo + " TO BE PUT TO A CHALLENGE OF WITS!");
        while (!gameOver) {
            System.out.printf("\n%80s  %1d\n\n\n", "Round", (roundCounter + 1));
            boolean playerOneTurn = true;
            boolean playerTwoTurn = true;
            // for player one choose line, player two guess
            while (playerOneTurn) {
                String letterBank = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 0 1 2 3 4 5 6 7 8 9");
                // selecting phrase

                String PhraseHidden = "";
                String playerOnePhrase = "";
                boolean invalid = true;
                // seeing if phrase works. checks if it is empty and if it has
                // all valid characters
                while (invalid) {
                    System.out.print(playerOne + ", select a phrase");
                    playerOnePhrase = keyboard.nextLine().toUpperCase();
                    if (playerOnePhrase.isEmpty()) {
                        System.out.println("Please enter a phrase");
                       
                    }
                    // seeing if phrase works. checks if it is empty and if it
                    // has all valid characters . checks if it is empty and if
                    // it has all valid characters
                    for (int i = 0; i < playerOnePhrase.length(); i++) {

                        if (ACCEPTED_CHARACTERS.indexOf(playerOnePhrase.charAt(i)) == -1) {
                            System.out.println("\n Invalid word, please only use valid alpha-numerical characters..");
                            break;
                        }
                        
                        
                        if (playerOnePhrase.trim().length() == EMPTY) {
                            System.out.println("Please enter in a word and not just spaces.");
                            break;
                        }
                        if (ACCEPTED_CHARACTERS.indexOf(playerOnePhrase.charAt(i)) != -1 &&
                            playerOnePhrase.trim().length() != EMPTY) {
                            invalid = false;
                            playerOnePhrase = playerOnePhrase.trim();
                        }

                    }
                }
                // if the phrase is valid
                // to make a version of the word that is hidden
                for (int i = 0; i < playerOnePhrase.length(); i++) {
                    if (playerOnePhrase.charAt(i) == ' ')
                        PhraseHidden += '/';
                    if (playerOnePhrase.charAt(i) != ' ')
                        PhraseHidden += '-';
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
                    System.out.println(PhraseHidden);
                    if (PhraseHidden.indexOf('-') == -1){
                    	playerTwoPoints += i+1;
                        System.out.println("Good job " + playerTwo + ". You have earned " + (i +1) +
                            " points. You currently have " + playerTwoPoints + " points");
                       playerOneTurn = false;
                    }
                    System.out.println(letterBank);
                    System.out.println("\nYou have " +(i-1)+" chances until you will be forced to guess.\n");

                    // this is for if the player is being forced to guessed
                    if (i == 1) {
                    	boolean forcedGuess = true;
                    	while (forcedGuess){
                        System.out.print("Out of guesses " + playerTwo +
                            ". Time to guess what the phrase is.\nWhat do you think the phrase is?");
                        String guess = keyboard.nextLine().toUpperCase();
                        if (guess.isEmpty()){
                        	System.out.println("\nPlease actuly type something\n");
                        	
                        }
                        if (!guess.isEmpty()){
                        	forcedGuess = false;
                        // if you get right answer
                        if (guess.equals(playerOnePhrase)) {

                            playerTwoPoints += i;
                            System.out.println("Good job " + playerTwo + ". You have earned " + i +
                                " points. You currently have " + playerTwoPoints + " points");
                          playerOneTurn = false;; // exits loop of guessing
                        }

                        if (!guess.equals(playerOnePhrase)) {

                            System.out.println("Too bad " + playerTwo +
                                ". You have not guessed right so you have gotten 0 points. You currently have " +
                                playerTwoPoints + " points");
                            playerOneTurn = false;; // exits loop of guessing
                        }
                        }
                    }
                    }
                    // for when it is not the final guess
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
                        	boolean invalidChar = true;
                        	while (invalidChar){
                            System.out.println("What letter are you going to guess " + playerTwo);
                            String guessLong = keyboard.nextLine().toUpperCase();
                            if (guessLong.isEmpty()){
                            	System.out.println("Please actualy type something.\n");
                            	
                            }
                            if (!guessLong.isEmpty()){
                            char guess = guessLong.charAt(0);
                            
                            if (guessLong.length() > 1) {
                                System.out.println("\nChoose only one character when guessing");
                               
                            }
                            if (ACCEPTED_GUESSES.indexOf(guess) == -1) {
                                System.out
                                    .print("\n Invalid word, please only use valid alpha-numerical characters..");
                                
                            }

                            if (letterBank.indexOf(guess) == -1 && ACCEPTED_GUESSES.indexOf(guess) != -1) {
                                System.out.println("\nPlease pick a letter that you have not already picked");
                                
                            }
                            // this are is for if the guess is valid
                            if (guessLong.length() == 1 && letterBank.indexOf(guess) != -1 &&
                                ACCEPTED_GUESSES.indexOf(guess) != -1) {
                            	invalidChar = false;
                                boolean correct = true;
                                for (int h = 0; h < playerOnePhrase.length(); h++) {
                                    // if the letter is in the word
                                    if (guess == playerOnePhrase.charAt(h)) {
                                        // making the new hidden phrase
                                        for (int k = 0; k < playerOnePhrase.length(); k++) {
                                            if (playerOnePhrase.charAt(k) == guess) {
                                                PhraseHidden = PhraseHidden.substring(0, k) + guess +
                                                    PhraseHidden.substring(k + 1);
                                               
                                            }
                                        }

                                    }
                                    // this is if the letter guessed is not in
                                    // the phrase
                                    if (PhraseHidden.indexOf(guess) == -1)
                                        correct = false;

                                }
                                if (!correct)
                                    System.out.println("Sorry " + playerTwo + ", that letter is not in the phrase\n");
                                if (correct)
                                    System.out.println("Correct " + playerTwo + ", that letter is in the phrase\n");
                                letterBank = letterBank.substring(0, letterBank.indexOf(guess)) + "- " +
                                    letterBank.substring(letterBank.indexOf(guess) + 2);

                            }
                            }
                        	}
                            // for if they want to guess the phrase -----ADD A
                            // COUNTER SO AT 1 POINT THEY HAVE TO GUESS
                        } else if (choice.equals("2")) {

                            String guess = "";
                            boolean invalidGuess = true;
                            while (invalidGuess) {
                                System.out.println("What do you think the phrase is?");
                                guess = keyboard.nextLine().toUpperCase();
                                if (guess.isEmpty()){
                                	System.out.println("Please actualy type something\n");
                                }
                                if (!guess.isEmpty()){
                                // seeing if the guess if only made up of valid
                                // chars
                                for (int h = 0; h < guess.length(); h++) {
                                    // keeps looping if not a valid guess
                                    
                                    if (ACCEPTED_CHARACTERS.indexOf(guess.charAt(h)) == -1 ||
                                        guess.trim().length() == 0) {
                                        System.out.println("That is an invalid guess");
                                        System.out.print(playerTwo + ", please make a valid guess");
                                        break;
                                    }
                                    // makes it exit choice loop if it is a
                                    // valid guess
                                    if (ACCEPTED_CHARACTERS.indexOf(guess.charAt(h)) != -1)
                                        invalidGuess = false;

                                }
                                }
                                }
                            
                            // checked if the guess is write or wrong
                            if (guess.equals(playerOnePhrase)) {
                                playerTwoPoints += i;
                                System.out.println("Good job " + playerTwo + ". You have earned " + i +
                                    " points. You currently have " + playerTwoPoints + " points");
                               break;
                            }
                            // if wrong will exit back to the start of the guess
                            // loop
                            if (!guess.equals(playerOnePhrase)) {
                                System.out.println("Nice try, " + playerTwo +
                                    " not right still.");
                            }
                                
                            
                        }
                    }

                } // exits the playerOneTurn loop
                playerOneTurn = false;

            }
            while (playerTwoTurn) {
                String letterBank = ("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 0 1 2 3 4 5 6 7 8 9");
                // selecting phrase

                String PhraseHidden = "";
                String playerTwoPhrase = "";
                boolean invalid = true;
                // seeing if phrase works. checks if it is empty and if it has
                // all valid characters
                while (invalid) {
                	System.out.print(playerTwo + ", select a phrase");
                    playerTwoPhrase = keyboard.nextLine().toUpperCase();
                    if (playerTwoPhrase.isEmpty()) {
                        System.out.println("Please enter a phrase");
                       
                    }
                    // seeing if phrase works. checks if it is empty and if it
                    // has all valid characters . checks if it is empty and if
                    // it has all valid characters
                    for (int i = 0; i < playerTwoPhrase.length(); i++) {

                        if (ACCEPTED_CHARACTERS.indexOf(playerTwoPhrase.charAt(i)) == -1) {
                            System.out.println("\n Invalid word, please only use valid alpha-numerical characters..");
                            break;

                        }
                        if (playerTwoPhrase.isEmpty()) {
                            System.out.println("Please enter a phrase");
                            break;
                        }
                        if (playerTwoPhrase.trim().length() == EMPTY) {
                            System.out.println("Please enter in a word and not just spaces.");
                            break;

                        }

                        if (ACCEPTED_CHARACTERS.indexOf(playerTwoPhrase.charAt(i)) != -1 &&
                            playerTwoPhrase.trim().length() != EMPTY) {
                            invalid = false;
                            playerTwoPhrase = playerTwoPhrase.trim();
                        }

                    }
                }
                // if the phrase is valid
                // to make a version of the word that is hidden
                for (int i = 0; i < playerTwoPhrase.length(); i++) {
                    if (playerTwoPhrase.charAt(i) == ' ')
                        PhraseHidden += '/';
                    if (playerTwoPhrase.charAt(i) != ' ')
                        PhraseHidden += '-';
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
                    System.out.println(PhraseHidden);
                    if (PhraseHidden.indexOf('-') == -1){
                    	playerOnePoints += i+1;
                        System.out.println("Good job " + playerOne + ". You have earned " + (i +1) +
                            " points. You currently have " + playerOnePoints + " points");
                       break;
                    }
                    System.out.println(letterBank);
                    System.out.println("\nYou have " +(i-1)+" chances until you will be forced to guess.\n");
                    // this is for if the player is being forced to guessed
                    if (i == 1) {
                    	boolean forcedGuess = true;
                    	while (forcedGuess){
                        System.out.print("Out of guesses " + playerOne +
                            ". Time to guess what the phrase is.\nWhat do you think the phrase is?");
                        String guess = keyboard.nextLine().toUpperCase();
                        if (guess.isEmpty()){
                        	System.out.println("\nPlease actuly type something\n");
                        	
                        }
                        if (!guess.isEmpty()){
                        	forcedGuess = false;
                        // if you get right answer
                        if (guess.equals(playerTwoPhrase)) {

                            playerOnePoints += i;
                            System.out.println("Good job " + playerOne + ". You have earned " + i +
                                " points. You currently have " + playerOnePoints + " points");
                          playerOneTurn = false;; // exits loop of guessing
                        }

                        if (!guess.equals(playerTwoPhrase)) {

                            System.out.println("Too bad " + playerOne +
                                ". You have not guessed right so you have gotten 0 points. You currently have " +
                                playerOnePoints + " points");
                            playerTwoTurn = false;; // exits loop of guessing
                        }
                        }
                    }
                    }
                    // for when it is not the final guess
                    if (i != 1) {
                        System.out.println("\nIf you guess the right answer you get " + i + " points");
                        System.out.println(playerOne + " Are you going to guess a letter(1) or the phrase(2)");
                        String choice = keyboard.nextLine().toUpperCase();

                        // checking if it is a valid choice
                        if (!choice.equals("1") && !choice.equals("2")) {
                            System.out.println("That is not a valid choice. Please select 1 or 2\n");
                            i++;

                        }
                        // if the player chooses to guess a letter
                        if (choice.equals("1")) {
                        	boolean invalidChar = true;
                        	while (invalidChar){
                            System.out.println("What letter are you going to guess " + playerOne);
                            String guessLong = keyboard.nextLine().toUpperCase();
                            if (guessLong.isEmpty()){
                            	System.out.println("Please actualy type something.\n");
                            	
                            }
                            if (!guessLong.isEmpty()){
                            char guess = guessLong.charAt(0);
                            
                            if (guessLong.length() > 1) {
                                System.out.println("\nChoose only one character when guessing");
                               
                            }
                            if (ACCEPTED_GUESSES.indexOf(guess) == -1) {
                                System.out
                                    .print("\nInvalid word, please only use valid alpha-numerical characters..");
                                
                            }

                            if (letterBank.indexOf(guess) == -1 && ACCEPTED_GUESSES.indexOf(guess) != -1) {
                                System.out.println("\nPlease pick a letter that you have not already picked");
                                
                            }
                            // this are is for if the guess is valid
                            if (guessLong.length() == 1 && letterBank.indexOf(guess) != -1 &&
                                ACCEPTED_GUESSES.indexOf(guess) != -1) {
                            	invalidChar = false;
                                boolean correct = true;
                                for (int h = 0; h < playerTwoPhrase.length(); h++) {
                                    // if the letter is in the word
                                    if (guess == playerTwoPhrase.charAt(h)) {
                                        // making the new hidden phrase
                                        for (int k = 0; k < playerTwoPhrase.length(); k++) {
                                            if (playerTwoPhrase.charAt(k) == guess) {
                                                PhraseHidden = PhraseHidden.substring(0, k) + guess +
                                                    PhraseHidden.substring(k + 1);
                                               
                                            }
                                        }

                                    }
                                    // this is if the letter guessed is not in
                                    // the phrase
                                    if (PhraseHidden.indexOf(guess) == -1)
                                        correct = false;

                                }
                                if (!correct)
                                    System.out.println("Sorry " + playerOne + ", that letter is not in the phrase\n");
                                if (correct)
                                    System.out.println("Correct " + playerOne + ", that letter is in the phrase\n");
                                letterBank = letterBank.substring(0, letterBank.indexOf(guess)) + "- " +
                                    letterBank.substring(letterBank.indexOf(guess) + 2);

                            }
                            }
                        	}
                            // for if they want to guess the phrase -----ADD A
                            // COUNTER SO AT 1 POINT THEY HAVE TO GUESS
                        } else if (choice.equals("2")) {

                            String guess = "";
                            boolean invalidGuess = true;
                            while (invalidGuess) {
                                System.out.println("What do you think the phrase is?");
                                guess = keyboard.nextLine().toUpperCase();
                                if (guess.isEmpty()){
                                	System.out.println("Please actualy type something\n");
                                }
                                if (!guess.isEmpty()){
                                // seeing if the guess if only made up of valid
                                // chars
                                for (int h = 0; h < guess.length(); h++) {
                                    // keeps looping if not a valid guess
                                    
                                    if (ACCEPTED_CHARACTERS.indexOf(guess.charAt(h)) == -1 ||
                                        guess.trim().length() == 0) {
                                        System.out.println("That is an invalid guess");
                                        System.out.print(playerTwo + ", please make a valid guess");
                                        break;
                                    }
                                    // makes it exit choice loop if it is a
                                    // valid guess
                                    if (ACCEPTED_CHARACTERS.indexOf(guess.charAt(h)) != -1)
                                        invalidGuess = false;

                                }
                                }
                                }
                            
                            // checked if the guess is write or wrong
                            if (guess.equals(playerTwoPhrase)) {
                                playerOnePoints += i;
                                System.out.println("Good job " + playerOne + ". You have earned " + i +
                                    " points. You currently have " + playerOnePoints + " points");
                               break;
                            }
                            // if wrong will exit back to the start of the guess
                            // loop
                            if (!guess.equals(playerTwoPhrase)) {
                                System.out.println("Nice try, " + playerOne +
                                    " not right still. ");
                            }
                                
                            
                        }
                    }

                }
                roundCounter++;
                playerTwoTurn = false;
                //this is all for deciding if the tie sequence will happen
                if (roundCounter > TOTAL_TURNS && playerOnePoints == playerTwoPoints ){
                	System.out.println("\n\nThis again? Well it seems you both are tied. " + playerTwo + " or " + playerOne + " hurry up and finish the game.\n\n");
                	
                }
                if (roundCounter == TOTAL_TURNS && playerOnePoints == playerTwoPoints ){
                    System.out.println("\n\nThis is interesting. " + playerOne + " and " + playerTwo + ", you are both tied with " + playerOnePoints +". We will not do a tie breaker round each to see if either of you can pull ahead. Good luck.\n\n");
                    
                }
               
                if (roundCounter >= TOTAL_TURNS && playerOnePoints != playerTwoPoints) {
                    System.out.printf("%97s","THE GAME IS OVER AND WE NOW HAVE A WINNER");
                	gameOver = true;
                    keyboard.close();
                }
            }

           
                        }
                    
                      
                        
                   
            
        
        // end sequence, winners have been determined and game is over
        if (playerOnePoints > playerTwoPoints)
            System.out.print("\nCongratulations " + playerOne + ", you have won the game");
        else
            System.out.print("\nCongratulations " + playerTwo + ", you have won the game");
    }
}