package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void attack() {
        Hero hero = new Hero(100, 15, SpecialCapacity.ONE_SHOT);
        int attackPoints = hero.attack();
        assertEquals(15, attackPoints);
    }

    @Test
    void isAlive() {
        Hero hero = new Hero(100, 15, SpecialCapacity.ONE_SHOT);
        assertTrue(hero.isAlive());
        hero.setHealthPoints(0);
        assertFalse(hero.isAlive());
    }

    @Test
    void takeDamage() {
        Hero hero = new Hero(100, 15, SpecialCapacity.ONE_SHOT);
        hero.takeDamage(10);
        assertEquals(90, hero.getHealthPoints());
    }

    @Test
    void useSpecalCapacity() {
        Hero hero = new Hero(100, 15, SpecialCapacity.HEALING);
        hero.useSpecalCapacity(new Brigand());
        assertEquals(110, hero.getHealthPoints());
    }
}