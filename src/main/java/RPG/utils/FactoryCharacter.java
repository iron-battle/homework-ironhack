// FactoryCharacter.java
package RPG.utils;

import RPG.model.Character;
import RPG.model.Warrior;
import RPG.model.Wizard;

import java.util.Scanner;

/**
 * Fábrica para crear personajes personalizados mediante input del usuario.
 */
public class FactoryCharacter {

    // Scanner único para leer entradas por consola
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Método público para crear un personaje.
     * @param playerName identificador del jugador (ej. "Player 1", "Player 2")
     * @return un objeto Character (Warrior o Wizard)
     */
    public static Character createCharacter(String playerName) {
        System.out.print("Enter name for " + playerName + ": ");
        String name = SCANNER.nextLine().trim();

        System.out.print("Choose character type (Warrior/Wizard): ");
        String type = SCANNER.nextLine().trim().toLowerCase(); // Normaliza la entrada a minúsculas

        if (type.equals("warrior")) {
            return createWarrior(name);
        } else if (type.equals("wizard")) {
            return createWizard(name);
        } else {
            System.out.println("Invalid character type. Defaulting to Warrior.");
            return new Warrior(name, 150, 30, 20); // Valores por defecto
        }
    }

    // === MÉTODOS PRIVADOS AUXILIARES ===

    /**
     * Crea un personaje tipo Warrior pidiendo al usuario los atributos necesarios.
     * @param name nombre del guerrero
     * @return instancia de Warrior
     */
    private static Warrior createWarrior(String name) {
        System.out.println("--- Creating Warrior: " + name + " ---");

        System.out.print("Enter HP (100-200): ");
        int hp = readIntInRange(100, 200);

        System.out.print("Enter Strength (1-10): ");
        int strength = readIntInRange(1, 10);

        System.out.print("Enter Stamina (10-50): ");
        int stamina = readIntInRange(10, 50);

        return new Warrior(name, hp, stamina, strength);
    }

    /**
     * Crea un personaje tipo Wizard pidiendo al usuario los atributos necesarios.
     * @param name nombre del mago
     * @return instancia de Wizard
     */
    private static Wizard createWizard(String name) {
        System.out.println("--- Creating Wizard: " + name + " ---");

        System.out.print("Enter HP (50-100): ");
        int hp = readIntInRange(50, 100);

        System.out.print("Enter Intelligence (1-50): ");
        int intelligence = readIntInRange(1, 50);

        System.out.print("Enter Mana (10-50): ");
        int mana = readIntInRange(10, 50);

        return new Wizard(name, hp, intelligence, mana);
    }

    /**
     * Lee y asegura que un valor ingresado esté entre un mínimo y máximo.
     * @param min mínimo permitido
     * @param max máximo permitido
     * @return valor validado
     */
    private static int readIntInRange(int min, int max) {
        try {
            int value = Integer.parseInt(SCANNER.nextLine().trim());
            return Math.max(min, Math.min(max, value));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Using minimum value: " + min);
            return min;
        }
    }
}
