<%-- 
    Document   : Principal.jsp
    Created on : 23/03/2021, 07:11:07 PM
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <div class="collapse navbar-collapse" id="navBarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" aria-current="page" href="#">Home</a>

                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?accion=asesoriaAsesor&action=Listar&id=${usuario.getId()}" target="myFrame">Mis Asesorías</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?accion=datosAsesor&action=Listar&id=${usuario.getId()}" target="myFrame">Datos Personales</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?accion=todasAsesorias&action=Listar" target="myFrame">Asesorias</a>
                    </li>
                      <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="Controlador?accion=todasSolicitudes&action=Listar" target="myFrame">Todas Solicitudes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="#">Contacto</a>
                    </li>

                </ul>
                <div class="dropdown">
                    <button  style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false" text-center>

                        
               
                        
                        Asesor: ${usuario.getNombre()}
                         ID ${usuario.getId()}    
                         
                    </button>
                    <ul class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">

                            <img src="images/image1.jpg" alt="60" width="60"/>
                        </a>


                        <a class="dropdown-item" href="#">
                            ${usuario.getUsuario()}
                        </a>
                        <a class="dropd own-item" href="#">
                            ${usuario.getEmail()}
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">

                            <form action="Validar" method="POST">

                                <button name ="accion" value="salir" class="dropdown-item" href="%">Salir</button>
                            </form>

                        </a>

                    </ul>
                </div>

            </div>

        </nav>
        <div class="m-4" style="height: 550px;">

            <iframe name="myFrame" style="height: 100%; width: 100%">


            </iframe>
        </div>              
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>


    </body>
</html>
