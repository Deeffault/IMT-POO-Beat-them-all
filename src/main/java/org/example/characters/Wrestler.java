package org.example.characters;

/**
 * The Wrestler class represents a specific type of enemy in the game.
 * Wrestlers have reduced damage intake compared to other enemies.
 */
public class Wrestler extends Enemy {

    /**
     * Constructs a new Wrestler with predefined health points and attack points.
     */
    public Wrestler() {
        super(80, 10);
    }

    /**
     * Takes damage and reduces the damage by half before applying it to the wrestler.
     *
     * @param damage the amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        int reducedDamage = damage / 2; // Reduces the received damage
        System.out.println("Le catcheur encaisse en réduisant les dégâts à " + reducedDamage + " !");
        super.takeDamage(reducedDamage);
    }

    /**
     * Returns a string representation of the wrestler.
     *
     * @return a string representation of the wrestler
     */
    @Override
    public String toString() {
        return "Wrestler (Point de vie = " + healthPoints + ", Point d'attaque = " + attackPoints + ")";
    }
}