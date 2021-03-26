package com.company;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Battle {
    //Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    Boolean roll = rand.nextBoolean();
    File oof1 = new File("oof1.wav");
    File oof2 = new File("oof2.wav");


    public Boolean attack(Pokemon pokemon1, Pokemon pokemon2, List<Pokemon> gevangen) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Boolean winnaar = null;
        while (pokemon1.health > 0 && pokemon2.health > 0) {
            System.out.println("\n" + pokemon1.name + " Attacks for " + pokemon1.strength + " damage!");

            AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(oof1);
            Clip yes = AudioSystem.getClip();
            yes.open(audioStream2);
            yes.start();

            pokemon2.health -= pokemon1.strength;
            if (pokemon2.health > 0) {
                System.out.println(pokemon2.name + " has " + pokemon2.health + " HP left.");
            } else {
                System.out.println(pokemon2.name + " is dead.");
                winnaar = true;
                if (roll){
                    System.out.println("\nYou catch " + pokemon2.name + "!");
                    System.out.println(pokemon2.name + " has been added to your team.");
                    gevangen.add(pokemon2);
                }
                else{
                    System.out.println("You throw a pokéball, but miss. Try playing more baseball.");
                }
                break;
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }


            AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(oof2);
            Clip no = AudioSystem.getClip();
            no.open(audioStream3);
            no.start();
            System.out.println("\n" + pokemon2.name + " Attacks for " + pokemon2.strength + " damage!");


            pokemon1.health -= pokemon2.strength;
            if (pokemon1.health > 0) {
                System.out.println(pokemon1.name + " has " + pokemon1.health + " HP left.");
            } else {
                System.out.println(pokemon1.name + " is dead.");
                winnaar = false;
                break;
            }
            try {
                Thread.sleep(700);
            } catch(InterruptedException e) {
                System.out.println("got interrupted!");
            }
        }
        return winnaar;
        }
    }

