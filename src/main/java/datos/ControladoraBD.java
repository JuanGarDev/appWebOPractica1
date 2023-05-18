package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.UsuarioBean;

public class ControladoraBD {

    private final String INSERT = "INSERT INTO usuarios (usuario, contrasena, email) VALUES (?,?,?)";
    private final String DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
    private final String SELECT_ALL = "SELECT * FROM usuarios";
    private final String SELECT_BY_ID = "SELECT * FROM usuarios WHERE id_usuario = ?";
    private final String SELECT_BY_USUARIO = "SELECT * FROM usuarios WHERE usuario = ?";

    private final String UPDATE = "UPDATE usuarios SET usuario = ?, contrasena = ?, email = ?";

    public ControladoraBD() {
    }

    public void agregarUsuario(UsuarioBean usuarioBean) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, usuarioBean.getUsuario());
            stmt.setString(2, usuarioBean.getContrasena());
            stmt.setString(3, usuarioBean.getEmail());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error");
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

    }

    public List<UsuarioBean> listarUsuarios() {

        List<UsuarioBean> usuarios = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            usuarios = new ArrayList<>();

            while (rs.next()) {
                UsuarioBean usuarioBean = new UsuarioBean();
                usuarioBean.setUsuario(rs.getString("usuario"));
                usuarioBean.setContrasena(rs.getString("contrasena"));
                usuarioBean.setEmail(rs.getString("email"));
                usuarioBean.setIdCliente(rs.getInt("id_usuario"));
                usuarios.add(usuarioBean);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladoraBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return usuarios;
    }

    public UsuarioBean encontrarUsuario(int usuarioBean) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioBean usuario = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, usuarioBean);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioBean();
                usuario.setIdCliente(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setEmail(rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return usuario;
    }
    
    public UsuarioBean encontrarUsuario(String usuarioBean) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioBean usuario = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_USUARIO);
            stmt.setString(1, usuarioBean);
            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new UsuarioBean();
                usuario.setIdCliente(rs.getInt("id_usuario"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setEmail(rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return usuario;
    }

}
