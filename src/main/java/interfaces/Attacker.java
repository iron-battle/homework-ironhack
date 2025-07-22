package interfaces;

import model.Character;

public interface Attacker {
    void attack(Character target, boolean specialAttack);
}
