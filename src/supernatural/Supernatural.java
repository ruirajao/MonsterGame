package supernatural;

public abstract class Supernatural {

    private final int damage;
    private final String monsterName;

    public Supernatural(int damage, String monsterName) {
        this.damage = damage;
        this.monsterName = monsterName;
    }

    public abstract int attackDamage();

    public int getDamage() {
        return damage;
    }

    public String getMonsterName() {
        return monsterName;
    }
}