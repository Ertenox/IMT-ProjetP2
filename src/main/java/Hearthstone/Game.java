package Hearthstone;
import java.util.Scanner;
public class Game {
    private Board playerBoard;
    private Board opponentBoard;
    private Hero playerHero;
    private Hero opponentHero;

    public Game(Hero playerHero, Hero opponentHero) {
        this.playerBoard = new Board();
        this.opponentBoard = new Board();
        this.playerHero = playerHero;
        this.opponentHero = opponentHero;
    }

    // Méthode pour démarrer le jeu
    public void startGame() {
        // Initialiser le plateau, les Heros, etc.
        System.out.println("Début du jeu.");
        opponentHero.setMana(1);
        playerHero.setMana(1);



        // Commencer les tours de jeu
        while (playerHero.isAlive() && opponentHero.isAlive()) {
            playTurn(playerHero, opponentHero, playerBoard, opponentBoard);
            playTurn(opponentHero, playerHero, opponentBoard, playerBoard);
            // Vous pouvez ajouter d'autres logiques ici selon les règles du jeu
        }

        // Afficher le résultat du jeu
        displayGameResult();
    }

    // Méthode pour simuler un tour de jeu
    private void playTurn(Hero currentHero, Hero opponentHero, Board currentBoard, Board opponentBoard) {
        // Afficher des informations sur l'état du jeu
        System.out.println("Tour de " + currentHero.getName());

        // Utiliser la capacité spéciale du Hero
        currentHero.useHeroPower(opponentHero);

        // Poser une carte sur le plateau (simulé ici)
        Card card = new Card("Nom de la carte", 1, "Carte",  new Monster("1", 1, 5),currentHero);
        card.playCard();

        // Jouer le tour pour chaque monstre sur le plateau
        for (Monster monster : currentBoard.getPlayerMonsters()) {
            monster.playTurn();
        }

        // Vérifier si le Hero adverse est mis KO
        if (!opponentHero.isAlive()) {
            System.out.println("Le Hero " + opponentHero.getName() + " est mis KO. " + currentHero.getName() + " remporte la partie!");
            // Vous pouvez ajouter d'autres logiques ici
        }
    }

    // Méthode pour afficher le résultat du jeu
    private void displayGameResult() {
        System.out.println("Fin du jeu.");
        // Vous pouvez ajouter d'autres logiques ici pour afficher le résultat final
    }

    public static void main(String[] args) {
        // Créer les Heros
        String name = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Liste des heros: \n 1- Mage \n 2- Guerrier");
        System.out.println("Choisissez votre hero: ");
        int choix = sc.nextInt();
        if (choix == 1) {
            System.out.println("Vous avez choisi le Mage");
             name = "Mage";
        } else if (choix == 2) {
            System.out.println("Vous avez choisi le Guerrier");
             name = "Guerrier";

        } else {
            System.out.println("Choix invalide");
            System.exit(0);
        }
        System.out.println("Vous avez choisi le " + name);

        Hero playerHero = new PlayerHero(name, 20, new PlayerHeroPower(name), 2);
        Hero opponentHero = new OpponentHero(name, 20, new OpponentHeroPower(name), 2);

        Game game = new Game(playerHero, opponentHero);
        game.startGame();
    }
}