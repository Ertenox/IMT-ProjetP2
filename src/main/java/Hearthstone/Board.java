package Hearthstone;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Hero playerHero;
    private Hero opponentHero;
    private List<Monster> playerMonsters;
    private List<Monster> opponentMonsters;

    public Board() {
        playerMonsters = new ArrayList<Monster>();
        opponentMonsters = new ArrayList<Monster>();
    }

    // Méthode pour ajouter un monstre du joueur au plateau
    public void addPlayerMonster(Monster monster) {
        playerMonsters.add(monster);
    }

    // Méthode pour ajouter un monstre de l'adversaire au plateau
    public void addOpponentMonster(Monster monster) {
        opponentMonsters.add(monster);
    }

    // Méthode pour obtenir les monstres du joueur
    public List<Monster> getPlayerMonsters() {
        return playerMonsters;
    }

    // Méthode pour obtenir les monstres de l'adversaire
    public List<Monster> getOpponentMonsters() {
        return opponentMonsters;
    }

    // Méthode pour vérifier si le joueur a des monstres en vie
    public boolean playerHasMonstersAlive() {
        for (Monster monster : playerMonsters) {
            if (monster.isAlive()) {
                return true;
            }
        }
        return false;
    }

    // Méthode pour vérifier si l'adversaire a des monstres en vie
    public boolean opponentHasMonstersAlive() {
        for (Monster monster : opponentMonsters) {
            if (monster.isAlive()) {
                return true;
            }
        }
        return false;
    }
    public Hero getOpponent(Monster monster) {

        if (monster.getBoard() == this) {
            return opponentHero;
        } else {
            return playerHero;
        }
    }

    //supprimer le monstre du plateau si il est mort
    public void removeOpponentMonster(Monster monster) {
        opponentMonsters.remove(monster);
    }

    public void removePlayerMonster(Monster monster) {
        playerMonsters.remove(monster);
    }

    public void setPlayerHero(Hero playerHero) {
        this.playerHero = playerHero;
    }
    public void setOpponentHero(Hero opponentHero) {
        this.opponentHero = opponentHero;
    }



    public void displayBoard(Hero playerHero, Hero opponentHero) {
        System.out.println("Plateau de " + playerHero.getName() + ":");
        System.out.println("Héros: " + playerHero.getName() + " (" + playerHero.getHP() + " hp)");

        if (playerHero.getID() == 0) {
            if (playerMonsters.size() == 0) {
            }
            else {
                System.out.println("Monstres: ");
                displayPlayerMonsters();
            }
        } else {
            if (opponentMonsters.size() == 0) {
            }
            else {
                System.out.println("Monstres: ");
                displayOpponentMonsters();
            }
        }
    }

    public void resetMonstre() {
        for (Monster monster : playerMonsters) {
            monster.setHasAttacked(false);
        }
        for (Monster monster : opponentMonsters) {
            monster.setHasAttacked(false);
        }
    }

    public boolean displayPlayerMonsters() {
        if (playerMonsters.size() == 0) {
            return false;
        }

        for (int i = 0; i < playerMonsters.size(); i++) {
            Monster monster = playerMonsters.get(i);
            System.out.println((i + 1) + ". " + monster.getName() + " (" + monster.getAttack() + " attaque, " + monster.getHP() + " hp,)"+monster.getType());
        }
        if (playerMonsters.size() == 0) {
            return false;
        }
        return true;
    }

    public boolean displayOpponentMonsters() {
        if (opponentMonsters.size() == 0) {
            return false;
        }
        for (int i = 0; i < opponentMonsters.size(); i++) {
            Monster monster = opponentMonsters.get(i);
            System.out.println((i + 1) + ". " + monster.getName() + " (" + monster.getAttack() + " attaque, " + monster.getHP() + " hp)"+monster.getType());
        }
        if (opponentMonsters.size() == 0) {
            return false;
        }
        return true;
    }
}
