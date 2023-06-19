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
        <title>Vender Producto</title>
        <link rel="stylesheet" href="css/estilo7.css">
    </head>
    <style>
             form {
        display: grid;
        margin-left: 500px; 
        margin-right: 500px;
        padding: 30px;
    }
          .logo {
    position: absolute;
    top: 50px;
    left: 40px;
    display: block;
    z-index: 11;
    
  }
  .logo img {
    height: 100px;
    width: 100px;
    display: block;
  } 
    </style>
    <body>
                <%String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
            }%>
            <%PersonaDAO dao=new PersonaDAO();
            String usu=(String) session.getAttribute("usuarioSesion");
            List<Persona>list=dao.consultar3(usu);
            Iterator<Persona>iter=list.iterator();
            Persona per= null;
            int c=0;
            String Prod="";
            String img="";
            String Desc="";
            while(iter.hasNext()){
                per=iter.next();
                c=1;
                Prod=per.getNombre();
                img=per.getCR();
                Desc=per.getApellido();
            }%>
            <br>
            <header>  <a class="logo" >
            <img src="img/logo.png" alt="">
            </a>  </header>
             <h1 class="mb-0">SportSprint</h1>
<form action="Controlador" method="POST">
    <div>
        <label for="NP">Nombre del Producto</label>
        <input type="text" name="NP" id="NP" required="required">
    </div>
    <div>
        <label for="LI">Link de imagen del producto</label>
        <input type="text" name="LI" id="LI" required="required">
    </div>
    <div>
        <label for="Des">Descripción</label>
        <textarea name="Des" id="Des" rows="5" cols="50" required="required" maxlength="300"></textarea>
    </div>
    <div>
        <label for="PP">Precio</label>
        <input type="number" min="1" max="999999999999" name="PP" id="PP" required="required">
    </div>
    <div>
        <label for="CP">Cantidad de Disponibles:</label>
        <input type="number" name="CP" id="CP" min="1" required="required">
    </div>
    <div>
        <label for="tipo">Tipo de producto:</label>
        <select name="tipo" id="tipo">
            <option>Playera</option>
            <option>Tennis</option>
        </select>
    </div>
    <div class="button-container">
        <button type="submit" name="accion" value="Agregar Producto">Agregar Producto</button>
        <a href="main.jsp">Volver</a>
    </div>
    </body>
</html>
