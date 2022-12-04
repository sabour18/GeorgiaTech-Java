import java.lang.Math;

public class Dog extends Pet {

    // instance variables
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = 0.5;
        } else {
            this.droolRate = droolRate;
        }
    }

    public Dog(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.droolRate = 5.0;
    }

    @Override
    public int treat() {
        int time = 0;

        if (droolRate < 3.5) {
            time = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        } else if (droolRate <= 7.5) {
            time = (int) Math.ceil(getPainLevel() / getHealth());
        } else {
            time = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }
        heal();
        return time;
    }

    public void speak() {
        super.speak();
        String s = "";

        for (int i = 0; i < getPainLevel(); i++) {
            s += "bark ";
        }

        if (getPainLevel() > 5) {
            s.toUpperCase();
        }

        System.out.println(s);
    }

    public boolean equals(Object o) {
        Dog dog = (Dog) o;

        if (super.equals(dog) && droolRate == dog.getDroolRate()) {
            return true;
        }

        return false;
    }

    private double getDroolRate() {
        return droolRate;
    }

}
