package com.github.zipcodewilmington;
import java.util.Scanner;
import java.util.Random;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */

// Angela Kim

public class Wordguess {

    String[] words = {"CAT", "PAN", "SIT", "HAM"};
    String secretWord;
    char guess;
    char play;
    boolean isWordGuessed = false;
    boolean guessAgain = true;
    int attempts = 3;

    public static void main(String[] args) {
        Wordguess game = new Wordguess();
        game.runGame();
    }


    public void runGame() {

        announceGame();

        while(guessAgain) {


            randomWord();

            char[] secretWordArray = new char[secretWord.length()];
            for (int i = 0; i < secretWordArray.length; i++) {
                secretWordArray[i] += '_';
            }

            while (!isWordGuessed) {

                System.out.println(attempts + " attempts remaining");
                System.out.println(secretWordArray);

                getInput();

                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guess) {
                        secretWordArray[i] = guess;
                    }
                }
                attempts--;


                if (secretWord.equals(String.valueOf(secretWordArray))) {
                    isWordGuessed = true;
                    System.out.println("You guessed the word!");
                } else if (attempts == 0) {
                    System.out.println("Failed to guess the word :( ");
                    break;
                }


            }

            playAgain();
        }

    }

    public void announceGame() {
        System.out.println("Let's play Hangman! See if you can guess the correct word. ");
    }

    public String randomWord() {
        Random random = new Random();
        secretWord = words[random.nextInt(words.length - 1)];
        return secretWord;
    }


    public void getInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        guess = in.next().toUpperCase().charAt(0);
    }


    public void playAgain() {
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to play again? Enter Y (yes) or N (no)");
        play = in.next().toUpperCase().charAt(0);
        if(play=='Y') {
            attempts = 3;
            guessAgain = true;
            isWordGuessed = false;
        } else if(play=='N') {
            guessAgain = false;
            System.out.println("Thank you for playing. Goodbye!");
        }
    }



}
















//        String[] words = {"CAT", "BAT", "SAT", "FAT"};
//        Random random = new Random();
//        String secretWord = words[random.nextInt(words.length)-1];
//        char[] secretWordArray = secretWord.toCharArray();
//        char[] guessArray = {'_', '_', '_'};
//        char guess;
//        int attempts = 4;
//        int i =0;
//        Scanner in = new Scanner(System.in);
//
//        while(attempts>0) {
//            System.out.println("Enter a single letter: ");
//            guess = in.next().toUpperCase().charAt(0);
//
//            while(i<secretWordArray.length) {
//                if (secretWordArray[i] == guess) {
//                    guessArray[i] = secretWordArray[i];
//                    System.out.println("You have " + attempts + " attempts left");
//                    System.out.println(guessArray);
//                    i++;
//                } else {
//                    System.out.print("Oop. Try again.");
//                    System.out.println("You have " + attempts + " attempts left");
//                    System.out.println(guessArray);
//                    i++;
//                }
//
//            }
//
//            attempts--;
//        }
