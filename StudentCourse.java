import java.util.HashMap;
import java.util.Map;

public class StudentCourse {
    private Map<String, Map<String, Integer>> semesterCourses;

    public StudentCourse() {
        this.semesterCourses = new HashMap<>();
    }

    public void addCourse(String semester, String course, int marks) {
        if (!semesterCourses.containsKey(semester)) {
            semesterCourses.put(semester, new HashMap<>());
        }
        semesterCourses.get(semester).put(course, marks);
    }

    public void displayCourseInfo() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("Semester: " + semester);
            Map<String, Integer> courses = semesterCourses.get(semester);
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Marks: " + entry.getValue());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StudentCourse courses = new StudentCourse();
        courses.addCourse("Semester 1", "Mathematics", 85);
        courses.addCourse("Semester 1", "Physics", 78);
        courses.addCourse("Semester 2", "Chemistry", 90);
        courses.addCourse("Semester 2", "Biology", 82);
        courses.displayCourseInfo();
    }
}