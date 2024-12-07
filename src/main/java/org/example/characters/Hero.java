package org.example.characters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents a hero character in the game.
 * A hero has health points, attack points, and a special capacity.
 */
public class Hero implements org.example.characters.Character {

    private static final Logger logger = LogManager.getLogger(Hero.class);

    public int healthPoints;
    public int attackPoints;
    public SpecialCapacity specialCapacity;
    public boolean isSpecialCapacityUsed = false;

    /**
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
        return healthPoints >= 0;
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
                healthPoints += 10;
                isSpecialCapacityUsed = true;
                break;
            case RAGE:
//                while (target.isAlive()) {
//                    int originalAttackPoints = attackPoints;
//                    attackPoints *= 2;
//                    logger.info("ennemy is alive" + target.isAlive());
//                    if (!target.isAlive()) {
//                        attackPoints = originalAttackPoints;
//                        isSpecialCapacityUsed = true;
//                        break;
//                    }
//                }
            case ONE_SHOT:
                if (target instanceof Ennemy) {
                    target.takeDamage(((Ennemy) target).getHealthPoints());
                    isSpecialCapacityUsed = true;
                }
                break;
        }
    }

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