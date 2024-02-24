package main.model;

import java.util.List;

public interface PersonaDAO {
    void crearPersona(Persona persona);

    List<Persona> obtenerPersonas();

    Persona obtenerPersona(String correo);

    void actualizarPersona(Persona persona);

    void eliminarPersona(String correo);
}