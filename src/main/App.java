package main;

import main.controller.PersonaController;
import main.model.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        PersonaController controller = new PersonaController();

        Persona persona = new Persona("Andres", "3057379187", "3057379187", "daniel@gamil.com", 1);
        controller.crearPersona(persona);
    }
}
