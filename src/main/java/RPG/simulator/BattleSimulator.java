package RPG.simulator;

import RPG.interfaces.Attacker;
import RPG.model.Character;

public class BattleSimulator {


    public static void init(Character player1, Character player2) {
        int battles = 1;
        boolean finished = false;
        // Start the battle loop

        while(!finished) {
            printBattleStart(player1, player2); // Print the start of the battle
            resetPlayers(player1, player2);
            int round = 1;

            while (true) {
                printRoundHeader(battles, round); // Print the current battle and round number
                printHp(player1, player2);

                playRound(player1, player2);

                if (isBattleOver(player1, player2)) {
                    finished = handleBattleEnd(player1, player2, ++battles);
                    if (finished) break;
                    else continue;
                }
                round++;
            }
        }
    }

    private static void resetPlayers(Character player1, Character player2) {
        player1.reset();
        player2.reset();
    }

    private static void playRound(Character player1, Character player2) {
        if (player1.isAlive()) {
            System.out.println(player1.getName() + " attacks " + player2.getName() + "!");
            ((Attacker) player1).attack(player2);
            System.out.println(player2.getName() + " HP after attack: " + player2.getHp());
        }
        if (player2.isAlive()) {
            System.out.println(player2.getName() + " attacks " + player1.getName() + "!");
            ((Attacker) player2).attack(player1);
            System.out.println(player1.getName() + " HP after attack: " + player1.getHp());
        }
    }

    private static void printBattleStart(Character player1, Character player2) {
        System.out.println("\n=== BATTLE BEGINS ===");
        System.out.println(player1.getName() + " vs " + player2.getName());
    }

    private static void printRoundHeader(int battles, int round) {
        System.out.println("\n--- Battle " + battles + " - Round " + round + " ---");
    }

    private static void printHp(Character player1, Character player2) {
        System.out.println(player1.getName() + " HP: " + player1.getHp());
        System.out.println(player2.getName() + " HP: " + player2.getHp());
    }

    private static boolean isBattleOver(Character player1, Character player2) {
        return !player1.isAlive() || !player2.isAlive();
    }

    private static boolean handleBattleEnd(Character player1, Character player2, int battles) {
        System.out.println("\n=== BATTLE OVER ===");
        if (player1.isAlive() && !player2.isAlive()) {
            System.out.println(player1.getName() + " wins!");
            return true;
        } else if (!player1.isAlive() && player2.isAlive()) {
            System.out.println(player2.getName() + " wins!");
            return true;
        } else {
            System.out.println("It's a draw! Restarting battle...");
            return false;
        }
    }


}