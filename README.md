````markdown name=README.md
# homework-ironhack

En este repositorio implementamos un **RPG Battle Simulator**.
---

## 🎲 RPG Battle Simulator

Simulador de batalla RPG en Java para practicar herencia, polimorfismo e interfaces. Dos personajes (guerrero o mago) luchan en
combates por turnos hasta que solo queda uno vivo.
---

## 📁 Estructura del proyecto

```
homework-ironhack/
├── src/main/java/RPG/        # Código fuente en Java
├── README.md                 # Documentación
├── pom.xml                   # Configuración de Maven
└── .gitignore
```

---

## 🚀 Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/iron-battle/homework-ironhack.git
   ```
2. Abre el proyecto en IntelliJ, Eclipse o tu IDE preferido.
3. Ejecuta la clase `Main` en `src/main/java/RPG`.
4. Usa el menú por consola para crear personajes, iniciar combates o salir.

---

## 🧙‍♂️ Personajes

Existen dos clases que heredan de la abstracta `Character` e implementan la interfaz `Attacker`: **Warrior** y **Wizard**.

### Warrior

- **hp**: 100–200
- **stamina**: 10–50
- **strength**: 1–10

**Ataques:**
- **Heavy**: daño igual a `strength`, cuesta 5 stamina.
- **Weak**: daño = `strength / 2`, cuesta 1 stamina.
- Si no puede atacar, recupera 2 stamina.

### Wizard

- **hp**: 50–100
- **mana**: 10–50
- **intelligence**: 1–50

**Ataques:**
- **Fireball**: daño = `intelligence`, cuesta 5 mana.
- **Staff hit**: daño 2, cuesta 1 mana.
- Si no puede atacar, recupera 2 mana.

---

## ⚔️ Sistema de combate

- Se eligen dos personajes (idénticos o diferentes).
- Combaten por turnos, atacando simultáneamente.
- Se muestra un registro detallado de cada ronda.
- Si ambos mueren en la misma ronda → empate → se reinicia el combate.
- Se repite hasta que solo uno muere → se declara un ganador.

---

## ✅ Requisitos

- Menú interactivo por consola (crear personajes, combate, salida).
- Personalización de nombre y tipo en la creación de personajes.
- Registro en consola de todos los eventos del combate.
- Determinación del ganador final.

---

## 🎁 Bonus

- Importación desde archivo CSV de personajes.
- Batalla automática entre personajes generados aleatoriamente.

---

## ✨ Mejoras sugeridas

- Permitir múltiples personajes en una sesión.
- Añadir nuevas clases (por ejemplo, Archer, Healer).
- Ajustar balance de atributos y ataques.
- Exportar el log de combate a un fichero.

---

## 🛠️ Tecnologías usadas

- **Lenguaje:** Java (versión definida en `pom.xml`)
- **Gestión del proyecto:** Maven
- **IDE recomendado:** IntelliJ IDEA o Eclipse

---

## 🧩 Contribuyendo

- Haz tus implementaciones en una rama nueva.
- Envía pull requests para revisión y merge.
- Asegúrate de dejar un log limpio y descriptivo en cada commit.

---

---

# English version

## 🎲 RPG Battle Simulator

A Java-based RPG battle simulator designed to practice inheritance, polymorphism, and interfaces. 
Two characters (Warrior or Wizard) fight in turn-based combat until only one remains standing.
---

## 📁 Project Structure

```
homework-ironhack/
├── src/main/java/RPG/        # Java source code
├── README.md                 # Documentation
├── pom.xml                   # Maven configuration
└── .gitignore
```

---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/iron-battle/homework-ironhack.git
   ```
2. Open the project in IntelliJ, Eclipse, or your preferred IDE.
3. Run the `Main` class in `src/main/java/RPG`.
4. Use the console menu to create characters, start battles, or exit the game.

---

## 🧙‍♂️ Characters

There are two classes that inherit from the abstract class `Character` and implement the `Attacker` interface: **Warrior** and **Wizard**.

### Warrior

- **hp**: 100–200
- **stamina**: 10–50
- **strength**: 1–10

**Attacks:**
- **Heavy**: damage equals `strength`, costs 5 stamina.
- **Weak**: damage = `strength / 2`, costs 1 stamina.
- If unable to attack, recovers 2 stamina.

### Wizard

- **hp**: 50–100
- **mana**: 10–50
- **intelligence**: 1–50

**Attacks:**
- **Fireball**: damage = `intelligence`, costs 5 mana.
- **Staff hit**: damage 2, costs 1 mana.
- If unable to attack, recovers 2 mana.

---

## ⚔️ Combat System

- Two characters are selected (same or different types).
- They take turns attacking each other.
- Each round’s outcome is displayed in the console.
- If both die in the same round → draw → battle restarts.
- Loop continues until only one remains → winner is declared.

---

## ✅ Requirements

- Interactive console menu (create characters, start battle, exit).
- Custom character naming and class selection.
- Full combat log printed to the console.
- Proper end-of-battle winner display.

---

## 🎁 Bonus Features

- Import characters from a CSV file.
- Simulate automatic battles with randomly generated characters.

---

## ✨ Suggested Improvements

- Allow multiple characters in a session.
- Add new character classes (e.g., Archer, Healer).
- Adjust balance of stats and attack mechanics.
- Export combat log to a text file.

---

## 🛠️ Technologies Used

- **Language:** Java (version set in `pom.xml`)
- **Project Management:** Maven
- **IDEs:** Recommended IntelliJ IDEA or Eclipse

---

## 🧩 Contributing

- Make changes on a new branch.
- Submit pull requests for review and merging.
- Use clean and descriptive commit messages.

````
