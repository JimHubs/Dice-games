package Pig;

import java.util.Scanner;

public class Player {
    private Die die;
    private int rollCount;
    private int points;

    public Player() {
        this.die = new Die();
        points = 0;
    }

    public int getRollCount() {
        return rollCount;
    }

    public int getPoints() {
        return points;
    }

    public void throwDie() {
        die.roll();
        rollCount++;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        int pointsThisTurn = 0;
        boolean finished = false;
        while (!finished) {
            throwDie();
            System.out.printf("Rolling... %d\n", die.getFaceValue());
            pointsThisTurn += die.getFaceValue();
            System.out.println("Points this turn: " + pointsThisTurn);
            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();
            if (die.getFaceValue() == 1){
                System.out.println("Round over");
                finished = true;
                pointsThisTurn = 0;
            } else {
                System.out.println("Roll again? y/n");
            }
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
        points += pointsThisTurn;
    }
}
