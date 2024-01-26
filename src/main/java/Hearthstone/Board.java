package Hearthstone;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Monster> playerMonsters;
    private List<Monster> opponentMonsters;

    public Board() {
        playerMonsters = new ArrayList<>();
        opponentMonsters = new ArrayList<>();
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

}
