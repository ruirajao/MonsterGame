package supernatural.strikeable.monster;

public enum MonsterType {
    WEREWOLF("Werewolf",150, 30),
    VAMPIRE ("Vampire",120, 20),
    MUMMY("Mummy",200, 50);

    private String monsterName;
    private int hitpoints;
    private int damage;

    MonsterType(String monsterName, int hitpoints, int damage) {
        this.monsterName = monsterName;
        this.hitpoints = hitpoints;
        this.damage = damage;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public int getDamage() {
        return damage;
    }

    public String getMonsterName() {
        return monsterName;
    }
}
