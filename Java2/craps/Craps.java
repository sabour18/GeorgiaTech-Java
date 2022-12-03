package craps;

public class Craps {

    private Die die1, die2;
    private int point;

    public Craps() {
        die1 = new Die();
        die2 = new Die();
    }

    private int toss() {
        int total = die1.roll() + die2.roll();
        System.out.println("Die 1: " + die1.getValue() + "\nDie 2: " + die2.getValue());

        return total;
    }

    public void go() {
        point = toss();
        System.out.println("Points: " + point);
        if ((point == 7) || (point == 11)) {
            System.out.println("You Lost!");
        } else {
            System.out.println("Entering Stage 2");
            stage2();
        }
    }

    private void stage2() {
        boolean endGame = false;

        while (!endGame) {
            int total = toss();

            System.out.println("Total: " + total);
            if (total == point) {
                System.out.println("Winner!");
                endGame = true;
            } else if (total == 7) {
                System.out.println("You Lost!");
                endGame = true;
            }
        }
    }
}
