package RPG.utils;

public class DelayHelper {
    /**
     * Pausa la ejecución por un tiempo determinado.
     *
     * @param milliseconds Tiempo en milisegundos
     */
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // buena práctica para hilos interrumpidos
        }
    }
}
