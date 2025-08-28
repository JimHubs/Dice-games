package RollTwoDice;

import java.util.Arrays;

public class RollTwoDiceGame {
        public static void main(String[] args) {
            printRules();
            System.out.println();

            Player player = new Player();
            System.out.println("Plying RollTwoDice.");
            player.play();

            printResults(player);
            System.out.println();

            System.out.println("Thank you for playing RollTwoDie.");
        }

        public static void printRules() {
            System.out.println("=====================================================");
            System.out.println("Rules of RollTwoDice:");
            System.out.println("The player throws one die as long as he/she wants.");
            System.out.println("=====================================================");
        }

        public static void printResults(Player player) {
            System.out.println("Results");
            System.out.println("-------");
            System.out.println("Roll count: "+ player.getRollCount());
            System.out.println("sum of die = " + player.getSum());
            System.out.println("samme Antal øjne = " + player.getSameEyes());
            System.out.println("Største sum = " + player.getMax());
            System.out.println("Antal gange = " + Arrays.toString(player.getfaceCounter()));
            System.out.println("Gennemsnitlig sum = " + player.getAverageSum());
        }
    }