package supernatural.strikeable;

import supernatural.Supernatural;

public class Witch extends Supernatural implements Strikeable {

    private int hitpoints;
    private boolean isAlive;

    public Witch() {
        super(20, "Witch");
        this.hitpoints = 100;
        this.isAlive = true;
    }

    @Override
    public int attackDamage() {
        System.out.println("Witch attacks for " + this.getDamage() + " damage.");
        return this.getDamage();
    }

    @Override
    public boolean isAlive() {
        return this.hitpoints > 0;
    }

    @Override
    public int getHitpoints() {
        return this.hitpoints;
    }

    @Override
    public void takeDamage(int damage) {
        this.hitpoints -= damage;
        if (this.hitpoints <= 0) {
            isAlive = false;
        }
    }
}