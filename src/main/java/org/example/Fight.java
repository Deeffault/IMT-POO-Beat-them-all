package org.example;

import java.util.Random;
import java.util.Scanner;

/**
 * This class represents a fight between a hero and an enemy.
 * It contains methods to handle the attack logic and special capacity usage.
 */
public class Fight {

    /**
     * Handles the attack logic between a hero and an enemy.
     * The hero can attack multiple times and use a special capacity if available.
     *
     * @param hero   the hero character
     * @param ennemy the enemy character
     */
    public static void heroAttackEnnemy(Hero hero, Ennemy ennemy) {
        Random random = new Random();

        if (ennemy instanceof Gangster && ennemy.isAlive()) {
            int gangsterDammage = ennemy.attack();

            hero.takeDamage(gangsterDammage);
            System.out.println("Le héros reçoit " + gangsterDammage + " dégâts !");
            System.out.println("Le héros a " + hero.getHealthPoints() + " points de vie restants !");
        }

        int attackCount = random.nextInt(5) + 1;

        if (!hero.isSpecialCapacityUsed) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Voulez vous utiliser votre capacité spéciale ? (oui/non)");
            String response = scanner.nextLine();

            if (response.equals("oui")) {
                System.out.println("Le héros utilise sa capacité spéciale : " + hero.getSpecialCapacity());
                hero.useSpecialCapacity(ennemy);
                hero.isSpecialCapacityUsed = true;
            }
        }

        System.out.println("Le héros attaque " + attackCount + " fois !");
        for (int i = 0; i < attackCount && ennemy.isAlive(); i++) {
            int damage = hero.attack();
            System.out.println("Le héros inflige " + damage + " dégâts !");
            ennemy.takeDamage(damage);
            System.out.println("L'ennemi a maintenant " + ennemy.getHealthPoints() + " PV !");
        }

        if (ennemy.isAlive() && !(ennemy instanceof Gangster)) {
            int enemyDamage = ennemy.attack();
            System.out.println("Le héros reçoit " + enemyDamage + " dégâts !");
            hero.takeDamage(enemyDamage);
            System.out.println("Le héros a maintenant " + hero.getHealthPoints() + " PV !");
        }
    }
}