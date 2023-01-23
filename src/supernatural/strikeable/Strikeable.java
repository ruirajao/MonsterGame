package supernatural.strikeable;

public interface Strikeable {

     default boolean isAlive() {
        if (getHitpoints > 0) {
            return true;
        }
        return false;
    }


    public abstract int getDamage();
}
