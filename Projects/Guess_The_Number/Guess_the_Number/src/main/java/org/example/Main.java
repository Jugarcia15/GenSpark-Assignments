package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Well " + name + " I am thinking of a number between 1 and 20.");
        int targetNumber = (int) (Math.random() * 20) + 1; // Generate a random number between 1 and 20
        int attempts = 0;
        boolean guessedCorrectly = false;
        System.out.println("Take a guess.");
        int choice = 0;
        while (choice <5){
            int userInput = scanner.nextInt();
            if (userInput < 1 || userInput > 20) {
                System.out.println("Invalid guess. Please enter a number between 1 and 20.");
            } else if (userInput < targetNumber) {
                System.out.println("Too low. Try again.");
                attempts++;
            } else if (userInput > targetNumber) {
                System.out.println("Too high. Try again.");
                attempts++;
            } else {
                System.out.println("Congratulations, " + name + "! You guessed the correct number.");
                guessedCorrectly = true;
                break;
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry, " + name + ". You have used all your attempts. The number I was thinking of was " + targetNumber + ".");
            }
        }
    }
}