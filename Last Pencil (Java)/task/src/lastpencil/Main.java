package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfPencils = 0;
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = scanner.nextLine();
            try {
                numberOfPencils = Integer.parseInt(input);
                if (numberOfPencils <= 0) {
                    System.out.println("The number of pencils should be positive");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            }
        }

        String firstPlayer = "";
        System.out.println("Who will be the first (John, Jack):");
        while (true) {
            firstPlayer = scanner.nextLine();
            if (firstPlayer.equals("John") || firstPlayer.equals("Jack")) {
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }

        String currentPlayer = firstPlayer;

        while (numberOfPencils > 0) {
            // Print the pencils
            for (int i = 0; i < numberOfPencils; i++) {
                System.out.print("|");
            }
            System.out.println();

            // Print the current player's turn
            System.out.println(currentPlayer + "'s turn");

            int pencilsToRemove = 0;

            if (currentPlayer.equals("Jack")) {
                // Bot's move
                if (numberOfPencils == 1) {
                    pencilsToRemove = 1;
                } else if (numberOfPencils % 4 == 0) {
                    pencilsToRemove = 3;
                } else if (numberOfPencils % 4 == 3) {
                    pencilsToRemove = 2;
                } else if (numberOfPencils % 4 == 2) {
                    pencilsToRemove = 1;
                } else {
                    pencilsToRemove = random.nextInt(3) + 1;
                }
                System.out.println(pencilsToRemove);
            } else {
                // Player's move
                while (true) {
                    String input = scanner.nextLine();
                    try {
                        pencilsToRemove = Integer.parseInt(input);
                        if (pencilsToRemove < 1 || pencilsToRemove > 3) {
                            System.out.println("Possible values: '1', '2' or '3'");
                        } else if (pencilsToRemove > numberOfPencils) {
                            System.out.println("Too many pencils were taken");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Possible values: '1', '2' or '3'");
                    }
                }
            }

            // Update the number of pencils
            numberOfPencils -= pencilsToRemove;

            // Switch the player if the game is not over
            if (numberOfPencils > 0) {
                currentPlayer = currentPlayer.equals("John") ? "Jack" : "John";
            }
        }

        // Switch to the winning player
        currentPlayer = currentPlayer.equals("John") ? "Jack" : "John";

        // Print the winner
        System.out.println(currentPlayer + " won!");
    }
}