package org.example;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.characters.Enemy;
import org.example.utils.Fight;
import org.example.utils.Map;
import org.example.utils.Area;
import org.example.characters.Hero;
import org.example.characters.SpecialCapacity;

public class Main {
    public static Hero hero;
    public static Map map;

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("TP réalisé par William Pereira et Théo Lebiez!");

        Scanner reader = new Scanner(System.in);
        logger.info("Application started");

        System.out.println("Bienvenue dans la quête du Graal");

        System.out.println(
                """
                        Choisissez votre personnage :\s
                        -1 Artur Pendragon (défaut)\
                        
                        -2 Lancelot, le fameux stratège\
                        
                        -3 Genièvre, la force incarnée"""
        );
        while (hero == null) {
            String input = reader.nextLine();
            int userHeroChoice = input.isEmpty() ? 1 : Integer.parseInt(input);
            heroChoice(userHeroChoice);
        }

        System.out.println(
                """
                        Où souhaitez vous aller chercher le Graal :\s
                        -1 Le chateau Caermaloyw (défaut)\
                        
                        -2 La Taverne du chat noir"""
        );
        while (map == null) {
            String input = reader.nextLine();
            int userMapChoice = input.isEmpty() ? 1 : Integer.parseInt(input);
            mapChoice(userMapChoice);
        }
        gamePlan();
    }

    public static void heroChoice(int userChoice) {
        switch (userChoice) {

            case 1:
                hero = new Hero(260, 20, SpecialCapacity.HEALING);
                System.out.println("Vous avez choisi Artur Pendragon\n");
                logger.info("Chosen character: Artur Pendragon");
                break;

            case 2:
                hero = new Hero(320, 15, SpecialCapacity.INVINCIBILITY);
                System.out.println("Vous avez choisi Lancelot du lac\n");
                logger.info("Chosen character: Lancelot of the Lake");
                break;

            case 3:
                hero = new Hero(230, 30, SpecialCapacity.ONE_SHOT);
                System.out.println("Vous avez choisi Genièvre\n");
                logger.info("Chosen character: Guinevere");
                break;

            default:
                logger.info("Invalid character choice");
                throw new IllegalArgumentException("Choix invalide !\n");

        }
    }

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

    public static void gamePlan() {
        while (!map.isEndOfMap() && hero.isAlive()) {
            // Affiche la carte et la position du héros
            map.displayMap();

            Area currentArea = map.getCurrentArea();
            System.out.println("Vous arrivez dans la zone " + map.getCurrentPosition() + " de " + map.getName() + "\n");
            logger.info("Player is in area {} of {}", map.getCurrentPosition(), map.getName());

            // Affiche les détails de la zone (ennemis présents)
            currentArea.displayArea();  // Ajout de l'affichage de la zone

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
                System.out.println(currentEnemy + " s'approche !\n");

                // Affichage graphique avant le combat
                printFightGraphic(hero, currentEnemy);

                while (hero.isAlive() && currentEnemy.isAlive()) {
                    // Lancement de l'attaque du héros
                    Fight.heroAttackEnemy(hero, currentEnemy);

                    // Affichage graphique après l'attaque
                    printFightGraphic(hero, currentEnemy);
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
                map.moveToNextArea();
            }
        }

        if (hero.isAlive()) {
            System.out.println("🎉 Félicitations ! Vous avez terminé la carte \""
                    + map.getName() + "\" et trouvé le Graal !");
            logger.info("Congratulations! Player has reached the end of the map {} and found the Grail.", map.getName());
        }
    }

    public static void printFightGraphic(Hero hero, Enemy enemy) {
        // Affichage des deux stickmen face à face

        System.out.println("\nÉtat du combat :");

        // Affichage des HP et des Points de Combat
        System.out.println("Héros : " + hero.getHealthPoints() + " HP | Combat Power: " + hero.getAttackPoints());
        System.out.println("Ennemi : " + enemy.getHealthPoints() + " HP | Combat Power: " + enemy.getAttackPoints());

        // Affichage des stickmen (Héros à gauche, Ennemi à droite)
        System.out.println("\nCombat :");
        System.out.println(" Héros     |     Ennemi ");
        System.out.println("  O        |       O  ");
        System.out.println(" /|\\       |      /|\\ ");
        System.out.println(" / \\       |      / \\ ");

        // Affichage des HP sous forme de barres
        System.out.print("HP: ");
        for (int i = 0; i < hero.getHealthPoints() / 10; i++) {
            System.out.print("|");
        }
        System.out.print("\nHP: ");
        for (int i = 0; i < enemy.getHealthPoints() / 10; i++) {
            System.out.print("|");
        }
        System.out.println();

        // Affichage des Points de Combat
        System.out.print("Combat Power: ");
        for (int i = 0; i < hero.getAttackPoints() / 10; i++) {
            System.out.print("!");
        }
        System.out.println();

        System.out.print("Combat Power: ");
        for (int i = 0; i < enemy.getAttackPoints() / 10; i++) {
            System.out.print("!");
        }
        System.out.println();
    }

}
