package Modelo;

import static Modelo.Loguear.arr_user;
import java.util.ArrayList;

public class Usuario {

    private String usuario = "no";
    private String contrasena = "no";
    private String nombre;
    private String apellidos;
    private String fecha_nac;
    private String correo;
    public static ArrayList<Usuario> arr_user = new ArrayList<Usuario>();

    public Usuario() {
        arr_user.add(new Usuario("Alba", "1234"));
        arr_user.add(new Usuario("Laura", "1234"));
        arr_user.add(new Usuario("Pedro", "1234"));
        arr_user.add(new Usuario("Diego", "1234"));
    }

    public static void setArr_user(ArrayList<Usuario> arr_user) {
        Loguear.arr_user = arr_user;
    }

    public static ArrayList<Usuario> getArr_user() {
        return arr_user;
    }

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario(String usuario, String contrasena, String nombre, String apellidos, String fecha_nac, String correo) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }

    // Método para validar las credenciales contra el array de usuarios
    public static boolean validar(String user, String password, ArrayList<Usuario> arr_user) {
        for (Usuario usuario : arr_user) {
            if (usuario.getUsuario().equals(user) && usuario.getContrasena().equals(password)) {
                return true; // Credenciales válidas
            }
        }
        return false; // Credenciales no válidas
    }

}
