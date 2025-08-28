package CrabsV2;

import java.util.Scanner;

public class Crabs {
    public static void main(String[] args) {
        printRules();
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        Player player = new Player();
        System.out.println("Playing Craps.");

        boolean running = true;
        while (running) {
            player.play();
            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                running = false;
            }
        }

        System.out.println();
        printResults(player);
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println(" U win with 7 or 11. U lose if u get 2, 3, 10");
        System.out.println("=====================================================");
    }

    public static void printResults(Player player){
        System.out.println("Du tabte : " + player.getLoss());
        System.out.println("Du vandt : " + player.getWin());
        System.out.println("Thank you for playing Craps.");

    }

}