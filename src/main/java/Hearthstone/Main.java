package Hearthstone;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Antoine BERTIN | Noa PAILLETTE | FISA TI 2026 IMT Nord Europe \n Modifié pour type par Auguste et Arnaud");
        // Créer les Heros
        System.out.print("REGLES DU JEU : CHAQUE JOUEUR CHOISI SON HERO, UNE FOIS LA PHASE DE JEU ENCLENCHEE, CHAQUE JOUEUR PEUT \n REALISER DIFFERENTES ACTIONS SELON LE COUT EN MANA. LES ACTIONS SONT LES SUIVANTES: \n - UTILISER LE POUVOIR DE HERO (2 PTS DE MANA) \n - JOUER UNE CARTE, CHAQUE CARTE A UN CARACTERISTIQUE, NORMAL, PROVOKE OU CHARGE. \n PROVOKE SIGNIFIE QUE SEUL LES CARTES DE CE TYPE SONT ATTAQUABLES SI AU MOINS L'UNE EST SUR LE TERRAIN, CHARGE SIGNIFIE QU'ELLE PEUT ATTAQUER DES LE TOUR DE POSE \n - ATTAQUER AVEC UNE CARTE, CHAQUE CARTE A SON NIVEAU DE DEGATS D'ATTAQUE");
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
            System.out.println("Choix invalide \n Merci de choisir entre 1 et 2");
            main(args);
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
            System.out.println("Choix invalide \n Merci de choisir entre 1 et 2");
            main(args);
        }

        PlayerHero playerHero = new PlayerHero(name, 20, new PlayerHeroPower(name), 2);
        OpponentHero opponentHero = new OpponentHero(name2, 20, new OpponentHeroPower(name2), 2);


        Game game = new Game(playerHero, opponentHero);
        game.startGame();
    }
}