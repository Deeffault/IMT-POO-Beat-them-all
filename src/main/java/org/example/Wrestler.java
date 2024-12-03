package org.example;

/**
 * This class represents a wrestler enemy in the game.
 * A wrestler has specific health points and attack points.
 */
public class Wrestler extends Ennemy {

    /**
     * Constructs a new Wrestler with predefined health points and attack points.
     */
    public Wrestler() {
        super(100, 15);
    }

    /**
     * Performs an attack and returns the attack points.
     *
     * @return the attack points
     */
    @Override
    public int attack() {
        System.out.println("Le lutteur attaque avec un coup de poing !");
        return getAttackPoints();
    }

    /**
     * Takes damage and reduces the wrestler's health points.
     *
     * @param damage the amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        int reducedDamage = damage / 2;
        System.out.println("Le catcheur encaisse en réduisant les dégâts à " + reducedDamage + " !");
        super.takeDamage(reducedDamage);
    }
}