package supernatural;

import supernatural.strikeable.monster.Monster;

public class Fairy extends Supernatural {

    public Fairy() {
        super(50, "Lulu");
    }

    @Override
    public int attackDamage() {
        System.out.println("Lulu attack for " + this.getDamage() + " damage.");
        return this.getDamage();
    }
}