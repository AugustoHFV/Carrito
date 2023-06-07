
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Compras</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Vendedor</th>
                    <th>Fecha</th>
                    <th>Cantidad</th>
                    <th>Total pagado</th>
                    <th>Numero de Venta</th>
                </tr>
            </thead>
            <%
                PersonaDAO dao=new PersonaDAO();
                String Usu=(String) session.getAttribute("usuarioSesion");
                List<Persona>list=dao.consultar10(Usu);
                Iterator<Persona>iter=list.iterator();
                Persona per= null;
                while(iter.hasNext()){
                    per=iter.next();
                    String NP=per.getNombre1();
                    String Ven=per.getVendedor();
                    String Fecha=per.getNombre();
                    int Cant=per.getId();
                    int PrecioF=per.getId2();
                    int NV=per.getNV();
                
                %>
            <tbody>
                <tr>
                    <td><%=NP%></td>
                    <td><%=Ven%></td>
                    <td><%=Fecha%></td>
                    <td><%=Cant%></td>
                    <td><%=PrecioF%></td>
                    <td><%=NV%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
            <form action="Controlador" method="POST">
                <input type="submit" name="accion" value="Comprar Carrito">
            </form>
            <a href="Cuenta.jsp">Volver</a>
    </body>
</html>