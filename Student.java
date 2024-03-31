import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dateOfBirth;

    public Student(String name, String dob) {
        this.name = name;
        this.dateOfBirth = parseDate(dob);
    }

    private LocalDate parseDate(String dob) {
        DateTimeFormatter formatter = null;
        if (dob.contains("-")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else if (dob.contains("/")) {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        } else {
            throw new IllegalArgumentException("Invalid date format");
        }
        return LocalDate.parse(dob, formatter);
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Age: " + calculateAge() + " years");
    }

    private int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - dateOfBirth.getYear();
        if (currentDate.getMonthValue() < dateOfBirth.getMonthValue() ||
                (currentDate.getMonthValue() == dateOfBirth.getMonthValue() &&
                        currentDate.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            age--;
        }
        return age;
    }

    public static void main(String[] args) {
        Student student = new Student("ZiyaKausar", "2004-11-16");
        student.displayStudentInfo();
    }
}
