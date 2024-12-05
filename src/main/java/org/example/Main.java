package org.example;

import org.example.characters.Hero;
import org.example.characters.SpecialCapacity;
import org.example.utils.Map;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("TP réalisé par William Pereira et Théo Lebiez!");

        ArrayList<Hero> heroes = new ArrayList<>();
        Hero artur = new Hero(100, 10, SpecialCapacity.HEALING);
        Hero lancelot = new Hero(95, 12, SpecialCapacity.MATRIX);
        Hero genievre = new Hero(90,15, SpecialCapacity.ONE_SHOT);
        heroes.add(artur);
        heroes.add(lancelot);
        heroes.add(genievre);

        ArrayList<Map> maps = new ArrayList<>();
        Map caermaloyw = new Map("Chateau Caermaloyw",1,7,7,1);
        Map taverne = new Map("Taverne du chat noir",1,4,4,1);
        maps.add(caermaloyw);
        maps.add(taverne);


        System.out.println("Liste des héros :");
        for (Hero hero : heroes) {
            System.out.println(hero.toString());
        }

        System.out.println("Liste des maps :");
        for (Map map : maps) {
            System.out.println(map.toString());
        }


    }
}