package edu.ucdenver.tournament;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LineUp implements Serializable {
    private final ArrayList<Player> listOfPlayers;
    private final Team team;
    public LineUp(Team team){
        this.team = team;
        this.listOfPlayers = new ArrayList<>();
    }
    public Team getTeam(){
        return team;
    }
    public List<Player> getPlayers(){
        if(listOfPlayers.isEmpty()) return null;
        else return new ArrayList<>(this.listOfPlayers);
    }
    public void addPlayer(Player player){
        this.listOfPlayers.add(player);

    }
}
