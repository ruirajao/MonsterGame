package supernatural.strikeable.monster;

public class Werewolf extends Monster {

    public Werewolf() {
        super(MonsterType.WEREWOLF.getHitpoints(), MonsterType
                .WEREWOLF.getDamage(), MonsterType.WEREWOLF.getMonsterName());
    }

    @Override
    public int attackDamage() {
        System.out.println("Werewolf attacks for " + this.getDamage() + " damage.");
        return this.getDamage();
    }
}