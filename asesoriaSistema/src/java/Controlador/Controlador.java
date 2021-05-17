/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Asesor;
import Entidades.Asesoria;
import Entidades.Solicitante;
import Entidades.Solicitud;
import Negocio.asesoriaDAO;
import Negocio.solicitudDAO;
import Negocio.usuarioAdministradorDAO;
import Negocio.usuarioAsesorDAO;
import Negocio.usuarioSolicitanteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Sergio
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    usuarioAsesorDAO uaDAO = new usuarioAsesorDAO();
    usuarioSolicitanteDAO usDAO = new usuarioSolicitanteDAO();

    asesoriaDAO aseDAO = new asesoriaDAO();
    Asesoria asesoria = new Asesoria();

    solicitudDAO soliDAO = new solicitudDAO();
    Solicitud solicitud = new Solicitud();

    usuarioAdministradorDAO uadmDAO = new usuarioAdministradorDAO();
    usuarioSolicitanteDAO usuarioDAO = new usuarioSolicitanteDAO();

    Asesor asesor = new Asesor();
    Solicitante solicitante = new Solicitante();
    int ide, idAccion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        String action = request.getParameter("action");
        if (accion.equals("principalAsesor")) {
            request.getRequestDispatcher("asesor/principalAsesor.jsp").forward(request, response);
        }
        if (accion.equals("principalSolicitante")) {
            request.getRequestDispatcher("solicitante/principalSolicitante.jsp").forward(request, response);
        }
        if (accion.equals("principalAdministrador")) {
            request.getRequestDispatcher("administrador/principalAdministrador.jsp").forward(request, response);
        }

        //AQUI VA LO NUEVO bueono
        if (accion.equals("todasSolicitudes")) { //BUENO, SI SE USA
            try {
                switch (action) {
                    case "Listar":
                        List lista = soliDAO.listarSolicitudes();
                        request.setAttribute("solicitudes", lista);
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                request.getRequestDispatcher("asesor/todasSolicitudes.jsp").forward(request, response);
            }
            request.getRequestDispatcher("asesor/todasSolicitudes.jsp").forward(request, response);
        }
        if (accion.equals("todasAsesorias")) { //BUENO, SI SE USA
            try {
                switch (action) {
                    case "Listar":
                        List lista = aseDAO.listarAsesoria();
                        request.setAttribute("asesorias", lista);
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                request.getRequestDispatcher("asesor/todasAsesorias.jsp").forward(request, response);
            }
            request.getRequestDispatcher("asesor/todasAsesorias.jsp").forward(request, response);
        }

        if (accion.equals("asesoriaAsesor")) { //PENDIENTE, POSIBLE ELIMINACION
            try {
                switch (action) {
                    case "Listar":

                        ide = Integer.parseInt(request.getParameter("id"));
                        List lista = aseDAO.listar(ide);
                        request.setAttribute("asesorias", lista);
                        break;

                    case "Agregar":

                        String tema = request.getParameter("txtTema");
                        String descripcion = request.getParameter("txtDescripcion");
                        String fecString = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDate = null;
                        SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDate = new java.sql.Date(sdf2.parse(fecString).getTime());
                        String enlace = request.getParameter("txtEnlace");

                        //ide = Integer.parseInt(request.getParameter("id"));
                        asesoria.setTema(tema);
                        asesoria.setDescripcion(descripcion);
                        asesoria.setFecha(fecFormatoDate);
                        asesoria.setId_asesor(ide);
                        asesoria.setEnlace(enlace);
                        aseDAO.agregarAsesoria(asesoria);

                        request.getRequestDispatcher("Controlador?accion=asesoriaAsesor&action=Listar&id=" + ide).forward(request, response);

                        break;
                    case "Editar":

                        idAccion = Integer.parseInt(request.getParameter("id_editar"));
                        Asesoria ase = aseDAO.listarIdAsesoria(idAccion);
                        request.setAttribute("asesoria", ase);
                        request.getRequestDispatcher("Controlador?accion=asesoriaAsesor&action=Listar&id=" + ide).forward(request, response);

                        break;

                    case "Modificar":

                        String temaMod = request.getParameter("txtTema");
                        String descripcionMod = request.getParameter("txtDescripcion");
                        String fecStringMod = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDateMod = null;
                        SimpleDateFormat sdf2Mod = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDateMod = new java.sql.Date(sdf2Mod.parse(fecStringMod).getTime());
                        String enlaceMod = request.getParameter("txtEnlace");

                        asesoria.setTema(temaMod);
                        asesoria.setDescripcion(descripcionMod);
                        asesoria.setFecha(fecFormatoDateMod);
                        asesoria.setId_asesor(ide);
                        asesoria.setEnlace(enlaceMod);
                        asesoria.setId(idAccion);
                        aseDAO.actualizarAsesoria(asesoria);

                        request.getRequestDispatcher("Controlador?accion=asesoriaAsesor&action=Listar&id=" + ide).forward(request, response);
                        break;

                    case "Eliminar":
                        idAccion = Integer.parseInt(request.getParameter("id_eliminar"));
                        aseDAO.eliminarAsesoria(idAccion);
                        request.getRequestDispatcher("Controlador?accion=asesoriaAsesor&action=Listar&id=" + ide).forward(request, response);

                        break;

                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                request.getRequestDispatcher("Controlador?accion=asesoriaAsesor&action=Listar&id=" + ide).forward(request, response);
            }
            request.getRequestDispatcher("asesor/asesoriaAsesor.jsp").forward(request, response);
        }

        if (accion.equals("datosAsesor")) {
            try {
                switch (action) { //BUENO SI SE USA
                    case "Listar":

                        ide = Integer.parseInt(request.getParameter("id"));
                        Asesor ase = uadmDAO.listarIdAsesor(ide);
                        request.setAttribute("asesor", ase);
                        request.getRequestDispatcher("Controlador?accion=datosAsesor&action=Listar").forward(request, response);

                    case "Modificar":
                        String nombreModificar = request.getParameter("txtNombre");
                        String semestreModificar = request.getParameter("txtSemestre");
                        String telefonoModificar = request.getParameter("txtTelefono");
                        String correoModificar = request.getParameter("txtCorreo");
                        String usuarioModificar = request.getParameter("txtUsuario");
                        String contrasenaModificar = request.getParameter("txtContra");

                        asesor.setNombre(nombreModificar);
                        asesor.setSemestre(semestreModificar);
                        asesor.setTelefono(telefonoModificar);
                        asesor.setEmail(correoModificar);
                        asesor.setUsuario(usuarioModificar);
                        asesor.setContrasena(contrasenaModificar);
                        asesor.setId(ide);
                        uadmDAO.actualizarAsesor(asesor);
                        request.getRequestDispatcher("Controlador?accion=datosAsesor&action=Listar&id="+ide).forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }
            } catch (Exception e) {
            }
            request.getRequestDispatcher("asesor/datosAsesor.jsp").forward(request, response);

        }

        if (accion.equals("solicitudesSolicitante")) { //BUENO, SI SE USA
            try {
                switch (action) {
                    case "Listar":

                        ide = Integer.parseInt(request.getParameter("id"));
                        List lista = soliDAO.listar(ide);
                        request.setAttribute("solicitudes", lista);

                        break;

                    case "Agregar":

                        String tema = request.getParameter("txtTema");
                        String descripcion = request.getParameter("txtDescripcion");
                        String fecString = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDate = null;
                        SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDate = new java.sql.Date(sdf2.parse(fecString).getTime());

                        solicitud.setTema(tema);
                        solicitud.setDescripcion(descripcion);
                        solicitud.setFecha(fecFormatoDate);
                        solicitud.setId_solicitante(ide);
                        soliDAO.agregarSolicitud(solicitud);

                        request.getRequestDispatcher("Controlador?accion=solicitudesSolicitante&action=Listar&id=" + ide).forward(request, response);

                        break;
                    case "Editar":
                        idAccion = Integer.parseInt(request.getParameter("id_editar"));

                        Solicitud soli = soliDAO.listarIdSolicitud(idAccion);
                        request.setAttribute("solicitud", soli);
                        request.getRequestDispatcher("Controlador?accion=solicitudesSolicitante&action=Listar&id=" + ide).forward(request, response);

                        break;

                    case "Modificar":

                        String temaMod = request.getParameter("txtTema");
                        String descripcionMod = request.getParameter("txtDescripcion");

                        String fecStringMod = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDateMod = null;
                        SimpleDateFormat sdf2Mod = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDateMod = new java.sql.Date(sdf2Mod.parse(fecStringMod).getTime());

                        solicitud.setTema(temaMod);
                        solicitud.setDescripcion(descripcionMod);
                        solicitud.setFecha(fecFormatoDateMod);
                        solicitud.setId_solicitante(ide);
                        solicitud.setId(idAccion);
                        soliDAO.actualizarSolicitud(solicitud);

                        request.getRequestDispatcher("Controlador?accion=solicitudesSolicitante&action=Listar&id=" + ide).forward(request, response);

                        break;
                    case "Eliminar":

                        idAccion = Integer.parseInt(request.getParameter("id_eliminar"));
                        soliDAO.eliminarSolicitud(idAccion);

                        request.getRequestDispatcher("Controlador?accion=solicitudesSolicitante&action=Listar&id=" + ide).forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }
            } catch (Exception e) {
                request.getRequestDispatcher("solicitante/solicitudesSolicitante.jsp").forward(request, response);

            }
            request.getRequestDispatcher("solicitante/solicitudesSolicitante.jsp").forward(request, response);

        }

        //REGISTRO ASESORIAAASassaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        if (accion.equals("registroAsesorias")) { //BUENO, SI SE USA

            try {

                switch (action) {
                    case "Listar":

                        List lista = aseDAO.listarAsesoria();
                        request.setAttribute("asesorias", lista);
                        break;

                    case "Agregar":

                        String tema = request.getParameter("txtTema");
                        String descripcion = request.getParameter("txtDescripcion");
                        String fecString = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDate = null;
                        SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDate = new java.sql.Date(sdf2.parse(fecString).getTime());

                        asesoria.setTema(tema);
                        asesoria.setDescripcion(descripcion);
                        asesoria.setFecha(fecFormatoDate);
                        aseDAO.agregarAsesoria(asesoria);

                        request.getRequestDispatcher("Controlador?accion=registroAsesorias&action=Listar").forward(request, response);

                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));

                        Asesoria ase = aseDAO.listarIdAsesoria(ide);
                        request.setAttribute("asesoria", ase);
                        request.getRequestDispatcher("Controlador?accion=registroAsesorias&action=Listar").forward(request, response);

                        break;

                    case "Modificar":

                        String temaMod = request.getParameter("txtTema");
                        String descripcionMod = request.getParameter("txtDescripcion");

                        String fecStringMod = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDateMod = null;
                        SimpleDateFormat sdf2Mod = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDateMod = new java.sql.Date(sdf2Mod.parse(fecStringMod).getTime());

                        asesoria.setTema(temaMod);
                        asesoria.setDescripcion(descripcionMod);
                        asesoria.setFecha(fecFormatoDateMod);
                        asesoria.setId(ide);
                        aseDAO.actualizarAsesoria(asesoria);

                        request.getRequestDispatcher("Controlador?accion=registroAsesorias&action=Listar").forward(request, response);

                        break;

                    case "Eliminar":

                        ide = Integer.parseInt(request.getParameter("id"));
                        aseDAO.eliminarAsesoria(ide);

                        request.getRequestDispatcher("Controlador?accion=registroAsesorias&action=Listar").forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }
            } catch (Exception e) {
            }

            request.getRequestDispatcher("administrador/registroAsesorias.jsp").forward(request, response);

            //otororoeoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
        }

        if (accion.equals("registroSolicitudes")) { //BUENO, SI SE USA

            try {

                switch (action) {
                    case "Listar":

                        List lista = soliDAO.listarSolicitudes();
                        request.setAttribute("solicitudes", lista);
                        break;

                    case "Agregar":

                        String tema = request.getParameter("txtTema");
                        String descripcion = request.getParameter("txtDescripcion");
                        String fecString = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDate = null;
                        SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDate = new java.sql.Date(sdf2.parse(fecString).getTime());

                        asesoria.setTema(tema);
                        asesoria.setDescripcion(descripcion);
                        asesoria.setFecha(fecFormatoDate);
                        aseDAO.agregarAsesoria(asesoria);

                        request.getRequestDispatcher("Controlador?accion=registroSolicitudes&action=Listar").forward(request, response);

                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));

                        Asesoria ase = aseDAO.listarIdAsesoria(ide);
                        request.setAttribute("asesoria", ase);
                        request.getRequestDispatcher("Controlador?accion=registroSolicitudes&action=Listar").forward(request, response);

                        break;

                    case "Modificar":

                        String temaMod = request.getParameter("txtTema");
                        String descripcionMod = request.getParameter("txtDescripcion");
                        String fecStringMod = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDateMod = null;
                        SimpleDateFormat sdf2Mod = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDateMod = new java.sql.Date(sdf2Mod.parse(fecStringMod).getTime());

                        asesoria.setTema(temaMod);
                        asesoria.setDescripcion(descripcionMod);
                        asesoria.setFecha(fecFormatoDateMod);
                        asesoria.setId(ide);
                        aseDAO.actualizarAsesoria(asesoria);

                        request.getRequestDispatcher("Controlador?accion=registroSolicitudes&action=Listar").forward(request, response);

                        break;

                    case "Eliminar":

                        ide = Integer.parseInt(request.getParameter("id"));
                        aseDAO.eliminarAsesoria(ide);

                        request.getRequestDispatcher("Controlador?accion=registroSolicitudes&action=Listar").forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }
            } catch (Exception e) {
            }

            request.getRequestDispatcher("administrador/registroSolicitudes.jsp").forward(request, response);

            //otororoeoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
        }

        if (accion.equals("registroAsesores")) {
            try {
                switch (action) { //BUENO SI SE USA
                    case "Listar":

                        List lista = uadmDAO.listarAsesor();

                        request.setAttribute("asesores", lista);
                        break;

                    case "Agregar":

                        String nombre = request.getParameter("txtNombre");
                        String semestre = request.getParameter("txtSemestre");
                        String telefono = request.getParameter("txtTelefono");
                        String correo = request.getParameter("txtCorreo");
                        String usuario = request.getParameter("txtUsuario");
                        String contrasena = request.getParameter("txtContra");

                        /* String fecString = request.getParameter("txtDate");
                        java.sql.Date fecFormatoDate = null;
                        SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                        fecFormatoDate = new java.sql.Date(sdf2.parse(fecString).getTime());
                         */
                        asesor.setNombre(nombre);
                        asesor.setSemestre(semestre);
                        asesor.setTelefono(telefono);
                        asesor.setEmail(correo);
                        asesor.setUsuario(usuario);
                        asesor.setContrasena(contrasena);
                        //asesor.setFecha(fecFormatoDate);
                        uadmDAO.agregarAsesor(asesor);

                        request.getRequestDispatcher("Controlador?accion=registroAsesores&action=Listar").forward(request, response);

                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));

                        Asesor ase = uadmDAO.listarIdAsesor(ide);
                        request.setAttribute("asesor", ase);
                        request.getRequestDispatcher("Controlador?accion=registroAsesores&action=Listar").forward(request, response);

                        break;

                    case "Modificar":
                        String nombreModificar = request.getParameter("txtNombre");
                        String semestreModificar = request.getParameter("txtSemestre");
                        String telefonoModificar = request.getParameter("txtTelefono");
                        String correoModificar = request.getParameter("txtCorreo");
                        String usuarioModificar = request.getParameter("txtUsuario");
                        String contrasenaModificar = request.getParameter("txtContra");

                        asesor.setNombre(nombreModificar);
                        asesor.setSemestre(semestreModificar);
                        asesor.setTelefono(telefonoModificar);
                        asesor.setEmail(correoModificar);
                        asesor.setUsuario(usuarioModificar);
                        asesor.setContrasena(contrasenaModificar);

                        asesor.setId(ide);

                        uadmDAO.actualizarAsesor(asesor);
                        request.getRequestDispatcher("Controlador?accion=registroAsesores&action=Listar").forward(request, response);

                        break;
                    case "Eliminar":

                        ide = Integer.parseInt(request.getParameter("id"));
                        uadmDAO.eliminarAsesor(ide);

                        request.getRequestDispatcher("Controlador?accion=registroAsesores&action=Listar").forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }
            } catch (Exception e) {
            }
            request.getRequestDispatcher("administrador/registroAsesores.jsp").forward(request, response);
        }

        if (accion.equals("registroSolicitantes")) {
            //solicitanteskdjfovopsdvkmbzspvk´pzdkbv´pszkbpskg´pdkhrtspgh´tfdhrk
            switch (action) { //Bueno, si se usa
                case "Listar":

                    List lista = usuarioDAO.listarSolicitante();
                    request.setAttribute("solicitantes", lista);

                    break;

                case "Agregar":
                    String nombre = request.getParameter("txtNombre");
                    String institucion = request.getParameter("txtInstitucion");
                    String telefono = request.getParameter("txtTelefono");
                    String correo = request.getParameter("txtCorreo");
                    String usuario = request.getParameter("txtUsuario");
                    String contrasena = request.getParameter("txtContra");

                    solicitante.setNombre(nombre);
                    solicitante.setInstitucion(institucion);
                    solicitante.setTelefono(telefono);
                    solicitante.setEmail(correo);
                    solicitante.setUsuario(usuario);
                    solicitante.setContrasena(contrasena);

                    usuarioDAO.agregarSolicitante(solicitante);
                    request.getRequestDispatcher("Controlador?accion=registroSolicitantes&action=Listar").forward(request, response);

                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));

                    Solicitante soli = usuarioDAO.listarIdSolicitante(ide);
                    request.setAttribute("solicitante", soli);
                    request.getRequestDispatcher("Controlador?accion=registroSolicitantes&action=Listar").forward(request, response);

                    break;

                case "Modificar":
                    String nombreModificar = request.getParameter("txtNombre");
                    String institucionModificar = request.getParameter("txtInstitucion");
                    String telefonoModificar = request.getParameter("txtTelefono");
                    String correoModificar = request.getParameter("txtCorreo");
                    String usuarioModificar = request.getParameter("txtUsuario");
                    String contrasenaModificar = request.getParameter("txtContra");

                    solicitante.setNombre(nombreModificar);
                    solicitante.setInstitucion(institucionModificar);
                    solicitante.setTelefono(telefonoModificar);
                    solicitante.setEmail(correoModificar);
                    solicitante.setUsuario(usuarioModificar);
                    solicitante.setContrasena(contrasenaModificar);
                    solicitante.setId(ide);
                    usuarioDAO.actualizarSolicitante(solicitante);
                    request.getRequestDispatcher("Controlador?accion=registroSolicitantes&action=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    ide = Integer.parseInt(request.getParameter("id"));
                    usuarioDAO.eliminarSolicitante(ide);

                    request.getRequestDispatcher("Controlador?accion=registroSolicitantes&action=Listar").forward(request, response);

                    break;
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("administrador/registroSolicitantes.jsp").forward(request, response);
        }

        if (accion.equals("datosSolicitante")) {
            //solicitanteskdjfovopsdvkmbzspvk´pzdkbv´pszkbpskg´pdkhrtspgh´tfdhrk
            switch (action) { //Bueno, si se usa
                case "Listar":

                    ide = Integer.parseInt(request.getParameter("id"));

                    Solicitante soli = usuarioDAO.listarIdSolicitante(ide);
                    request.setAttribute("solicitante", soli);
                //    request.getRequestDispatcher("Controlador?accion=datosSolicitante&action=Listar").forward(request, response);

                    break;

                case "Modificar":
                    String nombreModificar = request.getParameter("txtNombre");
                    String institucionModificar = request.getParameter("txtInstitucion");
                    String telefonoModificar = request.getParameter("txtTelefono");
                    String correoModificar = request.getParameter("txtCorreo");
                    String usuarioModificar = request.getParameter("txtUsuario");
                    String contrasenaModificar = request.getParameter("txtContra");

                    solicitante.setNombre(nombreModificar);
                    solicitante.setInstitucion(institucionModificar);
                    solicitante.setTelefono(telefonoModificar);
                    solicitante.setEmail(correoModificar);
                    solicitante.setUsuario(usuarioModificar);
                    solicitante.setContrasena(contrasenaModificar);
                    solicitante.setId(ide);
                    usuarioDAO.actualizarSolicitante(solicitante);
                    request.getRequestDispatcher("Controlador?accion=datosSolicitante&action=Listar&id="+ide).forward(request, response);

                    break;
                
                default:
                    throw new AssertionError();

            }

            request.getRequestDispatcher("solicitante/datosSolicitante.jsp").forward(request, response);
        }

        if (accion.equals("datosAdministrador")) {
            request.getRequestDispatcher("administrador/datosAdministrador.jsp").forward(request, response);
        }

        String menu = request.getParameter("menu");

        /*  if (menu.equals("asesoriaAsesor")) {
            request.getRequestDispatcher("asesor/asesoriaAsesor.jsp").forward(request, response);

        }
        if (menu.equals("datosAsesor")) {
            request.getRequestDispatcher("asesor/datosAsesor.jsp").forward(request, response);

        }
         */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
