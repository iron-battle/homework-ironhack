// BattleSimulator.java
package RPG.simulator;

import RPG.interfaces.Attacker;
import RPG.model.Character;
import static RPG.utils.DelayHelper.sleep;
import static RPG.utils.AnsiColors.*;

/**
 * Clase que simula batallas por rondas entre dos personajes.
 */
public class BattleSimulator {

    /**
     * Inicia la simulación de batalla entre dos personajes.
     * Se repite si hay empate, hasta que haya un ganador.
     *
     * @param player1 Primer personaje
     * @param player2 Segundo personaje
     */
    public static void init(Character player1, Character player2) {
        int battles = 1;
        boolean finished = false;

        while (!finished) {
            printBattleStart(player1, player2);
            resetPlayers(player1, player2);

            int round = 1;

            // Bucle de rondas hasta que uno pierda
            while (true) {
                printRoundHeader(battles, round);
                printHp(player1, player2);

                playRound(player1, player2);

                if (isBattleOver(player1, player2)) {
                    finished = handleBattleEnd(player1, player2, ++battles);
                    if (finished) break; // Salir si hay ganador
                    else continue;       // Reiniciar si fue empate
                }

                round++;
            }
        }
    }

    // === MÉTODOS PRIVADOS ===

    /**
     * Reinicia los personajes usando su método reset().
     */
    private static void resetPlayers(Character player1, Character player2) {
        player1.reset();
        player2.reset();
    }

    /**
     * Ejecuta una ronda de combate: cada personaje ataca si sigue vivo.
     */
    private static void playRound(Character player1, Character player2) {
        if (player1.isAlive()) {
            System.out.println( RED + player1.getName() + " attacks " + player2.getName() + "!" + RESET);
            ((Attacker) player1).attack(player2);
            System.out.println("\t" + player2.getName() + " HP after attack: " + player2.getHp());
        }

        if (player2.isAlive()) {
            System.out.println( BLUE + player2.getName() + " attacks " + player1.getName() + "!" + RESET);
            ((Attacker) player2).attack(player1);
            System.out.println("\t" + player1.getName() + " HP after attack: " + player1.getHp());
        }
        sleep(2000);
    }

    /**
     * Muestra el inicio de una batalla.
     */
    private static void printBattleStart(Character player1, Character player2) {
        System.out.println(GREEN + "\n====== BATTLE BEGINS ======" + RESET);
        System.out.println(RED + player1.getName() + RESET + " vs " + BLUE  + player2.getName() + RESET);
        sleep(1000);
    }

    /**
     * Muestra encabezado de ronda con número de batalla y ronda actual.
     */
    private static void printRoundHeader(int battles, int round) {
        System.out.println(GREEN + "──────────────────────────" + RESET);
        System.out.println("--- Battle " + battles + " - Round " + round + " ---");
        System.out.println(GREEN + "──────────────────────────" + RESET);

    }

    /**
     * Muestra la vida actual de ambos personajes.
     */
    private static void printHp(Character player1, Character player2) {
        System.out.println(
                RED + player1.getName() + " HP: " + player1.getHp() + RESET + " | " + BLUE + player2.getName() + " HP: " + player2.getHp() + RESET
        );
//        sleep(600);

    }

    /**
     * Verifica si alguno de los personajes ha muerto.
     */
    private static boolean isBattleOver(Character player1, Character player2) {
        return !player1.isAlive() || !player2.isAlive();
    }

    /**
     * Muestra el resultado final de la batalla y determina si se debe repetir (en caso de empate).
     *
     * @return true si hay ganador, false si hay empate y debe repetirse
     */
    private static boolean handleBattleEnd(Character player1, Character player2, int battles) {
        System.out.println(GREEN + "\n====== BATTLE OVER ======" + RESET);

        if (player1.isAlive() && !player2.isAlive()) {
            System.out.println(RED + player1.getName() + " wins!" + RESET);
            return true;
        } else if (!player1.isAlive() && player2.isAlive()) {
            System.out.println(BLUE + player2.getName() + " wins!" + RESET);
            return true;
        } else {
            System.out.println(GREEN + "It's a draw! Restarting battle..." + RESET);
            return false;
        }
}
}
