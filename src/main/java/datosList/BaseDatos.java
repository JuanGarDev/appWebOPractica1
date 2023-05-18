package datosList;

import java.util.ArrayList;
import java.util.List;
import logica.UsuarioBean;

public class BaseDatos {

    private List<UsuarioBean> usuarios;

    public BaseDatos() {
        usuarios = new ArrayList<>();
    }
    
    public void agregarUsuario(UsuarioBean usuarioBean){
        this.usuarios.add(usuarioBean);
    }
    
    public List<UsuarioBean> listarUsuarios(){
        return this.usuarios;
    }
    
    public UsuarioBean obtenerUsuario(int usuarioBean){
        return this.usuarios.get(usuarioBean);
    }
    
}
