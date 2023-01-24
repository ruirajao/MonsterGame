package supernatural.strikeable.monster;

import supernatural.Supernatural;
import supernatural.strikeable.Strikeable;

public abstract class Monster extends Supernatural implements Strikeable {
    private int hitpoints;
    private boolean isAlive = true;

    public Monster(int hitpoints, int damage, String monsterName) {
        super(damage, monsterName);
        this.hitpoints = hitpoints;
    }

    public abstract int attackDamage();

    public void kill() {
        this.isAlive = false;
        System.out.println(this.getMonsterName() + " has been killed.");
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void takeDamage(int damage) {
        this.hitpoints -= damage;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
}