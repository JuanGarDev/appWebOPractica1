package test;

import datos.ControladoraBD;
import logica.UsuarioBean;
import logica.Verificador;

public class Test {

    public static void main(String[] args) {

        ControladoraBD bd = new ControladoraBD();
        Verificador v = new Verificador(bd);
        UsuarioBean usuario = new UsuarioBean("jacksito", "jack", "jackson@outlook.com");
        UsuarioBean usuarioErroneo = new UsuarioBean("juan", "jack", "juan@outlook.com");
        
        System.out.println(bd.encontrarUsuario(2) != null);
        System.out.println(v.esAutentico(usuario));
        System.out.println(v.esAutentico(usuarioErroneo));

    }
}
