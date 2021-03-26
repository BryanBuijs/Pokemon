package com.company;

import java.util.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);

        File file = new File("billycrawford.wav");
        File whosthatpokemon = new File("whosthatpokemon.wav");
        File ash = new File("ash.wav");
        File win = new File("win.wav");



            Trainer trainer = new Trainer();

            Pokemon pikachu = new Pokemon(1, "Pikachu", 60, 10, "Electric");
            Pokemon bryan = new Pokemon(2, "Bryan", 200, 10, "Muscle");
            Pokemon ivanildo = new Pokemon(3, "Ivanildo", 500, 250, "Psychic");
            Pokemon nabil = new Pokemon(4, "Nabil", 350, 999, "Programmer");
            Pokemon ilona = new Pokemon(5, "Ilona", 400, 50, "Water");
            Pokemon snorlax = new Pokemon(6,"Paul",150, 1, "faggot");

            List<Pokemon> caughtPokemon = new ArrayList<Pokemon>();
            List<Pokemon> starterPokemon = new ArrayList<Pokemon>();
            starterPokemon.add(pikachu);
            starterPokemon.add(bryan);
            starterPokemon.add(ivanildo);
            starterPokemon.add(nabil);
            starterPokemon.add(ilona);


            AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(whosthatpokemon);
            Clip whoisthatpokemonclip = AudioSystem.getClip();
            whoisthatpokemonclip.open(audioStream1);
            whoisthatpokemonclip.start();


            Pokemon returnedPokemon = trainer.pokemonKiezen(starterPokemon);
            starterPokemon.remove(returnedPokemon);


            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String response = "";
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f); // Reduce volume by 20 decibels.


            clip.start();

            while (starterPokemon.size() > 0) {


                Wild.showWildPokemon(starterPokemon);
                int pokemon2 = scanner.nextInt();
                System.out.println("Je koos " + starterPokemon.get(pokemon2 - 1).name);
                Pokemon aanval1 = starterPokemon.get(pokemon2 - 1);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("got interrupted!");
                }

                Battle battle = new Battle();
                boolean winner = battle.attack(trainer.gekozenPokemon, aanval1, caughtPokemon);
                if (winner) {
                    System.out.println("\nYou've won!");
                    starterPokemon.remove(aanval1);
                    Caught.printCaughtPokemon(caughtPokemon);
                } else {
                    clip.stop();
                    AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(ash);
                    Clip play = AudioSystem.getClip();
                    play.open(audioStream4);
                    play.start();

                    System.out.println("You lost, game over!");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("got interrupted!");
                    }

                    System.exit(0);
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("got interrupted!");
                }
            }
            clip.stop();
            AudioInputStream audioStream5 = AudioSystem.getAudioInputStream(win);
            Clip winning = AudioSystem.getClip();
            winning.open(audioStream5);
            winning.start();

            System.out.println("\nThe game is over, you've won, good job!");

        try {
            Thread.sleep(16000);
        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
        }
    }


















































