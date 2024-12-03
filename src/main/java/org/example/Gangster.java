package org.example;

/**
 * This class represents a gangster enemy in the game.
 * A gangster has specific health points and attack points.
 */
public class Gangster extends Ennemy {

    /**
     * Constructs a new Gangster with predefined health points and attack points.
     */
    public Gangster() {
        super(60, 15);
    }

    /**
     * Performs an attack and returns the attack points.
     *
     * @return the attack points
     */
    @Override
    public int attack() {
        System.out.println("Le gangster tire sur le héros avant qu'il n'approche !");
        return getAttackPoints();
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
}