package org.example;

import org.example.characters.*;
import org.example.utils.InputHandler;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

    @Test
    void ennemyDisappearsWhenDefeatedWithInput() {
        Main.mapChoice(42);

        Main.heroChoice(1);

        Enemy enemy = new Enemy(Main.hero.attackPoints, 0); // Ennemi faible pour être vaincu rapidement
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy);
        Main.map.getAreas().get(1).setEnemies(enemies);

        String userInput = """
                oui   // Interaction pour choisir d'utiliser la capacité spéciale
                \n      // Appuyer sur entrée pour continuer le combat
                \n      // Appuyer sur entrée pour passer à la zone suivante
                """;

        InputHandler inputHandler = new InputHandler(new Scanner(new ByteArrayInputStream(userInput.getBytes())));

        Main.gamePlan(inputHandler);
        assertEquals(0, enemy.getHealthPoints(), "The enemy should be defeated");
        assertTrue(Main.map.getAreas().get(1).getEnemies().isEmpty(), "The list of enemies should be empty");
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

        String userInput = """
                oui   // Interaction pour choisir d'utiliser la capacité spéciale
                \n      // Appuyer sur entrée pour continuer le combat
                \n      // Appuyer sur entrée pour passer à la zone suivante
                """;
        InputHandler inputHandler = new InputHandler(new Scanner(new ByteArrayInputStream(userInput.getBytes())));

        try {
            Main.gamePlan(inputHandler);

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