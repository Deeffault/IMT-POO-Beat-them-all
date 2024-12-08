package org.example;

import org.example.characters.Enemy;
import org.example.characters.Hero;
import org.example.characters.SpecialCapacity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void attack() {
        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        int attackPoints = hero.attack();
        assertEquals(15, attackPoints);
    }

    @Test
    void isAlive() {
        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        assertTrue(hero.isAlive());
        hero.setHealthPoints(0);
        assertFalse(hero.isAlive());
    }

    @Test
    void takeDamage() {
        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        hero.takeDamage(10);
        assertEquals(90, hero.getHealthPoints());
    }

    @Test
    void useSpecialCapacityHealing() {
        Hero hero = new Hero(100, 15, SpecialCapacity.HEALING);
        hero.useSpecialCapacity(hero);
        assertEquals(150, hero.getHealthPoints());
    }

    @Test
    void useSpecialCapacityOneShot() {
        Hero hero = new Hero(100, 15, SpecialCapacity.ONE_SHOT);
        Enemy target = new Enemy(100, 15);

        hero.useSpecialCapacity(target);
        assertFalse(target.isAlive());
    }

    @Test
    void useSpecialCapacityStun() {
        Hero hero = new Hero(100, 15, SpecialCapacity.STUN);
        Enemy target = new Enemy(100, 15);

        hero.useSpecialCapacity(target);
        assertTrue(target.isStunned());

        target.attack();
        assertEquals(100, hero.getHealthPoints());
    }
}