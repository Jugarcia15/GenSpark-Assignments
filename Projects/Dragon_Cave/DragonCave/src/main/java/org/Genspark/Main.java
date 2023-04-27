package org.Genspark;

import java.util.Scanner;

public class Main {


        public static void playGame(){
            System.out.println("You are in a land full of dragons. In fron of you,");
            System.out.println("you see two caves. In one cave, the dragon is friendly");
            System.out.println("and will share his treasure with you. The other dragon");
            System.out.println("is greedy and hungry and will eat you on sight.");
            System.out.println("Which cave will you go into? (1 or 2)");


        }
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        playGame();
        while( choice ==0){
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Gobbles you down in one bite!");
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
            }
            choice = 0;

        }

    }






}