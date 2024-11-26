package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

    @Test
    void heroAttackEnnemyWithoutSpecialCapacity() {
        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        Ennemy ennemy = new Brigand();

        Fight.heroAttackEnnemy(hero, ennemy);

        assertTrue(hero.getHealthPoints() < 100);
        assertTrue(ennemy.getHealthPoints() < 50);
    }

    @Test
    void heroAttackEnnemyWithOneShotSpecialCapacity() {
        Hero hero = new Hero(100, 15, SpecialCapacity.ONE_SHOT);
        Ennemy ennemy = new Brigand();

        Fight.heroAttackEnnemy(hero, ennemy);

        assertTrue(hero.getHealthPoints() <= 100);
        assertEquals(0, ennemy.getHealthPoints());
    }

    @Test
    void heroAttackGangster() {
        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        Ennemy gangster = new Gangster();

        Fight.heroAttackEnnemy(hero, gangster);

        assertTrue(hero.getHealthPoints() < 100);
        assertTrue(gangster.getHealthPoints() < 50);
    }

    @Test
    void heroUsesSpecialCapacity() {
        Hero hero = new Hero(100, 15, SpecialCapacity.HEALING);
        Ennemy ennemy = new Brigand();

        Fight.heroAttackEnnemy(hero, ennemy);

        assertTrue(hero.getHealthPoints() > 100);
        assertTrue(ennemy.getHealthPoints() < 50);
    }

    @Test
    void heroAttackEnnemyWithUserInput() {
        //FIXME: This test is not working

        // Emulate user input
        String userInput = "oui\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(userInput.getBytes()));

            Hero hero = new Hero(100, 15, SpecialCapacity.HEALING);
            Ennemy ennemy = new Brigand();

            Fight.heroAttackEnnemy(hero, ennemy);

            assertTrue(hero.getHealthPoints() > 100);
            assertTrue(ennemy.getHealthPoints() < 50);
        } finally {
            System.setIn(stdin);
        }
    }
}