package Hearthstone;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Game {
    public Board playerBoard;
    public Board opponentBoard;
    private PlayerHero playerHero;
    private OpponentHero opponentHero;

    private List<Card> playerDeck;
    private List<Card> opponentDeck;

    public Game(PlayerHero playerHero, OpponentHero opponentHero) {
        this.playerBoard = new Board();
        this.opponentBoard = new Board();
        this.playerHero = playerHero;
        this.opponentHero = opponentHero;
        this.playerDeck = generateDeckPlayer();
        this.opponentDeck = generateDeckOpponent();
        distributeCardsPlayer(playerDeck, playerHero);
        distributeCardsOpponent(opponentDeck, opponentHero);
    }

    private List<Card> generateDeckPlayer() {
        List<Card> deckPlayer = new ArrayList<>();
        Monster Acolyte1 = new Monster("Acolyte de la mort ", 4, 3, playerBoard);
        Monster Baron1 = new Monster("Baron vaillefendre ", 2, 2, playerBoard);
        Monster Chevalier = new Monster("Chevalier de la mort ", 4, 4, playerBoard);
        Card card = new Card("Acolyte de la mort ", 3, "Mort vivant", Acolyte1, playerHero);
        Card card2 = new Card("Baron vaillefendre ", 2, "Mort vivant", Baron1, playerHero);
        Card card3 = new Card("Chevalier de la mort ", 4, "Mort vivant", Chevalier, playerHero);
        deckPlayer.add(card);
        deckPlayer.add(card2);
        deckPlayer.add(card3);
        return deckPlayer;
    }

    private List<Card> generateDeckOpponent() {
        List<Card> deckOpponent = new ArrayList<>();
        Monster Acolyte2 = new Monster("Acolyte de la mort ", 4, 3, opponentBoard);
        Monster Baron2 = new Monster("Baron vaillefendre ", 2, 2, opponentBoard);
        Monster Chevalier = new Monster("Chevalier de la mort ", 4, 4, opponentBoard);
        Card card = new Card("Acolyte de la mort ", 3, "Mort vivant", Acolyte2, opponentHero);
        Card card2 = new Card("Baron vaillefendre ", 2, "Mort vivant", Baron2, opponentHero);
        Card card3 = new Card("Chevalier de la mort ", 4, "Mort vivant", Chevalier, opponentHero);
        deckOpponent.add(card);
        deckOpponent.add(card2);
        deckOpponent.add(card3);
        return deckOpponent;
    }

    private void distributeCardsPlayer(List<Card> deck, PlayerHero Hero) {
        // Logique pour distribuer des cartes au Joueur1
        for (int i = 0; i < 3; i++) {
            Card card = deck.remove(0); // Retirez la première carte du deck
            Hero.addCardToHand(card);
        }
    }
    private void distributeCardsOpponent(List<Card> deck, OpponentHero Hero) {
        // Logique pour distribuer des cartes au joueur 2
        for (int i = 0; i < 3; i++) {
            Card card = deck.remove(0); // Retirez la première carte du deck
            Hero.addCardToHand(card);
        }
    }

    // Méthode pour démarrer le jeu
    public void startGame() {

        System.out.println("Début du jeu.");
        opponentHero.setMana(1);
        playerHero.setMana(1);

        int manaMax = 1;


        // Commencer les tours de jeu
        while (playerHero.isAlive() && opponentHero.isAlive()) {
            //compter le nombre de tours
            manaMax++;
            playTurn(playerHero, opponentHero, playerBoard, opponentBoard,manaMax);
            playTurn(opponentHero, playerHero, opponentBoard, playerBoard,manaMax);

        }

        // Afficher le résultat du jeu
        displayGameResult();
    }

    // Méthode pour simuler un tour de jeu
    private void playTurn(Hero currentHero, Hero opponentHero, Board currentBoard, Board opponentBoard, int tour) {
        if(tour > 9){
            currentHero.setMana(9);
        }
        else {
            currentHero.setMana(tour);
        }



        //Méthode pour afficher le board
        currentBoard.displayBoard(currentHero, opponentHero);
        opponentBoard.displayBoard(opponentHero, currentHero);
        System.out.println("Tour de " + currentHero.getName());
        System.out.println("Points de vie de " + currentHero.getName() + ": " + currentHero.getHP()+ "\n Points de mana: "+ currentHero.getMana()+"\n Que faire ? : \n 1- Utiliser le pouvoir du joueur \n 2- Jouer une carte \n 3- Passer le tour \n 4- Attaquer avec un monstre");

        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        if (choix == 1) {
            System.out.println("Vous avez choisi d'utiliser le pouvoir du joueur");
            //afficher les cibles possibles sur le board

            System.out.println("Choisissez une cible: ");
            System.out.println("1- Hero adverse");
            for (int i = 0; i < opponentBoard.getPlayerMonsters().size(); i++) {
                System.out.println(i + 2 + "- " + opponentBoard.getPlayerMonsters().get(i).getName());
            }
            int choixCible = sc.nextInt();
            if (choixCible == 1) {
                currentHero.useHeroPower(opponentHero);
            } else if (choixCible > 1 && choixCible <= opponentBoard.getPlayerMonsters().size() + 1) {
                currentHero.useHeroPower(opponentBoard.getPlayerMonsters().get(choixCible - 2));
            } else {
                System.out.println("Choix invalide");
                System.exit(0);
            }

        } else if (choix == 2) {
            System.out.println("Vous avez choisi de jouer une carte");
            currentHero.viewHand();
            System.out.println("Choisissez une carte à jouer: ");
            int choixCarte = sc.nextInt();
            currentHero.playCard(choixCarte - 1, currentBoard, currentHero);

        } else if (choix == 3) {
            System.out.println("Vous avez choisi de passer le tour");
        }
        else if (choix == 4){
            System.out.print("Quel monstre va attaquer ? : ");
            if (currentHero.getID() == 0){
                currentBoard.displayPlayerMonsters();
                Scanner sc2 = new Scanner(System.in);
                int choixMonstre = sc2.nextInt();
                if (choixMonstre > 0 && choixMonstre <= currentBoard.getPlayerMonsters().size()){
                    System.out.println("Choisissez une cible: ");
                    System.out.println("1- Hero adverse");
                    for (int i = 0; i < opponentBoard.getPlayerMonsters().size(); i++) {
                        System.out.println(i + 2 + "- " + opponentBoard.getPlayerMonsters().get(i).getName());
                    }
                    int choixCible = sc.nextInt();
                    if (choixCible == 1) {
                        currentBoard.getPlayerMonsters().get(choixMonstre-1).attack(opponentHero);
                    } else if (choixCible > 1 && choixCible <= opponentBoard.getPlayerMonsters().size() + 1) {
                        currentBoard.getPlayerMonsters().get(choixMonstre-1).attack(opponentBoard.getPlayerMonsters().get(choixCible - 2));
                    } else {
                        System.out.println("Choix invalide");
                        System.exit(0);
                    }
                }
                else {
                    System.out.println("Choix invalide");
                    System.exit(0);
                }
                    currentBoard.getPlayerMonsters().get(choixMonstre-1).attack(opponentHero);
                }
                else {
                    System.out.println("Choix invalide");
                    System.exit(0);
                }
            }
            else if (currentHero.getID() == 1){
                currentBoard.displayOpponentMonsters();
                Scanner sc2 = new Scanner(System.in);
                int choixMonstre = sc2.nextInt();
                if (choixMonstre > 0 && choixMonstre <= currentBoard.getOpponentMonsters().size()){
                    System.out.println("Choisissez une cible: ");
                    System.out.println("1- Hero adverse");
                    for (int i = 0; i < opponentBoard.getPlayerMonsters().size(); i++) {
                        System.out.println(i + 2 + "- " + opponentBoard.getPlayerMonsters().get(i).getName());
                    }
                    int choixCible = sc.nextInt();
                    if (choixCible == 1) {
                        currentBoard.getOpponentMonsters().get(choixMonstre-1).attack(opponentHero);
                    } else if (choixCible > 1 && choixCible <= opponentBoard.getPlayerMonsters().size() + 1) {
                        currentBoard.getOpponentMonsters().get(choixMonstre-1).attack(opponentBoard.getPlayerMonsters().get(choixCible - 2));
                    } else {
                        System.out.println("Choix invalide");
                        System.exit(0);
                    }
                }
                else {
                    System.out.println("Choix invalide");
                    System.exit(0);
                }
                }
                else {
                    System.out.println("Choix invalide");
                    System.exit(0);
            }





        // Vérifier si le Hero adverse est mis KO
        if (!opponentHero.isAlive()) {
            System.out.println("Le Hero " + opponentHero.getName() + " est mis KO. " + currentHero.getName() + " remporte la partie!");
        }
    }

    private void displayGameResult() {
        System.out.println("Fin du jeu.");

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

        PlayerHero playerHero = new PlayerHero(name, 20, new PlayerHeroPower(name), 2);
        OpponentHero opponentHero = new OpponentHero(name2, 20, new OpponentHeroPower(name), 2);


        Game game = new Game(playerHero, opponentHero);
        game.startGame();
    }


}