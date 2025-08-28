package Pig;

public class Pig {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        Player player1 = new Player();
        Player player2 = new Player();

        runGame(player1, player2);

        printResults(player1);
        System.out.println();

        printResults(player2);
        System.out.println();

    }

    public static void runGame(Player player1, Player player2) {
        boolean running = true;
        while (running) {
            System.out.println("Spiller 1 tur.");
            player1.play();
            printCurrentPoints(player1);

            if (player1.getPoints() < 100) {
                System.out.println("Spiller 2 tur");
                player2.play();
               printCurrentPoints(player2);

                running = player2.getPoints() < 100;

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
        }

        public static void printCurrentPoints (Player player) {
            System.out.println("Current points: " + player.getPoints());
        }
    }