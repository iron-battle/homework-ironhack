package model;


import interfaces.Attacker;

import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String id, String name, int hp) {
        super(id, name, hp);
        Random random = new Random();
        this.stamina = random.nextInt(50) + 1;
        // Random stamina between 1 and 50
        this.strength = random.nextInt(10) + 1; // Random strength between 1 and 50
    }
    // Example attack
    public void attack(Character target, boolean specialAttack) {
        if (specialAttack) {
            target.setHp(target.getHp() - getStrength()); // Ataque fuerte
            setStamina(getStamina() - 5); // Reduce stamina
        } else {
            target.setHp(target.getHp() - getStrength() / 2); // Ataque débil
            setStamina(getStamina() + 1); // Aumenta stamina
        }
    }

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

}