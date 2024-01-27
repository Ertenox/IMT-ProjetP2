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

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void playCard(Hero currentHero) {
        // Logique pour jouer la carte
        System.out.println("La carte " + name + " est jouée.");

        // Invoquer le monstre sur le plateau
        Board currentBoard = monster.getBoard();
        if (currentHero.getID() == 0){
            currentBoard.addPlayerMonster(monster);
        }
        else if (currentHero.getID() == 1){
            currentBoard.addOpponentMonster(monster);
        }
        System.out.println("Le monstre " + monster.getName() + " est invoqué sur le plateau.");
    }
}
