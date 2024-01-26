package Hearthstone;

public class PlayerHero extends Hero{
    public PlayerHero(String name, int hp, PlayerHeroPower heroPower, int heroPowerCost){
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
        return 0;
    }

    @Override
    public int getHP() {
        return 0;
    }
}
