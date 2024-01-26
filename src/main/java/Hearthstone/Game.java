package Hearthstone;

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
        // ...

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
        Card card = new Card("Nom de la carte", new Monster(1, "Nom du monstre", 5, 3, MonsterType.CLASSIC, currentBoard));
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
        // Exemple d'utilisation de la classe Game
        Hero playerHero = new Hero(1, "Joueur", 30, new ());
        Hero opponentHero = new Hero(2, "Adversaire", 30, new OpponentSpecialAbility());

        Game game = new Game(playerHero, opponentHero);
        game.startGame();
    }
}