package supernatural.strikeable.monster;

public class Vampire extends Monster {


    public Vampire() {
        super(MonsterType.WEREWOLF.getHitpoints(), MonsterType
                .WEREWOLF.getDamage(), MonsterType.WEREWOLF.getMonsterName());
    }

    @Override
    public void attack(Monster target) {
        if (bite() == 0) {
            setHitpoints(getHitpoints() + (getDamage() / 2));
        }
        target.setHitpoints(target.getHitpoints() - this.getDamage());
        System.out.println("supernatural.strikeable.monster.Vampire attacked " + target.getMonsterName() + " for " + this.getDamage() + " damage. \n" +
                target.getMonsterName() + " now has " + target.getHitpoints() + " hitpoints.");
        System.out.println(".".repeat(150));
    }

    public int bite() {
        System.out.println("supernatural.strikeable.monster.Vampire has bitten his target. He recovered " + (this.getDamage() / 2) + " hitpoints.");
        return (int) (Math.random() * 2);
    }
}