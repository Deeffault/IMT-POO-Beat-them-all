package org.example.characters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents a hero character in the game.
 * A hero has health points, attack points, and a special capacity.
 */
public class Hero implements Character {

    public int healthPoints;
    public int attackPoints;
    public SpecialCapacity specialCapacity;
    public boolean isSpecialCapacityUsed = false;

    /**
     * Constructs a new Hero with the specified health points, attack points, and special capacity.
     *
     * @param healthPoints    the health points of the hero
     * @param attackPoints    the attack points of the hero
     * @param specialCapacity the special capacity of the hero
     */
    public Hero(int healthPoints, int attackPoints, SpecialCapacity specialCapacity) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.specialCapacity = specialCapacity;
    }

    /**
     * Returns the health points of the hero.
     *
     * @return the health points of the hero
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Sets the health points of the hero.
     *
     * @param healthPoints the new health points of the hero
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Returns the attack points of the hero.
     *
     * @return the attack points of the hero
     */
    public int getAttackPoints() {
        return attackPoints;
    }

    /**
     * Sets the attack points of the hero.
     *
     * @param attackPoints the new attack points of the hero
     */
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    /**
     * Returns the special capacity of the hero.
     *
     * @return the special capacity of the hero
     */
    public SpecialCapacity getSpecialCapacity() {
        return specialCapacity;
    }

    /**
     * Sets the special capacity of the hero.
     *
     * @param specialCapacity the new special capacity of the hero
     */
    public void setSpecialCapacity(SpecialCapacity specialCapacity) {
        this.specialCapacity = specialCapacity;
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
     * Checks if the hero is alive.
     *
     * @return true if the hero is alive, false otherwise
     */
    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    /**
     * Takes damage and reduces the hero's health points.
     *
     * @param damage the amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        healthPoints -= damage;
    }

    /**
     * Uses the special capacity of the hero on the target.
     *
     * @param target the target character
     */
    public void useSpecialCapacity(Character target) {
        switch (specialCapacity) {
            case HEALING:
                healthPoints += 50;
                isSpecialCapacityUsed = true;
                break;
            case STUN:
                if (target instanceof Enemy) {
                    ((Enemy) target).setStunned(true);
                    System.out.println("\nL'ennemi est étourdi et ne fait plus de dégats pour le moment," +
                            " profitez-en pour l'attaquer !");
                    isSpecialCapacityUsed = true;
                }
                break;
            case ONE_SHOT:
                if (target instanceof Enemy) {
                    target.takeDamage(((Enemy) target).getHealthPoints());
                    isSpecialCapacityUsed = true;
                }
                break;
        }
    }

    /**
     * Returns a string representation of the hero.
     *
     * @return a string representation of the hero
     */
    @Override
    public String toString() {
        return "Hero{" +
                "healthPoints=" + healthPoints +
                ", attackPoints=" + attackPoints +
                ", specialCapacity=" + specialCapacity +
                ", isSpecialCapacityUsed=" + isSpecialCapacityUsed +
                '}';
    }
}