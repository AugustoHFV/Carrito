<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo2.css">
    <link rel="shortcout icon" href="IMG/logo.png">
    <title>Document</title>
</head>
<body>
            <%String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
            }%>
    <a class="logo" target="_blank">
        <img src="img/logo.png" alt="">
    </a>        
    <center><a href="Carrito.jsp"><img width="60" height="60" src="img/carrito.png" alt=""></a></center>
        <input class="menu-icon" type="checkbox" id="menu-icon" name="menu-icon"/>
        <label for="menu-icon"></label>
        <nav class="nav">     
          <ul class="pt-5">
            <li><a href="tennis.jsp">Tennis</a></li>
            <li><a href="Playeras.jsp">Playeras</a></li>
            <li><a href="Productos.jsp">Vender un Producto</a></li>
            <li><a href="Cuenta.jsp">Configuración de la cuenta</a></li>
          </ul>
        </nav>
    
        <div class="section-center">
          <h1 class="mb-0">SportSprint</h1>
        </div>
        
</body>
</html>