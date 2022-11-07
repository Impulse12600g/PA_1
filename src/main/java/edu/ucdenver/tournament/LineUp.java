package edu.ucdenver.tournament;

import java.util.ArrayList;
import java.util.List;

public class LineUp {
    private ArrayList<Player> listOfPlayers;
    private Team team;
    public LineUp(Team team){
        this.team = team;
    }
    public Team getTeam(){
        return team;
    }
    public List<Player> getPlayers(){
        return listOfPlayers;
    }
    public void addPlayer(Player player){
        this.listOfPlayers.add(player);

    }
}
