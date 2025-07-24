package RPG;

import java.util.List;
import java.util.Scanner;
import RPG.model.Character;
import RPG.utils.FactoryCharacter;
import RPG.utils.LoadCaracterCSV;
import RPG.utils.RandomCharacter;
import RPG.simulator.BattleSimulator;

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
        System.out.println("\n===== RPG BATTLE MENU =====");
        System.out.println("1. Create custom characters and battle");
        System.out.println("2. Random battle simulation");
        System.out.println("3. Exit");
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
        System.out.println("\n--- CUSTOM BATTLE ---");
        System.out.println("1. Crear personajes personalizados para la batalla");
        System.out.println("2. Importar personajes desde CSV");
        System.out.print("Elige una opción: ");
        String choice = SCANNER.nextLine().trim();
        if (choice.equals("1")) {
            Character player1 = FactoryCharacter.createCharacter("Player 1");
            Character player2 = FactoryCharacter.createCharacter("Player 2");
            System.out.println("\nPersonajes creados:");
            System.out.println(player1);
            System.out.println(player2);
            System.out.println("\nIniciando batalla...");
            startBattle(player1, player2);
        } else if (choice.equals("2")) {
            List<Character> characters = LoadCaracterCSV.loadFromCSV("characters.csv");
            if (characters.isEmpty()) {
                System.out.println("No hay personajes disponibles.");
                return;
            }
            System.out.println("Personajes disponibles:");
            for (int i = 0; i < characters.size(); i++) {
                System.out.println((i + 1) + ". " + characters.get(i));
            }
            Character player1 = selectCharacterFromList(characters, "Player 1");
            Character player2 = selectCharacterFromList(characters, "Player 2");
            System.out.println("\nPersonajes seleccionados:");
            System.out.println(player1);
            System.out.println(player2);
            System.out.println("\nIniciando batalla...");
            startBattle(player1, player2);
        } else {
            System.out.println("Opción inválida. Regresando al menú principal.");
        }
    }

    private static void randomBattle() {
        System.out.println("\n--- RANDOM BATTLE ---");
        Character player1 = RandomCharacter.generateRandomCharacter();
        Character player2 = RandomCharacter.generateRandomCharacter();
        System.out.println(player1);
        System.out.println(player2);
        System.out.println("\nCharacters created:");
        System.out.println("\nStarting battle...");
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
