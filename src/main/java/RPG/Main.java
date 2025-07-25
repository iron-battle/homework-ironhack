package RPG;

import java.util.List;
import java.util.Scanner;
import RPG.model.Character;
import RPG.utils.FactoryCharacter;
import RPG.utils.LoadCaracterCSV;
import RPG.utils.RandomCharacter;
import RPG.simulator.BattleSimulator;
import static RPG.utils.AnsiColors.*;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            String choice = SCANNER.nextLine().trim();
            exit = handleMenuChoice(choice);
        }
        SCANNER.close();
    }

    private static void showMenu() {
        System.out.println(GREEN + "╔══════════════════════════════════════╗" + RESET);
        System.out.println(GREEN + "║           RPG BATTLE MENU            ║" + RESET);
        System.out.println(GREEN + "║                                      ║" + RESET);
        System.out.println(GREEN + "║  1. Create custom characters         ║" + RESET);
        System.out.println(GREEN + "║  2. Random battle simulation         ║" + RESET);
        System.out.println(GREEN + "║  3. Exit                             ║" + RESET);
        System.out.println(GREEN + "╚══════════════════════════════════════╝" + RESET);
        System.out.print("Choose an option: ");
    }

    public static boolean handleMenuChoice(String choice) {
        return switch (choice) {
            case "1" -> {
                customBattle();
                yield false;
            }
            case "2" -> {
                randomBattle();
                yield false;
            }
            case "3" -> {
                System.out.println("Exiting the RPG Battle Simulator. Goodbye!");
                yield true;
            }
            default -> {
                System.out.println("Invalid option. Please try again.");
                yield false;
            }
        };
    }

    private static void customBattle() {
        System.out.println(GREEN + "\n╔══════════════════════════════════════╗" + RESET);
        System.out.println(GREEN +   "║         CUSTOM BATTLE MENU           ║" + RESET);
        System.out.println(GREEN +   "║                                      ║" + RESET);
        System.out.println(GREEN +   "║  1. Create characters (Manual)       ║" + RESET);
        System.out.println(GREEN +   "║  2. Import characters from CSV       ║" + RESET);
        System.out.println(GREEN +   "╚══════════════════════════════════════╝" + RESET);
        System.out.print("Choose an option: ");
        String choice = SCANNER.nextLine().trim();
        if (choice.equals("1")) {
            Character player1 = FactoryCharacter.createCharacter("Player 1");
            Character player2 = FactoryCharacter.createCharacter("Player 2");
            System.out.println("\nCreated characters:");
            System.out.println(player1);
            System.out.println(player2);
            System.out.println("\nStarting battle...");
            startBattle(player1, player2);
        } else if (choice.equals("2")) {
            List<Character> characters = LoadCaracterCSV.loadFromCSV("characters.csv");
            if (characters.isEmpty()) {
                System.out.println("No characters available.");
                return;
            }
            System.out.println("Available characters:");
            for (int i = 0; i < characters.size(); i++) {
                System.out.println((i + 1) + ". " + characters.get(i));
            }
            Character player1 = selectCharacterFromList(characters, "Player 1");
            Character player2 = selectCharacterFromList(characters, "Player 2");
            System.out.println("\nSelected characters:");
            System.out.println(player1);
            System.out.println(player2);
            System.out.println("\nStarting battle...");
            startBattle(player1, player2);
        } else {
            System.out.println("Invalid option. Returning to the main menu.");
        }
    }

    private static void randomBattle() {
        System.out.println(GREEN + "\n================= RANDOM BATTLE =================" + RESET);
        Character player1 = RandomCharacter.generateRandomCharacter();
        Character player2 = RandomCharacter.generateRandomCharacter();
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("\nCharacters created:");
        System.out.println("\nStarting battle...");
        System.out.println(GREEN + "============================================" + RESET);
        startBattle(player1, player2);
    }

    private static void startBattle(Character player1, Character player2) {
        BattleSimulator.init(player1, player2);
    }

    private static Character selectCharacterFromList(List<Character> characters, String playerName) {
        while (true) {
            System.out.print("Select the number for " + playerName + ": ");
            try {
                int index = Integer.parseInt(SCANNER.nextLine().trim()) - 1;
                if (index >= 0 && index < characters.size()) {
                    return characters.get(index);
                } else {
                    System.out.println("Number out of range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }
}
