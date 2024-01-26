package Hearthstone;

public class PlayerHeroPower implements HeroPower {

    private String type;

    public PlayerHeroPower(String type) {
        this.type = type;
    }
    @Override
    public void usePower(Hero hero, Entity target) {
        System.out.println(hero.getName() + " utilise son pouvoir de joueur.");
        if (type.equals("Mage")) {
            System.out.println("Le pouvoir du Mage inflige 1 point de dégât à l'adversaire.");
            target.takeDamage(1);

        } else if (type.equals("Guerrier")) {
            System.out.println("Le pouvoir du Guerrier inflige 2 points de dégât à l'adversaire.");
            target.takeDamage(1);
        }
}
}
