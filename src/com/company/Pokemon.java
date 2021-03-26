package com.company;

public class Pokemon {

    int id;
    String name;
    int health;
    int strength;
    String type;

    public Pokemon(){

    }

    public Pokemon(String name){
        health = 200;
    }

    public Pokemon(int id, String name,int health,int strength,String type){
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.type = type;
    }
}
