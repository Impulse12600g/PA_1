package edu.ucdenver.tournament;

import java.io.Serializable;

public class Referee implements Serializable {
    private String name;
    private Country country;

    public Referee(String name, Country country){
        this.name = name;
        this.country = country;
    }
    public Country getCountry(){
        return country;
    }
    public String getName() {//needed to pull name from tournament add referee method
        return name;
    }

}
