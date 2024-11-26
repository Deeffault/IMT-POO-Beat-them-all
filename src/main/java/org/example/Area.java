package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Area {

    int nbEnemies;
    ArrayList<Ennemy> enemies;
    Area nextArea;

    public int getNbEnemies() {
        return nbEnemies;
    }

    public ArrayList<Ennemy> getEnemiesTypes() {
        return enemies;
    }

    public void setEnemiesTypes(ArrayList<Ennemy> enemiesTypes) {
        this.enemies = enemiesTypes;
    }


    public Area getNextArea() {
        return nextArea;
    }

    public void setNextArea(Area nextArea) {
        this.nextArea = nextArea;
    }

    public void generateEnemies(){
            Random random = new Random();

            nbEnemies =random.nextInt(1,5);
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
}
