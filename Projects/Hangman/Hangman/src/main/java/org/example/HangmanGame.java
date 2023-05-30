package org.example;

import java.util.Scanner;

public class HangmanGame {
    private String secretWord;
    private StringBuilder guessedLetters;
    private StringBuilder missedLetters;
    private int maxMisses;


    public static void main(String[] args) {
        //System.out.println("Hello world!");
        HangmanGame game = new HangmanGame();
        game.play();
    }

    public void play() {
        System.out.println("HANGMAN");
        System.out.println("|----|");
        System.out.println("     |");
        System.out.println("     |");
        System.out.println("     |");
        System.out.println("     ===");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the secret word: ");
        secretWord = scanner.nextLine().toLowerCase();

        guessedLetters = new StringBuilder();
        missedLetters = new StringBuilder();
        maxMisses = 5;

        while (true) {
            System.out.println("Missed Letters: " + missedLetters.toString());
            System.out.println("Word: " + getMaskedWord());

            if (isWordGuessed()) {
                System.out.println("Congratulations! You guessed the word: " + secretWord);
                break;
            }

            if (missedLetters.length() >= maxMisses) {
                System.out.println("Game Over! You have used all your attempts.");
                System.out.println("The word was: " + secretWord);
                break;
            }

            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (Character.isLetter(guess)) {
                if (guessedLetters.indexOf(Character.toString(guess)) != -1) {
                    System.out.println("You already guessed that letter. Try again.");
                } else {
                    checkGuess(guess);
                }
            } else {
                System.out.println("Invalid input. Please enter a letter.");
            }
        }
    }

    private void checkGuess(char guess) {
        if (secretWord.indexOf(guess) != -1) {
            guessedLetters.append(guess);
            System.out.println("Correct guess!");
        } else {
            missedLetters.append(guess);
            System.out.println("Wrong guess!");
        }
    }

    private String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();

        for (int i = 0; i < secretWord.length(); i++) {
            char c = secretWord.charAt(i);

            if (guessedLetters.indexOf(Character.toString(c)) != -1) {
                maskedWord.append(c);
            } else {
                maskedWord.append("_");
            }
        }

        return maskedWord.toString();
    }

    private boolean isWordGuessed() {
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessedLetters.indexOf(Character.toString(secretWord.charAt(i))) == -1) {
                return false;
            }
        }

        return true;
    }
}
