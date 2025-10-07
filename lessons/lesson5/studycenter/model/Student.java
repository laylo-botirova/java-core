package lessons.lesson5.studycenter.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int totalPoints;
    private List attendanceList = new ArrayList();

    public Student(String name, String email) {
        super(name, email);
        this.totalPoints = 0;
    }

    public void addAttendance(boolean isPresent) {
        attendanceList.add(Boolean.valueOf(isPresent));
    }

    public void addPoints(int points) {
        totalPoints += points;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getAttendance() {
        int count = 0;
        for (int i = 0; i < attendanceList.size(); i++) {
            Boolean isPresent = (Boolean) attendanceList.get(i);
            if (isPresent.booleanValue()) {
                count++;
            }
        }
        return count;

    }

    public String getRole() {
        return "Student";
    }
}





