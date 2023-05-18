package test;

import datos.BaseDatos;
import logica.UsuarioBean;

public class Test {

    public static void main(String[] args) {

        BaseDatos bd = new BaseDatos();
        UsuarioBean usuario = new UsuarioBean("jacksito", "jack", "jackson@outlook.com");
        UsuarioBean usuarioErroneo = new UsuarioBean("juan", "jack", "juan@outlook.com");
        
        System.out.println(bd.encontrarUsuario(2) != null);

    }
}
