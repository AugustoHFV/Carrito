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
        <link rel="stylesheet" href="css/estilo9.css">
        <style>
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
        margin-top: 30px;
        margin-right: 100px;
        border-radius: 5px;
        font-size: 20px;    
    }

    .button-container button:hover,
    .button-container a:hover {
        background-color: #ffeba7;
        color: black;
    }
        </style>
    </head>
    <body>
                    <header>  <a class="logo" >
            <img src="img/logo.png" alt="">
            </a>  </header>
            <div style="position: absolute; top: 35px; right: 97px;">
    <div class="button-container">
        <a href="Productos2.jsp">Volver</a>
    </div>
    </div>
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
            <br><br><br>
            
            <form action="Controlador" method="POST">
            <p><label>Nombre del Producto</label></p>
            <p><input type="text" name="NP" value="<%=Prod%>" required="required"></p>
            <p><label>Link de imagen del producto</label></p>
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

    </body>
</html>