package supernatural.strikeable;

import supernatural.Supernatural;
import supernatural.strikeable.monster.Monster;

public class Witch extends Supernatural implements Strikeable {


    public Witch(int damage, String monsterName) {
        super(damage, monsterName);
    }

    @Override
    public int attack() {

        System.out.println("Morgana attack for " + this.getDamage() + " damage.");
        System.out.println(".".repeat(150));
        return this.getDamage();

    }
}
