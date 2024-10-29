package BD;

import static BD.Conexion.getConexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bbdd {

    private static final String NOMBRE_BBD = "usuarios";
    private static final String NOMBRE_TABLA = "usuario";

    public static void crearBBDD() {

        try {
            String sql = "CREATE DATABASE IF NOT EXISTS " + NOMBRE_BBD;
            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.executeUpdate();

            String sql_use = "USE " + NOMBRE_BBD;
            PreparedStatement ps_use = getConexion().prepareStatement(sql_use);
            ps_use.executeUpdate();

            String sql_tabla = "CREATE TABLE IF NOT EXISTS " + NOMBRE_TABLA + " (usuario VARCHAR(20), contrasena VARCHAR(20), nombre VARCHAR(20), apellidos VARCHAR(20), fecha_nac VARCHAR(20), correo VARCHAR(20), PRIMARY KEY(usuario))";
            PreparedStatement ps_tabla = getConexion().prepareStatement(sql_tabla);
            ps_tabla.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se ha creado la base de datos");
        }
    }

    public static boolean registrarUsuario(Usuario u) {
        String sql = "INSERT INTO " + NOMBRE_TABLA + " (usuario, contrasena, nombre, apellidos, fecha_nac, correo) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = getConexion();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getContrasena());
            stmt.setString(3, u.getNombre());
            stmt.setString(4, u.getApellidos());
            stmt.setString(5, u.getFecha_nac());
            stmt.setString(6, u.getCorreo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("No se ha creado el usuario" + e.getMessage());
            return false;
        }
    }

    public static boolean verificarUsuario(Usuario u) {
        String sql = "SELECT * FROM " + NOMBRE_TABLA + " WHERE usuario = ?";
        Connection conn = getConexion();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error al verificar el usuario: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al verificar el usuario en la base de datos", e);
        }
    }
    public static boolean validarUsuario(Usuario u) {
        String sql = "SELECT * FROM " + NOMBRE_TABLA + " WHERE usuario = ? AND contrasena = ?";
        Connection conn = getConexion();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getContrasena());
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Devuelve true si hay un resultado
        } catch (SQLException e) {
            System.out.println("Error al verificar el usuario: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al verificar el usuario en la base de datos", e);
        }
    }
}
