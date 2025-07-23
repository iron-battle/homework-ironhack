package RPG.model;

import RPG.interfaces.Attacker;

import java.util.Random;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior( String name, int hp) {
        super( name, hp);
        Random random = new Random(); // Initialize random number generator
        this.stamina = random.nextInt(50) + 1;
        // Random stamina between 1 and 50
        this.strength = random.nextInt(10) + 1; // Random strength between 1 and 50
    }
    public Warrior( String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = stamina;
        this.strength = strength;
    }

    // Example attack
    public void attack(Character target) {
        boolean specialAttack = new Random().nextBoolean();
        int damage;
        if (specialAttack && (getStamina() >= 5 )) {
            // Ataque fuerte
            damage = getStrength();
            target.receiveDamage(damage);
            setStamina(getStamina() - 5);
        } else if (getStamina() > 0) {
            // Ataque débil
            damage = getStrength() / 2;
            target.receiveDamage(damage);
            setStamina(getStamina() + 1);
        } else {  
            //Sin resistencia suficiente para atacar
            setStamina(getStamina() + 2);
        }
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "id ='" + getId() + '\'' +
                ", name ='" + getName() + '\'' +
                ", hp =" + getHp() +
                ", isAlive =" + isAlive() +
                ", stamina =" + stamina +
                ", strength =" + strength +
                '}';
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