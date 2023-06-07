<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuenta</title>
    </head>
    <body>
                <%String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
            }%>
            <%  PersonaDAO dao=new PersonaDAO();
                String Id=(String) session.getAttribute("id");
                List<Persona>list=dao.consultar3(Id);
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                int c=0;
                String Prod="";
                String img="";
                String Desc="";
                String Disp="";
                String Precio="";
                String Vend="";
                while(iter.hasNext()){
                    per=iter.next();
                    c=1;
                    Prod=per.getNombre();
                    img=per.getCR();
                    Desc=per.getApellido();
                    Precio=per.getContraseña();
                    Disp=per.getUsuario();
            }
            if(c==0){
                response.sendRedirect("main.jsp");
            }%>
        <form action="Controlador" method="POST">
            <p><label>Nombre del Producto</label></p>
            <p><input type="text" name="NP" value="<%=Prod%>" required="required"></p>
            <p><label>link de imagen del producto</label></p>
            <p><input type="text" name="LI" value="<%=img%>" required="required"></p>
            <p><label>Descripción</label></p>
            <p><textarea name="Des" rows="5" cols="50" required="required" maxlength="300"><%=Desc%></textarea></p>
            <p><label>Precio</label></p>
            <p>$<input type="number" min="1" max="999999999999" value="<%=Precio%>" name="PP" required="required"></p>
            <p><label>Cantidad de Disponibles:</label></p>
            <p><input type="number" name="CP" value="<%=Disp%>" min="1" required="required"></p>
            <p><label>Tipo de producto:</label></p>
            <p><select name="tipo">
                <option>Playera</option>
                <option>Tennis</option>
            </select></p>
            <p><input type="submit" name="accion" value="Editar Producto"></p>
        </form>
            <a href="Productos2.jsp">Volver</a>
    </body>
</html>