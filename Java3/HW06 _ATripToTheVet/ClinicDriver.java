import java.io.FileNotFoundException;

/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class ClinicDriver {

    public static void main(String[] args) {
        Clinic clinic = new Clinic("Patients.csv");
        String dayOneReport = "";
        try {
            dayOneReport = clinic.nextDay("Appointments.csv");
            System.out.println(dayOneReport);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (InvalidPetException e) {
            e.printStackTrace();
        }

        String[] dayOneAppointments = dayOneReport.split("\\n");
        for (String appointment : dayOneAppointments) {
            if (!clinic.addToFile(appointment)) {
                System.out.println("Appointment could not be added to file!");
            }
        }

    }
}
