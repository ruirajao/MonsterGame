package supernatural.strikeable;

public interface Strikeable {

    boolean isAlive();

    int getHitpoints();

    void setHitpoints(int hitpoints);

    public abstract int getDamage();
}