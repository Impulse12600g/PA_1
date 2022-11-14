package edu.ucdenver.tournament;

import java.io.Serializable;

/**
 * <p>
 * Country class
 * </p>
 */
public class Country implements Serializable {

    /**
     * <p>
     * countryName variable to store the Country name.
     * </p>
     */
    private final String countryName;

    /**
     * <p>
     * Country constructor.
     * Used to assign the name to the Country.
     * </p>
     * @param countryName to be assigned to the Country's name
     */
    public Country(String countryName){
        this.countryName = countryName;
    }

    /**
     * <p>
     * getCountryName method to retrieve the Country's name.
     * </p>
     * @return this.countryName representing the Country object's name
     */
    public String getCountryName() {
        return this.countryName;
    }

}
