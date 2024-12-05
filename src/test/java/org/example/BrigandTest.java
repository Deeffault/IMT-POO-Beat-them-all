package org.example;

import org.example.characters.Brigand;
import org.example.characters.Hero;
import org.example.characters.SpecialCapacity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrigandTest {

    @Test
    void attack() {
        Brigand brigand = new Brigand();
        int attackPoints = brigand.attack();
        assertEquals(10, attackPoints);

        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        hero.takeDamage(attackPoints);
        assertEquals(90, hero.getHealthPoints());
    }

    @Test
    void takeDamage() {
        Brigand brigand = new Brigand();
        brigand.takeDamage(10);
        assertEquals(40, brigand.getHealthPoints());

        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        hero.attack();
    }
}