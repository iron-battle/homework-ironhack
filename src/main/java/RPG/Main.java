package RPG;

import java.util.Scanner; // Needed for user input
import RPG.model.Character;
import RPG.model.Warrior;
import RPG.model.Wizard;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        do {
            System.out.println("=== RPG BATTLE SIMULATOR ===");
            System.out.println("1. Create custom characters and battle");
            System.out.println("2. Random battle simulation");
            System.out.println("3. Import characters from CSV (not implemented)");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            // Read user input
            String choice = SCANNER.nextLine().trim(); // Normalize input 1

            switch (choice) {
                case "1":
                    customBattle();
                    break;
                case "2":
                    randomBattle();
                    break;
                case "3":
                    importFromCSV();
                    break;
                case "4":
                    exit = true;
                    System.out.println("Exiting the RPG Battle Simulator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while(!exit);
    }

    private static void customBattle() {
        System.out.println("\n--- CUSTOM BATTLE ---");

        Character player1 = createCharacter("Player 1");
        Character player2 = createCharacter("Player 2");

        System.out.println("\nCharacters created:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("\nStarting battle...");
        // startBattle(player1, player2);

        // Implement custom character creation and battle logic
        System.out.println("Custom battle mode is not yet implemented.");
    }

    private static Character createCharacter(String playerName) {
        System.out.print("Enter name for " + playerName + ": ");
        String name = SCANNER.nextLine().trim();
        System.out.print("Choose character type (Warrior/Wizard): ");
        String type = SCANNER.nextLine().trim().toLowerCase(); //  Normalize input to lowercase
        if (type.equals("warrior")) {
            return createWarrior(); // Example stats
        } else if (type.equals("wizard")) {
            return  createWizard();
        } else {
            System.out.println("Invalid character type. Defaulting to Warrior.");
            return new Warrior(name, 150, 30, 20);
        }

    }

    private static Warrior createWarrior() {
        // Name
        System.out.print("Enter Warrior name: ");
        String name = SCANNER.nextLine().trim();
        // Validate HP input
        System.out.print("Enter HP (100-200): ");
        int hp = Math.max(100, Math.min(200, Integer.parseInt(SCANNER.nextLine().trim())));
        // Validate stamina input
        System.out.print("Enter Strength (1-10): ");
        int strength = Math.max(1, Math.min(10, Integer.parseInt(SCANNER.nextLine().trim())));
        System.out.print("Enter Stamina (10-50): ");
        int stamina = Math.max(10, Math.min(50, Integer.parseInt(SCANNER.nextLine().trim())));
        // Create and return Warrior
        return new Warrior(name, hp, stamina, strength); // return a instance of Warrrior
    }

    private static Wizard createWizard(){ // esta función al ser llamada devuelve una instancia de Wizard
        // Name
        System.out.print("Enter Wizard name: "); // imprime un mensaje que pide un Nombre
        String name = SCANNER.nextLine().trim(); // Recoge la entrada del usuario y la guarda en una variable
        // Validate HP input
        System.out.print("Enter HP (50-100): ");  // imprime un mensaje que pide un valor para HP que esté entre 50-100
        // Recoge la entrada del usuario y la guarda en una variable asegurando que esté entre 50 y 100
        int hp = Math.max(50, Math.min(100, Integer.parseInt(SCANNER.nextLine().trim())));
        // Validate intelligence input
        System.out.print("Enter intelligence (1-50): ");
        int intelligence = Math.max(1, Math.min(50, Integer.parseInt(SCANNER.nextLine().trim())));
        System.out.print("Enter mana (10-50): ");
        int mana = Math.max(10, Math.min(50, Integer.parseInt(SCANNER.nextLine().trim())));
        // Create and return Wizard
        return new Wizard(name, hp, intelligence, mana);

    }

    private static void randomBattle() {
        // Implement random battle simulation logic
        System.out.println("Random battle simulation is not yet implemented.");
    }
    private static void importFromCSV() {
        // Implement CSV import logic
        System.out.println("Import from CSV is not yet implemented.");
    }
}