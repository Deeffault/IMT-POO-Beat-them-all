package org.example.utils;

import org.example.characters.Brigand;
import org.example.characters.Ennemy;
import org.example.characters.Gangster;
import org.example.characters.Wrestler;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an area in the game which contains enemies.
 */
public class Area {

    int nbEnemies;
    ArrayList<Ennemy> enemies;
    Area nextArea;

    /**
     * Constructs a new Area and initializes the enemies list.
     */
    public Area() {
        this.enemies = new ArrayList<>();
    }

    /**
     * Gets the number of enemies in the area.
     *
     * @return the number of enemies
     */
    public int getNbEnemies() {
        return nbEnemies;
    }

    /**
     * Gets the list of enemy types in the area.
     *
     * @return the list of enemies
     */
    public ArrayList<Ennemy> getEnemiesTypes() {
        return enemies;
    }

    /**
     * Sets the list of enemy types in the area.
     *
     * @param enemiesTypes the list of enemies to set
     */
    public void setEnemiesTypes(ArrayList<Ennemy> enemiesTypes) {
        this.enemies = enemiesTypes;
    }

    /**
     * Gets the next area.
     *
     * @return the next area
     */
    public Area getNextArea() {
        return nextArea;
    }

    /**
     * Sets the next area.
     *
     * @param nextArea the next area to set
     */
    public void setNextArea(Area nextArea) {
        this.nextArea = nextArea;
    }

    /**
     * Generates a random number of enemies (between 1 and 4) and adds them to the area.
     */
    public void generateEnemies() {
        Random random = new Random();
        nbEnemies = random.nextInt(1, 5);
        for (int i = 0; i < nbEnemies; i++) {
            int enemyType = random.nextInt(3); // 0, 1, or 2

            Ennemy enemy;
            switch (enemyType) {
                case 0:
                    enemy = new Brigand();
                    break;
                case 1:
                    enemy = new Gangster();
                    break;
                case 2:
                    enemy = new Wrestler();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + enemyType);
            }

            enemies.add(enemy);
        }
    }

    @Override
    public String toString() {
        return "Area{" +
                "nbEnemies=" + nbEnemies +
                ", enemies=" + enemies +
                ", nextArea=" + nextArea +
                '}';
    }
}