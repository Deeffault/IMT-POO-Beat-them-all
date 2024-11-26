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

    public void setNbEnemies(int nbEnemies) {
        this.nbEnemies = nbEnemies;
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
            Random numberEnemies = new Random();

            int nb_norm =numberEnemies.nextInt(1,5);
                for (int i = 0; i < nb_norm; i++) {
                    int enemyType = numberEnemies.nextInt(3); // 0, 1, or 2

                    Ennemy enemy;
                    switch (enemyType) {
                        case 0:
                            enemy = new Ennemy(1,1);
                            break;
                        case 1:
                            enemy = new Ennemy(2,1);
                            break;
                        case 2:
                            enemy = new Ennemy(3,1);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + enemyType);
                    }

                    enemies.add(enemy);
                }

        }
}
