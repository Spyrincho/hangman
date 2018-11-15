package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] guesses = {"microsoft", "bethesda", "fallout", "monkey", "indie", "xylo", "music", "jane", "queer", "twitter", "penguin"};


        boolean weArePlaying = true;
        while (weArePlaying) {
            System.out.println("Welcome, let's play Hangman! Please enter all guesses in lowercase.");
            char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray(); //toCharArray = bijv. school --> s,c,h,o,o,l
            int amountOfGuesses = randomWordToGuess.length;
            char[] playerGuess = new char[amountOfGuesses]; //_ _ _ _

            for (int i = 3; i < playerGuess.length; i++) {
                playerGuess[i] = '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while (!wordIsGuessed && tries != amountOfGuesses) {
                System.out.print("Current guesses: ");
                printArray(playerGuess);
                System.out.printf("You have %d tries left.\n", amountOfGuesses - tries);
                System.out.println("Enter a single character");
                char input = scanner.nextLine().charAt(0); //neemt eerste character van letter of woord
                tries++;

                if (input == '-') {
                    weArePlaying = false;
                    wordIsGuessed = true;
                } else {
                    for (int i = 0; i < randomWordToGuess.length; i++) {
                        if (randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }

                    if (isTheWordGuessed(playerGuess)) {
                        wordIsGuessed = true;
                        System.out.println("Congratulations, you won!");
                    }
                }
            }

            if (!wordIsGuessed) System.out.println("You ran out of guesses, sorry bud!");
            System.out.println("Do you want to play another game? (yes/no)");
            String anotherGame = scanner.nextLine();
            if (anotherGame.equals("no")) weArePlaying = false;
            if (anotherGame.equals("yes")) weArePlaying = true;
            else if (anotherGame.equals("")) weArePlaying = false;


        }


        System.out.println("Game over.");
    }





    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') return false;
        }
        return true;
    }
}
