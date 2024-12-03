package org.example;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static  final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        System.out.println("TP réalisé par William Pereira et Théo Lebiez!");

        try{
            //FIXME: This is not working
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            LOGGER.severe("Could not load logging configuration: " + e.getMessage());
        }

        LOGGER.info("Logging configuration loaded successfully.");

        Hero hero = new Hero(100, 10, SpecialCapacity.HEALING);
        Ennemy ennemy = new Gangster();

        // Simulate a fight to generate logs
        Fight.heroAttackEnnemy(hero, ennemy);

        LOGGER.info("Fight simulation completed.");
    }
}