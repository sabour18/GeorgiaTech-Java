package craps;

import java.util.Random;

public class Die {

    // instance variables
    private int value;
    private Random rand;

    // static variables
    private static final int MAX_VALUE = 6;

    // construcotr
    public Die() {
        value = 1;
        rand = new Random();
    }

    // methods
    public int roll() {
        value = rand.nextInt(MAX_VALUE) + 1;
        return value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "Die has a value of: " + value;
    }
}
