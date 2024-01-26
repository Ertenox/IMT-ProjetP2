package Hearthstone;

public class Monster implements Entity, Attacker{
    private static int idCounter = 0;
    private int id;
    private String name;
    private int hp;
    private int attack;
    private Board board;


    public Monster(String name, int hp, int attack, Board board) {
        this.id = idCounter++;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.board = board;
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



    @Override
    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }


    @Override
    public void attack(Entity target) {
        // Vérifier si la cible est valide
        if (target != null) {
            // Infliger des dégâts à la cible
            target.takeDamage(this.attack);
        }
    }
}
