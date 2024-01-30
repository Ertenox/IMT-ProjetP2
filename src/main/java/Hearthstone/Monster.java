package Hearthstone;

public class Monster implements Entity, Attacker{
    private static int idCounter = 0;
    private int id;
    private String name;
    private int hp;
    private int attack;
    private Board board;
    private boolean hasAttacked;

    private String type;





    public Monster(String name, int hp, int attack, Board board, boolean hasAttacked, String type) {
        this.id = idCounter++;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.board = board;
        this.hasAttacked = hasAttacked;
        this.type = type;
    }

    public void playTurn() {
        // Attaquer le héros adverse
        attack(board.getOpponent(this));

        }

    public int getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getType() {
        return type;
    }

    public void heal(Entity target, int heal) {
        if (target != null) {
            target.setHP(target.getHP() + heal);
        }
    }

    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public void setHP(int i) {
        this.hp = i;
    }

    public boolean gethasAttacked() {
        return hasAttacked;
    }
    public void setHasAttacked(boolean hasAttacked) {
        this.hasAttacked = hasAttacked;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }


    @Override
    public void attack(Entity target) {
        // Vérifier si la cible est valide
        if (target != null) {
            // Infliger des dégâts à la cible
            target.takeDamage(this.attack);
            if (target instanceof Monster) {
                System.out.println(this.getName() + " attaque " + target.getName() + " et lui inflige " + this.getAttack() + " points de dégâts.");
                if(target.getHP() <= 0){
                    if (((Monster) target).getBoard() == this.getBoard()) {
                        System.out.println(target.getName() + " est mort.");
                        ((Monster) target).getBoard().removePlayerMonster((Monster) target);
                    } else {
                        System.out.println(target.getName() + " est mort.");
                        ((Monster) target).getBoard().removeOpponentMonster((Monster) target);
                    }
                }
            } else if (target instanceof Hero) {
                System.out.println(this.getName() + " attaque " + target.getName() + " et lui inflige " + this.getAttack() + " points de dégâts.");
            }
        }
    }
}
