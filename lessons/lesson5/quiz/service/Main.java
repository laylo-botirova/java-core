package lessons.lesson5.quiz.service;

import lessons.lesson5.quiz.model.Player;
import lessons.lesson5.quiz.model.Question;
import lessons.lesson5.quiz.model.Team;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = new Quiz(title);

        while (true) {

            System.out.println("1) Add question");
            System.out.println("2) Add team");
            System.out.println("3) Start quiz");
            System.out.println("4) Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter question text: ");
                String text = scanner.nextLine();
                System.out.println("Enter correct answer: ");
                String answer = scanner.nextLine();
                System.out.println("Enter points: ");
                int points = scanner.nextInt();
                scanner.nextLine();
                quiz.addQuestion(new Question(text, answer, points));
                System.out.println("Question added.");
            } else if (choice == 2) {
                System.out.println("Enter team name: ");
                String teamName = scanner.nextLine();
                Team team = new Team(teamName);
                System.out.println("Enter number of players: ");
                int n = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < n; i++) {
                    System.out.println("Enter player name: ");
                    String playerName = scanner.nextLine();
                    team.addPlayer(new Player(playerName));
                }
                quiz.addTeam(team);
                System.out.println("Team added.");
            } else if (choice == 3) {
                quiz.startQuiz();
            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
