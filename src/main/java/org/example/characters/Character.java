package org.example.characters;

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
    int attack();

    /**
     * Checks if the character is alive.
     *
     * @return true if the character is alive, false otherwise
     */
    boolean isAlive();

    /**
     * Takes damage and reduces the character's health points.
     *
     * @param damage the amount of damage to take
     */
    void takeDamage(int damage);
}