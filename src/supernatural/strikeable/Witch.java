package supernatural.strikeable;

import supernatural.Supernatural;
import supernatural.strikeable.monster.Monster;

public class Witch extends Supernatural implements Strikeable {


    public Witch(int damage, String monsterName) {
        super(damage, monsterName);
    }

    @Override
    public void attack(Monster target) {

    }
}
