package org.example.utils;

import org.example.characters.Brigand;
import org.example.characters.Enemy;
import org.example.characters.Gangster;
import org.example.characters.Wrestler;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an area in the game that can contain multiple enemies.
 * The number and type of enemies are randomly generated.
 */
public class Area {
    private int nbEnemies;

    public ArrayList<Enemy> enemies;

    /**
     * Constructs an empty area with no enemies.
     */
    public Area() {
        this.nbEnemies = 0;
        this.enemies = new ArrayList<>();
    }

    /**
     * Generates a random number of enemies (between 1 and 4) and populates the area with them.
     * The type of each enemy is also randomly chosen.
     */
    public void generateEnemies() {
        Random random = new Random();
        nbEnemies = random.nextInt(1, 5);
        enemies.clear(); // Clear existing enemies before generating new ones

        for (int i = 0; i < nbEnemies; i++) {
            int enemyType = random.nextInt(3); // 0, 1, or 2

            Enemy enemy;
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

    /**
     * Returns the number of enemies in the area.
     *
     * @return the number of enemies
     */
    public int getNbEnemies() {
        return nbEnemies;
    }

    /**
     * Returns the list of enemies in the area.
     *
     * @return the list of enemies
     */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * Set an ArrayList of enemies
     *
     * @param enemies
     */
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
        this.nbEnemies = enemies.size();
    }

}