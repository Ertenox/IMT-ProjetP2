package Hearthstone;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
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
        Monster Acolyte1 = new Monster("Acolyte de la mort ", 4, 3, playerBoard,true, "normal");
        Monster Baron1 = new Monster("Baron vaillefendre ", 2, 2, playerBoard,true, "provoke");
        Monster Chevalier = new Monster("Chevalier de la mort ", 4, 4, playerBoard,true, "normal");
        Monster MagmaDog = new Monster("Chien de magma ", 5, 9, playerBoard,true, "normal");
        Card card = new Card("Acolyte de la mort ", 3, "Mort vivant", Acolyte1, playerHero);
        Card card2 = new Card("Baron vaillefendre ", 2, "Mort vivant", Baron1, playerHero);
        Card card3 = new Card("Chevalier de la mort ", 4, "Mort vivant", Chevalier, playerHero);
        Card card4 = new Card("Chien de magma ", 7, "Bête", MagmaDog, playerHero);
        deckPlayer.add(card);
        deckPlayer.add(card2);
        deckPlayer.add(card3);
        deckPlayer.add(card4);
        return deckPlayer;
    }

    private List<Card> generateDeckOpponent() {
        List<Card> deckOpponent = new ArrayList<>();
        Monster Acolyte2 = new Monster("Acolyte de la mort ", 4, 3, opponentBoard,true, "normal");
        Monster Baron2 = new Monster("Baron vaillefendre ", 2, 2, opponentBoard,true, "provoke");
        Monster Chevalier = new Monster("Chevalier de la mort ", 4, 4, opponentBoard,true,"normal");
        Monster Murloc = new Monster("Murloc ", 2, 1, opponentBoard,true, "normal");
        Card card = new Card("Acolyte de la mort ", 3, "Mort vivant", Acolyte2, opponentHero);
        Card card2 = new Card("Baron vaillefendre ", 2, "Mort vivant", Baron2, opponentHero);
        Card card3 = new Card("Chevalier de la mort ", 4, "Mort vivant", Chevalier, opponentHero);
        Card card4 = new Card("Murloc ", 1, "Murloc", Murloc, opponentHero);

        deckOpponent.add(card);
        deckOpponent.add(card2);
        deckOpponent.add(card3);
        deckOpponent.add(card4);
        return deckOpponent;
    }

    private void distributeCardsPlayer(List<Card> deck, PlayerHero Hero) {
        // Logique pour distribuer des cartes au Joueur1`
        for (int i = 0; i < deck.size(); i++) {
            Card card = deck.get(i);
            //ajouter une carte à la main du joueur
            Hero.addCardToHand(card);
        }
    }
    private void distributeCardsOpponent(List<Card> deck, OpponentHero Hero) {
        // Logique pour distribuer des cartes au joueur 2
        for (int i = 0; i < deck.size(); i++) {
            Card card = deck.get(i); // Retirez la première carte du deck
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

        while (currentHero.getMana() > 0) {
            //Méthode pour afficher le board
            opponentBoard.displayOpponentMonsters();
            currentBoard.displayBoard(currentHero, opponentHero);
            opponentBoard.displayBoard(opponentHero, currentHero);
            System.out.println("Tour de " + currentHero.getName());
            System.out.println("Points de vie de " + currentHero.getName() + ": " + currentHero.getHP()+ "\n Points de mana: "+ currentHero.getMana()+"\n Que faire ? : \n 1- Utiliser le pouvoir du joueur \n 2- Jouer une carte \n 3- Passer le tour \n 4- Attaquer avec un monstre");

            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            if (choix == 1) {
                if(currentHero.getID()==1){
                    System.out.println("Vous avez choisi d'utiliser le pouvoir du joueur");
                    //afficher les cibles possibles sur le board
                    List<Monster> provokers = new ArrayList<Monster>();
                    for (int i = 0; i < opponentBoard.getPlayerMonsters().size(); i++) {
                        if (opponentBoard.getPlayerMonsters().get(i).getType() == "provoke") {
                            System.out.println(i + 1 + "- " + opponentBoard.getPlayerMonsters().get(i).getName());
                            provokers.add(opponentBoard.getPlayerMonsters().get(i));
                        }
                    }
                    if (provokers.size() > 0) {
                        System.out.println("Des provocateurs sont sur le terrain, Choisissez une cible: ");
                        int choixCible = sc.nextInt();
                        if (choixCible > 0 && choixCible <= provokers.size()) {
                            currentHero.useHeroPower(provokers.get(choixCible - 1));
                        } else {
                            System.out.println("Choix invalide");
                            continue;
                        }
                    } else {
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
                            continue;
                        }

                    }

                }
                else if (currentHero.getID()==0) {
                    System.out.println("Vous avez choisi d'utiliser le pouvoir du joueur");

                    List<Monster> provokers = new ArrayList<Monster>();
                    for (int i = 0; i < opponentBoard.getOpponentMonsters().size(); i++) {
                        if (opponentBoard.getOpponentMonsters().get(i).getType() == "provoke") {
                            System.out.println(i + 1 + "- " + opponentBoard.getOpponentMonsters().get(i).getName());
                            provokers.add(opponentBoard.getOpponentMonsters().get(i));
                        }
                    }
                    if (provokers.size() > 0) {
                        System.out.println("Des provocateurs sont sur le terrain, Choisissez une cible: ");
                        int choixCible = sc.nextInt();
                        if (choixCible > 0 && choixCible <= provokers.size()) {
                            currentHero.useHeroPower(provokers.get(choixCible - 1));
                        } else {
                            System.out.println("Choix invalide");
                            continue;
                        }
                    } else {

                        System.out.println("Choisissez une cible: ");
                        System.out.println("1- Hero adverse");
                        for (int i = 0; i < opponentBoard.getOpponentMonsters().size(); i++) {
                            System.out.println(i + 2 + "- " + opponentBoard.getOpponentMonsters().get(i).getName());
                        }
                        int choixCible = sc.nextInt();
                        if (choixCible == 1) {
                            currentHero.useHeroPower(opponentHero);
                        } else if (choixCible > 1 && choixCible <= opponentBoard.getOpponentMonsters().size() + 1) {
                            currentHero.useHeroPower(opponentBoard.getOpponentMonsters().get(choixCible - 2));
                        } else {
                            System.out.println("Choix invalide");
                            System.exit(0);
                        }
                    }
                }

            } else if (choix == 2) {
                System.out.println("Vous avez choisi de jouer une carte");
                currentHero.viewHand();
                System.out.println("Choisissez une carte à jouer: ");
                int choixCarte = sc.nextInt();
                currentHero.playCard(choixCarte - 1, currentBoard, currentHero);
            } else if (choix == 3) {
                System.out.println("Vous avez choisi de passer le tour");
                currentHero.setMana(0);
            }
            else if (choix == 4) {
                System.out.print("Quel monstre va attaquer ? : ");
                if (currentHero.getID() == 0) {
                    if (!currentBoard.getPlayerMonsters().isEmpty()){
                    currentBoard.displayPlayerMonsters();
                    Scanner sc2 = new Scanner(System.in);
                    int choixMonstre = sc2.nextInt();
                    if (!currentBoard.getPlayerMonsters().get(choixMonstre - 1).gethasAttacked()) {
                        if (choixMonstre > 0 && choixMonstre <= currentBoard.getPlayerMonsters().size()) {
                            List<Monster> provokers = new ArrayList<Monster>();
                            System.out.println("Choisissez une cible: ");
                            for (int i = 0; i < opponentBoard.getOpponentMonsters().size(); i++) {
                                if (opponentBoard.getOpponentMonsters().get(i).getType() == "provoke") {
                                    System.out.println(i + 1 + "- " + opponentBoard.getOpponentMonsters().get(i).getName());
                                    provokers.add(opponentBoard.getOpponentMonsters().get(i));
                                }
                            }
                            if (provokers.size() > 0) {
                                System.out.println("Des provocateurs sont sur le terrain, Choisissez une cible: ");
                                int choixCible = sc.nextInt();
                                if (choixCible > 0 && choixCible <= provokers.size()) {
                                    Monster target = provokers.get(choixCible - 1);
                                    currentBoard.getPlayerMonsters().get(choixMonstre - 1).attack(target);
                                    if (target.getHP() <= 0) {
                                        opponentBoard.getPlayerMonsters().remove(target);
                                    }
                                } else {
                                    System.out.println("Choix invalide");
                                    continue;
                                }
                            } else {
                                System.out.println("Choisissez une cible: ");
                                System.out.println("1- Hero adverse");
                                for (int i = 0; i < opponentBoard.getOpponentMonsters().size(); i++) {
                                    System.out.println(i + 2 + "- " + opponentBoard.getOpponentMonsters().get(i).getName());
                                }
                                int choixCible = sc.nextInt();
                                if (choixCible == 1) {
                                    currentBoard.getPlayerMonsters().get(choixMonstre - 1).attack(opponentHero);
                                } else if (choixCible > 1 && choixCible <= opponentBoard.getOpponentMonsters().size() + 1) {
                                    Monster target = opponentBoard.getOpponentMonsters().get(choixCible - 2);
                                    currentBoard.getPlayerMonsters().get(choixMonstre - 1).attack(target);
                                    if (target.getHP() <= 0) {
                                        opponentBoard.getOpponentMonsters().remove(target);
                                    }
                                } else {
                                    System.out.println("Choix invalide");
                                    System.exit(0);
                                }
                            }
                        } else {
                            System.out.println("Choix invalide");
                            System.exit(0);
                        }
                        currentBoard.getPlayerMonsters().get(choixMonstre - 1).setHasAttacked(true);
                    } else {
                        System.out.println("Ce monstre a déjà attaqué");
                        continue;
                    }
                    }
                    else {
                        System.out.println("Vous n'avez pas de monstre sur le terrain");
                        continue;
                    }
                } else if (currentHero.getID() == 1) {

                    if (!currentBoard.getOpponentMonsters().isEmpty()) {
                        System.out.println("Vous avez choisi de faire attaquer un monstre");

                        currentBoard.displayOpponentMonsters();
                        Scanner sc2 = new Scanner(System.in);
                        int choixMonstre = sc2.nextInt();
                        if (!currentBoard.getOpponentMonsters().get(choixMonstre - 1).gethasAttacked()) {
                            List<Monster> provokers = new ArrayList<Monster>();
                            System.out.println("Choisissez une cible: ");
                            for (int i = 0; i < opponentBoard.getPlayerMonsters().size(); i++) {
                                if (opponentBoard.getPlayerMonsters().get(i).getType() == "provoke") {
                                    System.out.println(i + 1 + "- " + opponentBoard.getPlayerMonsters().get(i).getName());
                                    provokers.add(opponentBoard.getPlayerMonsters().get(i));
                                }
                            }
                            if (provokers.size() > 0) {
                                System.out.println("Des provocateurs sont sur le terrain, Choisissez une cible: ");
                                int choixCible = sc.nextInt();
                                if (choixCible > 0 && choixCible <= provokers.size()) {
                                    Monster target = provokers.get(choixCible - 1);
                                    currentBoard.getOpponentMonsters().get(choixMonstre - 1).attack(target);
                                    if (target.getHP() <= 0) {
                                        opponentBoard.getPlayerMonsters().remove(target);
                                    }
                                } else {
                                    System.out.println("Choix invalide");
                                    continue;
                                }
                            } else {
                                System.out.println("Choisissez une cible: ");
                                System.out.println("1- Hero adverse");
                                for (int i = 0; i < opponentBoard.getPlayerMonsters().size(); i++) {
                                    System.out.println(i + 2 + "- " + opponentBoard.getPlayerMonsters().get(i).getName());
                                }
                                int choixCible = sc.nextInt();
                                if (choixCible == 1) {
                                    currentBoard.getOpponentMonsters().get(choixMonstre - 1).attack(opponentHero);
                                } else if (choixCible > 1 && choixCible <= opponentBoard.getPlayerMonsters().size() + 1) {
                                    Monster target = opponentBoard.getPlayerMonsters().get(choixCible - 2);
                                    currentBoard.getOpponentMonsters().get(choixMonstre - 1).attack(target);
                                    if (target.getHP() <= 0) {
                                        opponentBoard.getPlayerMonsters().remove(target);
                                    }
                                } else {
                                    System.out.println("Choix invalide");
                                    System.exit(0);
                                }

                            }
                            currentBoard.getOpponentMonsters().get(choixMonstre - 1).setHasAttacked(true);

                        } else {
                            System.out.println("Ce monstre a déjà attaqué");
                            continue;
                        }
                    }
                    else {
                        System.out.println("Vous n'avez pas de monstre sur le terrain");
                        continue;
                    }
                }
            }

            else {
                System.out.println("Choix invalide");
                System.exit(0);
            }





            // Vérifier si le Hero adverse est mis KO
            if (!opponentHero.isAlive()) {
                System.out.println("Le Hero " + opponentHero.getName() + " est mis KO. " + currentHero.getName() + " remporte la partie!");
                System.exit(0);
            }
        }
        currentBoard.resetMonstre();
        opponentBoard.resetMonstre();
    }





    private void displayGameResult() {
        System.out.println("Fin du jeu.");

    }




}