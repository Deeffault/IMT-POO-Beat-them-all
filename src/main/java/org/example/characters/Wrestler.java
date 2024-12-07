package org.example.characters;

import org.example.characters.Ennemy;

public class Wrestler extends Ennemy {

    public Wrestler() {
        super(100, 15);
    }

    @Override
    public int attack() {
        System.out.println("Le catcheur attaque avec un coup de poing !");
        return getAttackPoints();
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = damage / 2; // Réduction des dégâts reçus
        System.out.println("Le catcheur encaisse en réduisant les dégâts à " + reducedDamage + " !");
        super.takeDamage(reducedDamage);
    }
}
