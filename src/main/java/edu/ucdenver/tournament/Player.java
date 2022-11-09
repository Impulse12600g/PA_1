package edu.ucdenver.tournament;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int age;
    private double height;
    private double weight;

    public Player(String name, int age, double height, double weight){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

    }

    // getters
    public String getName(){return name;}
    public int getAge(){return age;}
    public double getHeight(){return height;}
    public double getWeight(){return weight;}

    // setters
    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setHeight(double height){this.height = height;}
    public void setWeight(double weight){this.weight = weight;}

}
