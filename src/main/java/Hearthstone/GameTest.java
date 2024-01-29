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


        // Joueur actuel joue la carte jusqu'à ce que le héros adversaire soit mis KO
        while (opponentPlayer.isAlive()) {
            currentPlayer.useHeroPower(opponentPlayer);
        }

        // Vérification si le héros adversaire est mis KO
        assertTrue(opponentPlayer.isDead());
    }
}


