<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Productos</title>
    </head>
    <body>
        <%  String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
            }
            PersonaDAO dao=new PersonaDAO();
            List<Persona>list=dao.consultar4(U);
            Iterator<Persona>iter=list.iterator();
            Persona per= null;
            String Prod="";
            String img="";
            String Desc="";
            int fondos=0;
            while(iter.hasNext()){
                per=iter.next();
                Prod=per.getNombre();
                img=per.getCR();
                Desc=per.getContraseña();
                fondos=per.getId();
            }%>
        <form action="Controlador" method="POST">
            <p><label>Nombre de usuario</label></p>
            <p><input type="text" value="<%=Prod%>" name="NP" required="required"></p>
            <p><label>Correo</label></p>
            <p><input type="text" value="<%=img%>" name="LI" required="required"></p>
            <p><label>Contraseña:</label></p>
            <p><input type="text" value="<%=Desc%>" name="CP" required="required"></p>
            <p><label>Establecer fondos de la cuenta:</label></p>
            <p><input type="text" value="<%=fondos%>" name="F" required="required"></p>
            <p><input type="submit" name="accion" value="Editar"></p>
            <br><br>
            <p><input type="submit" name="accion" value="Cerrar Sesion"></p>
            <a href="Productos2.jsp">Mis Ventas</a>
            <a href="Compras.jsp">Mis Compras</a>
        </form>
            <a href="main.jsp">Volver</a>
    </body>
</html>

