package org.example.characters;

/**
 * This class represents an enemy character in the game.
 * An enemy has health points and attack points.
 */
public class Enemy implements Character {

    /**
     * The health points of the enemy.
     */
    public int healthPoints;

    /**
     * The attack points of the enemy.
     */
    public int attackPoints;

    /**
     * Constructs a new Enemy with the specified health points and attack points.
     *
     * @param healthPoints the health points of the enemy
     * @param attackPoints the attack points of the enemy
     */
    public Enemy(int healthPoints, int attackPoints) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
    }

    /**
     * Returns the health points of the enemy.
     *
     * @return the health points of the enemy
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Sets the health points of the enemy.
     *
     * @param healthPoints the new health points of the enemy
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Returns the attack points of the enemy.
     *
     * @return the attack points of the enemy
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * Sets the attack points of the enemy.
     *
     * @param attackPoints the new attack points of the enemy
     */
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    /**
     * Performs an attack and returns the attack points.
     *
     * @return the attack points
     */
    @Override
    public int attack() {
        return attackPoints;
    }

    /**
     * Checks if the enemy is alive.
     *
     * @return true if the enemy is alive, false otherwise·
     */
    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * Takes damage and reduces the enemy's health points.
     *
     * @param damage the amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        healthPoints -= damage;
    }

    @Override
    public String toString() {
        return "Ennemi (Point de vie = " + healthPoints + ", Point d'attaque = " + attackPoints + ")";
    }
}