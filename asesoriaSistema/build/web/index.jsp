<%-- 
    Document   : index.jsp
    Created on : 23/03/2021, 07:09:52 PM
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="container mt-4 col-lg-4">
            <div class ="card col-sm-10"> 
                <div class ="card-body">
                    <form class="form-sign" action="Validar" method="POST">
                        <div class = "form-group text-center">
                            <h3>Login</h3>
                            <img src="images/image1.jpg" alt="70" width="170"/>
                            <div ><label>Bienvenido al sistema</label></div>
                            
                        </div>
                        <div class ="form-group">
                            <label>Usuario</label>
                            <input type="text" name ="txtuser" class=" form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name ="txtpass" class=" form-control">

                        </div>


                        <div>
                            <input type="radio" id="asesor" name="usuario" value="asesor">
                            <label for="Asesor">Asesor</label><br>
                            <input type="radio" id="female" name="usuario" value="solicitante">
                            <label for="Solicitante">Solicitante</label><br>
                            <input type="radio" id="other" name="usuario" value="administrador">
                            <label for="Adinistrador">Administrador</label>
                        </div>





                        <div class="mt-4 text-center">
                            <input type="submit" name ="accion" value ="Ingresar" class="btn btn-primary btn-b">
                        </div>

                    </form>
                </div>
            </div>

        </div>


    </body>
</html>
