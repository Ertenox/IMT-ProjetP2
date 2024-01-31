package Hearthstone;

public class OpponentHero extends Hero{
    public OpponentHero( String name, int hp, OpponentHeroPower heroPower, int heroPowerCost){
        super(name, hp, heroPower, heroPowerCost);
    }

    @Override
    public void useHeroPower(Entity target) {
        if (getMana() < getHeroPowerCost()) {
            System.out.println("You don't have enough mana to use your hero power.");
            return;
        }
        setMana(getMana() - getHeroPowerCost());
        getHeroPower().usePower(this, target);

    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getHP() {

        return this.hp;
    }

    @Override
    public void setHP(int i) {
        this.hp = i;
    }
}
