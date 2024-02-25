package main.model;

import java.util.List;

/**
 * Interfaz que define los métodos para interactuar con entidades de tipo
 * Persona en una base de datos.
 */
public interface PersonaDAO {

    /**
     * Crea una nueva entrada de persona en la base de datos.
     *
     * @param persona La persona a crear.
     */
    void crearPersona(Persona persona);

    /**
     * Obtiene una lista de todas las personas almacenadas en la base de datos.
     *
     * @return Una lista de objetos Persona.
     */
    List<Persona> obtenerPersonas();

    /**
     * Obtiene una persona específica de la base de datos según su dirección de
     * correo electrónico.
     *
     * @param correo La dirección de correo electrónico de la persona a buscar.
     * @return La Persona encontrada, o null si no se encuentra ninguna persona con
     *         el correo especificado.
     */
    Persona obtenerPersona(String correo);

    /**
     * Actualiza la información de una persona en la base de datos.
     *
     * @param persona La persona con la información actualizada.
     */
    void actualizarPersona(Persona persona);

    /**
     * Elimina una persona de la base de datos según su dirección de correo
     * electrónico.
     *
     * @param correo La dirección de correo electrónico de la persona a eliminar.
     */
    void eliminarPersona(String correo);
}
