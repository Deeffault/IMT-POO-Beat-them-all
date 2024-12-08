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
        super(50, 10); // Specific stats for brigand
    }

    /**
     * Performs an attack and returns the attack points.
     *
     * @return the attack points
     */
    @Override
    public int attack() {
        System.out.println("Le brigand attaque avec sa massue !");
        return getAttackPoints();
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

    @Override
    public String toString() {
        return "Brigand (Point de vie = " + healthPoints + ", Point d'attaque = " + attackPoints + ")";
    }
}