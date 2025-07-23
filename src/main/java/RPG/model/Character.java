package RPG.model;

import static RPG.utils.Utils.generateUUID;

public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        this.id = generateUUID();
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    /**
     * Recibe daño y actualiza los puntos de vida.
     * Si los puntos de vida llegan a 0 o menos, el personaje muere.
     *
     * @param damage Daño recibido
     */
    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}