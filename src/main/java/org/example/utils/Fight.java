package org.example.utils;

import org.example.characters.*;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents a fight between a hero and an enemy.
 * It contains methods to handle the attack logic and special capacity usage.
 */
public class Fight {
    private static final Logger logger = LogManager.getLogger(Fight.class);

    /**
     * Handles the attack logic between a hero and an enemy.
     * The hero can attack multiple times and use a special capacity if available.
     *
     * @param hero  the hero character
     * @param enemy the enemy character
     */
    public static void heroAttackEnemy(Hero hero, Enemy enemy, InputHandler inputHandler) {
        Random random = new Random();

        if (enemy instanceof Gangster && enemy.isAlive()) {
            System.out.println("Le Gangster tire sur le héro avant que celui-ci n'attaque !");
            int gangsterDamage = enemy.attack();
            hero.takeDamage(gangsterDamage);
            System.out.println("Le héros reçoit " + gangsterDamage + " dégâts !");
            logger.info("The hero received {} damages !", gangsterDamage);
            if (!hero.isAlive()) {
                System.out.println("Le héros est mort avant de pouvoir attaquer !");
                logger.info("The hero die before attacking");
                return;
            }
            System.out.println("Le héros a " + hero.getHealthPoints() + " points de vie restants !");
            logger.info("The hero has {} health points remaining", hero.getHealthPoints());
        }

        int attackCount = random.nextInt(5) + 1;
        logger.info("The hero attacks {} times", attackCount);

        if (!hero.isSpecialCapacityUsed) {
            String response = inputHandler.getInput("Voulez-vous utiliser votre capacité spéciale ? (oui/Non)");

            if ("oui".equalsIgnoreCase(response)) {
                System.out.println("Le héros utilise sa capacité spéciale : " + hero.getSpecialCapacity());
                logger.info("The hero use is special capacity : {}", hero.getSpecialCapacity());
                if (hero.getSpecialCapacity() == SpecialCapacity.HEALING) {
                    hero.useSpecialCapacity(hero);
                } else {
                    hero.useSpecialCapacity(enemy);
                    hero.isSpecialCapacityUsed = true;
                }
            }
        }

        System.out.println("Le héros attaque " + attackCount + " fois !");
        logger.info("The hero attacks {} time(s)", attackCount);
        for (int i = 0; i < attackCount && enemy.isAlive(); i++) {
            int damage = hero.attack();
            enemy.takeDamage(damage);
            logger.info(enemy.toString());
            if (!enemy.isAlive()) {
                logger.info("Enemy is dead");
                break;
            }
            System.out.println("L'ennemi a maintenant " + enemy.getHealthPoints() + " PV !");
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Sleep interrupted");
            }
        }

        if (enemy.isAlive() && !(enemy instanceof Gangster)) {
            if (enemy instanceof Wrestler) {
                System.out.println("Le catcheur attaque avec un coup de poing !");
            } else {
                System.out.println("Le brigand attaque avec sa massue !");
            }
            int enemyDamage = enemy.attack();
            System.out.println("Le héros reçoit " + enemyDamage + " dégâts !");
            hero.takeDamage(enemyDamage);
            if (!hero.isAlive()) {
                System.out.println("Le héros est mort avant de pouvoir attaquer !");
                logger.info("The hero die before attacking");
                return;
            }
            System.out.println("Le héros a maintenant " + hero.getHealthPoints() + " PV !");
            System.out.println("\n");
        }
    }
}