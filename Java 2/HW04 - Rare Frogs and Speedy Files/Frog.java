package Pond;

public class Frog {

    // instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;

    // static vars
    public static String species = "Rare Pepe";
    private static final int DEFAULT_AGE = 5;
    private static final double DEFAULT_TONGUE = 5;

    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;

        // updates if frog is a froglet or not
        if (age > 1 || age < 7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }

    public Frog(String name, double ageYears, double tongueSpeed) {
        this(name, (int) (ageYears * 12), tongueSpeed);
    }

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TONGUE);
    }

    public void grow(int aged) {

        for (int i = aged; i > 0; i--) {
            if (age < 12) {
                tongueSpeed++;
            } else if (age >= 30) {
                if (tongueSpeed > 5) {
                    tongueSpeed--;
                }
            }
            age++;
        }

        // updates if frog is a froglet or not
        if (age > 1 || age < 7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }

    }

    public void grow() {
        grow(1);
    }

    public void eat(Fly fly) {
        if (fly.getMass() == 0) {
            return;
        }

        // if fly caught
        if (tongueSpeed > fly.getSpeed()) {
            if (fly.getMass() >= (age / 2)) {
                grow();
                fly.setMass(0.0);
            }
        } else {// no caught
            fly.setMass(fly.getMass() + 1);
        }
    }// eat

    public String toString() {
        if (isFroglet) {
            return "My name is " + name + " and I’m a rare froglet! I’m " + age
                    + " months old and my tongue has a speed of " + tongueSpeed;
        } else {
            return "My name is " + name + " and I’m a rare frog! I’m " + String.format("%.2f", age)
                    + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed);
        }
    }
}
