package lessons.lesson5.studycenter;

import lessons.lesson5.studycenter.model.Course;
import lessons.lesson5.studycenter.model.Student;
import lessons.lesson5.studycenter.model.Teacher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter teacher name: ");
        String teacherName = scanner.nextLine();
        System.out.println("Enter teacher email: ");
        String teacherEmail = scanner.nextLine();
        Teacher teacher = new Teacher(teacherName, teacherEmail);

        System.out.println("Enter course title: ");
        String courseTitle = scanner.nextLine();
        Course course = new Course(courseTitle, teacher);

        while (true) {

            System.out.println("1) Add student");
            System.out.println("2) Mark attendance");
            System.out.println("3) Add points");
            System.out.println("4) Show course info");
            System.out.println("5) Exit");
            System.out.print("Choose: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                System.out.println("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.println("Enter student email: ");
                String studentEmail = scanner.nextLine();
                Student s = new Student(studentName, studentEmail);
                course.addStudent(s);
            } else if (choice == 2) {
                System.out.println("Enter student name: ");
                String name = scanner.nextLine();
                System.out.println("Is the student present? (true/false): ");
                boolean present = scanner.nextBoolean();
                scanner.nextLine();
                course.markAttendance(name, present);
            } else if (choice == 3) {
                System.out.println("Enter student name: ");
                String name = scanner.nextLine();
                System.out.println("Enter points to add: ");
                int points = scanner.nextInt();
                scanner.nextLine();
                course.addPoints(name, points);
            } else if (choice == 4) {
                course.getCourseInfo();
            } else if (choice == 5) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }
    }

