package Hearthstone;

public abstract class Hero implements Entity{
    private static int idCounter = 0;
    private int id;
    private String name;
    private int hp;
    private String heroPower;
    private int heroPowerCost;

    private int mana;

    public Hero(String name, int hp, String heroPower, int heroPowerCost) {
        this.id = idCounter++;
        this.name = name;
        this.hp = hp;
        this.heroPower = heroPower;
        this.heroPowerCost = heroPowerCost;
    }

    public abstract void useHeroPower(Entity target);

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getHeroPower() {
        return heroPower;
    }

    public int getHeroPowerCost() {
        return heroPowerCost;
    }

    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
}
