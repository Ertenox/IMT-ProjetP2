package Hearthstone;

public class Monster implements Entity, Attacker{
    private static int idCounter = 0;
    private int id;
    private String name;
    private int hp;
    private int attack;

public Monster(String name, int hp, int attack) {
        this.id = idCounter++;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public void playTurn() {
        System.out.println("Monster " + this.name + " is playing its turn.");

    }

    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }



    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public void attack(Entity target) {
        target.takeDamage(this.attack);
    }
}
