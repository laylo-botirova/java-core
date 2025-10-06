package lessons.lesson5.quiz.model;

public class Question {
    private String text;
    private String answer;
    private int points;

    public Question(String text, String answer, int points){
        this.text = text;
        this.answer= answer;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }
}
