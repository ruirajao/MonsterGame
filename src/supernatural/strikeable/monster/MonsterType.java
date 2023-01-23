package supernatural.strikeable.monster;

public enum MonsterType {
    WEREWOLF("Warwick",150, 30),
    WEREWOLF("Vladimir",120, 20),
    MUMMY("Amumu",200, 50);

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
