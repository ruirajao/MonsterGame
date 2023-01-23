package supernatural.strikeable.monster;

import supernatural.Supernatural;
import supernatural.strikeable.Strikeable;

public abstract class Monster extends Supernatural implements Strikeable {
    private int hitpoints;


    public Monster(int hitpoints, int damage, String monsterName) {
        super(damage, monsterName);
        this.hitpoints = hitpoints;
    }

    public abstract int attack();
    public boolean isAlive() {
        if (this.hitpoints > 0) {
            return true;
        }
        return false;
    }
    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    /*public int getDamage() {
        return damage;
    }

    public String getMonsterName() {
        return monsterName;
    }*/
}
