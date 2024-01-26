package Hearthstone;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero implements Entity{
    private static int idCounter = 0;
    private int id;
    private String name;
    private int hp;
    private HeroPower heroPower;
    private int heroPowerCost;

    private int mana;

    private List<Card> hand = new ArrayList<>();

    public Hero(String name, int hp, HeroPower heroPower, int heroPowerCost) {
        this.id = idCounter++;
        this.name = name;
        this.hp = hp;
        this.heroPower = heroPower;
        this.heroPowerCost = heroPowerCost;
        this.hand = new ArrayList<>();
    }

    public abstract void useHeroPower(Entity target);
    public void addCardToHand(Card card) {
        // Ajouter la carte à la main du champion
        hand.add(card);
    }
    public void viewHand() {
        // Afficher la main du champion
        System.out.println("Main de " + getName() + ":");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ". " + hand.get(i).getName());
        }
    }

    public void playCard(int cardIndex, Board board) {
        // Vérifier si l'index est valide
        if (cardIndex >= 0 && cardIndex < hand.size()) {
            // Récupérer la carte à jouer
            Card cardToPlay = hand.remove(cardIndex);

            // Jouer la carte sur le plateau
            cardToPlay.playCard();
        } else {
            System.out.println("Index de carte invalide.");
        }
    }

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

    public HeroPower getHeroPower() {
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
    public Hero getHero() {
        return this;
    }
}
