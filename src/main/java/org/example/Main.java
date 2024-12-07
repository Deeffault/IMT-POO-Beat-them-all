package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import org.example.utils.Fight;
import org.example.characters.Hero;
import org.example.characters.SpecialCapacity;


public class Main {
    private static Hero hero;
    private static Map map;

    public static void main(String[] args) {
        System.out.println("TP réalisé par William Pereira et Théo Lebiez!");

        Scanner reader = new Scanner(System.in);
        System.out.println("Bienvenue dans la quête du Graal");
        System.out.println("Choisissez votre personnage : \n-1 Artur Pendragon" +
                "\n-2 Lancelot, le fameux stratège" +
                "\n-3 Genièvre, la force incarnée");
        int userHeroChoice = reader.nextInt();
        heroChoice(userHeroChoice);

        System.out.println("Où souhaitez vous aller chercher le Graal : \n-1 Le chateau Caermaloyw" +
                "\n-2 La Taverne du chat noir");
        int userMapChoice = reader.nextInt();
        mapChoice(userMapChoice);

        gamePlan();
    }

    public static void heroChoice(int userchoice) {
        switch (userchoice) {
            case 1:
                hero = new Hero(250, 20, SpecialCapacity.HEALING);
                System.out.println("Vous avez choisi Artur Pendragon\n");
                break;
            case 2:
                hero = new Hero(270, 14, SpecialCapacity.MATRIX);
                System.out.println("Vous avez choisi Lancelot\n");
                break;
            case 3:
                hero = new Hero(2300, 40, SpecialCapacity.ONE_SHOT);
                System.out.println("Vous avez choisi Genièvre\n");
                break;
            default:
                throw new IllegalArgumentException("Choix invalide !\n");
        }
    }

    public static void mapChoice(int userchoice) {
        switch (userchoice) {
            case 1:
                map = new Map("Le Chateau Caermaloyw", 1, 7);
                System.out.println("Carte choisie : Chateau Caermaloyw\n");
                break;
            case 2:
                map = new Map("La Taverne du chat noir", 1, 4);
                System.out.println("Carte choisie : Taverne du chat noir\n");
                break;
            default:
                throw new IllegalArgumentException("Choix invalide !");
        }
    }

    public static void gamePlan() {
        while (!map.isEndOfMap() && hero.isAlive()) {
            Area currentArea = map.getCurrentArea();
            System.out.println("Vous êtes dans la zone " + map.getCurrentPosition() + " de " + map.getName());
            System.out.println("Il y a " + currentArea.getNbEnemies() + " ennemis dans cette zone.");// Peut on faire un getclass pour indiquer quels sont les enemies ?

            for (int i = 0; i <= currentArea.getNbEnemies() -1; i++) {
                System.out.println(currentArea.getEnemies().get(i)+" s'approche !");
                while (hero.isAlive() && currentArea.getEnemies().get(i).isAlive()) {
                    Fight.heroAttackEnnemy(hero, currentArea.getEnemies().get(i));
                }
                if (!hero.isAlive()) {
                    System.out.println("GAME OVER ! Le héros est mort dans sa quête du Graal.");
                    return;
                }
            }

            if (hero.isAlive()) {
                map.moveToNextArea();
            }
        }

        if (hero.isAlive()) {
            System.out.println("Félicitations ! Vous avez atteint la fin de la carte " + map.getName() + " et trouvé le Graal !");
        }
    }

}
