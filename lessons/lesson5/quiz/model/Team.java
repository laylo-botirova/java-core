package lessons.lesson5.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List players= new ArrayList();
    private int score;

    public Team(String name) {
        this.name = name;
    }
    public  void addPlayer(Player player){
        players.add(player);
    }
    public void addScore(int points){
        score += points;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
    public void  showPlayers(){
        System.out.println("Team: "+ name);
        for (int i = 0; i < players.size(); i++) {
            Player p = (Player) players.get(i);
            System.out.println(" "+p.getName());

        }
    }
}
