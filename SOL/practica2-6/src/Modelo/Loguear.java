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

    public static void setArr_user(ArrayList<Usuario> arr_user) {
        Loguear.arr_user = arr_user;
    }

    public static ArrayList<Usuario> getArr_user() {
        return arr_user;
    }
}