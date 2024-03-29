package main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la interfaz PersonaDAO que proporciona métodos para
 * interactuar con la tabla 'persona' en la base de datos.
 */
public class PersonaDAOImpl implements PersonaDAO {

    private ConnectionDB connectionDB = ConnectionDB.getInstance();
    private static final Logger logger = Logger.getLogger(PersonaDAOImpl.class.getName());

    /**
     * {@inheritDoc}
     */
    @Override
    public void crearPersona(Persona persona) {
        String query = "INSERT INTO persona(nombre, telefono, fechaNacimiento, correo, rol) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            pStatement.setString(1, persona.getNombre());
            pStatement.setString(2, persona.getTelefono());
            pStatement.setString(3, persona.getFechaNacimiento());
            pStatement.setString(4, persona.getCorreo());
            pStatement.setInt(5, persona.getRol());
            pStatement.executeUpdate();
            logger.log(Level.INFO, "Persona creada: " + persona.toString());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creando persona");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Persona> obtenerPersonas() {
        List<Persona> personas = new ArrayList<>();
        String query = "SELECT * FROM persona";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query);) {
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String correo = rs.getString("correo");
                Integer rol = rs.getInt("rol");
                personas.add(new Persona(nombre, telefono, fechaNacimiento, correo, rol));
            }
            rs.close();
            logger.log(Level.INFO, "Personas encontradas correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error obteniendo personas");
        }
        return personas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Persona obtenerPersona(String correo) {
        Persona persona = null;
        String query = "SELECT * FROM persona WHERE correo = ?";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            pStatement.setString(1, correo);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("fechaNacimiento");
                String correoOut = rs.getString("correo");
                Integer rol = rs.getInt("rol");
                persona = new Persona(nombre, telefono, fechaNacimiento, correoOut, rol);
                logger.log(Level.INFO, "Persona encontrada correctamente");
            }
            rs.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error obteniendo persona");
        }
        return persona;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actualizarPersona(Persona persona) {
        String query = "UPDATE persona SET nombre=?, telefono=?, fechaNacimiento=?, correo=?, rol=? WHERE correo=?";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            
            pStatement.setString(1, persona.getNombre());
            pStatement.setString(2, persona.getTelefono());
            pStatement.setString(3, persona.getFechaNacimiento());
            pStatement.setString(4, persona.getCorreo());
            pStatement.setInt(5, persona.getRol());
            pStatement.setString(6, persona.getCorreo());
            pStatement.executeUpdate();
            logger.log(Level.INFO, "Persona actualizada correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error actualizando persona", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void eliminarPersona(String correo) {
        String query = "DELETE FROM persona WHERE correo = ?";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            pStatement.setString(1, correo);
            pStatement.executeUpdate();
            logger.log(Level.INFO, "Persona eliminada correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error eliminando persona");
        }
    }
}