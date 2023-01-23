package supernatural;

import supernatural.strikeable.monster.Monster;

public class Fairy extends Supernatural {

    public Fairy() {
        super(50, "Lulu");
    }

    @Override
    public int attack() {
        System.out.println("Lulu attack for " + this.getDamage() + " damage.");
        System.out.println(".".repeat(150));
        return this.getDamage();
    }
}