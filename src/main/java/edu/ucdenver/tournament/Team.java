package edu.ucdenver.tournament;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private ArrayList<Player> squad;
    private Country country;

    public Team(String name, Country country){
        this.name = name;
        this.country = country;
    }
    public Country getCountry(){//uml says getCounty

        return country;
    }

    public List<Player> getSquad(){return squad;}

    public void addPlayer(String name, int age, double height, double weight){
        this.squad.add(new Player(name, age, height, weight));
    }
    public String getName() {
        return name;
    }

}
