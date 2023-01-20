public class Vampire extends Monster {

    private final String name = "Vampire";

    public Vampire() {
        super(120, 20, "Vampire");
    }

    @Override
    public void attack(Monster target) {
        if (bite() == 0) {
            setHitpoints(getHitpoints() + (getDamage() / 2));
        }
        target.setHitpoints(target.getHitpoints() - this.getDamage());
        System.out.println("Vampire attacked " + target.getMonsterName() + " for " + this.getDamage() + " damage. \n" +
                target.getMonsterName() + " now has " + target.getHitpoints() + " hitpoints.");
        System.out.println(".".repeat(150));
    }

    public int bite() {
        System.out.println("Vampire has bitten his target. He recovered " + (this.getDamage() / 2) + " hitpoints.");
        return (int) (Math.random() * 2);
    }
}