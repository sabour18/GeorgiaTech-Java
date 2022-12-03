package Pond;

public class Fly {

    // instance variables
    private double mass;
    private double speed;

    // static variables
    private static double DEFAULT_SPEED = 10;
    private static double DEFAULT_MASS = 5;

    // Constructor
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    // Methods
    public double getMass() {
        return mass;
    }

    public double getSpeed() {
        return speed;
    }

    public void setMass(double newMass) {
        mass = newMass;
    }

    public String toString() {
        if (this.getMass() == 0) {
            return "I'm dead, but I used to be a fly with a speed of " + String.format("%.2f", this.getSpeed());
        } else {
            return "I'm a speedy fly with " + String.format("%.2f", this.getSpeed()) + " and a "
                    + String.format("%.2f", this.getMass()) + " mass.";
        }
    }
}
