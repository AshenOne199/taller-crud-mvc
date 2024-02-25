package main.controller;

import java.util.List;

import main.model.Persona;
import main.model.PersonaDAO;
import main.model.PersonaDAOImpl;

/**
 * Controlador que gestiona las operaciones relacionadas con las personas en el
 * sistema.
 */
public class PersonaController {
    private PersonaDAO personaDAO;

    /**
     * Constructor que inicializa el controlador con una implementación de
     * PersonaDAO.
     */
    public PersonaController() {
        personaDAO = new PersonaDAOImpl();
    }

    /**
     * Crea una nueva persona en el sistema.
     *
     * @param persona La persona a crear.
     */
    public void crearPersona(Persona persona) {
        personaDAO.crearPersona(persona);
    }

    /**
     * Obtiene una lista de todas las personas en el sistema.
     *
     * @return Una lista de objetos Persona.
     */
    public List<Persona> obtenerPersonas() {
        return personaDAO.obtenerPersonas();
    }

    /**
     * Obtiene una persona específica del sistema según su dirección de correo
     * electrónico.
     *
     * @param correo La dirección de correo electrónico de la persona a buscar.
     * @return La Persona encontrada, o null si no se encuentra ninguna persona con
     *         el correo especificado.
     */
    public Persona obtenerPersona(String correo) {
        return personaDAO.obtenerPersona(correo);
    }

    /**
     * Actualiza la información de una persona en el sistema.
     *
     * @param persona La persona con la información actualizada.
     */
    public void actualizarPersona(Persona persona) {
        personaDAO.actualizarPersona(persona);
    }

    /**
     * Elimina una persona del sistema según su dirección de correo electrónico.
     *
     * @param correo La dirección de correo electrónico de la persona a eliminar.
     */
    public void eliminarPersona(String correo) {
        personaDAO.eliminarPersona(correo);
    }
}
