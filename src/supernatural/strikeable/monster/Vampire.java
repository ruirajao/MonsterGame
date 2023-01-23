package supernatural.strikeable.monster;

public class Vampire extends Monster {


    public Vampire() {
        super(MonsterType.VAMPIRE.getHitpoints(), MonsterType
                .VAMPIRE.getDamage(), MonsterType.VAMPIRE.getMonsterName());
    }

    @Override
    public int attack() {
        if (bite() == 0) {
            setHitpoints(getHitpoints() + (getDamage() / 2));
        }

        System.out.println("Vladimir attacks for " + this.getDamage() + " damage.");
        System.out.println(".".repeat(150));
        return this.getDamage();
    }

    public int bite() {
        System.out.println("supernatural.strikeable.monster.Vampire has bitten his target. He recovered " + (this.getDamage() / 2) + " hitpoints.");
        return (int) (Math.random() * 2);
    }
}