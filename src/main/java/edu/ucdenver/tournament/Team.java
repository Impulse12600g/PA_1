package edu.ucdenver.tournament;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {
    private final String name;
    private final ArrayList<Player> squad;
    private final Country country;

    public Team(String name, Country country){
        this.name = name;
        this.country = country;
        this.squad = new ArrayList<>();
    }
    public Country getCountry(){//uml says getCounty
        return country;
    }

    public List<Player> getSquad(){
        if(squad.isEmpty()) return null;
        else return new ArrayList<>(this.squad);
    }

    // Add player to national squad, can't have more than 35 on a team
    public void addPlayer(String name, int age, double height, double weight){
        if(this.getSquad() == null) this.squad.add(new Player(name, age, height, weight));
        else if(this.getSquad().size() < 35) this.squad.add(new Player(name, age, height, weight));
        else throw new IllegalArgumentException("Squad already has 35 players");
    }
    public String getName() {
        return name;
    }

}
