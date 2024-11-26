package org.example;

public class Hero implements Character {

    public int healthPoints;
    public int attackPoints;
    public SpecialCapacity specialCapacity;

    public boolean isSpecialCapacityUsed = false;

    public Hero(int healthPoints, int attackPoints, SpecialCapacity specialCapacity) {
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.specialCapacity = specialCapacity;
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

    public SpecialCapacity getSpecialCapacity() {
        return specialCapacity;
    }

    public void setSpecialCapacity(SpecialCapacity specialCapacity) {
        this.specialCapacity = specialCapacity;
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

    public void useSpecialCapacity(Character target) {
        switch (specialCapacity) {
            case HEALING:
                healthPoints += 10;
                isSpecialCapacityUsed = true;
                break;
//            case MATRIX:
//                healthPoints += 5;
//                isSpecialCapacityUsed = true;
//                break;
            case ONE_SHOT:
                if (target instanceof Ennemy) {
                    target.takeDamage(((Ennemy) target).getHealthPoints());
                    isSpecialCapacityUsed = true;
                }
                break;
        }
    }
}
