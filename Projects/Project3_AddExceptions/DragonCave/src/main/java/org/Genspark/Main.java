package org.Genspark;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


        public static void playGame(){
            System.out.print("You are in a land full of dragons. In front of you,\n" +
                    "you see two caves. In one cave, the dragon is friendly\n" +
                    "and will share his treasure with you. The other dragon\n" +
                    "is greedy and hungry and will eat you on sight.\n" +
                    "Which cave will you go into? (1 or 2)\n");
        }
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        playGame();
        while( choice ==0){
            try{
                choice = scanner.nextInt();
                if(choice == 1){
//                    System.out.println("You approach the cave...");
//                    System.out.println("It is dark and spooky...");
//                    System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
//                    System.out.println("Gobbles you down in one bite!");
                    System.out.print("You approach the cave...\n" +
                            "It is dark and spooky...\n" +
                            "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                            "Gobbles you down in one bite!\n");
                    break;
                }
                else if(choice == 2){
                    System.out.println("You approach the cave...");
                    System.out.println("It is dark and spooky...");
                    System.out.println("Yet, the large dragon that emerges...");
                    System.out.println("Greets you and gives you the treasure.");
                    break;
                }
                else{
                    System.out.println("Incorrect input. Please enter either '1' or '2'.");
                    choice=0;
                }
            } catch(InputMismatchException e){
                System.out.println("Incorrect input. Please enter either '1' or '2'.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0;
            }
        }
    }
}