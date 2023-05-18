package web;

import datos.ControladoraBD;
import datosList.BaseDatos;
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
        
        HttpSession session = request.getSession();

        //Controladora de la base de datos y verificador de usuario
        //En la base de datos ya existe el usuario
        ControladoraBD bd = new ControladoraBD();
        Verificador verificador = new Verificador(bd);
        
        //"Base de datos" con ArrayList
        BaseDatos baseD = new BaseDatos();
        //Preestablecemos el usuario, simulando la existencia de este
        baseD.agregarUsuario(new UsuarioBean("jacksito", "jack", "jackson@outlook.com"));

        
        //Recuperamos los datos del formulario y asignamos a un objeto
        UsuarioBean usuarioBean = new UsuarioBean(request.getParameter("usuario"), 
        request.getParameter("contrasena"), request.getParameter("email"));
        
        
        //Verifica si el usuario existe en el ArrayList a travez de su nombre de usuario
        boolean esCorrecto = usuarioBean.getUsuario().equals(baseD.obtenerUsuario(0).getUsuario());


        
        if(esCorrecto){
            session.setAttribute("usuarioBean", usuarioBean);
            response.sendRedirect(request.getContextPath() + "\\datos.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "\\error.html");
        }
        

        //No funciona de esta forma
        /*
        if(verificador.esAutentico(usuarioBean)){
            session.setAttribute("usuarioBean", usuarioBean);
            response.sendRedirect(request.getContextPath() + "\\datos.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "\\error.html");
        }*/
    }

}
