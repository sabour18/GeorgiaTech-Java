package Java2.HW05AmidstUs;

//import java.util.Arrays;

public class Gameplay {
    public static void main(String[] args) {

        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 30);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("angel", 0, 1, 0);

        System.out.println(bob);

        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut sussy = new RedAstronaut("Suspicious Person", 100, "expert");

        liam.sabotage(bob);

        System.out.println(bob);

        System.out.println(sussy);
        liam.freeze(sussy);
        System.out.println(sussy);

        System.out.println(albert);
        liam.freeze(albert);
        System.out.println(albert);

        System.out.println(sussy);
        albert.emergencyMeeting();
        System.out.println(sussy);

        System.out.println(bob);
        System.out.println(heath);
        sussy.emergencyMeeting();
        System.out.println(bob);
        System.out.println(heath);

        System.out.println(sussy);
        bob.emergencyMeeting();
        System.out.println(sussy);

        System.out.println(heath);
        heath.completeTask();
        System.out.println(heath);

        System.out.println(heath);
        heath.completeTask();
        System.out.println(heath);

        System.out.println(heath);
        heath.completeTask();
        System.out.println(heath);

        System.out.println(angel);
        System.out.println(liam);
        liam.freeze(angel);
        System.out.println(angel);
        System.out.println(liam);

        System.out.println(bob);
        liam.sabotage(bob);
        liam.sabotage(bob);
        System.out.println(bob);

        System.out.println(bob);
        liam.freeze(bob);
        System.out.println(bob);

        // Crewmates should win
        /*
         * System.out.println(liam);
         * angel.emergencyMeeting();
         * System.out.println(liam);
         */

        // Impostors win here
        System.out.println(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        liam.sabotage(heath);
        System.out.println(heath);

        liam.freeze(heath);
        System.out.println(heath);
    }
}
