public class Mummy extends Monster {

    private int attackCounter;

    public Mummy() {
        super(200, 50, "Mummy");
    }

    @Override
    public void attack(Monster target) {
        attackCounter++;
        if (attackCounter == 3) {
            this.setHitpoints(this.getHitpoints() - this.getDamage() / 2);
            System.out.println("Mummy failed the attack and got some bandages unrolled. It took "
                    + (this.getDamage() / 2) + " damage.");
            attackCounter = 0;
            return;
        }
        target.setHitpoints(target.getHitpoints() - this.getDamage());
        System.out.println("Mummy attacked " + target.getMonsterName() + " for " + this.getDamage() + " damage. \n" +
                target.getMonsterName() + " now has " + target.getHitpoints() + " hitpoints.");
        System.out.println(".".repeat(150));

    }

}