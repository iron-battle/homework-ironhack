package RPG.utils;

import java.util.UUID;

public class Utils {

    public static String generateUUID()    {
        String result = UUID.randomUUID().toString();

        result = result.replaceAll("-", "");
        result = result.substring(0, 32);

        return result;
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

}
