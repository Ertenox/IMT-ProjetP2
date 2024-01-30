package Hearthstone;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
        Monster petitGars = new Monster("Petit gars ", 1, 1, playerBoard,true, "charge");
        Monster stormwindGuard = new Monster("Garde de Hurlevent ", 5, 1, playerBoard,true, "provoke");
        Monster murloc = new Monster("Murloc ", 2, 1, playerBoard,true, "charge");
        Monster dagueTueuse = new Monster("Dague tueuse ", 1, 7, playerBoard,true, "normal");
        Monster licheKing = new Monster("Roi liche ", 8, 8, playerBoard,true, "normal");
        Monster killerGoblin = new Monster("Gobelin tueur ", 3, 2, playerBoard,true, "normal");
        Monster behemoth = new Monster("Behemoth ", 10, 8, playerBoard,true, "normal");
        Monster orchestratrice = new Monster("Orchestratrice ", 6, 3, playerBoard,true, "provoke");
        Monster gigantotem = new Monster("Gigantotem ", 8, 8, playerBoard,true, "charge");
        Monster rockeuse = new Monster("Rockeuse ", 3, 2, playerBoard,true, "normal");
        Monster drake = new Monster("Drake ", 8, 4, playerBoard,true, "provoke");


        Card card = new Card("Acolyte de la mort ", 3, "Mort vivant", Acolyte1, playerHero);
        Card card2 = new Card("Baron vaillefendre ", 2, "Mort vivant", Baron1, playerHero);
        Card card3 = new Card("Chevalier de la mort ", 4, "Mort vivant", Chevalier, playerHero);
        Card card4 = new Card("Chien de magma ", 7, "Bête", MagmaDog, playerHero);
        Card card5 = new Card("Petit gars ", 1, "Bête", petitGars, playerHero);
        Card card6 = new Card("Garde de Hurlevent ", 4, "Humain", stormwindGuard, playerHero);
        Card card7 = new Card("Murloc ", 1, "Murloc", murloc, playerHero);
        Card card8 = new Card("Dague tueuse ", 3, "Arme", dagueTueuse, playerHero);
        Card card9 = new Card("Roi liche ", 8, "Mort vivant", licheKing, playerHero);
        Card card10 = new Card("Gobelin tueur ", 3, "Mort vivant", killerGoblin, playerHero);
        Card card11 = new Card("Behemoth ", 7, "Bête", behemoth, playerHero);
        Card card12 = new Card("Orchestratrice funeste  ", 5, "Humain", orchestratrice, playerHero);
        Card card13 = new Card("Gigantotem ", 9, "Totem", gigantotem, playerHero);
        Card card14 = new Card("Rockeuse redoutable ", 3, "Orc", rockeuse, playerHero);
        Card card15 = new Card("Drake thorignir ", 8, "Dragon", drake, playerHero);

        deckPlayer.add(card);
        deckPlayer.add(card2);
        deckPlayer.add(card3);
        deckPlayer.add(card4);
        deckPlayer.add(card5);
        deckPlayer.add(card6);
        deckPlayer.add(card7);
        deckPlayer.add(card8);
        deckPlayer.add(card9);
        deckPlayer.add(card10);
        deckPlayer.add(card11);
        deckPlayer.add(card12);
        deckPlayer.add(card13);
        deckPlayer.add(card14);
        deckPlayer.add(card15);
        return deckPlayer;
    }

    private List<Card> generateDeckOpponent() {
        List<Card> deckOpponent = new ArrayList<>();
        Monster Acolyte1 = new Monster("Acolyte de la mort ", 4, 3, opponentBoard,true, "normal");
        Monster Baron1 = new Monster("Baron vaillefendre ", 2, 2, opponentBoard,true, "provoke");
        Monster Chevalier = new Monster("Chevalier de la mort ", 4, 4, opponentBoard,true, "normal");
        Monster MagmaDog = new Monster("Chien de magma ", 5, 9, opponentBoard,true, "normal");
        Monster petitGars = new Monster("Petit gars ", 1, 1, opponentBoard,true, "charge");
        Monster stormwindGuard = new Monster("Garde de Hurlevent ", 5, 1, opponentBoard,true, "provoke");
        Monster murloc = new Monster("Murloc ", 2, 1, opponentBoard,true, "charge");
        Monster dagueTueuse = new Monster("Dague tueuse ", 1, 7, opponentBoard,true, "normal");
        Monster licheKing = new Monster("Roi liche ", 8, 8, opponentBoard,true, "normal");
        Monster killerGoblin = new Monster("Gobelin tueur ", 3, 2, opponentBoard,true, "normal");
        Monster behemoth = new Monster("Behemoth ", 10, 8, opponentBoard,true, "normal");
        Monster orchestratrice = new Monster("Orchestratrice ", 6, 3, opponentBoard,true, "provoke");
        Monster gigantotem = new Monster("Gigantotem ", 8, 8, opponentBoard,true, "charge");
        Monster rockeuse = new Monster("Rockeuse ", 3, 2, opponentBoard,true, "normal");
        Monster drake = new Monster("Drake ", 8, 4, opponentBoard,true, "provoke");


        Card card = new Card("Acolyte de la mort ", 3, "Mort vivant", Acolyte1, opponentHero);
        Card card2 = new Card("Baron vaillefendre ", 2, "Mort vivant", Baron1, opponentHero);
        Card card3 = new Card("Chevalier de la mort ", 4, "Mort vivant", Chevalier, opponentHero);
        Card card4 = new Card("Chien de magma ", 7, "Bête", MagmaDog, opponentHero);
        Card card5 = new Card("Petit gars ", 1, "Bête", petitGars, opponentHero);
        Card card6 = new Card("Garde de Hurlevent ", 4, "Humain", stormwindGuard, opponentHero);
        Card card7 = new Card("Murloc ", 1, "Murloc", murloc, opponentHero);
        Card card8 = new Card("Dague tueuse ", 3, "Arme", dagueTueuse, opponentHero);
        Card card9 = new Card("Roi liche ", 8, "Mort vivant", licheKing, opponentHero);
        Card card10 = new Card("Gobelin tueur ", 3, "Mort vivant", killerGoblin, opponentHero);
        Card card11 = new Card("Behemoth ", 7, "Bête", behemoth, opponentHero);
        Card card12 = new Card("Orchestratrice funeste  ", 5, "Humain", orchestratrice, opponentHero);
        Card card13 = new Card("Gigantotem ", 9, "Totem", gigantotem, opponentHero);
        Card card14 = new Card("Rockeuse redoutable ", 3, "Orc", rockeuse, opponentHero);
        Card card15 = new Card("Drake thorignir ", 8, "Dragon", drake, opponentHero);

        deckOpponent.add(card);
        deckOpponent.add(card2);
        deckOpponent.add(card3);
        deckOpponent.add(card4);
        deckOpponent.add(card5);
        deckOpponent.add(card6);
        deckOpponent.add(card7);
        deckOpponent.add(card8);
        deckOpponent.add(card9);
        deckOpponent.add(card10);
        deckOpponent.add(card11);
        deckOpponent.add(card12);
        deckOpponent.add(card13);
        deckOpponent.add(card14);
        deckOpponent.add(card15);
        return deckOpponent;
    }

    private void distributeCardsPlayer(List<Card> deck, PlayerHero Hero) {
        // Logique pour distribuer des cartes au Joueur1`
        //generer un nombre aléatoire entre 0 et 20
        //generer un nombre aléatoire entre 0 et et la taille du deck
        int randomCard = (int)(Math.random() * deck.size());
        if (randomCard == 0){
            randomCard = 1;
        }
        if (deck.isEmpty() || deck.size() == 1){
            System.out.println("Le deck est vide");
        }
        else {
            Card card = deck.get(randomCard);
            //ajouter une carte à la main du joueur
            Hero.addCardToHand(card);
            //retirer la carte du deck
            deck.remove(randomCard);
        }

    }
    private void distributeCardsOpponent(List<Card> deck, OpponentHero Hero) {
        // Logique pour distribuer des cartes au joueur 2
        //generer un nombre aléatoire entre 0 et et la taille du deck
        int randomCard = (int)(Math.random() * deck.size());
        if (randomCard == 0){
            randomCard = 1;
        }
        if (deck.isEmpty() || deck.size() == 1){
            System.out.println("Le deck est vide");
        }
        else {
            Card card = deck.get(randomCard);
            //ajouter une carte à la main du joueur
            Hero.addCardToHand(card);
            //retirer la carte du deck
            deck.remove(randomCard);
        }
    }

    // Méthode pour démarrer le jeu
    public void startGame() {

        System.out.println("Début du jeu.");
        opponentHero.setMana(1);
        playerHero.setMana(1);

        int manaMax = 1;
        //distribuer trois cartes à chacun
        for (int i = 0; i < 1; i++) {
            distributeCardsPlayer(playerDeck, playerHero);
            distributeCardsOpponent(opponentDeck, opponentHero);
        }


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
        Logger logger = Logger.getLogger("MyLog");



        try {



            //supprimer le fichier si il existe déjà
            if (new File("log_partie.log").exists()) {
                new File("log_partie.log").delete();
            }

           else{
                FileHandler fh;
                logger.setUseParentHandlers(false);

                logger.info("Tour n°+"+tour);
                fh = new FileHandler("log_partie.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);}

        }
        catch (SecurityException e) {
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        if (tour > 9) {
            currentHero.setMana(9);
        }
        else {
            currentHero.setMana(tour);
        }
        //Méthode pour afficher le board

        opponentBoard.displayOpponentMonsters();
        currentBoard.displayBoard(currentHero, opponentHero);
        opponentBoard.displayBoard(opponentHero, currentHero);
        System.out.println("Tour de " + currentHero.getName());
        System.out.println("Points de vie de " + currentHero.getName() + ": " + currentHero.getHP()+ "\n Points de mana: "+ currentHero.getMana()+"\n ");
        logger.info("Tour de " + currentHero.getName()+"\n HP = "+currentHero.getHP());


        while (currentHero.getMana() >= 0) {
            System.out.println("Que faire ? : \n 1- Utiliser le pouvoir du joueur \n 2- Jouer une carte \n 3- Passer le tour \n 4- Attaquer avec un monstre \n 5- Afficher la main \n Mana actuelle: "+ currentHero.getMana());


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
                            logger.info("Le pouvoir du joueur "+currentHero.getName()+" inflige 1 point de dégât à " + provokers.get(choixCible - 1).getName());
                        } else {
                            System.out.println("Choix invalide");
                            logger.warning("Problème: CIBLE INVALIDE");
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
                            logger.info("Le pouvoir du joueur "+currentHero.getName()+" inflige 1 point de dégât à " + opponentHero.getName());
                        } else if (choixCible > 1 && choixCible <= opponentBoard.getPlayerMonsters().size() + 1) {
                            currentHero.useHeroPower(opponentBoard.getPlayerMonsters().get(choixCible - 2));
                            logger.info("Le pouvoir du joueur "+currentHero.getName()+" inflige 1 point de dégât à " + opponentBoard.getPlayerMonsters().get(choixCible - 2).getName());
                        } else {
                            System.out.println("Choix invalide");
                            logger.warning("Problème: CIBLE INVALIDE");
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
                            logger.info("Le pouvoir du joueur "+currentHero.getName()+" inflige 1 point de dégât à " + provokers.get(choixCible - 1).getName());
                        } else {
                            System.out.println("Choix invalide");
                            logger.warning("Problème: CIBLE INVALIDE");
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
                            logger.info("Le pouvoir du joueur "+currentHero.getName()+" inflige 1 point de dégât à " + opponentHero.getName());
                        } else if (choixCible > 1 && choixCible <= opponentBoard.getOpponentMonsters().size() + 1) {
                            currentHero.useHeroPower(opponentBoard.getOpponentMonsters().get(choixCible - 2));
                            logger.info("Le pouvoir du joueur "+currentHero.getName()+" inflige 1 point de dégât à " + opponentBoard.getOpponentMonsters().get(choixCible - 2).getName());
                        } else {
                            System.out.println("Choix invalide");
                            logger.warning("Problème: CIBLE INVALIDE");
                            continue;
                        }
                    }
                }

            } else if (choix == 2) {
                System.out.println("Vous avez choisi de jouer une carte");
                currentHero.viewHand();
                System.out.println("Choisissez une carte à jouer: ");
                int choixCarte = sc.nextInt();
                Card card = currentHero.getHand().get(choixCarte - 1);
                currentHero.playCard(choixCarte - 1, currentBoard, currentHero);
                logger.info("Le joueur "+currentHero.getName()+" joue la carte "+card.getName());
                if (card.getMonster().getType().equals("charge")){
                    card.getMonster().setHasAttacked(false);
                }
            } else if (choix == 3) {
                System.out.println("Vous avez choisi de passer le tour");
                logger.info("Le joueur "+currentHero.getName()+" passe son tour");
                break;
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
                                    logger.info("Le monstre "+currentBoard.getPlayerMonsters().get(choixMonstre - 1).getName()+" attaque "+opponentHero.getName());
                                } else if (choixCible > 1 && choixCible <= opponentBoard.getOpponentMonsters().size() + 1) {
                                    Monster target = opponentBoard.getOpponentMonsters().get(choixCible - 2);
                                    currentBoard.getPlayerMonsters().get(choixMonstre - 1).attack(target);
                                    logger.info("Le monstre "+currentBoard.getPlayerMonsters().get(choixMonstre - 1).getName()+" attaque "+target.getName());
                                    if (target.getHP() <= 0) {
                                        opponentBoard.getOpponentMonsters().remove(target);
                                        logger.info("Le monstre "+target.getName()+" appartenant au joueur"+currentHero.getName()+" est mort");
                                    }
                                } else {
                                    System.out.println("Choix invalide");
                                    logger.warning("Problème: CIBLE INVALIDE");
                                    continue;
                                }
                            }
                        } else {
                            System.out.println("Choix invalide");
                            logger.warning("Problème: CIBLE INVALIDE");
                            continue;
                        }
                        currentBoard.getPlayerMonsters().get(choixMonstre - 1).setHasAttacked(true);
                    } else {
                        System.out.println("Ce monstre a déjà attaqué");
                        logger.warning("Problème: MONSTRE DEJA ATTAQUE");
                        continue;
                    }
                    }
                    else {
                        System.out.println("Vous n'avez pas de monstre sur le terrain");
                        logger.warning("Problème: PAS DE MONSTRE SUR LE TERRAIN");
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
                                    logger.info("Le monstre "+currentBoard.getOpponentMonsters().get(choixMonstre - 1).getName()+" attaque "+target.getName());
                                    if (target.getHP() <= 0) {
                                        opponentBoard.getPlayerMonsters().remove(target);
                                        logger.info("Le monstre "+target.getName()+" appartenant au joueur"+currentHero.getName()+" est mort");
                                    }
                                } else {
                                    System.out.println("Choix invalide");
                                    logger.warning("Problème: CIBLE INVALIDE");
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
                                    logger.info("Le monstre "+currentBoard.getOpponentMonsters().get(choixMonstre - 1).getName()+" attaque "+target.getName());
                                    if (target.getHP() <= 0) {
                                        opponentBoard.getPlayerMonsters().remove(target);
                                        logger.info("Le monstre "+target.getName()+" appartenant au joueur"+currentHero.getName()+" est mort");
                                    }
                                } else {
                                    System.out.println("Choix invalide");
                                    logger.warning("Problème: CIBLE INVALIDE");
                                    continue;
                                }

                            }
                            currentBoard.getOpponentMonsters().get(choixMonstre - 1).setHasAttacked(true);

                        } else {
                            System.out.println("Ce monstre a déjà attaqué");
                            logger.warning("Problème: MONSTRE DEJA ATTAQUE");
                            continue;
                        }
                    }
                    else {
                        System.out.println("Vous n'avez pas de monstre sur le terrain");
                        logger.warning("Problème: PAS DE MONSTRE SUR LE TERRAIN");
                        continue;
                    }
                }
            } else if (choix == 5) {
                System.out.println("Vous avez choisi d'afficher la main");
                logger.info("Le joueur "+currentHero.getName()+" affiche sa main");
                currentHero.viewHand();


            } else {
                System.out.println("Choix invalide");
                logger.warning("Problème: CHOIX INVALIDE");
                continue;
            }





            // Vérifier si le Hero adverse est mis KO
            if (!opponentHero.isAlive()) {
                System.out.println("Le Hero " + opponentHero.getName() + " est mis KO. " + currentHero.getName() + " remporte la partie!");
                logger.info("Le joueur "+currentHero.getName()+" remporte la partie");
                System.exit(0);
            }
        }
        currentBoard.resetMonstre();
        opponentBoard.resetMonstre();
        if (currentHero.getID() == 0) {
            distributeCardsPlayer(playerDeck,(PlayerHero) currentHero);
        } else {
            distributeCardsOpponent(opponentDeck, (OpponentHero) currentHero);
        }
    }





    private void displayGameResult() {
        System.out.println("Fin du jeu.");

    }




}