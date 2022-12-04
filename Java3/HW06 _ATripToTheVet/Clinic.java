import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Clinic {

    // instanve variables
    File patientFile;
    private int day;

    public Clinic(File file) {
        patientFile = file;
        day = 1;
    }

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException, InvalidPetException {
        Scanner scanner = new Scanner(f);
        // String line = null;
        String name = "";
        String type = "";
        double drool = -1;
        int mice = -1;
        int time = -1;
        double x = -1;
        double health = -1;
        int painLevel = -1;
        String s = "";

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArr = line.split(",");

            name = lineArr[0];
            type = lineArr[1];
            if (type.toUpperCase().equals("DOG")) {
                drool = Double.parseDouble(lineArr[2]);
                x = drool;
            } else if (type.toUpperCase().equals("CAT")) {
                mice = Integer.parseInt(lineArr[2]);
                x = (int) mice;
            } else {
                throw new InvalidPetException("Invalid Pet Type");
            }
            time = Integer.parseInt(lineArr[3]);

            // System.out.println(mice);

            System.out.println(
                    "Consultation for " + name + " the " + type + " at " + time + ".");

            boolean success = false;
            while (!success) {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("What is the health of " + name + "?");

                    health = sc.nextDouble();
                    success = true;
                } catch (InputMismatchException e) {
                    System.out.println("You donut: Thats not double, try again");
                }
            }

            success = false;
            while (!success) {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("On a scale of 1 to 10, how much pain is " + name + " in right now?");

                    painLevel = sc.nextInt();
                    success = true;
                } catch (InputMismatchException e) {
                    System.out.println("You donut: Thats not an Int, try again");
                }
            }

            Dog doggo;
            Cat kitty;
            if (type.toUpperCase().equals("DOG")) {
                doggo = new Dog(name, health, painLevel, drool);
                doggo.speak();
            } else {
                kitty = new Cat(name, health, painLevel, mice);
                kitty.speak();
            }
            s += name + "," + type + "," + x + ",Day " + day + "," + time + "," + time + "," + health + "," + painLevel
                    + "\n";

        }
        scanner.close();
        day++;
        return s;
    }

    public String nextDay(String fileName) throws FileNotFoundException, InvalidPetException {

        return nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo) {
        try {
            FileWriter writer = new FileWriter(patientFile);

            writer.write(patientInfo);
        } catch (IOException e) {
        }
        return true;
    }
}
