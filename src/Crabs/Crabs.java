package Crabs;

import java.util.Arrays;

public class Crabs {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        Player player = new Player();
        System.out.println("Playing Craps.");
        player.play();

        System.out.println();

        System.out.println("Thank you for playing Craps.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println(" U win with 7 or 11. U lose if u get 2, 3, 10");
        System.out.println("=====================================================");
    }

    }