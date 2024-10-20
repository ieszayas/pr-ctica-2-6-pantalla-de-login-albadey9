package Modelo;

public class Usuario {

    private String usuario;
    private String contrasena;

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", contrasena=" + contrasena + '}';
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

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
