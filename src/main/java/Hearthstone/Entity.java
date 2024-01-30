package Hearthstone;

public interface Entity {
    int getID();
    String getName();
    int getHP();
    void takeDamage(int damage);
    boolean isAlive();

    void setHP(int i);
}
