package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! What is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Well " + name + " I am thinking of a number between 1 and 20.");
        System.out.println("Take a guess.");
        int choice = 0;
        while (choice <5){
            int userInput = scanner.nextInt();
            

        }
    }
}