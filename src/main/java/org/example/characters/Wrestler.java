package org.example.characters;

public class Wrestler extends Enemy {

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

    @Override
    public String toString() {
        return "Wrestler (Point de vie = " + healthPoints + ", Point d'attaque = " + attackPoints + ")";
    }
}
