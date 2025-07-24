package RPG.model;

import RPG.interfaces.Attacker;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    // Valores originales para hacer reset
    private final int originalHp;
    private final int originalMana;
    private final int originalIntelligence;

    public Wizard(String name, int hp) {
        super(name, hp);
        Random random = new Random();
        this.mana = random.nextInt(50) + 1;
        this.intelligence = random.nextInt(50) + 1;
        // Guardamos los valores originales
        this.originalHp = hp;
        this.originalMana = mana;
        this.originalIntelligence = intelligence;
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana ;
        this.intelligence = intelligence;

        // Guardamos los valores originales
        this.originalHp = hp;
        this.originalMana = mana;
        this.originalIntelligence = intelligence;
    }

    public void attack(Character target) {
        boolean specialAttack = new Random().nextBoolean();
        int damage;
        if (specialAttack && (getMana() >= 5 )) {
            //Ataque fuerte bola de fuego
            System.out.println(getName() + " casts a fireball on " + target.getName());
            damage = getIntelligence();
            target.receiveDamage(damage);
            setMana(getMana() -5);
        } else if (getMana() > 0) {
            //Golpe de bastón
            System.out.println(getName() + " hits " + target.getName() + " with a staff");
            damage = 2;
            target.receiveDamage(damage);
            setMana(getMana() +1);
        } else {
            // Recuperas maná, no puedes golpear
            System.out.println(getName() + " is out of mana. Resting...");
            setMana(getMana() + 2);
        }
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "id ='" + getId() + '\'' +
                ", name ='" + getName() + '\'' +
                ", hp =" + getHp() +
                ", isAlive =" + isAlive() +
                ", mana =" + getMana() +
                ", intelligence =" + getIntelligence() +
                '}';
    }

    public void reset() {
        setAlive(true);
        setHp(originalHp);
        setMana(originalMana);
        setIntelligence(originalIntelligence);
    }

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
}
