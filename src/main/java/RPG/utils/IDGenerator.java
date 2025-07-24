package RPG.utils;

import java.util.UUID;

public class IDGenerator {
    /**
     * Genera un identificador único (UUID) en formato compacto (sin guiones).
     *
     * @return String de 8 caracteres con letras y números aleatorios
     */
    public static String generateId() {
        // Generar UUID estándar: 36 caracteres con guiones
        String result = UUID.randomUUID().toString();

        // Eliminar los guiones
        result = result.replaceAll("-", "");

        // Asegurarse de que la longitud sea de 8 caracteres
        return result.substring(0, 8);
    }
}
