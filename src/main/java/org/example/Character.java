package org.example;

/**
 * This interface represents a character in the game.
 * A character can attack, check if it is alive, and take damage.
 */
public interface Character {

    /**
     * Performs an attack and returns the attack points.
     *
     * @return the attack points
     */
    public int attack();

    /**
     * Checks if the character is alive.
     *
     * @return true if the character is alive, false otherwise
     */
    public boolean isAlive();

    /**
     * Takes damage and reduces the character's health points.
     *
     * @param damage the amount of damage to take
     */
    public void takeDamage(int damage);
}