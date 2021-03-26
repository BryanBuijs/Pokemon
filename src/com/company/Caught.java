package com.company;

import java.util.List;

public class Caught {

    public static void printCaughtPokemon (List<Pokemon> caughtPokemon){
        if(caughtPokemon.size() > 0){
            System.out.println("\nYou caught the following pokémon: ");
            for (int x = 0; x < caughtPokemon.size(); x++) {
                System.out.println(caughtPokemon.get(x).name);
            }
        }
    }
}
