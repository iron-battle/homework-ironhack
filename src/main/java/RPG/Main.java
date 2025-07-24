package RPG;

import java.util.Scanner; // Needed for user input
import RPG.model.Character;
import RPG.model.Warrior;
import RPG.model.Wizard;
import RPG.utils.RandomCharacter;
import RPG.interfaces.Attacker;
import RPG.simulator.BattleSimulator; // Import the Character class

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        boolean exit = false;

        while(!exit) {
            showMenu(); // Display the menu options

            String choice = SCANNER.nextLine().trim(); // Read user input and normalize input 1

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
        }
    }
    private  static void showMenu() {
        System.out.println("\n===== RPG BATTLE MENU =====");
        System.out.println("1. Create custom characters and battle");
        System.out.println("2. Random battle simulation");
        System.out.println("3. Import characters from CSV (not implemented)");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void customBattle() {
        System.out.println("\n--- CUSTOM BATTLE ---");
        Character player1 = createCharacter("Player 1");
        Character player2 = createCharacter("Player 2");
        System.out.println("\nCharacters created:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("\nStarting battle...");
        startBattle(player1, player2);
    }

    private static Character createCharacter(String playerName) {
        System.out.print("Enter name for " + playerName + ": ");
        String name = SCANNER.nextLine().trim();
        System.out.print("Choose character type (Warrior/Wizard): ");
        String type = SCANNER.nextLine().trim().toLowerCase(); //  Normalize input to lowercase
        if (type.equals("warrior")) {
            return createWarrior(); // Call the function to create a Warrior
        } else if (type.equals("wizard")) {
            return  createWizard(); // Call the function to create a Wizard
        } else {
            System.out.println("Invalid character type. Defaulting to Warrior.");
            return new Warrior(name, 150, 30, 20);
        }

    }
    // Esta función al ser llamada devuelve una instancia de Warrior
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
        return new Warrior(name, hp, stamina, strength); // return an instance of Warrior.
    }

    // Esta función al ser llamada devuelve una instancia de Wizard
    private static Wizard createWizard(){
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

    private static void startBattle(Character player1, Character player2){
        BattleSimulator.init(player1,player2);
    }

    //TODO
    private static void randomBattle() {
        System.out.println("\n--- RANDOM BATTLE ---");
        Character player1 = RandomCharacter.generateRandomCharacter();
        Character player2 = RandomCharacter.generateRandomCharacter();
        System.out.println("\nCharacters created:");
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("\nStarting battle...");
        startBattle(player1, player2);
    }
    //TODO
    private static void importFromCSV() {
        // Implement CSV import logic
        System.out.println("Import from CSV is not yet implemented.");
    }
}