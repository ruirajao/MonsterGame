package supernatural.strikeable.monster;

public class Werewolf extends Monster {

    public Werewolf() {
        super(MonsterType.WEREWOLF.getHitpoints(), MonsterType
                .WEREWOLF.getDamage(), MonsterType.WEREWOLF.getMonsterName());
    }

    @Override
    public void attack(Monster target) {
        target.setHitpoints(target.getHitpoints() - this.getDamage());
        System.out.println("supernatural.strikeable.monster.Werewolf attacked " + target.getMonsterName() + " for " + this.getDamage() + " damage. \n" +
                target.getMonsterName() + " now has " + target.getHitpoints() + " hitpoints.");
        System.out.println(".".repeat(150));
    }

}