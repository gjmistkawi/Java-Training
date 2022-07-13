package Lesson_1;

import java.util.Random;
import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        System.out.println("Guessing Game\n");
        guessingGame();
    }

    public static void guessingGame() {
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();
        int input;
        int target = rand.nextInt(100) + 1;

        System.out.println("Guess a number between 1 and 100");
        for(int i = 0; i < 5; i++) {
            input = scn.nextInt();
            if(input == target) {
                System.out.println("Perfect guess!");
                return;
            }

            else if(input >= (target - 10) && input <= (target + 10)) {
                System.out.println("Close enough, the number was " + target);
                return;
            }

            else {
                System.out.println("Not quite, try again.");
            }
        }

        System.out.println("Sorry, the correct answer was " + target);
    }
}
