import java.util.InputMismatchException;
import java.util.Scanner;
//not quite done, error messges. dividing by 0. and alphabetize

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(
                "What operation would you like to do?\n'add'\n'subtract'\n'multiply'\n'divide'\n'alphabatize'\n");
        String operation = input.next().toLowerCase();

        switch (operation) {
            case "add":
                System.out.println("Result: " + addSubtract(0));
                break;
            case "subtract":
                System.out.println("Result: " + addSubtract(69));
                break;
            case "multiply":
                System.out.println("Result: " + multiDivide(0));
                break;
            case "divide":
                System.out.println("Result: " + multiDivide(69));
                break;
            case "alphabatize":
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
                break;
        }
    }

    private static int addSubtract(int toDo) {

        System.out.print("Enter 2 integers, 1 at a time, in the order of operation: \n");

        boolean repeat = true;
        while (repeat) {
            try {
                Scanner input = new Scanner(System.in);
                int a = input.nextInt();
                int b = input.nextInt();
                repeat = false;

                int result;
                if (toDo == 0) {
                    result = a + b;
                } else {
                    result = a - b;
                }
                input.close();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("Invalid integer: Try again");
                System.out.print("Enter 2 integers, 1 at a time, in the order of operation: \n");
            }
        }
        return 0;
    }

    private static double multiDivide(int toDo) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 2 doubles, 1 at a time, in the order of operation: \n");

        boolean repeat = true;
        while (repeat) {
            try {
                double a = Double.parseDouble(input.next());
                double b = Double.parseDouble(input.next());
                repeat = false;

                double result;
                if (toDo == 0) {
                    result = a * b;
                } else {
                    result = a / b;
                }
                input.close();
                return result;

            } catch (NumberFormatException e) {
                System.out.println("Invalid double: Try again");
                System.out.print("Enter 2 doubles, 1 at a time, in the order of operation: \n");
            }
        }
        return 0;
    }
}
