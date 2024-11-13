package org.example;

public class Ennemy implements Character {

    public int healthPoints;
    public int attackPoints;

    public Ennemy(int healthPoints, int attackPoints) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    @Override
    public int attack() {
        return attackPoints;
    }

    @Override
    public boolean isAlive() {
        return healthPoints > 0;
    }

    @Override
    public void takeDamage(int damage) {
        healthPoints -= damage;
    }
}
