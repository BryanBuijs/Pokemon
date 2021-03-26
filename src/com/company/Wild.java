package com.company;
import java.util.*;

public class Wild {

    public static void showWildPokemon(List<Pokemon> wildPokemonList){
        System.out.println("\nWho would you like to attack? ");
        for (int x = 0; x < wildPokemonList.size(); x++) {
            System.out.println(wildPokemonList.get(x).name);
        }
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }
}
