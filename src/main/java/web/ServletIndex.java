package web;

import datos.ControladoraBD;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.UsuarioBean;
import logica.Verificador;

@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Recuperamos el objeto session
        HttpSession session = request.getSession();
        //Instanciamos al verificador
        ControladoraBD bd = new ControladoraBD();
        Verificador verificador = new Verificador(bd);
        
        //Recuperamos los datos del formulario y asignamos a un objeto
        UsuarioBean usuarioBean = new UsuarioBean(request.getParameter("usuario"), 
        request.getParameter("contrasena"), request.getParameter("email"));
        
        
        //Verificamos los datos
        if(bd.encontrarUsuario(2) != null){
            //Enviamos el objeto al scope session
            session.setAttribute("usuarioBean", usuarioBean);
            //Redirigimos al jsp
            response.sendRedirect(request.getContextPath() + "\\datos.jsp");
        }else{
            //Enviamos a la pagina de error
            response.sendRedirect(request.getContextPath() + "\\error.html");
        }
        
    }

}
