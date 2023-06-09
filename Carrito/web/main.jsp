<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo2.css">
    <link rel="shortcout icon" href="IMG/logo.png">
    <title>Principal</title>
    <style>
        
  .nav{
    position: fixed;
    top: 33px;
    right: 50px;
    display: block;
    width: 80px;
    height: 80px;
    padding: 0;
    margin: 0;
    z-index: 9;
    overflow: hidden;
    box-shadow: 0 8px 30px 0 rgba(0,0,0,0.3);
    background-color: #353746;
    text-decoration:none;
    animation: border-transform 7s linear infinite;
    transition: top 350ms 1100ms cubic-bezier(0.23, 1, 0.32, 1),  
                right 350ms 1100ms cubic-bezier(0.23, 1, 0.32, 1),
                transform 250ms 1100ms ease,
                width 650ms 400ms cubic-bezier(0.23, 1, 0.32, 1),
                height 650ms 400ms cubic-bezier(0.23, 1, 0.32, 1);
  }
  @keyframes border-transform{
      0%,100% { border-radius: 63% 37% 54% 46% / 55% 48% 52% 45%; } 
    14% { border-radius: 40% 60% 54% 46% / 49% 60% 40% 51%; } 
    28% { border-radius: 54% 46% 38% 62% / 49% 70% 30% 51%; } 
    42% { border-radius: 61% 39% 55% 45% / 61% 38% 62% 39%; } 
    56% { border-radius: 61% 39% 67% 33% / 70% 50% 50% 30%; } 
    70% { border-radius: 50% 50% 34% 66% / 56% 68% 32% 44%; } 
    84% { border-radius: 46% 54% 50% 50% / 35% 61% 39% 65%; } 
  }
  
  .menu-icon:checked ~ .nav {
    animation-play-state: paused;
    top: 50%;
    right: 50%;
    transform: translate(50%, -50%);
    text-decoration:none;
    width: 200%;
    height: 200%;
    transition: top 350ms 700ms cubic-bezier(0.23, 1, 0.32, 1),  
                right 350ms 700ms cubic-bezier(0.23, 1, 0.32, 1),
                transform 250ms 700ms ease,
                width 750ms 1000ms cubic-bezier(0.23, 1, 0.32, 1),
                height 750ms 1000ms cubic-bezier(0.23, 1, 0.32, 1);
  }
  
  .nav ul{
    position: absolute;
    text-decoration:none;
    top: 50%;
    left: 0;
    display: block;
    width: 100%;
    padding: 0;
    margin: 0;
    z-index: 6;
    text-align: center;
    transform: translateY(-50%);
    list-style: none;
  }
  .nav ul li{
    position: relative;
    display: block;
    width: 100%;
    padding: 0;
    margin: 10px 0;
    text-align: center;
    list-style: none;
    pointer-events: none;
    opacity: 0;
    visibility: hidden;
    text-decoration:none;
    transform: translateY(30px);
    transition: all 250ms linear;
  }
  .nav ul li:nth-child(1){
    transition-delay: 200ms;
  }
  .nav ul li:nth-child(2){
    transition-delay: 150ms;
  }
  .nav ul li:nth-child(3){
    transition-delay: 100ms;
  }
  .nav ul li:nth-child(4){
    transition-delay: 50ms;
  }
  .nav ul li a{
    font-family: 'Montserrat', sans-serif;
    font-size: 9vh;
    text-transform: uppercase;
    line-height: 1.2;
    font-weight: 800;
    display: inline-block;
    position: relative;
    color: #ececee;
    transition: all 250ms linear;
  }
  .nav ul li a:hover{
    text-decoration: none;
    color: #ffeba7;
  }
  .nav ul li a:after{
    display: block;
    position: absolute;
    top: 50%;
    content: '';
    height: 2vh;
    margin-top: -1vh;
    width: 0;
    left: 0;
    background-color: #353746;
    opacity: 0.8;
    transition: width 250ms linear;
    text-decoration: none;
  }
  .nav ul li a:hover:after{
    width: 100%;
  }
          .carrito{
      position: absolute;
      bottom: 20px;
      left: 20px;
      background-color: #353746;
      padding: 9px ;
      border-radius: 10px;
  }
    </style>
</head>
<body>
            <%String U=(String) session.getAttribute("usuarioSesion");
            if(U==null){
            response.sendRedirect("index.jsp");
            }%>
    <a class="logo" target="_blank">
        <img src="img/logo.png" alt="">
    </a>        
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
        <div class="carrito"><a href="Carrito.jsp"><img width="60" height="60" src="img/compras.png" alt=""></a></div>
</body>
</html>