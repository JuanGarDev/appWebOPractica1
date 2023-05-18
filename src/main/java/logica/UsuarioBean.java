package logica;

public class UsuarioBean {

    private int idCliente;
    private String usuario;
    private String contrasena;
    private String email;

    public UsuarioBean() {
    }

    public UsuarioBean(String usuario, String contrasena, String email) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    public UsuarioBean(int idCliente, String usuario, String contrasena, String email) {
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioBean{" + "idCliente=" + idCliente + ", usuario=" + usuario + ", contrasena=" + contrasena + ", email=" + email + '}';
    }
 
    
    
}
