package supernatural.strikeable;

import supernatural.Supernatural;
import supernatural.strikeable.monster.Monster;

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
        return false;
    }

    @Override
    public int getHitpoints() {
        return 0;
    }

    @Override
    public void setHitpoints(int hitpoints) {
    }
}