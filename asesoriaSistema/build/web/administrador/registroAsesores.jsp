<%-- 
    Document   : registrosAdministrador
    Created on : 29/03/2021, 10:32:42 PM
    Author     : Sergio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="d-flex">
            <div class="card col-sm-4">
                <div class ="card-body">

                    <form action="Controlador?accion=registroAsesores" method="POST">

                        <div class ="form-group">
                            <label>Nombre: </label>
                            <input type="text"  required value="${asesor.getNombre()}" name="txtNombre" class="form-control">


                        </div>
                        <div class ="form-group">
                            <label>Semestre: </label>
                            <input type="text" required value="${asesor.getSemestre()} "name="txtSemestre" class="form-control">


                        </div>
                        <div class ="form-group">
                            <label>Telefono: </label>
                            <input type="text"  required value="${asesor.getTelefono()} "name="txtTelefono" class="form-control">


                        </div>
                        <div class ="form-group">
                            <label>Correo </label>
                            <input type="text"  required value="${asesor.getEmail()} "name="txtCorreo" class="form-control">


                        </div>
                        <div class ="form-group">
                            <label>Usuario </label>
                            <input type="text" required value="${asesor.getUsuario()}  "name="txtUsuario" class="form-control">


                        </div>
                        <div class ="form-group">
                            <label>Contraseña </label>
                            <input type="text" required value="${asesor.getContrasena()} "name="txtContra" class="form-control">


                        </div>


                        <input type="submit" name="action" value="Agregar" class="btn btn-info">
                        <input type="submit" name="action" value="Modificar" class="btn btn-primary">
                    </form>


                </div>


            </div>
            <div class="card col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Semestre</th>
                            <th>telefono</th>
                            <th>Email</th>
                            <th>Usuario</th>
                            <th>Contraseña</th>
                            <th>Accion</th>

                        </tr>
                    <tbody>
                        <c:forEach var = "asesor" items="${asesores}">
                            <tr> 
                                <td>${asesor.getId()}</td>
                                <td>${asesor.getNombre()}</td>
                                <td>${asesor.getSemestre()}</td>
                                <td>${asesor.getTelefono()}</td>
                                <td>${asesor.getEmail()}</td>
                                <td>${asesor.getUsuario()}</td>
                                <td>${asesor.getContrasena()}</td>

                                <td>
                                    <a class="btn btn-warning" href="Controlador?accion=registroAsesores&action=Editar&id=${asesor.getId()}">Modificar</a>
                                    <a class="btn btn-danger" href="Controlador?accion=registroAsesores&action=Eliminar&id=${asesor.getId()}">Eliminar</a>

                                </td>



                            </tr>
                        </c:forEach>

                    </tbody>


                    </thead>





                </table>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>


    </body>
</html>
