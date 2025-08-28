package CrabsV2;

import Crabs.Die;

import java.util.Scanner;

public class Player {
    private Die die;
    private Die die2;
    private int win;
    private int loss;

    public Player() {
        this.die = new Die();
        this.die2 = new Die();
        this.win = 0;
        this.loss = 0;
    }

    public int getWin(){
        return win;
    }

    public int getLoss(){
        return loss;
    }

    public void throwDie() {
        die.roll();
        die2.roll();
        int rollSum = die.getFaceValue() + die2.getFaceValue();

        System.out.println("Du kastede = " + rollSum);

        if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
            System.out.println("Crabs! Du taber!");
            loss++;
            return;
        } else if (rollSum == 7 || rollSum == 11) {
            System.out.println("Du vandt!");
            win++;
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
                loss++;
            } else if (rollSum == point) {
                System.out.println("Du rullede det samme, du vandt!");
                win++;
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tryk Enter for at starte...");
        scanner.nextLine(); // Venter på brugerens input

        throwDie(); // Kaster terninger én gang
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
