package supernatural.strikeable;

import supernatural.Supernatural;
import supernatural.strikeable.monster.Monster;

public class Witch extends Supernatural implements Strikeable {

    private int hitpoints;
    private boolean isAlive;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

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
        return isAlive;
    }

    @Override
    public int getHitpoints() {
        return this.hitpoints;
    }

    @Override
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
        if (this.hitpoints <= 0) {
            isAlive = false;
        }
    }
}