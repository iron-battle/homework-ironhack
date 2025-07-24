// Warrior.java
package RPG.model;

import RPG.interfaces.Attacker;

import java.util.Random;

/**
 * Clase que representa a un Guerrero (Warrior).
 * Tiene atributos de fuerza y resistencia, y ejecuta ataques variables.
 */
public class Warrior extends Character implements Attacker {

    private int stamina;
    private int strength;

    // Copias de seguridad para restaurar estado original con reset()
    private final int ORIGINAL_HP;
    private final int ORIGINAL_STAMINA;
    private final int ORIGINAL_STRENGTH;

    /**
     * Constructor aleatorio (solo nombre y vida, los demás valores se generan).
     */
    public Warrior(String name, int hp) {
        super(name, hp);

        Random random = new Random();
        this.stamina = random.nextInt(50) + 1;    // 1 - 50
        this.strength = random.nextInt(10) + 1;   // 1 - 10

        this.ORIGINAL_HP = hp;
        this.ORIGINAL_STAMINA = stamina;
        this.ORIGINAL_STRENGTH = strength;
    }

    /**
     * Constructor con todos los atributos definidos.
     */
    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;

        this.ORIGINAL_HP = hp;
        this.ORIGINAL_STAMINA = stamina;
        this.ORIGINAL_STRENGTH = strength;
    }

    /**
     * Ejecuta un ataque sobre el objetivo.
     * Hay 3 posibles acciones según la stamina:
     * - Ataque fuerte: consume 5 de stamina
     * - Ataque débil: suma 1 de stamina
     * - Descanso: suma 2 de stamina
     */
    @Override
    public void attack(Character target) {
        boolean specialAttack = new Random().nextBoolean();
        int damage;

        if (specialAttack && stamina >= 5) {
            // Ataque fuerte: daño total = fuerza
            System.out.println("\t" + getName() + " performs a HEAVY attack on " + target.getName());
            damage = strength;
            target.receiveDamage(damage);
            stamina -= 5;
        } else if (stamina > 0) {
            // Ataque débil: daño = fuerza / 2 (truncado)
            System.out.println("\t" + getName() + " performs a WEAK attack on " + target.getName());
            damage = strength / 2;
            target.receiveDamage(damage);
            stamina += 1; // recuperación leve
        } else {
            // Sin energía suficiente para atacar
            System.out.println("\t" + getName() + " is too tired to attack. Resting...");
            stamina += 2; // recuperación pasiva
        }
    }

    /**
     * Restaura los valores originales del guerrero (vida, fuerza y stamina).
     */
    @Override
    public void reset() {
        setHp(ORIGINAL_HP);
        setStamina(ORIGINAL_STAMINA);
        setStrength(ORIGINAL_STRENGTH);
        setAlive(true);
    }

    // === Getters y Setters ===

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // === Representación textual del objeto ===

    @Override
    public String toString() {
        return String.format(
                """
                ───── Warrior ─────
                ID        : %s
                Name      : %s
                HP        : %d
                Alive     : %s
                Stamina   : %d
                Strength  : %d
                """,
                getId(), getName(), getHp(), isAlive(), stamina, strength
        );
    }
}
