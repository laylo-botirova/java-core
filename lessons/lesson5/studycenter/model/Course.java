package lessons.lesson5.studycenter.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private Teacher teacher;
    private List students = new ArrayList();

    public Course(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }
    public void addStudent(Student student){
        students.add(student);
        System.out.println(student.getName()+" added to course: "+ title);
    }
    public void markAttendance(String name, boolean isPresent){
        int found = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = (Student) students.get(i);
            if(s.getName().equalsIgnoreCase(name)){
                s.addAttendance(isPresent);
                System.out.println(name+ " attendance: "+(isPresent ? " present.": " absent"));
                found = 1;
                break;

            }

        }
        if(found == 0){
            System.out.println("student not found- "+ name);
        }
    }
    public void addPoints(String name, int points ){
        int found =0;
        for (int i = 0; i < students.size(); i++) {
            Student s = (Student ) students.get(i);
            if(s.getName().equalsIgnoreCase(name));{
                s.addPoints(points);
                System.out.println(points+ " points added for "+ name);
                found =1;
                break;
            }

        }
        if ((found==0)) System.out.println("this student not found"+ name);
    }


    public void getCourseInfo() {
        System.out.println("Course{" +
                "title='" + title + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                '}');
        if(students.isEmpty()){
            System.out.println("no students yet");
        }else{
            for (int i = 0; i < students.size(); i++) {
                Student s = (Student) students.get(i);
                System.out.println(" "+ s.getName()+ ". points: "+ ". attendance: "+ s.getAttendance());

            }
        }
    }

    public String getTitle() {
        return title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List getStudents() {
        return students;
    }
}
