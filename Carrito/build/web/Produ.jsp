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
            <link rel="stylesheet" href="css/estilo10.css">
    </head>
            <style>
            
    .button-container {
        display: flex;
        justify-content: center;  
        margin-top: 5px; 
    }

    .button-container button,
    .button-container a {
        padding: 5px 10px;
        background-color: #ffeba7;
        color: black;
        text-decoration: none;
        text-align: center;
        border: none;
        cursor: pointer;
        margin: 0 5px; 
        border-radius: 5px;
        font-size: 20px;    
    }

    .button-container button:hover,
    .button-container a:hover {
        background-color: #ffeba7;
        color: black;
    }
      .logo {
    position: absolute;
    top: 50px;
    left: 30px;
    display: block;
    z-index: 11;
    transition: all 250ms linear;
  }
  .logo img {
    height: 80px;
    width: auto;
    display: block;
  }
   .img {
    position: absolute;
    height: 400px;
    width: 400px;
    top: 500px;
    left: 760px;
    border-radius:15px; 
    display: block;
    z-index: 11;
    transition: all 250ms linear;
  }

  

        </style>
    <body>
            <a class="logo" target="_blank">
        <img src="img/logo.png" alt="">
    </a>
            <div style="position: absolute; top: 35px; right: 97px;">
    <div class="button-container">
        <a href="main.jsp">Volver</a>
    </div>
    </div>
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
            if(Disp<=0 || c==0){
                session.setAttribute("mensaje","No hay stock del producto");
                session.setAttribute("link","main.jsp");
                response.sendRedirect("mensaje.jsp");
            }%>
            <br><br>
            
        <h1><%=Prod%></h1>
        <img class="img" src="<%=img%>" alt="producto"/>
        <h3>Descripción:</h3>
        <h3><%=Desc%></h3>
        <h2><%=Precio%></h2>
        <h4>Disponibles: <%=Disp%></h4>
        <h4>Vendedor: <%=Vend%></h4>
        <h4>Cantidad a Comprar: <input name="cantidad" min="1" max="<%=Disp%>" type="number"></h4>
        <input type="submit" name="accion" value="Agregar al carrito">
        </form>

    </body>
</html>
