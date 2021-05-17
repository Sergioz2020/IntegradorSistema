<%-- 
    Document   : registrosAdministrador
    Created on : 29/03/2021, 10:32:42 PM
    Author     : Sergio
--%>
<%@page import="java.util.Hashtable"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.usuarioAdministradorDAO"%>




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

                    <form action="Controlador?accion=registroAsesorias" method="POST">

                        <div class ="form-group">
                            <label>Tema </label>
                            <input type="text" required value="${asesoria.getTema()}" name="txtTema" class="form-control">


                        </div>
                        <div class ="form-group">
                            <label>Descripcion </label>
                            <input type="text" required value="${asesoria.getDescripcion()}" name="txtDescripcion" class="form-control">


                        </div>
                        <div class ="form-group">
                            <label>Fecha </label>
                            <input type="Date" 

                                   value="2018-07-22"
                                   min="2021-01-01" max="2022-12-31" 
                                   name="txtDate" class="form-control">


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
                            <th>Tema</th>
                            <th>Descripcion</th>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th>Asesor</th>
                            <th>Enlace</th>
                            <th>Contacto Asesor</th>

                            <th>Accion</th>

                        </tr>
                    <tbody>
                        <c:forEach var = "asesoria" items="${asesorias}">
                            <tr> 
                                <td>${asesoria.getId()}</td>
                                <td>${asesoria.getTema()}</td>
                                <td>${asesoria.getDescripcion()}</td>
                                <td>${asesoria.getFecha()}</td>
                                <td>${asesoria.getHora()}</td>
                                <td>${asesoria.getNombre_asesor()}</td>
                                <td><a href="${asesoria.getEnlace()}" target="_blank">  ${asesoria.getEnlace()} </a></td>
                                <td>${asesoria.getEmail()}</td>


                                <td>
                                    <a class="btn btn-warning" href="Controlador?accion=registroAsesorias&action=Editar&id=${asesoria.getId()}">Modificar</a>
                                    <a class="btn btn-danger" href="Controlador?accion=registroAsesorias&action=Eliminar&id=${asesoria.getId()}">Eliminar</a>

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
