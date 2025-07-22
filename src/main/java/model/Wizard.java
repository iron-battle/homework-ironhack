package model;

import interfaces.Attacker;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String id, String name, int hp) {
        super(id, name, hp);

        Random random = new Random();

        this.mana = random.nextInt(50) + 1;
        this.intelligence = random.nextInt(50) + 1;
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

    public void attack(Character target, boolean specialAttack) {
        if (specialAttack && (getMana() >= 5 )) {
            target.setHp(target.getHp() - getIntelligence());
            //Ataque fuerte bola de fuego
            setMana(getMana() -5);
        } else if (getMana() > 0) {
            target.setHp(target.getHp() - 2);
            //Golpe de bastón
            setMana(getMana() +1);
        } else {
            // Recuperas maná, no puedes golpear
            setMana(getMana() + 2);
        }
    }
}
