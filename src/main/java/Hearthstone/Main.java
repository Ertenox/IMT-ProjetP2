package Hearthstone;
import java.util.Scanner;

public class Main {

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