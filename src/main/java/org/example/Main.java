package org.example;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.characters.Enemy;
import org.example.utils.Fight;
import org.example.utils.InputHandler;
import org.example.utils.Map;
import org.example.utils.Area;
import org.example.characters.Hero;
import org.example.characters.SpecialCapacity;

/**
 * The Main class is the entry point of the application.
 * It initializes the game, allows the user to choose a hero and a map,
 * and manages the game flow.
 */
public class Main {
    public static Hero hero;
    public static Map map;

    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     * The main method that starts the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("TP réalisé par William Pereira et Théo Lebiez!");

        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        logger.info("Application started");

        System.out.println("Bienvenue dans la quête du Graal");

        while (hero == null) {
            String input = inputHandler.getInput("""
                    Choisissez votre personnage :
                    - 1 Artur Pendragon (défaut)
                    - 2 Lancelot, le fameux stratège
                    - 3 Genièvre, la force incarnée
                    Votre choix :""");
            int userHeroChoice = input.isEmpty() ? 1 : Integer.parseInt(input);
            heroChoice(userHeroChoice);
        }

        while (map == null) {
            String input = inputHandler.getInput("""
                    Où souhaitez-vous aller chercher le Graal :
                    - 1 Le château Caermaloyw (défaut)
                    - 2 La Taverne du chat noir
                    Votre choix :""");
            int userMapChoice = input.isEmpty() ? 1 : Integer.parseInt(input);
            mapChoice(userMapChoice);
        }

        gamePlan(inputHandler);
    }

    /**
     * Allows the user to choose a hero based on the input.
     *
     * @param userChoice the user's choice of hero
     */
    public static void heroChoice(int userChoice) {
        switch (userChoice) {

            case 1:
                hero = new Hero(260, 15, SpecialCapacity.HEALING);
                System.out.println("Vous avez choisi Artur Pendragon\n");
                logger.info("Chosen character: Artur Pendragon");
                break;

            case 2:
                hero = new Hero(290, 10, SpecialCapacity.STUN);
                System.out.println("Vous avez choisi Lancelot du lac\n");
                logger.info("Chosen character: Lancelot of the Lake");
                break;

            case 3:
                hero = new Hero(230, 20, SpecialCapacity.ONE_SHOT);
                System.out.println("Vous avez choisi Genièvre\n");
                logger.info("Chosen character: Guinevere");
                break;

            default:
                logger.info("Invalid character choice");
                throw new IllegalArgumentException("Choix invalide !\n");

        }
    }

    /**
     * Allows the user to choose a map based on the input.
     *
     * @param userChoice the user's choice of map
     */
    public static void mapChoice(int userChoice) {
        switch (userChoice) {

            case 1:
                map = new Map("Le Chateau Caermaloyw", 1, 7);
                System.out.println("Carte choisie : Chateau Caermaloyw\n");
                logger.info("Chosen map: Caermaloyw Castle");
                break;

            case 2:
                map = new Map("La Taverne du chat noir", 1, 4);
                System.out.println("Carte choisie : Taverne du chat noir\n");
                logger.info("Chosen map: The Tavern of the Black Cat");
                break;

            case 42:
                map = new Map("Test", 1, 3);
                System.out.println("Carte de test\n"); // Map used for unit tests
                logger.info("Chosen map: Test map");
                break;

            default:
                logger.info("Invalid map choice");
                throw new IllegalArgumentException("Choix invalide !");
        }
    }

    /**
     * Manages the game flow, including moving through the map and handling fights.
     */
    public static void gamePlan(InputHandler inputHandler) {
        while (!map.isEndOfMap() && hero.isAlive()) {
            map.displayMap();

            Area currentArea = map.getCurrentArea();
            System.out.println("Vous arrivez dans la zone " + map.getCurrentPosition() + " de " + map.getName() + "\n");
            logger.info("Player is in area {} of {}", map.getCurrentPosition(), map.getName());

            currentArea.displayArea();

            // Get enemy types
            StringBuilder enemyTypes = new StringBuilder();
            for (Enemy enemy : currentArea.getEnemies()) {
                if (!enemyTypes.isEmpty()) {
                    enemyTypes.append(", ");
                }
                enemyTypes.append(enemy.getClass().getSimpleName());
            }

            logger.info("Enemies in area {}: {}", map.getCurrentPosition(), enemyTypes);

            while (!currentArea.getEnemies().isEmpty()) {
                Enemy currentEnemy = currentArea.getEnemies().getFirst();
                System.out.println(currentEnemy + " s'approche !");

                printFightGraphic(hero, currentEnemy);

                while (hero.isAlive() && currentEnemy.isAlive()) {
                    Fight.heroAttackEnemy(hero, currentEnemy, inputHandler);

                    printFightGraphic(hero, currentEnemy);

                    inputHandler.getInput("Appuyez sur Entrée pour continuer le combat...");
                }

                if (!hero.isAlive()) {
                    System.out.println("💀 GAME OVER ! Le héros est mort dans sa quête du Graal.");
                    logger.info("GAME OVER! The hero has died in the quest for the Grail.");
                    return;
                }

                if (!currentEnemy.isAlive()) {
                    System.out.println("\n╔══════════════════════════════╗");
                    System.out.println("║    L'ennemi est vaincu !     ║");
                    System.out.println("╚══════════════════════════════╝\n");
                    logger.info("Enemy defeated. Remaining enemies: {}", currentArea.getEnemies().size());
                    currentArea.getEnemies().removeFirst();
                }
            }

            if (hero.isAlive()) {
                inputHandler.getInput("Appuyez sur Entrée pour passer à la zone suivante...");
                map.moveToNextArea();
            }
        }

        if (hero.isAlive()) {
            System.out.println("🎉 Félicitations ! Vous avez terminé la carte \""
                    + map.getName() + "\" et trouvé le Graal !");
            logger.info("Congratulations! Player has reached the end of the map {} and found the Grail.",
                    map.getName()
            );
        }
    }

    /**
     * Prints a simple graphic representation of the fight between the hero and the enemy.
     *
     * @param hero  the hero character
     * @param enemy the enemy character
     */
    public static void printFightGraphic(Hero hero, Enemy enemy) {
        System.out.println("\nCombat :");
        System.out.println(" Héros     |     Ennemi ");
        System.out.println("  O        |       O  ");
        System.out.println(" /|\\       |      /|\\ ");
        System.out.println(" / \\       |      / \\ ");

        System.out.print("HP du héro: ");
        for (int i = 0; i < hero.getHealthPoints() / 10; i++) {
            System.out.print("|");
        }
        if (hero.getHealthPoints() > 0) {
            System.out.print(" (" + hero.getHealthPoints() + ")");
        }
        System.out.print("\nHP de l'ennemi: ");
        for (int i = 0; i < enemy.getHealthPoints() / 10; i++) {
            System.out.print("|");
        }
        if (enemy.getHealthPoints() > 0) {
            System.out.print(" (" + enemy.getHealthPoints() + ")");
        }
        System.out.println();
    }

}