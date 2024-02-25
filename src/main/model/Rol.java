package main.model;

/**
 * Clase que representa un rol en el sistema.
 */
public class Rol {
    private String id;
    private String nombre;

    /**
     * Constructor para crear un nuevo rol con un ID y un nombre.
     *
     * @param id     El ID del rol.
     * @param nombre El nombre del rol.
     */
    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return El nombre del rol.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param nombre El nombre del rol.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del rol.
     *
     * @return El ID del rol.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID del rol.
     *
     * @param id El ID del rol.
     */
    public void setId(String id) {
        this.id = id;
    }
}
