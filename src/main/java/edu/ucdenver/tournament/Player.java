package edu.ucdenver.tournament;

import java.io.Serializable;

/**
 * <p>
 * Player class
 * </p>
 */
public class Player implements Serializable {

    /**
     * <p>
     * name variable to hold the name of the player.
     * </p>
     */
    private String name;
    /**
     * <p>
     * age variable to hold the age of the player.
     * </p>
     */
    private int age;

    /**
     * <p>
     * height variable to hold the height of the player.
     * </p>
     */
    private double height;

    /**
     * <p>
     * weight variable to hold the weight of the player.
     * </p>
     */
    private double weight;

    /**
     * <p>
     * Player constructor to build the player object from the given attributes.
     * </p>
     * @param name representing the name to be given to the player
     * @param age representing the age to be given to the player
     * @param height representing the height to be given to the player
     * @param weight representing the weight to be given to the player
     */
    public Player(String name, int age, double height, double weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

    }

    // getters

    /**
     * <p>
     * getName getter to retrieve the player name.
     * </p>
     * @return name assigned to the player object
     */
    public String getName(){return name;}

    /**
     * <p>
     * getAge getter to retrieve the player age.
     * </p>
     * @return age assigned to the player object
     */
    public int getAge(){return age;}

    /**
     * <p>
     * getHeight getter to retrieve the player height.
     * </p>
     * @return height assigned to the player object
     */
    public double getHeight(){return height;}

    /**
     * <p>
     * getWeight getter to retrieve the player weight.
     * </p>
     * @return weight assigned to the player object
     */
    public double getWeight(){return weight;}

    // setters

    /**
     * <p>
     * setName setter to assign the player name.
     * </p>
     * @param name representing the name we want to give the player object
     */
    public void setName(String name){this.name = name;}

    /**
     * <p>
     * setAge setter to assign the player age.
     * </p>
     * @param age representing the age we want to give the player object
     */
    public void setAge(int age){this.age = age;}

    /**
     * <p>
     * setHeight setter to assign the player height.
     * </p>
     * @param height representing the height we want to give the player object
     */
    public void setHeight(double height){this.height = height;}

    /**
     * <p>
     * setWeight setter to assign the player weight.
     * </p>
     * @param weight representing the weight we want to give the player object
     */
    public void setWeight(double weight){this.weight = weight;}

}
