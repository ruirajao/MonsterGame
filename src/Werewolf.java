public class Werewolf extends Monster {

    public Werewolf() {
        super(100, 30, "Werewolf");
    }

    @Override
    public void attack(Monster target) {
        target.setHitpoints(target.getHitpoints() - this.getDamage());
        System.out.println("Werewolf attacked " + target.getMonsterName() + " for " + this.getDamage() + " damage. \n" +
                target.getMonsterName() + " now has " + target.getHitpoints() + " hitpoints.");
        System.out.println(".".repeat(150));
    }
}