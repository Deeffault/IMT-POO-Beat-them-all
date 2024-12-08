package org.example.characters;

/**
 * This class represents a brigand enemy in the game.
 * A brigand has specific health points and attack points.
 */
public class Brigand extends Enemy {

    /**
     * Constructs a new Brigand with predefined health points and attack points.
     */
    public Brigand() {
        super(65, 10); // Specific stats for brigand
    }

    /**
     * Takes damage and reduces the brigand's health points.
     *
     * @param damage the amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        System.out.println("Le brigand reçoit " + damage + " dégâts !");
        super.takeDamage(damage);
    }

    /**
     * Returns a string representation of the brigand.
     *
     * @return a string representation of the brigand
     */
    @Override
    public String toString() {
        return "Brigand (Point de vie = " + healthPoints + ", Point d'attaque = " + attackPoints + ")";
    }
}