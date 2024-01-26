package Hearthstone;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Game {
    public Board playerBoard;
    public Board opponentBoard;
    private Hero playerHero;
    private Hero opponentHero;

    private List<Card> playerDeck;
    private List<Card> opponentDeck;

    public Game(Hero playerHero, Hero opponentHero) {
        this.playerBoard = new Board();
        this.opponentBoard = new Board();
        this.playerHero = playerHero;
        this.opponentHero = opponentHero;
        this.playerDeck = generateDeck();
        this.opponentDeck = generateDeck();
        distributeCards(playerDeck, playerHero);
        distributeCards(opponentDeck, opponentHero);
    }

    private List<Card> generateDeck() {
        // Logique pour générer une liste de cartes
        // Vous devrez personnaliser cette logique en fonction de vos besoins
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Monster monster = new Monster("Monstre " + i, 5, 3, playerBoard);
            Card card = new Card("Carte " + i, 2, "Description de la carte " + i, monster, playerHero);
            deck.add(card);
        }
        return deck;
    }

    private void distributeCards(List<Card> deck, Hero Hero) {
        // Logique pour distribuer des cartes au Hero
        for (int i = 0; i < 10; i++) {
            Card card = deck.remove(0); // Retirez la première carte du deck
            Hero.addCardToHand(card);
        }
    }

    // Méthode pour démarrer le jeu
    public void startGame() {

        System.out.println("Début du jeu.");
        opponentHero.setMana(1);
        playerHero.setMana(1);



        // Commencer les tours de jeu
        while (playerHero.isAlive() && opponentHero.isAlive()) {
            playTurn(playerHero, opponentHero, playerBoard, opponentBoard);
            playTurn(opponentHero, playerHero, opponentBoard, playerBoard);

        }

        // Afficher le résultat du jeu
        displayGameResult();
    }

    // Méthode pour simuler un tour de jeu
    private void playTurn(Hero currentHero, Hero opponentHero, Board currentBoard, Board opponentBoard) {
        opponentHero.setMana(opponentHero.getMana() + 1);
        currentHero.setMana(currentHero.getMana() + 1);
        System.out.println("Tour de " + currentHero.getName());

        System.out.println("Points de vie de " + currentHero.getName() + ": " + currentHero.getHp()+ "\n Points de mana: "+ currentHero.getMana()+"\n Que faire ? : \n 1- Utiliser le pouvoir du joueur \n 2- Jouer une carte \n 3- Passer le tour");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        if (choix == 1) {
            System.out.println("Vous avez choisi d'utiliser le pouvoir du joueur");
            currentHero.useHeroPower(opponentHero);
        } else if (choix == 2) {
            System.out.println("Vous avez choisi de jouer une carte");
            currentHero.viewHand();
            System.out.println("Choisissez une carte à jouer: ");
            int choixCarte = sc.nextInt();
            currentHero.playCard(choixCarte - 1, currentBoard, currentHero);

        } else if (choix == 3) {
            System.out.println("Vous avez choisi de passer le tour");
        }
        else if (choix == 4) {
            //afficher le board
            System.out.println("Vous avez choisi d'afficher le board");
            currentBoard.displayBoard(currentHero, opponentHero);

        }
        else {
            System.out.println("Choix invalide");
            System.exit(0);
        }
        // Poser une carte sur le plateau (simulé ici)


        // Vérifier si le Hero adverse est mis KO
        if (!opponentHero.isAlive()) {
            System.out.println("Le Hero " + opponentHero.getName() + " est mis KO. " + currentHero.getName() + " remporte la partie!");
            // Vous pouvez ajouter d'autres logiques ici
        }
    }

    private void displayGameResult() {
        System.out.println("Fin du jeu.");
        // Vous pouvez ajouter d'autres logiques ici pour afficher le résultat final
    }

    public static void main(String[] args) {
        // Créer les Heros
        String name = "";
        String name2 = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Liste des heros: \n 1- Mage \n 2- Guerrier");
        System.out.println("Joueur 1: Choisissez votre hero: ");
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
        System.out.println("Joueur 2: Choisissez votre hero: ");
        int choix2 = sc.nextInt();
        if (choix2 == 1) {
            System.out.println("Vous avez choisi le Mage");
            name2 = "Mage";
        } else if (choix2 == 2) {
            System.out.println("Vous avez choisi le Guerrier");
            name2 = "Guerrier";

        } else {
            System.out.println("Choix invalide");
            System.exit(0);
        }

        Hero playerHero = new PlayerHero(name, 20, new PlayerHeroPower(name), 2);
        Hero opponentHero = new OpponentHero(name2, 20, new OpponentHeroPower(name), 2);

        Game game = new Game(playerHero, opponentHero);
        game.startGame();
    }


}