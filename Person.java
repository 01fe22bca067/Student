import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    protected String name;
    private Date dateOfBirth;

    public Person(String name, String dob) {
        System.out.println("Date of birth string: " + dob);
        this.name = name;
        this.dateOfBirth = parseDateOfBirth(dob);
    }

    public void displayName() {
        System.out.println("Person Name: " + name);
    }

    public int calculateAge() {
        if (dateOfBirth != null) {
            Date currentDate = new Date();
            long diffInMillies = Math.abs(currentDate.getTime() - dateOfBirth.getTime());
            long diff = diffInMillies / (24 * 60 * 60 * 1000); // Convert milliseconds to days
            int age = (int) (diff / 365);
            return age;
        } else {
            System.err.println("Date of birth is null");
            return -1; // Or handle this case differently as needed
        }
    }

    private Date parseDateOfBirth(String dob) {
        Date date = null;
        try {
            SimpleDateFormat sdf = null;
            if (dob.contains("-")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (dob.contains("/")) {
                sdf = new SimpleDateFormat("dd/MM/yyyy");
            } else {
                throw new IllegalArgumentException("Invalid date format");
            }
            date = sdf.parse(dob);
        } catch (ParseException e) {
            System.err.println("Error parsing date of birth: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid date format: " + e.getMessage());
        }
        return date;
    }
}
