package org.example.utils;

import org.example.characters.Brigand;
import org.example.characters.Ennemy;
import org.example.characters.Gangster;
import org.example.characters.Wrestler;

import java.util.ArrayList;
import java.util.Random;

public class Area {
    private int nbEnemies;
    private ArrayList<Ennemy> enemies;

    public Area() {
        this.nbEnemies = 0;
        this.enemies = new ArrayList<>();
    }

    public void generateEnemies() {
        Random random = new Random();
        nbEnemies = random.nextInt(1, 5);
        enemies.clear(); // Clear existing enemies before generating new ones

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

    // Getters and setters
    public int getNbEnemies() {
        return nbEnemies;
    }

    public ArrayList<Ennemy> getEnemies() {
        return enemies;
    }

}
