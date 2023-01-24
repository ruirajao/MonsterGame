package supernatural.strikeable.monster;

public class Vampire extends Monster {

    public Vampire() {
        super(MonsterType.VAMPIRE.getHitpoints(), MonsterType
                .VAMPIRE.getDamage(), MonsterType.VAMPIRE.getMonsterName());
    }

    public void recoverHealth(int healing){
        this.setHitpoints(this.getHitpoints()+healing);
    }
    @Override
    public int attackDamage() {
        if (bite() == 0) {
            this.recoverHealth((getDamage() / 2));
        }
        System.out.println("Vampire attacks for " + this.getDamage() + " damage.");
        return this.getDamage();
    }

    public int bite() {
        System.out.println("Vampire has bitten his target. He recovered " + (this.getDamage() / 2) + " hitpoints.");
        return (int) (Math.random() * 2);
    }
}