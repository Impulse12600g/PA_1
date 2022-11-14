package edu.ucdenver.tournament;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Team class
 * </p>
 */
public class Team implements Serializable {

    /**
     * <p>
     * name variable to represent the team name
     * </p>
     */
    private final String name;

    /**
     * <p>
     * squad array list built of players in a team
     * </p>
     */
    private final ArrayList<Player> squad;

    /**
     * <p>
     * country object of class Country to assign to a team
     * </p>
     */
    private final Country country;

    /**
     * <p>
     * Team constructor that will build the team, assign a team name, a country the team represents,
     * and build a squad array list for the team.
     * </p>
     * @param name representing the name of the team to be created
     * @param country holding the country object that will be tied to the team
     */
    public Team(String name, Country country){
        this.name = name;
        this.country = country;
        this.squad = new ArrayList<>();
    }
    /**
     * <p>
     * getCountry getter method for retrieving the country the team represents.
     * </p>
     * @return country object that is tied to the team
     */
    public Country getCountry(){//uml says getCounty
        return country;
    }

    /**
     * <p>
     * getSquad getter method for retrieving the squad of players on the team.
     * If the squad is empty, the method will return null
     * </p>
     * @return null if the team is empty.
     *         this.squad if there is at least one player in the list
     */
    public List<Player> getSquad(){
        if(squad.isEmpty()) return null;
        else return new ArrayList<>(this.squad);
    }

    /**
     * <p>
     * addPlayer method to assign a player to a squad.
     * The method will check if the squad is empty first and add the new player to the squad if it is.
     * If the squad is not empty, it will add the player to the squad if there are not already 35 players.
     * If there are 35 players already on the squad, an exception will be thrown stating the squad is full.
     * </p>
     * @param name representing the name we want to assign to a new player
     * @param age representing the age we want to assign to a new player
     * @param height representing the height we want to assign to a new player
     * @param weight representing the weight we want to assign to a new player
     */
    public void addPlayer(String name, int age, double height, double weight){
        if(this.getSquad() == null) this.squad.add(new Player(name, age, height, weight));
        else if(this.getSquad().size() < 35) this.squad.add(new Player(name, age, height, weight));
        else throw new IllegalArgumentException("Squad already has 35 players");
    }

    /**
     * <p>
     * getName method getter to retrieve the name of the team
     * </p>
     * @return name of the team
     */
    public String getName() {
        return name;
    }

}
