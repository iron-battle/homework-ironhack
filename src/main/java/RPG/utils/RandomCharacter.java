// RandomCharacter.java
package RPG.utils;

import RPG.model.Warrior;
import RPG.model.Wizard;
import RPG.model.Character;

/**
 * Utilidad para generar personajes aleatorios (Warrior o Wizard)
 * con atributos y nombres generados de forma pseudoaleatoria.
 */
public class RandomCharacter {

    /**
     * Genera aleatoriamente un personaje, ya sea Warrior o Wizard.
     * @return una instancia de Character aleatoria
     */
    public static Character generateRandomCharacter() {
        System.out.print("Generating a random character... ");

        String type = chooseRandomType();             // Decide aleatoriamente el tipo
        String name = generateRandomName(type);       // Genera un nombre acorde al tipo

        if (type.equalsIgnoreCase("wizard")) {
            return generateWizard(name);
        } else {
            return generateWarrior(name);
        }
    }

    // === MÉTODOS DE GENERACIÓN DE PERSONAJES ===

    /**
     * Crea un Warrior con atributos aleatorios dentro de rangos válidos.
     * @param name nombre del personaje
     * @return instancia de Warrior
     */
    public static Warrior generateWarrior(String name) {
        int hp = generateRandomAttribute(100, 200);
        int stamina = generateRandomAttribute(10, 50);
        int strength = generateRandomAttribute(1, 10);
        return new Warrior(name, hp, stamina, strength);
    }

    /**
     * Crea un Wizard con atributos aleatorios dentro de rangos válidos.
     * @param name nombre del personaje
     * @return instancia de Wizard
     */
    public static Wizard generateWizard(String name) {
        int hp = generateRandomAttribute(50, 100);
        int mana = generateRandomAttribute(10, 50);
        int intelligence = generateRandomAttribute(1, 50);
        return new Wizard(name, hp, mana, intelligence);
    }

    // === MÉTODOS AUXILIARES ===

    /**
     * Genera un nombre aleatorio acorde al tipo de personaje.
     * @param characterType tipo de personaje ("wizard" o "warrior")
     * @return nombre generado
     */
    public static String generateRandomName(String characterType) {
        String[] wizardNames = {
                "Gandalf", "Merlin", "Saruman", "Dumbledore", "Harry",
                "Hermione", "Frodo", "Bilbo", "Aragorn", "Legolas"
        };

        String[] warriorNames = {
                "Conan", "Achilles", "Leonidas", "Spartacus", "Xena",
                "Lancelot", "Arthur", "Beowulf", "Sheera", "Sigurd"
        };

        return characterType.equalsIgnoreCase("wizard")
                ? wizardNames[(int) (Math.random() * wizardNames.length)]
                : warriorNames[(int) (Math.random() * warriorNames.length)];
    }

    /**
     * Selecciona aleatoriamente entre los tipos de personaje disponibles.
     * @return "wizard" o "warrior"
     */
    public static String chooseRandomType() {
        String[] characterTypes = {"warrior", "wizard"};
        return characterTypes[(int) (Math.random() * characterTypes.length)];
    }

    /**
     * Genera un número aleatorio entre min y max (ambos inclusive).
     * @param min mínimo valor posible
     * @param max máximo valor posible
     * @return número aleatorio dentro del rango
     */
    public static int generateRandomAttribute(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
