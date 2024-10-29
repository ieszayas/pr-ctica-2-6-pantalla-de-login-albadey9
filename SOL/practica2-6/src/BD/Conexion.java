package BD;

import java.sql.*;
import java.util.*;

public class Conexion {

    private static Connection conexion = null;

    private Conexion() {
    }

    public static Connection getConexion() {

        if (conexion == null) {
            try {
                String url;
                String usuario = "root";
                url = "jdbc:mysql://localhost:3306/";
                conexion = DriverManager.getConnection(url, usuario, null);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al conectar al servidor MySQL.");
            }
        }

        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            }

        } catch (SQLException ex) {
            System.out.println("No se ha podido cerrar la conexion");
        }
    }

}
