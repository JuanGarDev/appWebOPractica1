package datos;

import falso.BaseDatosFalsa;
import java.util.HashMap;
import java.util.Map;
import logica.UsuarioBean;

public class ControladoraBD {


    private Map<String, UsuarioBean> usuarios;
    //private BaseDatos bd;
    private BaseDatosFalsa bdf;
    
    public ControladoraBD() {
        //bd = new BaseDatos();
        bdf = new BaseDatosFalsa();
        usuarios = bdf.listarUsuarios();
    }
    
    public UsuarioBean buscarUsuario(String usuarioBean){
        return usuarios.get(usuarioBean);
    }
    
    public boolean existeUsuario(String usuarioBean){
        return usuarios.containsKey(usuarioBean);
    }
    
    
}