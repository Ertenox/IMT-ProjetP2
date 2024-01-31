package Hearthstone;

public class PlayerHero extends Hero{
    public PlayerHero(String name, int hp, PlayerHeroPower heroPower, int heroPowerCost){
        super(name, hp, heroPower, heroPowerCost);
    }

    @Override
    public void useHeroPower(Entity target) {
        if (getMana() < getHeroPowerCost()) {
            System.out.println("Pas assez de mana pour le pouvoir.");
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
