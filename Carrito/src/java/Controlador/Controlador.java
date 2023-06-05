/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     String consultar="consultar.jsp";
    String registrar="main.jsp";
    String editar="editar.jsp";
   
    Persona p= new Persona();
    PersonaDAO pd= new PersonaDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
HttpSession sesion=request.getSession();
        String acceso="";
        String action=request.getParameter("accion");
        System.out.println(action);
        if(action.equalsIgnoreCase("consultar")){
            acceso=consultar;
        }else if(action.equalsIgnoreCase("Crear")){
            try{
                System.out.println("si");
                String N=request.getParameter("newname");
                String CE=request.getParameter("newemail");
                String C=request.getParameter("newpass");
                p.setNombre(N);
                p.setCR(CE);
                p.setContraseña((C));
                pd.registrar(p);
                sesion.setAttribute("mensaje","Cuenta Creada");
                sesion.setAttribute("link","index.jsp");
                acceso="mensaje.jsp";
                } catch (Exception e ) {
                    sesion.setAttribute("mensaje","Ocurrió un error");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
        }
        }else if(action.equalsIgnoreCase("Iniciar Sesion")){
            String usuario=request.getParameter("logemail");
            String contra=request.getParameter("logpass");
            try {
                if(pd.Login(usuario, contra)==1){
                    sesion.setAttribute("email",usuario);
                    sesion.setAttribute("nivel","1");
                    sesion.setAttribute("usuarioSesion",usuario);
                    sesion.setAttribute("contra",contra);
                    acceso="main.jsp";
                }
                else{
                    sesion.setAttribute("mensaje","Usuario y/o Contraseña incorrectos");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
                }
        } catch (Exception e) {
            sesion.setAttribute("mensaje","Ocurrió un error");
            sesion.setAttribute("link","index.jsp");
            acceso="mensaje.jsp";
        }
        }
        else if(action.equalsIgnoreCase("Cerrar Sesión")){
            try{
                processRequest(request, response);
                PrintWriter out = response.getWriter();
                sesion.setAttribute("usuarioSesion",null);
                sesion.setAttribute("contra",null);
            } catch (Exception e ) {
                response.sendRedirect("index.jsp");
            }
        }
            
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}    



