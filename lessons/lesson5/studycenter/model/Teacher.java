package lessons.lesson5.studycenter.model;

public class Teacher extends Person {
    public Teacher(String name, String email) {
        super(name, email);
    }

        public String getRole() {
        return "Teacher";
    }
}
