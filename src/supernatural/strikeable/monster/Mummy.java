package supernatural.strikeable.monster;

public class Mummy extends Monster {

    private int attackCounter;

    public Mummy() {
        super(MonsterType.MUMMY.getHitpoints(), MonsterType
                .MUMMY.getDamage(), MonsterType.MUMMY.getMonsterName());
    }

    @Override
    public int attackDamage() {
        attackCounter++;
        if (attackCounter == 3) {
            this.takeDamage(this.getDamage() / 2);
            System.out.println("Mummy failed the attack and got some bandages unrolled. It took "
                    + (this.getDamage() / 2) + " damage.");
            attackCounter = 0;
            return 0;
        }
        System.out.println("Mummy attacks for " + this.getDamage() + " damage.");
        return this.getDamage();
    }
}