package Hearthstone;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {

    @Test
    public void testPlayCard() {
        // Création des instances nécessaires pour le test
        Board board = new Board();
        PlayerHeroPower playerHeroPower = new PlayerHeroPower("Mage");
        OpponentHeroPower opponentHeroPower = new OpponentHeroPower("Guerrier");
        PlayerHero currentPlayer = new PlayerHero("Joueur 1",20,playerHeroPower,1);
        OpponentHero opponentPlayer = new OpponentHero("Joueur 2",20,opponentHeroPower,1);
        board.setPlayerHero(currentPlayer);
        board.setOpponentHero(opponentPlayer);
        Monster monster = new Monster("Monstre Test", 2, 2, board,false);
        // Création d'une carte
        Card card = new Card("Carte d'invocation",1,"Invoque un monstre",monster,currentPlayer);
        Card card2 = new Card("Carte d'invocation",1,"Invoque un monstre",monster,opponentPlayer);

        // Création d'un monstre

        // Attribution du monstre à la carte

        // Attribution du plateau au monstre
        monster.setBoard(board);

        // Joueur actuel joue la carte
        card.playCard(currentPlayer);

        // Vérification si le monstre a été correctement ajouté à la liste du joueur actuel
        assertEquals(1, board.getPlayerMonsters().size());

        // Vérification si le monstre n'a pas été ajouté à la liste de l'opposant
        assertEquals(0, board.getOpponentMonsters().size());
    }
}

