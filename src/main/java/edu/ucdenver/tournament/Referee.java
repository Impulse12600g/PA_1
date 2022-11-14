package edu.ucdenver.tournament;

import java.io.Serializable;

/**
 * <p>
 * Referee class
 * </p>
 */
public class Referee implements Serializable {
    /**
     * <p>
     * name variable for referee object
     * </p>
     */
    private final String name;

    /**
     * <p>
     * country object of class Country to assign to a referee
     * </p>
     */
    private final Country country;

    /**
     * <p>
     * Referee constructor that assigns a name to the referee and a country that the referee represents.
     * </p>
     * @param name representing the name of the referee
     * @param country of class Country that the referee represents
     */
    public Referee(String name, Country country){
        this.name = name;
        this.country = country;
    }

    /**
     * <p>
     * getCountry getter method to retrieve the country that the referee represents
     * </p>
     * @return country object tied to the referee
     */
    public Country getCountry(){
        return country;
    }

    /**
     * <p>
     * getName getter method for retrieving the name of the referee object
     * </p>
     * @return name of the referee
     */
    public String getName() {//needed to pull name from tournament add referee method
        return name;
    }

}
