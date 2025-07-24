package RPG.utils;

import RPG.model.Character;
import RPG.model.Warrior;
import RPG.model.Wizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para cargar personajes desde un archivo CSV.
 */
public class LoadCaracterCSV {
    /**
     * Lee un archivo CSV y devuelve una lista de personajes.
     * @param fileName Nombre del archivo CSV (ej: "characters.csv")
     * @return Lista de objetos Character (Warrior o Wizard)
     */
    public static List<Character> loadFromCSV(String fileName) {
        List<Character> characters = new ArrayList<>();
        InputStream is = LoadCaracterCSV.class.getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            System.out.println("No se encontró el archivo en el classpath: " + fileName);
            return characters;
        }
        try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            boolean firstLine = true;
            while ((line = bufferReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Saltar la cabecera
                    continue;
                }
                String[] tokens = line.split(",");
                if (tokens.length < 5) continue; // Validación básica

                String type = tokens[0].trim().toLowerCase();
                String name = tokens[1].trim();
                int hp = Integer.parseInt(tokens[2].trim());
                int stat1 = Integer.parseInt(tokens[3].trim());
                int stat2 = Integer.parseInt(tokens[4].trim());

                switch (type) {
                    case "warrior":
                        characters.add(new Warrior(name, hp, stat1, stat2));
                        break;
                    case "wizard":
                        characters.add(new Wizard(name, hp, stat1, stat2));
                        break;
                    default:
                        System.out.println("Tipo de personaje desconocido: " + type);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return characters;
    }
}