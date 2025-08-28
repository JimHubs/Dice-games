package PigV2;

import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        Player player1 = new Player();
        Player player2 = new Player();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Indtast antal ønsket points for at vinde: ");
        int winAmount = scanner.nextInt();
        System.out.println("Antal points for at vinde = " + winAmount);

        runGame(player1, player2, winAmount);

        printResults(player1);
        System.out.println();

        printResults(player2);
        System.out.println();

    }

    public static void runGame(Player player1, Player player2, int winAmount) {
        boolean running = true;
        while (running) {
            System.out.println("Spiller 1 tur.");
            player1.play();
            printCurrentPoints(player1);
            if (player1.getPoints() < winAmount) {
                System.out.println("Spiller 2 tur");
                player2.play();
               printCurrentPoints(player2);

                running = player2.getPoints() < winAmount;

            } else {
                running = false;
            }
        }
    }

        public static void printRules () {
            System.out.println("=====================================================");
            System.out.println("Rules of Pig:");
            System.out.println("The player throws one die as long as he/she wants.");
            System.out.println("=====================================================");
        }
        public static void printResults (Player player){
            System.out.println("Results");
            System.out.println("-------");
            System.out.println("Total points: " + player.getPoints());
            System.out.println("Roll count: " + player.getRollCount());
            System.out.println("Average roll amount: " + player.getAvereageRollAmount());
        }

        public static void printCurrentPoints (Player player) {
            System.out.println("Current points: " + player.getPoints());
        }
    }