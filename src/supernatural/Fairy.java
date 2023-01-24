package supernatural;

import supernatural.strikeable.monster.Monster;

public class Fairy extends Supernatural {

    public Fairy() {
        super(50, "Fairy");
    }

    @Override
    public int attackDamage() {
        System.out.println("Fairy attacks for " + this.getDamage() + " damage.");
        return this.getDamage();
    }
}