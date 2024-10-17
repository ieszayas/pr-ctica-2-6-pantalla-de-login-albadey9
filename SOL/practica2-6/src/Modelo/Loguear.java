package Modelo;

import java.util.ArrayList;

public class Loguear {

    public static ArrayList<Usuario> arr_user = new ArrayList<Usuario>();

    public Loguear() {
        arr_user.add(new Usuario("Alba", "1234"));
        arr_user.add(new Usuario("Laura", "1234"));
        arr_user.add(new Usuario("Pedro", "1234"));
        arr_user.add(new Usuario("Diego", "1234"));
    }

    public static ArrayList<Usuario> getArr_user() {
        return arr_user;
    }

    public static boolean validar(String usuario, String contrasena) {
        for (Usuario usuario1 : arr_user) {
            if (usuario1.getUsuario().equals(arr_user) && usuario1.getContrasena().equals(arr_user)) {
                return true;
            }
        }
        return false;
    }
}
