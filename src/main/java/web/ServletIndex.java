package web;

import datos.BaseDatos;
import datos.ControladoraBD;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.UsuarioBean;

@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ControladoraBD bd = new ControladoraBD();

        //Recuperamos los datos del formulario y asignamos a un objeto
        UsuarioBean usuarioBean = new UsuarioBean(request.getParameter("usuario"),
                request.getParameter("contrasena"), request.getParameter("email"));

        UsuarioBean u = null;

        if (bd.existeUsuario(usuarioBean.getUsuario())) {
            u = bd.buscarUsuario(usuarioBean.getUsuario());
            if (usuarioBean.getContrasena().equals(u.getContrasena()) &&
                usuarioBean.getEmail().equals(u.getEmail())) {
                session.setAttribute("usuarioBean", usuarioBean);
                response.sendRedirect(request.getContextPath() + "\\datos.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "\\error.html");
            }
        }
    }

}
