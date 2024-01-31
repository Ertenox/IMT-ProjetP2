package Hearthstone;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testHeroKnockout() {
        // Création des instances nécessaires pour le test
        Board board = new Board();
        PlayerHeroPower playerHeroPower = new PlayerHeroPower("Mage");
        OpponentHeroPower opponentHeroPower = new OpponentHeroPower("Guerrier");
        PlayerHero currentPlayer = new PlayerHero("Joueur 1", 20, playerHeroPower, 0);
        OpponentHero opponentPlayer = new OpponentHero("Joueur 2", 20, opponentHeroPower, 1);
        board.setPlayerHero(currentPlayer);
        board.setOpponentHero(opponentPlayer);
        // Joueur utilise son pouvoir jusqu'à ce que le héros adversaire soit mis KO
        while (opponentPlayer.isAlive()) {
            currentPlayer.useHeroPower(opponentPlayer);
        }

        // Vérification si le héros adversaire est mis KO
        assertTrue(opponentPlayer.isDead());
    }

    @Test
    public void testMonstreKnockout(){
        // Création des instances nécessaires pour le test
        Board board = new Board();
        PlayerHeroPower playerHeroPower = new PlayerHeroPower("Mage");
        OpponentHeroPower opponentHeroPower = new OpponentHeroPower("Guerrier");
        PlayerHero currentPlayer = new PlayerHero("Joueur 1", 20, playerHeroPower, 0);
        OpponentHero opponentPlayer = new OpponentHero("Joueur 2", 20, opponentHeroPower, 0);
        board.setPlayerHero(currentPlayer);
        board.setOpponentHero(opponentPlayer);
        Monster monster = new Monster("Monstre", 5, 2, board, true, "Neutre");

        Monster monster1 = new Monster("Monstre", 2, 3, board, true, "Neutre");
        board.addPlayerMonster(monster);
        board.addOpponentMonster(monster1);
        // Joueur actuel joue la carte jusqu'à ce que le héros adversaire soit mis KO

        monster1.attack(monster);



        // Vérification si le héros adversaire est mis KO
        assertEquals(2, monster.getHP());
    }

    @Test
    public void testMonsterHero(){
// Création des instances nécessaires pour le test
        Board board = new Board();
        PlayerHeroPower playerHeroPower = new PlayerHeroPower("Mage");
        OpponentHeroPower opponentHeroPower = new OpponentHeroPower("Guerrier");
        PlayerHero currentPlayer = new PlayerHero("Joueur 1", 20, playerHeroPower, 0);
        OpponentHero opponentPlayer = new OpponentHero("Joueur 2", 20, opponentHeroPower, 0);
        board.setPlayerHero(currentPlayer);
        board.setOpponentHero(opponentPlayer);
        Monster monster = new Monster("Monstre", 5, 20, board, false, "Neutre");

        board.addPlayerMonster(monster);
        // Joueur actuel joue la carte jusqu'à ce que le héros adversaire soit mis KO

        while (opponentPlayer.isAlive()) {
            monster.attack(opponentPlayer);
        }
        board.removePlayerMonster(monster);
        // Vérification si le héros adversaire est mis KO
        assertTrue(opponentPlayer.isDead());
    }

    @Test
    public void testRemoveMonster(){
        Board board = new Board();
        PlayerHeroPower playerHeroPower = new PlayerHeroPower("Mage");
        OpponentHeroPower opponentHeroPower = new OpponentHeroPower("Guerrier");
        PlayerHero currentPlayer = new PlayerHero("Joueur 1", 20, playerHeroPower, 0);
        OpponentHero opponentPlayer = new OpponentHero("Joueur 2", 20, opponentHeroPower, 0);
        board.setPlayerHero(currentPlayer);
        board.setOpponentHero(opponentPlayer);
        Monster monster = new Monster("Monstre", 5, 20, board, false, "Neutre");

        board.addPlayerMonster(monster);

        assertEquals(1, board.getPlayerMonsters().size());
        board.removePlayerMonster(monster);
        assertEquals(0, board.getPlayerMonsters().size());
    }

}


