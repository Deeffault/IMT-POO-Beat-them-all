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
        logger.info("Application démarrée");

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
                hero = new Hero(270, 20, SpecialCapacity.HEALING);
                System.out.println("Vous avez choisi Artur Pendragon\n");
                logger.info("Le personnage choisi est Artur Pendragon");
                break;

            case 2:
                hero = new Hero(310, 16, SpecialCapacity.INVINCIBILITY);
                System.out.println("Vous avez choisi Lancelot du lac\n");
                logger.info("Le personnage choisi est Lancelot du lac");
                break;

            case 3:
                hero = new Hero(2300, 40, SpecialCapacity.ONE_SHOT);
                System.out.println("Vous avez choisi Genièvre\n");
                logger.info("Le personnage choisi est Genièvre");
                break;

            default:
                logger.info("Le choix  de personnage est invalide");
                throw new IllegalArgumentException("Choix invalide !\n");

        }
    }

    public static void mapChoice(int userChoice) {
        switch (userChoice) {

            case 1:
                map = new Map("Le Chateau Caermaloyw", 1, 7);
                System.out.println("Carte choisie : Chateau Caermaloyw\n");
                logger.info("La carte choisi est le Chateau de Caermaloyw");
                break;

            case 2:
                map = new Map("La Taverne du chat noir", 1, 4);
                System.out.println("Carte choisie : Taverne du chat noir\n");
                logger.info("La carte choisi est la Taverne du chat noir");
                break;
            case 42:
                map = new Map("Test", 1, 3);
                System.out.println("Carte de test\n"); //Map used for UT
                logger.info("Carte de test choisi");
                break;

            default:
                logger.info("La carte choisi est invalide");
                throw new IllegalArgumentException("Choix invalide !");
        }
    }

    public static void gamePlan() {
        while (!map.isEndOfMap() && hero.isAlive()) {
            Area currentArea = map.getCurrentArea();
            System.out.println("Vous arrivez dans la zone " + map.getCurrentPosition() + " de " + map.getName());
            logger.info("Le joueur est dans la zone {} de {}", map.getCurrentPosition(), map.getName());

            // get enemy types
            StringBuilder enemyTypes = new StringBuilder();
            for (Enemy enemy : currentArea.getEnemies()) {
                if (!enemyTypes.isEmpty()) {
                    enemyTypes.append(", ");
                }
                enemyTypes.append(enemy.getClass().getSimpleName());
            }

            System.out.println("Il y a " + currentArea.getNbEnemies() + " ennemis dans cette zone : "
                    + enemyTypes + ".\n");
            logger.info("Types des ennemis dans la zone {} : {}", map.getCurrentPosition(), enemyTypes);

            while (!currentArea.getEnemies().isEmpty()) {
                System.out.println(currentArea.getEnemies().getFirst() + " s'approche !\n");

                while (hero.isAlive() && currentArea.getEnemies().getFirst().isAlive()) {
                    Fight.heroAttackEnemy(hero, currentArea.getEnemies().getFirst());
                }

                if (!hero.isAlive()) {
                    System.out.println("GAME OVER ! Le héros est mort dans sa quête du Graal.");
                    return;
                }

                if (!currentArea.getEnemies().getFirst().isAlive()) {
                    System.out.println("L'ennemi est vaincu !\n");
                    currentArea.getEnemies().removeFirst();
                    logger.info("nb of enemies left : {}", currentArea.getEnemies().size());
                    logger.info(currentArea.getEnemies());
                }
            }

            if (hero.isAlive()) {
                map.moveToNextArea();
            }
        }

        if (hero.isAlive()) {
            System.out.println("Félicitations ! Vous avez atteint la fin de la carte "
                    + map.getName() + " et trouvé le Graal !");
        }
    }


}
