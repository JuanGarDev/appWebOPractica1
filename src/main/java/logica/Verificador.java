package logica;

import datos.ControladoraBD;

public class Verificador {

    private ControladoraBD bd;

    public Verificador(ControladoraBD controladoraBD) {
        this.bd = controladoraBD;
    }
    
    public boolean esAutentico(UsuarioBean usuarioBean){
        
        UsuarioBean usuario = this.bd.encontrarUsuario(usuarioBean.getUsuario()) != null ? this.bd.encontrarUsuario(usuarioBean.getUsuario()) : null;
        
        return usuario != null &&
                usuario.getUsuario().equals(usuarioBean.getUsuario()) &&
                usuario.getContrasena().equals(usuarioBean.getContrasena()) &&
                usuario.getEmail().equals(usuarioBean.getEmail());
        
    }
    
}
