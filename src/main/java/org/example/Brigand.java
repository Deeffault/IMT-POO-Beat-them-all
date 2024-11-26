package org.example;

public class Brigand extends Ennemy {

    public Brigand() {
        super(50, 10); // Statistiques spécifiques au brigand
    }

    @Override
    public int attack() {
        System.out.println("Le brigand attaque avec sa massue !");
        return getAttackPoints();
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Le brigand reçoit " + damage + " dégâts !");
        super.takeDamage(damage);
    }
}
