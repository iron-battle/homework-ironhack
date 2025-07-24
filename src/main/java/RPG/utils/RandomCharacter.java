package RPG.utils;

import RPG.model.Warrior;
import RPG.model.Wizard;
import RPG.model.Character;

public class RandomCharacter {

    public static Character generateRandomCharacter() {
        System.out.print("Generating a random character... ");
        String type = typeOfCharacter();
        String name = generateRamdomName(type);

        if (type.equalsIgnoreCase("wizard")) {
            return  generateWizard(name);
        } else {
            return generateWarrior(name);
        }
    }
    public static Warrior generateWarrior(String name) {
        int hp = generateRandomAttribute(100, 200);
        int stamina = generateRandomAttribute(10, 50);
        int strength = generateRandomAttribute(1, 10);
        return new Warrior(name, hp, stamina, strength);
    }
    public static Wizard generateWizard(String name) {
        int hp = generateRandomAttribute(50, 100);
        int mana = generateRandomAttribute(10, 50);
        int intelligence = generateRandomAttribute(1, 50);
        return new Wizard(name, hp, mana, intelligence);
    }
    public static String generateRamdomName(String characterType) {
        String[] wizardNames = {"Gandalf", "Merlin", "Saruman", "Dumbledore", "Harry", "Hermione", "Frodo", "Bilbo",
                "Aragorn", "Legolas"};
        String[] warriorNames = {"Conan", "Achilles", "Leonidas", "Spartacus", "Xena", "Lancelot", "Arthur", "Beowulf",
                "Sheera", "Sigurd"};

        return characterType.equalsIgnoreCase("wizard")
                ? wizardNames[(int) (Math.random() * wizardNames.length)]
                : warriorNames[(int) (Math.random() * warriorNames.length)];
    }
    public static String  typeOfCharacter(){
        String[] characterTypes = {"warrior", "wizard"};
        return characterTypes[(int) (Math.random() * characterTypes.length)];
    }
    public static int generateRandomAttribute(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
