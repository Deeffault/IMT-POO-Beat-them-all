package org.example;

import org.example.characters.*;
import org.example.utils.Fight;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class FightTest {

    private static final Logger logger = LogManager.getLogger(FightTest.class);

    @Test
    void heroAttackGangster() {
        Hero hero = new Hero(100, 15, SpecialCapacity.NONE);
        Enemy gangster = new Gangster();

        Fight.heroAttackEnemy(hero, gangster);

        assertTrue(hero.getHealthPoints() < 100);
        assertTrue(gangster.getHealthPoints() < 50);
    }

    @Test
    void ennemyDisappearsWhenDefeatedWithInput() {
        Main.mapChoice(42); // Map only created for test
        Main.heroChoice(1);

        Enemy enemy = new Enemy(Main.hero.attackPoints, 0);
        ArrayList<Enemy> ennemies = new ArrayList<>();
        ennemies.add(enemy);

        Main.map.getAreas().get(1).setEnemies(ennemies);
        logger.info(Main.map.getAreas().get(1).getNbEnemies());
        assertEquals(1, Main.map.getAreas().get(1).getNbEnemies(), "The area should have 1 enemy");

        // simulate user input to "oui"
        String userInput = "oui\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(userInput.getBytes())); // redirect the input stream

            Main.gamePlan();

            assertTrue(
                    Main.map.getAreas().get(1).getEnemies().isEmpty(),
                    "The list of ennemies should be empty"
            );
        } finally {
            System.setIn(stdin);    // Restore the original standard output stream after the test

        }
    }

    @Test
    void heroDieAndGameIsOver() {
        // Set up a weak hero with minimal health and attack power
        Hero hero = new Hero(1, 1, SpecialCapacity.NONE);
        Main.hero = hero;

        Main.mapChoice(42);
        // Simulate user input to ensure the hero does not use the special capacity
        System.setIn(new ByteArrayInputStream("non\n".getBytes())); // Simulate the user typing "non" and pressing Enter

        // Redirect standard output to capture the game's console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Save the original standard output stream
        System.setOut(new PrintStream(outputStream)); // Redirect standard output to the ByteArrayOutputStream

        try {
            Main.gamePlan();

            assertFalse(hero.isSpecialCapacityUsed, "The special capacity should not have been used.");

            // Retrieve the captured console output as a string
            String output = outputStream.toString();

            assertTrue(output.contains("GAME OVER ! Le héros est mort dans sa quête du Graal."),
                    "The defeat message should be displayed when the hero dies.");
        } finally {
            // Restore the original standard output stream after the test
            System.setOut(originalOut);
        }
    }
}