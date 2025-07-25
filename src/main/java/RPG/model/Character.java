// Character.java
package RPG.model;
import static RPG.utils.IDGenerator.generateId;


/**
 * Clase base abstracta para todos los personajes del juego.
 * Contiene propiedades comunes como id, nombre, hp y estado de vida.
 */
public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    /**
     * Constructor común para todos los personajes.
     *
     * @param name Nombre del personaje
     * @param hp   Puntos de vida iniciales
     */
    public Character(String name, int hp) {
        this.id = generateId(); // ID único usando UUID sin guiones
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    /**
     * Método que recibe daño y actualiza el estado del personaje.
     *
     * @param damage cantidad de daño recibido
     */
    public void receiveDamage(int damage) {
        this.hp -= damage;

        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false;
        }
    }

    /**
     * Método obligatorio para que las subclases restauren su estado inicial.
     * (por ejemplo, reiniciar hp, mana, stamina...).
     */
    public abstract void reset();

    // === Getters y Setters ===

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) { this.hp = hp; }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) { isAlive = alive; }

    // === Representación legible del personaje ===

    @Override
    public String toString() {
        return String.format(
                """
                Character
                ───────────────
                ID     : %s
                Name   : %s
                HP     : %d
                Alive  : %s
                """,
                id, name, hp, isAlive
        );
    }
}
