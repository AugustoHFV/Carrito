<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Tennis</title>
        <link rel="stylesheet" href="css/estilo3.css" />
        <link rel="shortcout icon" href="IMG/logo.png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    </head>
    <body>
        
               <%String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
            }%>
       <header>
	<h1>Tenis</h1>
	</header>
        <head>
        <title>Compra-venta de casas</title>
        <link rel="stylesheet" href="css/estilo3.css" />    
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <body>
            <div style="position: absolute; top: 35px; right: 97px;">
    <div class="button-container">
        <a href="main.jsp">Volver</a>
    </div>
    </div>
       
       <header>

        <div class="container-items">
        <%
            PersonaDAO dao=new PersonaDAO();
            List<Persona>list=dao.consultar1("Tennis");
            Iterator<Persona>iter=list.iterator();
            Persona per= null;
            while(iter.hasNext()){
                per=iter.next();%>
        <a href="Controlador?accion=Mostrar&Id=<%=per.getId()%>">
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