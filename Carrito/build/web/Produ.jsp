<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <body>
        <form action="Controlador" method="POST">
        <%String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
            }%>
        <%
            PersonaDAO dao=new PersonaDAO();
            String Id=(String) session.getAttribute("id");
            List<Persona>list=dao.consultar3(Id);
            Iterator<Persona>iter=list.iterator();
            Persona per= null;
            int c=0;
            String Prod="";
            String img="";
            String Desc="";
            int Disp=0;
            String Precio="";
            String Vend="";
            while(iter.hasNext()){
                per=iter.next();
                c=1;
                Prod=per.getNombre();
                img=per.getCR();
                Desc=per.getApellido();
                Precio="$"+per.getContraseña();
                Disp=Integer.parseInt(per.getUsuario());
                Vend=per.getVendedor();
            }
            if(c==0){
                response.sendRedirect("main.jsp");
            }
            if(Disp<=0){
                session.setAttribute("mensaje","No hay stock del producto");
                session.setAttribute("link","main.jsp");
                response.sendRedirect("mensaje.jsp");
            }%>
        <h1><%=Prod%></h1>
        <img src="<%=img%>" alt="producto"/>
        <h3>Descripción:</h3>
        <h3><%=Desc%></h3>
        <h2><%=Precio%></h2>
        <h4>Disponibles: <%=Disp%></h4>
        <h4>Vendedor: <%=Vend%></h4>
        <h4>Cantidad a Comprar: <input name="cantidad" min="1" max="<%=Disp%>" type="number"></h4>
        <input type="submit" name="accion" value="Agregar al carrito">
        </form>
        <a href="main.jsp">Volver</a>
    </body>
</html>
