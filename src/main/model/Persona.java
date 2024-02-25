package main.model;

/**
 * Clase que representa una persona.
 */
public class Persona {
    private String nombre;
    private String telefono;
    private String fechaNacimiento;
    private String correo;
    private Integer rol;

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre          El nombre de la persona.
     * @param telefono        El número de teléfono de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param correo          El correo electrónico de la persona.
     * @param rol             El rol de la persona.
     */
    public Persona(String nombre, String telefono, String fechaNacimiento, String correo, Integer rol) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.rol = rol;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     *
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     *
     * @param telefono El nuevo número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La nueva fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return El correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     *
     * @param correo El nuevo correo electrónico de la persona.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el rol de la persona.
     *
     * @return El rol de la persona.
     */
    public Integer getRol() {
        return rol;
    }

    /**
     * Establece el rol de la persona.
     *
     * @param rol El nuevo rol de la persona.
     */
    public void setRol(Integer rol) {
        this.rol = rol;
    }

    /**
     * Devuelve una representación en forma de cadena de la persona.
     *
     * @return Una cadena que representa la persona.
     */
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento
                + ", correo=" + correo + ", rol=" + rol + "]";
    }
}
