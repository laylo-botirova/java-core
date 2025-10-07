package lessons.lesson5.quiz.service;

import lessons.lesson5.quiz.model.Question;
import lessons.lesson5.quiz.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String title;
    private List questions = new ArrayList();
    private List teams = new ArrayList();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void addTeam(Team t) {
        teams.add(t);
    }

    public void startQuiz() {
        if (questions.isEmpty() || teams.isEmpty()) {
            System.out.println("Add questions and teams before starting the quiz.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Starting Quiz: " + title );

        for (int i = 0; i < questions.size(); i++) {
            Question q = (Question) questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.getText());

            for (int j = 0; j < teams.size(); j++) {
                Team t = (Team) teams.get(j);
                System.out.print(t.getName() + ", your answer: ");
                String ans = scanner.nextLine();
                if (ans.equalsIgnoreCase(q.getAnswer())) {
                    t.addScore(q.getPoints());
                    System.out.println("Correct: +" + q.getPoints() + " points");
                } else {
                    System.out.println("Wrong answer.");
                }
            }
        }

        System.out.println(" Results: ");
        for (int i = 0; i < teams.size(); i++) {
            Team t = (Team) teams.get(i);
            System.out.println(t.getName() + "  " + t.getScore() + " points");
        }
    }
}
