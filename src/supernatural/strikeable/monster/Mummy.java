package supernatural.strikeable.monster;

public class Mummy extends Monster {

    private int attackCounter;

    public Mummy() {
        super(MonsterType.MUMMY.getHitpoints(), MonsterType
                .MUMMY.getDamage(), MonsterType.MUMMY.getMonsterName());
    }

    @Override
    public int attack() {
        attackCounter++;
        if (attackCounter == 3) {
            this.setHitpoints(this.getHitpoints() - this.getDamage() / 2);
            System.out.println("supernatural.strikeable.monster.Mummy failed the attack and got some bandages unrolled. It took "
                    + (this.getDamage() / 2) + " damage.");
            attackCounter = 0;
            return 0;
        }
        System.out.println("Amumu attacks for " + this.getDamage() + " damage.");
        System.out.println(".".repeat(150));
        return this.getDamage();
    }
}