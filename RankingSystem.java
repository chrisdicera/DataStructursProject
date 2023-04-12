import java.util.HashMap;

import java.util.*;

public class RankingSystem {

    private HashMap<String, Integer> rankings;

    public RankingSystem() {

        rankings = new HashMap<String, Integer>();
    }

    public void addPlayer(String playerName, int score) {// this adds a player and their score
        rankings.put(playerName, score);
    }

    public void removePlayer(String playerName) {// This removes player name
        rankings.remove(playerName);
    }

    public int getScore(String playerName) {// This gets the player score 
        return rankings.get(playerName);
    }

    public List<String> getRanks() {// This get the players ranks 

        List<String> sortedPlayers = new ArrayList<String>(rankings.keySet());
        Collections.sort(sortedPlayers, new Comparator<String>() {

            public int compare(String a, String b) {
                return rankings.get(b) - rankings.get(a);
            }
        });

        return sortedPlayers;
    }

    public static void main(String[] args) {


        RankingSystem rankings = new RankingSystem();
        

        List<String> sortedPlayers = rankings.getRanks();

        for (int i = 0; i < sortedPlayers.size(); i++) {
            String playerName = sortedPlayers.get(i);
            int score = rankings.getScore(playerName);
            System.out.println((i+1) + ". " + playerName + " - " + score);

        }
    }
}
