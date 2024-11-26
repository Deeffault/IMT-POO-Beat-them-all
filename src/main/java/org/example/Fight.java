package org.example;

import java.util.Random;
import java.util.Scanner;

public class Fight {

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
                hero.useSpecalCapacity(ennemy);
                hero.isSpecialCapacityUsed = true;
            }
        }

        System.out.println("Le héros attaque " + attackCount + " fois !");
        for (int i = 0; i < attackCount && ennemy.isAlive(); i++) {
            int damage = hero.attack();
            ennemy.takeDamage(damage);
            System.out.println("L'ennemi a maintenant " + ennemy.getHealthPoints() + " PV !");
        }

        if (ennemy.isAlive() && !(ennemy instanceof Gangster)) {
            int enemyDamage = ennemy.attack();
            hero.takeDamage(enemyDamage);
            System.out.println("Le héros a maintenant " + hero.getHealthPoints() + " PV !");
        }
    }
}
