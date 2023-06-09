<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://unicons.iconscout.com/release/v2.1.9/css/unicons.css'>
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="shortcout icon" href="IMG/logo.png">
    <title>Inicio de Sesion</title>
    <style>
        .logo {
    position: absolute;
    top: 30px;
    right:1700px;
    display: block;
    z-index: 100;
    transition: all 250ms linear;
}
.logo img {
    height: 130px;
    width: auto;
    display: block;
}
    </style>
</head>

<body>
    <%String U=(String) session.getAttribute("usuarioSesion");
    if(U!=null){
    response.sendRedirect("main.jsp");
    }%>
    <a class="logo" target="_blank">
        <img src="img/logo.png" alt="">
    </a>
    

    <div class="section">
        <div class="container">
            <div class="row full-height justify-content-center">
                <div class="col-12 text-center align-self-center py-5">
                    <div class="section pb-5 pt-5 pt-sm-2 text-center">
                        <h6 class="mb-0 pb-3"><span>Iniciar Sesion</span><span>Crear Cuenta</span></h6>
                        <input class="checkbox" type="checkbox" id="reg-log" name="reg-log" />
                        <label for="reg-log"></label>
                        <div class="card-3d-wrap mx-auto">
                            <div class="card-3d-wrapper">
                                <div class="card-front">
                                    <div class="center-wrap">
                                        <div class="section text-center">
                                            <form action="Controlador" method="POST">
                                            <h4 class="mb-4 pb-3">Iniciar Sesion</h4>
                                            <div class="form-group">
                                                <input type="text" name="logemail" class="form-style"
                                                    placeholder="Nombre de Usuario" id="logemail" autocomplete="off">
                                                <i class="input-icon uil uil-user"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <input type="password" name="logpass" class="form-style"
                                                    placeholder="Contraseņa" id="logpass" autocomplete="off">
                                                <i class="input-icon uil uil-lock-alt"></i>
                                            </div>
                                            <input type="submit" name="accion" value="Iniciar Sesion">
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-back">
                                    <div class="center-wrap">
                                        <div class="section text-center">
                                            <form action="Controlador" method="POST">
                                            <h4 class="mb-4 pb-3">Crear Cuenta</h4>
                                            <div class="form-group">
                                                <input type="text" name="newname" class="form-style"
                                                    placeholder="Nombre de Usuario" required="required" autocomplete="off">
                                                <i class="input-icon uil uil-user"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <input type="email" name="newemail" class="form-style"
                                                    placeholder="Email" required="required"  autocomplete="off">
                                                <i class="input-icon uil uil-at"></i>
                                            </div>
                                            <div class="form-group mt-2">
                                                <input type="password" name="newpass" class="form-style"
                                                    placeholder="Crea una Contraseņa" required="required"  autocomplete="off">
                                                <i class="input-icon uil uil-lock-alt"></i>
                                            </div>
                                            <input type="submit" name="accion" value="Crear">
                                            </form>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<center><h3 class="h3"><span>Nota: los terminos ' no se registran</span></h3></center>
    <script src="./script.js"></script>
</body>

</html>