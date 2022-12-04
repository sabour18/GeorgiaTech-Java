
public class Cat extends Pet {

    // instance Variable
    private int miceCaught;

    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
        miceCaught = 0;
    }

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);

        if (miceCaught < 0) {
            this.miceCaught = 0;
        } else {
            this.miceCaught = miceCaught;
        }

        System.out.println("HEALTH: " + getHealth());
    }

    public void speak() {
        super.speak();
        String s = "";

        for (int i = 0; i < miceCaught; i++) {
            s += "meow ";
        }

        if (getPainLevel() > 5) {
            s.toUpperCase();
        }

        System.out.println(s);
    }

    @Override
    public int treat() {

        int time = 0;

        if (miceCaught < 4) {
            time = (int) Math.ceil((getPainLevel() * 2) / getHealth());
        } else if (miceCaught <= 7) {
            time = (int) Math.ceil(getPainLevel() / getHealth());
        } else {
            time = (int) Math.ceil(getPainLevel() / (getHealth() * 2));
        }
        heal();
        return time;
    }

    public boolean equals(Object o) {
        Cat cat = (Cat) o;

        if (super.equals(cat) && miceCaught == cat.getMiceCaught()) {
            return true;
        }

        return false;
    }

    public int getMiceCaught() {
        return miceCaught;
    }
}
