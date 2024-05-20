import java.util.ArrayList;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and setter methods for name and age
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Course {
    private String courseName;
    private int courseId;

    public Course(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    // Getter methods for courseName and courseId
    public String getCourseName() {
        return courseName;
    }

    public int getCourseId() {
        return courseId;
    }
}

class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    // Getter methods for name and subject
    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
}

class School {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Course> courses;

    public School() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }

    // Methods to add and remove students, teachers, and courses
    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    // Getter methods for students, teachers, and courses
    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        // Example usage
        School school = new School();

        Student student1 = new Student("Alice", 18);
        school.addStudent(student1);

        Teacher teacher1 = new Teacher("Mr. Smith", "Math");
        school.addTeacher(teacher1);

        Course course1 = new Course("Calculus", 101);
        school.addCourse(course1);

        System.out.println("Students: " + school.getStudents());
        System.out.println("Teachers: " + school.getTeachers());
        System.out.println("Courses: " + school.getCourses());
    }
}