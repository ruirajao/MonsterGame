package supernatural.strikeable;

public interface Strikeable {

    boolean isAlive();

    int getHitpoints();

    void takeDamage(int damage);
}