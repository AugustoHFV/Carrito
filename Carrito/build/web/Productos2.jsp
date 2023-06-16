<%@page import="java.util.Iterator"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Mis Productos</title>
        <link rel="stylesheet" href="css/estilo4.css" />
        <link rel="shortcout icon" href="IMG/logo.png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    </style>
    <body>
        <header>
	<h1>Mis Productos</h1>
                    <div style="position: absolute; top: 35px; right: 97px;">
    <div class="button-container">
        <a href="Cuenta.jsp">Volver</a>
    </div>
    </div>
	</header>
        <div class="container-items">
        <%String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
        }%>
        <%
            PersonaDAO dao=new PersonaDAO();
            List<Persona>list=dao.consultar5(U);
            Iterator<Persona>iter=list.iterator();
            Persona per= null;
            while(iter.hasNext()){
                per=iter.next();%>
        <a href="Controlador?accion=Mostrar2&Id=<%=per.getId()%>">
        <div class="item">
            <figure>
	<img
	src="<%=per.getCR()%>"
	alt="producto"
        />
	</figure>
	<div class="info-product">
	<h2><%=per.getNombre()%></h2>
        <p class="price">$<%=per.getContraseña()%></p>
    </div>
    </div>
        </a>
    <%}%>
    </div>
    <script src="index.js"></script>    
    </body>
</html>