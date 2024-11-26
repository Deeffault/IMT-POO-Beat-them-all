package org.example;

public class Gangster extends Ennemy {

    public Gangster() {
        super(60, 15); // Statistiques spécifiques au gangster
    }

    @Override
    public int attack() {
        System.out.println("Le gangster tire sur le héros avant qu'il n'approche !");
        return getAttackPoints();
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Le gangster reçoit " + damage + " dégâts !");
        super.takeDamage(damage);
    }
}
