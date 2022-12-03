import java.io.File;
import java.io.FileNotFoundException;
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

    public String nextDay(File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(f).useDelimiter(",");
        // String line = null;
        String name = "";
        String type = "";
        double drool;
        int mice = -76;
        int time;

        while (scanner.hasNextLine()) {
            name = scanner.next();
            type = scanner.next();
            if (type.equals("Dog")) {
                drool = scanner.nextDouble();
            } else {
                mice = scanner.nextInt();
            }
            // time = scanner.nextInt();

            System.out.println(mice);
            System.out.println(
                    "Consultation for " + name + " the " + type + " at " + ".\nWhat is the health of " + name);
        }
        scanner.close();
        return "Fuck";
    }

    public String nextDay(String fileName) throws FileNotFoundException {
        nextDay(new File(fileName));
        return "Doop";
    }
}
