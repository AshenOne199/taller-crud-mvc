package main.controller;

import java.util.List;

import main.model.Persona;
import main.model.PersonaDAO;
import main.model.PersonaDAOImpl;

public class PersonaController {
    private PersonaDAO personaDAO;

    public PersonaController() {
        personaDAO = new PersonaDAOImpl();
    }

    public void crearPersona(Persona persona) {
        personaDAO.crearPersona(persona);
    }

    public List<Persona> obtenerPersonas() {
        return personaDAO.obtenerPersonas();
    }

    public Persona obtenerPersona(String correo) {
        return personaDAO.obtenerPersona(correo);
    }

    public void actualizarPersona(Persona persona) {
        personaDAO.actualizarPersona(persona);
    }

    public void eliminarPersona(String correo) {
        personaDAO.eliminarPersona(correo);
    }
}