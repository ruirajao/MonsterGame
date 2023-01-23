package supernatural.strikeable.monster;

public class Werewolf extends Monster {

    public Werewolf() {
        super(MonsterType.WEREWOLF.getHitpoints(), MonsterType
                .WEREWOLF.getDamage(), MonsterType.WEREWOLF.getMonsterName());
    }

    @Override
    public int attack() {
        System.out.println("Warwick attacks for " + this.getDamage() + " damage.");
        System.out.println(".".repeat(150));
        return this.getDamage();
    }

}