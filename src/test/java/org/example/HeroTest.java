package org.example;

import org.example.characters.Ennemy;
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
        assertEquals(110, hero.getHealthPoints());
    }

    @Test
    void useSpecialCapacityOneShot() {
        Hero hero = new Hero(100, 15, SpecialCapacity.ONE_SHOT);
        Ennemy target = new Ennemy(100, 15);

        hero.useSpecialCapacity(target);
        assertFalse(target.isAlive());
    }

    @Test
    void useSpecialCapacityRage() {
        Hero hero = new Hero(100, 15, SpecialCapacity.RAGE);
        Ennemy target = new Ennemy(100, 15);

        hero.useSpecialCapacity(target);
        assertEquals(30, hero.attack());

        hero.attack();
        assertEquals(70, target.getHealthPoints() );

        hero.attack();
        assertEquals(40, target.getHealthPoints() );

        hero.attack();
        assertEquals(10, target.getHealthPoints() );

        hero.attack();
        assertFalse(target.isAlive());
    }
}