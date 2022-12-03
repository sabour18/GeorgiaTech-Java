public class InvalidPetException extends Exception {

    public InvalidPetException(String e) {
        super(e);
    }

    public InvalidPetException() {
        super("Your pet is invalid!");
    }
}
