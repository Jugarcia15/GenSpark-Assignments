package org.example;

import java.io.ByteArrayOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private int targetNumber;
    private StringBuilder outputBuilder;
    private ByteArrayOutputStream outputStream;

    public static void main(String[] args){
        Main game = new Main();
        game.startGame();
    }

    public void startGame() {
        outputBuilder = new StringBuilder();
        outputStream = new ByteArrayOutputStream();
        System.out.println("Hello! What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Well " + name + " I am thinking of a number between 1 and 20.");
        System.out.println("Take a guess.");

        appendToOutput("Hello! What is your name?");
        appendToOutput("Well " + name + " I am thinking of a number between 1 and 20.");
        appendToOutput("Take a guess.");

        targetNumber = (int) (Math.random() * 20) + 1; // Generate a random number between 1 and 20
        int attempts = 0;
        boolean guessedCorrectly = false;
        int choice = 0;
        while (attempts <5){
            try{
                int userInput = scanner.nextInt();
                if (userInput < 1 || userInput > 20) {
                    System.out.println("Invalid guess. Please enter a number between 1 and 20.");
                    appendToOutput("Invalid guess. Please enter a number between 1 and 20.");
                } else if (userInput < targetNumber) {
                    System.out.println("Too low. Try again.");
                    appendToOutput("Too low. Try again.");
                    attempts++;
                } else if (userInput > targetNumber) {
                    System.out.println("Too high. Try again.");
                    appendToOutput("Too high. Try again.");
                    attempts++;
                } else {
                    System.out.println("Congratulations, " + name + "! You guessed the correct number.");
                    appendToOutput("Congratulations, " + name + "! You guessed the correct number.");
                    guessedCorrectly = true;
                    break;
                }
            } catch(InputMismatchException e){
                appendToOutput("Invalid input. Please enter a valid number.");
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }

        }
        if (!guessedCorrectly) {
            appendToOutput("Sorry, " + name + ". You have used all your attempts. The number I was thinking of was " + targetNumber + ".");
            System.out.println("Sorry, " + name + ". You have used all your attempts. The number I was thinking of was " + targetNumber + ".");
        }
    }
    public int getTargetNumber() {
        return targetNumber;
    }

    public ByteArrayOutputStream getOutputStream() {
        return outputStream;
    }

    public String getOutput() {
        return outputBuilder.toString();
    }

    private void appendToOutput(String message) {
        outputBuilder.append(message).append("\n");
    }
}