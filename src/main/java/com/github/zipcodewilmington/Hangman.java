package com.github.zipcodewilmington;


import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] words = {"zipcode", "game", "cat", "hangman"};


        int wordIndex = (int) (Math.random() * words.length);
        String word = words[wordIndex];


        int lives = 5;
        StringBuilder wordProgress = new StringBuilder(word.replaceAll(".", "_"));
        StringBuilder usedLetters = new StringBuilder();

        while (lives > 0 && wordProgress.indexOf("_") != -1) {

            System.out.println("\nLives: " + lives);
            System.out.println("Word: " + wordProgress);
            System.out.println("Used letters: " + usedLetters);


            System.out.print("\nEnter a letter: ");
            String letter = scanner.nextLine();


            if (usedLetters.indexOf(letter) != -1) {
                System.out.println("You already used that letter!");
                continue;
            }


            if (word.indexOf(letter) != -1) {

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        wordProgress.setCharAt(i, letter.charAt(0));
                        System.out.println("Nice!");
                    }
                }
            } else {

                lives--;
                System.out.println("Sorry, not a correct letter.");
            }


            usedLetters.append(letter);
        }


        if (lives > 0) {
            System.out.println("\nCongratulations, you won!");
        } else {
            System.out.println("\nSorry, you lost. The word was " + word);
        }
    }
}
