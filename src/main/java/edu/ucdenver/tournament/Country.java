package edu.ucdenver.tournament;

import java.io.Serializable;

public class Country implements Serializable {
    private String countryName;

    public Country(String countryName){
        this.countryName = countryName;
    }
    public String getCountryName() {
        return this.countryName;
    }

}
