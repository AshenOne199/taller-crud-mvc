package main.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAOImpl implements PersonaDAO {

    private ConnectionDB connectionDB = ConnectionDB.getInstance();
    private static final Logger logger = Logger.getLogger(PersonaDAOImpl.class.getName());

    @Override
    public void crearPersona(Persona persona) {
        String query = "INSERT INTO personas(nombre, telefono, fechaNacimiento, correo, rol) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            pStatement.setString(1, persona.getNombre());
            pStatement.setString(2, persona.getTelefono());
            pStatement.setDate(3, convertToSql(persona.getFechaNacimiento()));
            pStatement.setString(4, persona.getCorreo());
            pStatement.setString(5, persona.getRol().getNombre());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error create persona", e);
        }
    }

    @Override
    public List<Persona> obtenerPersonas() {
        List<Persona> personas = new ArrayList<>();
        String query = "SELECT * FROM personas";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query);
                ResultSet rs = pStatement.executeQuery(query)) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                java.sql.Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String correo = rs.getString("correo");
                String rol = rs.getString("rol");
                Rol rolPersona = new Rol(rol, rol);
                personas.add(new Persona(nombre, telefono, convertToUtil(fechaNacimiento), correo, rolPersona));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error getAll personas", e);
        }
        return personas;
    }

    @Override
    public Persona obtenerPersona(String correo) {
        Persona persona = null;
        String query = "SELECT * FROM personas WHERE correo = ?";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            pStatement.setString(1, correo);
            ResultSet rs = pStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                java.sql.Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String correoOut = rs.getString("correo");
                String rol = rs.getString("rol");
                Rol rolPersona = new Rol(rol, rol);
                persona = new Persona(nombre, telefono, convertToUtil(fechaNacimiento), correoOut, rolPersona);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error get persona", e);
        }
        return persona;
    }

    @Override
    public void actualizarPersona(Persona persona) {
        String query = "UPDATE personas SET nombre = ?, telefono = ?, fechaNacimiento = ?, correo = ?, rol = ? WHERE correo = ?";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            pStatement.setString(1, persona.getNombre());
            pStatement.setString(2, persona.getTelefono());
            pStatement.setDate(3, convertToSql(persona.getFechaNacimiento()));
            pStatement.setString(4, persona.getCorreo());
            pStatement.setString(5, persona.getRol().getNombre());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error update persona", e);
        }
    }

    @Override
    public void eliminarPersona(String correo) {
        String query = "DELETE FROM personas WHERE correo = ?";
        try (Connection conn = connectionDB.getConnection();
                PreparedStatement pStatement = conn.prepareStatement(query)) {
            pStatement.setString(1, correo);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error delete persona", e);
        }
    }

    private java.sql.Date convertToSql(java.util.Date useUtilDatePackage) {
        return new java.sql.Date(useUtilDatePackage.getTime());
    }

    public static java.util.Date convertToUtil(java.sql.Date sqlDate) {
        return new java.util.Date(sqlDate.getTime());
    }
}