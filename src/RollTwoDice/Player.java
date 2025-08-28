package RollTwoDice;

import java.util.Scanner;

public class Player {
    private Die die;
    private Die die2;
    private int rollCount;
    private int sum = 0;
    private int sameEyes;
    private int[] faceCounter = new int[7];
    private double averageSum = 0;


    int max = Integer.MIN_VALUE;
    int count = 0;

    public Player() {
        this.die = new Die();
        this.die2 = new Die();
    }

    public int getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public int getSameEyes() {
        return sameEyes;
    }

    public int[] getfaceCounter() {
        return faceCounter;
    }

    public double getAverageSum() {
        return averageSum;
    }

    public int getRollCount() {
        return rollCount;
    }

    public void throwDie() {
        die.roll();
        die2.roll();
        sum += die.getFaceValue() + die2.getFaceValue();
        rollCount++;
        if (die.getFaceValue() == die2.getFaceValue()){
            sameEyes++;
        }
        if (die.getFaceValue() + die2.getFaceValue() > max){
            max = die.getFaceValue() + die2.getFaceValue();
            count = 1;
        }
        faceCounter[die.getFaceValue()]++;
        faceCounter[die2.getFaceValue()]++;

        averageSum = (double) sum / rollCount;

    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {
            throwDie();
            System.out.printf("Rolling Die1 ... %d\n", die.getFaceValue());
            System.out.printf("Rolling Die2 ... %d\n", die2.getFaceValue());
            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
    }
}
