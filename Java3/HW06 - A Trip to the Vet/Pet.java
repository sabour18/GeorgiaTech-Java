
public class Pet {

    // instance Variables
    private String name;
    private double health;
    private int painLevel;

    // Constructor
    public Pet(String name, double health, int painLevel) {
        this.name = name;

        if (health > 1.0) {
            this.health = 1.0;
        } else if (health < 0.0) {
            this.health = 0.0;
        } else {
            this.health = health;
        }

        if (painLevel > 10) {
            this.painLevel = 10;
        } else if (painLevel < 1) {
            painLevel = 1;
        } else {
            this.painLevel = painLevel;
        }
    }

    public abstract int treat();

    // Prints the Pets name. If painLevel of the pet is above 5
    // the string is all uppercase
    void speak() {
        String s = "Hello! My name is " + name;

        if (this.painLevel > 5) {
            s.toUpperCase();
        }

        System.out.println(s);
    }
}
