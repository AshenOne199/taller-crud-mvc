package main;

import java.util.List;

import main.controller.PersonaController;
import main.model.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        PersonaController controller = new PersonaController();

        Persona persona = new Persona("Andres", "30511111", "2000-10-19", "andres@gmail.com", 1);
        controller.crearPersona(persona);
        
        /* 
        Persona personaActualizada = new Persona("Andresss", "3051111231232111", "2000-10-19", "andres@gmail.com", 2);
        controller.actualizarPersona(personaActualizada);

        controller.eliminarPersona("daniel@gamil.com");

        List<Persona> personas = controller.obtenerPersonas();
        for (Persona elemento : personas) {
            System.out.println(elemento.toString());
        } */
    }
}
