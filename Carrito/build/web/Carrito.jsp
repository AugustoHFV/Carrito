
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
        <link rel="stylesheet" href="css/estilo6.css">
    </head>
    <body>
        <table border="1" class="tabla">
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Total a pagar</th>
                </tr>
            </thead>
            <%
                PersonaDAO dao=new PersonaDAO();
                String Usu=(String) session.getAttribute("usuarioSesion");
                List<Persona>list=dao.consultar7(Usu);
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                int c=0;
                while(iter.hasNext()){
                    per=iter.next();
                    String Id=per.getUsuario();
                    int Cant=per.getId();
                    List<Persona>list2=dao.consultar3(Id);
                    Iterator<Persona>iter2=list2.iterator();
                    Persona per2= null;
                    while(iter2.hasNext()){
                    c=1;
                    per2=iter2.next();
                    String Nombre=per2.getNombre();
                    String Precio=per2.getContraseña();
                    int Pre=Integer.parseInt(Precio);
                    int PrecioF=Pre*Cant;
                %>
            <tbody>
                <tr>
                    <td><%=Nombre%></td>
                    <td>$<%=Precio%></td>
                    <td><%=Cant%></td>
                    <td>$<%=PrecioF%></td>
                    <td>
                        <a href="Controlador?accion=EliminarC&Id=<%=Id%>" class="eliminar">Eliminar</a>
                    </td>
                </tr>
                <%}
                }%>
            </tbody>
        </table>
            <%if(c==1){%>
            <form action="Controlador" method="POST">
                <input type="submit" name="accion" value="Comprar Carrito" class="comprar">
            </form>
            <%}%>
            <a href="main.jsp" class="volver">Volver</a>
    </body>
</html>
