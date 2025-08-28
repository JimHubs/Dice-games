package Crabs;

import java.util.Scanner;

public class Player {
    private Die die;
    private Die die2;

    public Player() {
        this.die = new Die();
        this.die2 = new Die();
    }

    public void throwDie() {
        die.roll();
        die2.roll();
        int rollSum = die.getFaceValue() + die2.getFaceValue();

        System.out.println("Du kastede = " + rollSum);

        if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
            System.out.println("Crabs! Du taber!");
            return;
        } else if (rollSum == 7 || rollSum == 11) {
            System.out.println("Du vandt!");
            return;
        }

        int point = rollSum;
        System.out.println("Punkt etableret: " + point);

        boolean gameOn = true; // Styrer løkken

        while (gameOn) {
            die.roll();
            die2.roll();
            rollSum = die.getFaceValue() + die2.getFaceValue();
            System.out.println("Du kastede = " + rollSum);

            gameOn = (rollSum != 7 && rollSum != point); // Hvis vi rammer 7 eller point, stopper løkken

            if (rollSum == 7) {
                System.out.println("Du rullede 7, du tabte!");
            } else if (rollSum == point) {
                System.out.println("Du rullede det samme, du vandt!");
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tryk Enter for at starte...");
        scanner.nextLine(); // Venter på brugerens input

        throwDie(); // Kaster terninger én gang

        System.out.println("Game over! Tak for spillet!");
        scanner.close(); // Lukker scanner for at forhindre ressource-læk
    }
}





//    public void play() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Roll? (Press Enter)");
//        scanner.nextLine();
//        boolean finished = false;

//        while (!finished) {
//            throwDie();
//            System.out.println("Roll again? (Y/n)");
//            String again = scanner.nextLine().trim().toLowerCase(); // ✅ Read input properly
//
//            if (again.equals("n")) {
//                finished = true; // ✅ Properly exit game
//                System.out.println("Spillet er slut!");
//            }
//        }
