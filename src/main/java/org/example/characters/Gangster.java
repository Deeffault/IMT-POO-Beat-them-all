package org.example.characters;

/**
 * This class represents a gangster enemy in the game.
 * A gangster has specific health points and attack points.
 */
public class Gangster extends Enemy {

    /**
     * Constructs a new Gangster with predefined health points and attack points.
     */
    public Gangster() {
        super(55, 15);
    }

    /**
     * Takes damage and reduces the gangster's health points.
     *
     * @param damage the amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        System.out.println("Le gangster reçoit " + damage + " dégâts !");
        super.takeDamage(damage);
    }

    /**
     * Returns a string representation of the gangster.
     *
     * @return a string representation of the gangster
     */
    @Override
    public String toString() {
        return "Gangster (Point de vie = " + healthPoints + ", Point d'attaque = " + attackPoints + ")";
    }
}