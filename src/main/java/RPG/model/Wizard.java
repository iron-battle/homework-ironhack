// Wizard.java
package RPG.model;

import RPG.interfaces.Attacker;

import java.util.Random;

/**
 * Clase que representa a un Mago (Wizard).
 * Tiene atributos de maná e inteligencia, y realiza ataques mágicos o físicos.
 */
public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;

    // Valores originales para usar en reset()
    private final int ORIGINAL_HP;
    private final int ORIGINAL_MANA;
    private final int ORIGINAL_INTELLIGENCE;

    /**
     * Constructor aleatorio (solo nombre y hp, el resto se genera).
     */
    public Wizard(String name, int hp) {
        super(name, hp);

        Random random = new Random();
        setHp(random.nextInt(51) + 50); // 50 - 100
        this.mana = random.nextInt(50) + 1;         // 1 - 50
        this.intelligence = random.nextInt(50) + 1; // 1 - 50

        this.ORIGINAL_HP = hp;
        this.ORIGINAL_MANA = mana;
        this.ORIGINAL_INTELLIGENCE = intelligence;
    }

    /**
     * Constructor completo con valores definidos.
     */
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;

        this.ORIGINAL_HP = hp;
        this.ORIGINAL_MANA = mana;
        this.ORIGINAL_INTELLIGENCE = intelligence;
    }

    /**
     * Lógica de ataque del mago:
     * - Fireball (especial): daño = inteligencia, cuesta 5 de maná
     * - Golpe de bastón: daño fijo 2, recupera 1 de maná
     * - Si no puede atacar, descansa y recupera 2 de maná
     */
    @Override
    public void attack(Character target) {
        boolean specialAttack = new Random().nextBoolean();
        int damage;

        if (specialAttack && mana >= 5) {
            System.out.println("\t" + getName() + " casts a FIREBALL on " + target.getName());
            damage = intelligence;
            target.receiveDamage(damage);
            mana -= 5;
        } else if (mana > 0) {
            System.out.println("\t" + getName() + " hits " + target.getName() + " with a STAFF");
            damage = 2;
            target.receiveDamage(damage);
            mana += 1; // pequeña recuperación
        } else {
            System.out.println("\t" + getName() + " is out of mana. Resting...");
            mana += 2; // descanso sin atacar
        }
    }

    /**
     * Restaura el estado original del mago (vida, maná e inteligencia).
     */
    @Override
    public void reset() {
        setAlive(true);
        setHp(ORIGINAL_HP);
        setMana(ORIGINAL_MANA);
        setIntelligence(ORIGINAL_INTELLIGENCE);
    }

    // === Getters y Setters ===

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    // === Representación textual ===

    @Override
    public String toString() {
        return String.format(
                """
                ───── Wizard ─────
                ID           : %s
                Name         : %s
                HP           : %d
                Alive        : %s
                Mana         : %d
                Intelligence : %d
                """,
                getId(), getName(), getHp(), isAlive(), mana, intelligence
        );
    }
}
