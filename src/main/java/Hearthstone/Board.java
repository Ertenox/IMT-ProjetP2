package Hearthstone;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Hero playerHero;
    private Hero opponentHero;
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
    public Hero getOpponent(Monster monster) {

        if (monster.getBoard() == this) {
            return opponentHero;
        } else {
            return playerHero;
        }
    }

    public void displayBoard(Hero playerhero, Hero opponenthero) {
        System.out.println("Plateau du joueur:");
        displayHero(playerhero, playerMonsters);

        System.out.println("Plateau de l'adversaire:");
        displayHero(opponenthero, opponentMonsters);
    }

    private void displayHero(Hero hero, List<Monster> monsters) {
        if (hero == null) {
            System.out.println("Héros non défini.");
            return;
        }

        System.out.println("╔══════════════╗");
        System.out.println("║ " + centerString(hero.getName(), 14) + " ║");
        System.out.println("║ HP: " + centerString(Integer.toString(hero.getHp()), 10) + " ║");
        System.out.println("╠══════════════╣");

        if (monsters == null || monsters.isEmpty()) {
            System.out.println("║ Aucun monstre  ║");
        } else {
            for (int i = 0; i < monsters.size(); i++) {
                Monster monster = monsters.get(i);
                if (monster != null) {
                    String monsterInfo = String.format("║ %d. %s (HP: %d, ATT: %d) ║", i + 1, monster.getName(), monster.getHP(), monster.getAttack());
                    System.out.println(centerString(monsterInfo, 14));
                }
            }
        }

        System.out.println("╚══════════════╝");
    }

    private String centerString(String str, int length) {
        int pad = (length - str.length()) / 2;
        return String.format("%" + (pad + str.length()) + "s", str);
    }

}
