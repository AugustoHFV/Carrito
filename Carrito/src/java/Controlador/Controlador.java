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
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
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
   
    Properties props = new Properties();

    PersonaDAO dao=new PersonaDAO();
    Persona p= new Persona();
    Correos Corr=new Correos();
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
        HttpSession sesion=request.getSession();
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("Mostrar")){
            try{
                processRequest(request, response);
                PrintWriter out = response.getWriter();
                sesion.setAttribute("id",request.getParameter("Id"));
                acceso="Produ.jsp";
            } catch (Exception e ) {
                sesion.setAttribute("mensaje","Ocurrió un error");
                sesion.setAttribute("link","index.jsp");
                acceso="mensaje.jsp";
            }
        } else if(action.equalsIgnoreCase("Mostrar2")){
            try{
                processRequest(request, response);
                PrintWriter out = response.getWriter();
                sesion.setAttribute("id",request.getParameter("Id"));
                acceso="EditarP.jsp";
            } catch (Exception e ) {
                sesion.setAttribute("mensaje","Ocurrió un error");
                sesion.setAttribute("link","index.jsp");
                acceso="mensaje.jsp";
            }
        } else if(action.equalsIgnoreCase("EliminarC")){
            try{
                PersonaDAO dao=new PersonaDAO();
                processRequest(request, response);
                PrintWriter out = response.getWriter();
                p.setNombre(request.getParameter("Id"));
                p.setUsuario((String)sesion.getAttribute("usuarioSesion"));
                List<Persona>list=dao.consultar3(request.getParameter("Id"));
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                int Disp=0;
                while(iter.hasNext()){
                    per=iter.next();
                    Disp=Integer.parseInt(per.getUsuario());
                }
                List<Persona>list2=dao.consultar6((String)sesion.getAttribute("usuarioSesion"),request.getParameter("Id"));
                Iterator<Persona>iter2=list2.iterator();
                Persona per2= null;
                int Can2=0;
                while(iter2.hasNext()){
                    per2=iter2.next();
                    Can2=per2.getId();
                }
                Can2=Disp+Can2;
                pd.Restablecer(request.getParameter("Id"),Can2);
                pd.EliminarC(p);
                acceso="Carrito.jsp";
            } catch (Exception e ) {
                sesion.setAttribute("mensaje","Ocurrió un error");
                sesion.setAttribute("link","index.jsp");
                acceso="mensaje.jsp";
            }
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
        if(action.equalsIgnoreCase("consultar")){
            acceso=consultar;
        }else if(action.equalsIgnoreCase("Crear")){
            try{
                String N=request.getParameter("newname");
                N = N.replaceAll("'", "");
                String CE=request.getParameter("newemail");
                CE = CE.replaceAll("'", "");
                String C=request.getParameter("newpass");
                C = C.replaceAll("'", "");
                PersonaDAO dao=new PersonaDAO();
                List<Persona>list=dao.consultar11(N,CE);
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                int c=0;
                while(iter.hasNext()){
                    per=iter.next();
                    c=1;
                }
                if(per==null){
                p.setNombre(N);
                p.setCR(CE);
                p.setContraseña((C));
                pd.registrar(p);
                sesion.setAttribute("mensaje","Cuenta Creada");
                sesion.setAttribute("link","index.jsp");
                Corr.Correo(CE,"Cuenta Creada","Creaste una cuenta en SportSprint");
                acceso="mensaje.jsp";
                }else{
                    sesion.setAttribute("mensaje","Usuario y/o Correo ya registrados, intenta registrar otro");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
                }
                } catch (Exception e ) {
                    sesion.setAttribute("mensaje","Ocurrió un error");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
        }
        }else if(action.equalsIgnoreCase("Editar")){
            try{
                String Na=(String) sesion.getAttribute("usuarioSesion");
                String CE=request.getParameter("LI");
                CE = CE.replaceAll("'", "");
                String C=request.getParameter("CP");
                C = C.replaceAll("'", "");
                String F=request.getParameter("F");
                F = F.replaceAll("'", "");
                int CF=Integer.parseInt(F);
                if(CF>=0 && CF<=10000000)
                {
                F=Integer.toString(CF);
                p.setCR(CE);
                p.setContraseña((C));
                p.setUsuario(F);
                p.setNombre1(Na);
                pd.editar(p);
                acceso="Cuenta.jsp";
                }else{
                    sesion.setAttribute("mensaje","Evita ingresar valores ilógicos");
                    sesion.setAttribute("link","main.jsp");
                    acceso="mensaje.jsp";
                }
                } catch (Exception e ) {
                    sesion.setAttribute("mensaje","Ocurrió un error");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
        }
        }
        else if(action.equalsIgnoreCase("Agregar Producto")){
            try{
                String Ven=(String) sesion.getAttribute("usuarioSesion");
                String N=request.getParameter("NP");
                N = N.replaceAll("'", "");
                String CE=request.getParameter("LI");
                CE = CE.replaceAll("'", "");
                String Des=request.getParameter("Des");
                Des = Des.replaceAll("'", "");
                String C=request.getParameter("PP");
                C = C.replaceAll("'", "");
                String CP=request.getParameter("CP");
                CP = CP.replaceAll("'", "");
                String T=request.getParameter("tipo");
                T = T.replaceAll("'", "");
                PersonaDAO dao=new PersonaDAO();
                List<Persona>list=dao.consultar2();
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                int id=0;
                while(iter.hasNext()){
                    per=iter.next();
                    id=per.getId()+1;
                }
                p.setVendedor(Ven);
                p.setNombre(N);
                p.setCR(CE);
                p.setApellido(Des);
                p.setContraseña((C));
                p.setNombre1(CP);
                p.setUsuario(T);
                p.setId(id);
                pd.registrarP(p);
                sesion.setAttribute("mensaje","Producto Agregado");
                sesion.setAttribute("link","main.jsp");
                acceso="mensaje.jsp";
                } catch (Exception e ) {
                    sesion.setAttribute("mensaje","Ocurrió un error");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
        }
        }else if(action.equalsIgnoreCase("Agregar al carrito")){
            try{
                String ID=(String) sesion.getAttribute("id");
                int Can=Integer.parseInt(request.getParameter("cantidad"));         
                String Comp=(String) sesion.getAttribute("usuarioSesion");
                PersonaDAO dao=new PersonaDAO();
                List<Persona>list=dao.consultar3(ID);
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                int Disp=0;
                while(iter.hasNext()){
                    per=iter.next();
                    Disp=Integer.parseInt(per.getUsuario());
                }
                List<Persona>list2=dao.consultar6(Comp,ID);
                Iterator<Persona>iter2=list2.iterator();
                Persona per2= null;
                int c=0;
                int Can2=0;
                while(iter2.hasNext()){
                    per2=iter2.next();
                    Can2=per2.getId();
                    c=1;
                }
                int Can3=Can+Can2;
                if(Can>0 && Can<=Disp){
                    Can=Disp-Can;
                    p.setVendedor(ID);
                    p.setId(Can3);
                    p.setId2(Can);
                    p.setNombre(Comp);
                    if(c==0){
                        pd.registrarC(p);
                    }else{
                        pd.editarC(p);
                    }
                    pd.editarDis(p);
                    acceso="Carrito.jsp";
                }else{
                    sesion.setAttribute("mensaje","Evita exceder el máximo de disponibilidad");
                    sesion.setAttribute("link","Produ.jsp");
                    acceso="mensaje.jsp";
                }
                } catch (Exception e ) {
                    sesion.setAttribute("mensaje","Ocurrió un error");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
        }
        }else if(action.equalsIgnoreCase("Comprar Carrito")){
            try{       
                String Comp=(String) sesion.getAttribute("usuarioSesion");
                Fecha Fec=new Fecha();
                List<Persona>list=dao.consultar7(Comp);
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                int Disp=0;
                while(iter.hasNext()){
                    per=iter.next();
                    String Id=per.getUsuario();
                    int can=per.getId();
                    String Fecha=Fec.Fecha();
                    List<Persona>list2=dao.consultar3(Id);
                    Iterator<Persona>iter2=list2.iterator();
                    Persona per2= null;
                    while(iter2.hasNext()){
                        per2=iter2.next();
                        String NP=per2.getNombre();
                        int Precio=Integer.parseInt(per2.getContraseña());
                        String Vendedor=per2.getVendedor();
                        int PrecioF=can*Precio;
                        List<Persona>list3=dao.consultar8(Comp);
                        Iterator<Persona>iter3=list3.iterator();
                        Persona per3= null;
                        while(iter3.hasNext()){
                            per3=iter3.next();
                            int Fondos=per3.getId();
                            int NV=1;
                            List<Persona>list4=dao.consultar9(Vendedor);
                            Iterator<Persona>iter4=list4.iterator();
                            Persona per4= null;
                            while(iter4.hasNext()){
                                per4=iter4.next();
                                NV=(per4.getId())+1;
                            }
                            if(Fondos>=PrecioF){
                                String CE=(String) sesion.getAttribute("email");
                                int Fondos2=Fondos-PrecioF;
                                p.setNombre1(NP);
                                p.setVendedor(Vendedor);
                                p.setApellido(Fecha);
                                p.setId(can);
                                p.setId2(PrecioF);
                                p.setNV(NV);
                                p.setUsuario(Comp);
                                pd.editarF(Fondos2,Comp);
                                pd.registrarCompra(p);
                                List<Persona>list8=dao.consultar4(Vendedor);
                                Iterator<Persona>iter8=list8.iterator();
                                Persona per8= null;
                                int fondos3=0;
                                while(iter8.hasNext()){
                                    per8=iter8.next();
                                    fondos3=per8.getId();
                                }
                                fondos3=fondos3+PrecioF;
                                pd.editarF(fondos3, Vendedor);
                                pd.EliminarCP(Id,Comp);
                                Corr.Correo(CE,"Realizaste una compra en SportSprint","Producto: "+NP+" /// Cantidad: "+can+" /// Total Pagado: $"+PrecioF);
                                acceso="Compras.jsp";
                            }else{
                                sesion.setAttribute("mensaje","Fondos Insuficientes");
                                sesion.setAttribute("link","Carrito.jsp");
                                acceso="mensaje.jsp";
                            }
                        }
                    }    
                }
                } catch (Exception e ) {
                    sesion.setAttribute("mensaje","Ocurrió un error");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
        }
        }else if(action.equalsIgnoreCase("Editar Producto")){
            try{
                String Ven=(String) sesion.getAttribute("usuarioSesion");
                String N=request.getParameter("NP");
                N = N.replaceAll("'", "");
                String CE=request.getParameter("LI");
                CE = CE.replaceAll("'", "");
                String Des=request.getParameter("Des");
                Des = Des.replaceAll("'", "");
                String C=request.getParameter("PP");
                C = C.replaceAll("'", "");
                int CF=Integer.parseInt(C);
                String CP=request.getParameter("CP");
                CP = CP.replaceAll("'", "");
                int CFP=Integer.parseInt(CP);
                String T=request.getParameter("tipo");
                T = T.replaceAll("'", "");
                if(CF>=0 && CF<=10000000 && CFP>=0 && CFP<=10000000)
                {
                    C=Integer.toString(CF);
                    CP=Integer.toString(CFP);
                    int id=Integer.parseInt((String) sesion.getAttribute("id"));
                    p.setVendedor(Ven);
                    p.setNombre(N);
                    p.setCR(CE);
                    p.setApellido(Des);
                    p.setContraseña((C));
                    p.setNombre1(CP);
                    p.setUsuario(T);
                    p.setId(id);
                    pd.editarP(p);
                    sesion.setAttribute("mensaje","Producto Editado");
                    sesion.setAttribute("link","Productos2.jsp");
                    acceso="mensaje.jsp";
                }else{
                    sesion.setAttribute("mensaje","Evita ingresar valores ilógicos");
                    sesion.setAttribute("link","main.jsp");
                    acceso="mensaje.jsp";
                }
                } catch (Exception e ) {
                    sesion.setAttribute("mensaje","Ocurrió un error");
                    sesion.setAttribute("link","index.jsp");
                    acceso="mensaje.jsp";
        }
        }else if(action.equalsIgnoreCase("Iniciar Sesion")){
            String usuario=request.getParameter("logemail");
            usuario = usuario.replaceAll("'", "");
            String contra=request.getParameter("logpass");
            contra = contra.replaceAll("'", "");
            try {
                if(pd.Login(usuario, contra)==1){
                    List<Persona>list3=dao.consultar4(usuario);
                    Iterator<Persona>iter3=list3.iterator();
                    Persona per3= null;
                    String Email="";
                    while(iter3.hasNext()){
                        per3=iter3.next();
                        Email=per3.getCR();
                    }
                    sesion.setAttribute("email",Email);
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
        else if(action.equalsIgnoreCase("Cerrar Sesion")){
            try{
                System.out.println("si");
                sesion.setAttribute("usuarioSesion",null);
                sesion.setAttribute("mensaje","Cuenta cerrada");
                sesion.setAttribute("link","index.jsp");
                acceso="mensaje.jsp";
            } catch (Exception e ) {
                sesion.setAttribute("mensaje","Ocurrió un error");
                sesion.setAttribute("link","index.jsp");
                acceso="mensaje.jsp";
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



