package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trainer {

    Pokemon gekozenPokemon;
    Scanner scanner = new Scanner(System.in);


    public Pokemon pokemonKiezen(List<Pokemon> sp){

        System.out.println("Which starterpokémon would you like? Choose between 1-5.");

        for (int x = 0; x < sp.size(); x++){
            System.out.println(sp.get(x).name);
        }

        int pokemon1 = scanner.nextInt();
        while (pokemon1 > 5 || pokemon1 < 1) {
            System.out.println("Can you not count? Try again. 1 to 5. It's not hard.");
            pokemon1 = scanner.nextInt();
        }

        System.out.println("Je koos " + sp.get(pokemon1-1).name + ".");

        gekozenPokemon = sp.get(pokemon1-1);
        return gekozenPokemon;
    }
}
