package RPG.model;

import RPG.interfaces.Attacker;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp) {
        super(name, hp);

        Random random = new Random();

        this.mana = random.nextInt(50) + 1;
        this.intelligence = random.nextInt(50) + 1;
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);

        this.mana = mana ;
        this.intelligence = intelligence;
    }

    public void attack(Character target) {
        boolean specialAttack = new Random().nextBoolean();
        int damage;
        if (specialAttack && (getMana() >= 5 )) {
            //Ataque fuerte bola de fuego
            damage = getIntelligence();
            target.receiveDamage(damage);
            setMana(getMana() -5);
        } else if (getMana() > 0) {
            //Golpe de bastón
            damage = 2;
            target.receiveDamage(damage);
            setMana(getMana() +1);
        } else {
            // Recuperas maná, no puedes golpear
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
