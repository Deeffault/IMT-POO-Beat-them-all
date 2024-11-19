package org.example;

import java.util.ArrayList;

public class Area {

    int nbEnemies;

    ArrayList<Ennemy> enemiesTypes;

    Area nextArea;
    public int getNbEnemies() {
        return nbEnemies;
    }

    public void setNbEnemies(int nbEnemies) {
        this.nbEnemies = nbEnemies;
    }


    public ArrayList<Ennemy> getEnemiesTypes() {
        return enemiesTypes;
    }

    public void setEnemiesTypes(ArrayList<Ennemy> enemiesTypes) {
        this.enemiesTypes = enemiesTypes;
    }


    public Area getNextArea() {
        return nextArea;
    }

    public void setNextArea(Area nextArea) {
        this.nextArea = nextArea;
    }

}
