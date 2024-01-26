package Hearthstone;

public class Card {
    private String name;
    private int manaCost;
    private String description;
    private Monster monster;

    private Hero hero;

    public Card(String name, int manaCost, String description, Monster monster, Hero hero) {
        this.name = name;
        this.manaCost = manaCost;
        this.description = description;
        this.monster = monster;
        this.hero = hero;
    }

    public void playCard() {
        //first check if the player has enough mana
        //if not, print an error message and return
        //if yes, reduce the player's mana by the card's mana cost
        //then play the card's monster
       if (hero.getMana() < manaCost) {
           System.out.println("You don't have enough mana to play this card.");
           return;
       }
       hero.setMana(hero.getMana() - manaCost);
       monster.playTurn();

    }
}
