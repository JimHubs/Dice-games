package PigV2;

import java.util.Scanner;

public class Player {
    private Die die;
    private Die die2;
    private int rollCount;
    private int turnCount;
    private int points;

    public Player() {
        this.die = new Die();
        this.die2 = new Die();
        this.points = 0;
        this.turnCount = 0;
        this.rollCount = 0;
    }

    public double getAvereageRollAmount(){
        return (double) rollCount/turnCount;
    }

    public int getRollCount() {
        return rollCount;
    }

    public int getPoints() {
        return points;
    }

    public void throwDie() {
        die.roll();
        die2.roll();
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
            System.out.printf("Rolling... %s\n", die.getFaceValue() + " and " + die2.getFaceValue());
            pointsThisTurn += die.getFaceValue() + die2.getFaceValue();
            System.out.println("Points this turn: " + pointsThisTurn);
            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();

            if (die.getFaceValue() == 1 && die2.getFaceValue() == 1) {
                System.out.println("Round over");
                finished = true;
                pointsThisTurn = 0;
                points = 0;
            } else if (die.getFaceValue() == 1 || die2.getFaceValue() == 1) {
                finished = true;
                pointsThisTurn = 0;
            } else {
                System.out.println("Roll again? y/n");
            }
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }

        turnCount++;
        points += pointsThisTurn;
    }
}
