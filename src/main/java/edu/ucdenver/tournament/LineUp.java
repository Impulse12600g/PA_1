package edu.ucdenver.tournament;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * LineUp class
 * </p>
 */
public class LineUp implements Serializable {

    /**
     * <p>
     * listOfPlayers array list to hold line up players.
     * </p>
     */
    private final ArrayList<Player> listOfPlayers;

    /**
     * <p>
     * team object of class Team to assign the lineup to a given team.
     * </p>
     */
    private final Team team;

    /**
     * <p>
     * LineUp constructor that holds the team it represents and the list of players on the lineup.
     * </p>
     * @param team representing the team we are assigning to the lineup
     */
    public LineUp(Team team){
        this.team = team;
        this.listOfPlayers = new ArrayList<>();
    }

    /**
     * <p>
     * getTeam method for retrieving the team tied to a lineup.
     * </p>
     * @return team representing which team the lineup is tied to
     */
    public Team getTeam(){
        return team;
    }

    /**
     * <p>
     * getPlayers method to send back either null if the list is empty, or a list of players in the lineup.
     * </p>
     * @return this.listOfPlayers that holds the players on the lineup
     */
    public List<Player> getPlayers(){
        if(listOfPlayers.isEmpty()) return null;
        else return new ArrayList<>(this.listOfPlayers);
    }

    /**
     * <p>
     * addPlayer method to add a player object to the list of players in the lineup.
     * </p>
     * @param player representing the player of class Player we want to add to the lineup list
     */
    public void addPlayer(Player player){
        this.listOfPlayers.add(player);

    }
}
