/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.Solicitud;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import confDB.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class solicitudDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    int r;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarSolicitudes() {
        
        String sql = "SELECT s.id, s.tema, s.descripcion, s.fecha, s.hora, soli.nombre, soli.institucion, soli.telefono, soli.email FROM solicitudes s LEFT JOIN solicitantes soli ON s.id_solicitante = soli.id";
        List<Solicitud> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Solicitud solicitud = new Solicitud();
                solicitud.setId(rs.getInt(1));
                solicitud.setTema(rs.getString(2));
                solicitud.setDescripcion(rs.getString(3));
                solicitud.setFecha(rs.getDate(4));
                solicitud.setHora(rs.getTime(5));
                solicitud.setNombre_solicitante(rs.getString(6));
                solicitud.setInstitucion(rs.getString(7));
                solicitud.setTelefono(rs.getString(8));
                solicitud.setEmail(rs.getString(9));
                
                lista.add(solicitud);
            }
        } catch (Exception e) {
        }
        return lista;
        
    } //este servirá para mostrar la tabla con correo y telefono atodos los asesores

    public List listar(int id) {   //este es el que estoy usando para listar SOLICITUDES de  SOLICITANTES

        String sql = "SELECT s.id, s.tema, s.descripcion, s.fecha, s.hora FROM solicitudes s  WHERE id_solicitante=" + id;
        List<Solicitud> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Solicitud solicitud = new Solicitud();
                solicitud.setId(rs.getInt(1));
                solicitud.setTema(rs.getString(2));
                solicitud.setDescripcion(rs.getString(3));
                solicitud.setFecha(rs.getDate(4));
                solicitud.setHora(rs.getTime(5));
                
                lista.add(solicitud);
            }
        } catch (Exception e) {
        }
        return lista;
        
    }
    
    public int agregarSolicitud(Solicitud solicitud) {
        
        String sql = "INSERT INTO solicitudes (tema, descripcion, fecha, id_solicitante) VALUES (?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, solicitud.getTema());
            ps.setString(2, solicitud.getDescripcion());
            ps.setDate(3, solicitud.getFecha());
            //  ps.setTime(4, asesoria.getHora());
            ps.setInt(4, solicitud.getId_solicitante());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
        
    }
    
    public Solicitud listarIdSolicitud(int id) {
        Solicitud solicitud = new Solicitud();
        
        String sql = "SELECT * FROM solicitudes WHERE id=" + id;
        List<Solicitud> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                solicitud.setTema(rs.getString(2));
                solicitud.setDescripcion(rs.getString(3));
                solicitud.setFecha(rs.getDate(4));
                //asesoria.setHora(rs.getTime(6));
                solicitud.setId_solicitante(rs.getInt(5));
                
                lista.add(solicitud);
                
            }
            
        } catch (Exception e) {
        }
        
        return solicitud;
        
    }
    
    public int actualizarSolicitud(Solicitud solicitud) {
        
        String sql = "UPDATE solicitudes SET tema=?, descripcion=?, fecha=?, id_solicitante=? WHERE id=?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, solicitud.getTema());
            ps.setString(2, solicitud.getDescripcion());
            ps.setDate(3, solicitud.getFecha());
            ps.setInt(4, solicitud.getId_solicitante());
            ps.setInt(5, solicitud.getId());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
        
    }
    
    public void eliminarSolicitud(int id) {
        
        String sql = "DELETE FROM solicitudes WHERE id =" + id;
        
        try {
            con = cn.Conexion();
            
            ps = con.prepareStatement(sql);
            
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }
    
}
