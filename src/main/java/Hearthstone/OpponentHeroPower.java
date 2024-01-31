package Hearthstone;

public class OpponentHeroPower implements HeroPower {

    String type;

    public OpponentHeroPower(String type) {
        this.type = type;
    }
    @Override
    public void usePower(Hero hero, Entity target) {
        // Logique pour le pouvoir du joueur
        System.out.println(hero.getName() + " utilise son pouvoir de joueur.");
        if (type.equals("Mage")) {
            if(target instanceof Monster) {
                System.out.println("Le pouvoir du Mage inflige 1 point de dégât à "+ target.getName() +".");
                target.takeDamage(1);
                if (target.getHP() <= 0) {
                    System.out.println(target.getName() + " est mort.");
                    ((Monster) target).getBoard().removePlayerMonster((Monster) target);

                }
            } else if (target instanceof PlayerHero) {
                System.out.println("Le pouvoir du Mage inflige 1 point de dégât à l'adversaire.");
                target.takeDamage(1);
            }
        } else if (type.equals("Guerrier")) {
            if(target instanceof Monster){
                System.out.println("Le pouvoir du Guerrier inflige 1 points de dégât à "+ target.getName() +".");
                target.takeDamage(1);
                if (target.getHP() <= 0) {
                    System.out.println(target.getName() + " est mort.");
                    ((Monster) target).getBoard().removePlayerMonster((Monster) target);

                }
            } else if (target instanceof PlayerHero) {
                System.out.println("Le pouvoir du Guerrier inflige 1 points de dégât à l'adversaire.");
                target.takeDamage(1);
            }

        }
    }
}
