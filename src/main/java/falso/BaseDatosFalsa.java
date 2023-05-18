package falso;

import java.util.HashMap;
import java.util.Map;
import logica.UsuarioBean;

public class BaseDatosFalsa {
    
    private Map<String, UsuarioBean> usuarios;
    private UsuarioBean usuario1 = new UsuarioBean("jacksito", "jack", "jackson@outlook.com");

    public BaseDatosFalsa() {
        this.usuarios = new HashMap<>();
        this.usuarios.put(usuario1.getUsuario(), usuario1);
    }
    
    public Map<String, UsuarioBean> listarUsuarios(){
        return this.usuarios;
    }
    
    
}
