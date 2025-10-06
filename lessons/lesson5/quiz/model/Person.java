package lessons.lesson5.quiz.model;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract String getRole();
}
