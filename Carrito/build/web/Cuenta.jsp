<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuración de Cuenta</title>
        <link rel="stylesheet" href="css/estilo5.css">
    </head>
    <style>
          input[type="text"] {
    width: 100%;
    padding: 15px;
    margin-bottom: 1px;
    box-sizing: border-box;
    border-radius: 25px;
  }
  input[type="submit"] {
    padding: 15px 15px;
    background-color: #ffeba7;
    color:black;
    border: none;
    cursor: pointer;
    border-radius: 10px;
    margin-right: 40px;
    font-size: 20px;

  }
  input[type="submit"]:hover {
    background-color: #ffeba7;
  }
  a {
    display: block;
    margin-top: 10px;
  }
.volver {
    display: inline-block;
    padding: 5px 10px;
    background-color: #ffeba7;
    color: black;
    text-decoration: none;
    border-radius: 10px;
    margin-right: 52px;
  }
  .volver:hover {
    background-color: #ffeba7;
  }
    
  .logo {
    position: absolute;
    top: 50px;
    left: 80px;
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
        
            <header>  <a class="logo" >
            <img src="img/logo.png" alt="">
            </a>  </header>
            <br>
            <form action="Controlador" method="POST">
            <p><label>Nombre de usuario</label></p>
            <p><input type="text" value="<%=Prod%>" name="NP" disabled></p>
            <p><label>Correo</label></p>
            <p><input type="text" value="<%=img%>" name="LI" required="required"></p>
            <p><label>Contraseña:</label></p>
            <p><input type="text" value="<%=Desc%>" name="CP" required="required"></p>
            <p><label>Establecer fondos de la cuenta:</label></p>
            <p><input type="text" value="<%=fondos%>" name="F" required="required"></p>
            <a href="Productos2.jsp" class="volver">Mis Ventas</a>
            <a href="Compras.jsp" class="volver">Mis Compras</a>
            <a href="main.jsp" class="volver">Volver</a>
            <p><input type="submit" name="accion" value="Editar"> <input type="submit" name="accion" value="Cerrar Sesion"></p>

        </form>
            
    </body>
</html>

