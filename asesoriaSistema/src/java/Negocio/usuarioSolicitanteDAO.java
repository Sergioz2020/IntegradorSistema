/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.Asesoria;
import Entidades.Solicitante;
import Entidades.Usuario;
import confDB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class usuarioSolicitanteDAO {

    Conexion cn = new Conexion();
    Connection con;

    PreparedStatement ps;
    ResultSet rs; 
    int r;

    public Usuario validar(String usuario, String contrasena) {
        Usuario user = new Usuario();

        String sql = "SELECT * FROM solicitantes WHERE usuario=? AND contrasena=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            rs = ps.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contrasena"));
                user.setNombre(rs.getString("nombre"));
                user.setEmail(rs.getString("email"));

            }
        } catch (Exception e) {
        }
        return user;

    }
    
        public List listar(int id) {

        String sql = "SELECT a.id, a.Tema, a.Descripcion, a.fecha, a.hora, ase.nombre " 
                + "FROM asesorias a "
                + "LEFT JOIN asesores ase ON a.id_asesor = ase.id "
                + "WHERE id_solicitante=" + id;
        List<Asesoria> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Asesoria asesoria = new Asesoria();
                asesoria.setId(rs.getInt(1));
                asesoria.setTema(rs.getString(2));
                asesoria.setDescripcion(rs.getString(3));          
                asesoria.setFecha(rs.getDate(4));
                asesoria.setHora(rs.getTime(5));
                asesoria.setNombre_asesor(rs.getString(6));
                
                lista.add(asesoria);
            }
        } catch (Exception e) {
        }
        return lista;

    }
        
     
        
        
        
        
        
            public List listarSolicitante() {

        String sql = "SELECT * FROM solicitantes";
        List<Solicitante> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Solicitante solicitante = new Solicitante();
                solicitante.setId(rs.getInt(1));
                solicitante.setNombre(rs.getString(2));
                solicitante.setInstitucion(rs.getString(3));
                solicitante.setTelefono(rs.getString(4));
                solicitante.setEmail(rs.getString(5));
                solicitante.setUsuario(rs.getString(6));
                solicitante.setContrasena(rs.getString(7));

                lista.add(solicitante);
            }
        } catch (Exception e) {
        }
        return lista;

    }

    public int agregarSolicitante(Solicitante solicitante) {

        String sql = "INSERT INTO solicitantes (nombre, institucion, telefono, email, usuario, contrasena) VALUES (?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, solicitante.getNombre());
            ps.setString(2, solicitante.getInstitucion());
            ps.setString(3, solicitante.getTelefono());
            ps.setString(4, solicitante.getEmail());
            ps.setString(5, solicitante.getUsuario());
            ps.setString(6, solicitante.getContrasena());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;

    }
    public Solicitante listarIdSolicitante(int id) {
        Solicitante solicitante = new Solicitante();

        String sql = "SELECT * FROM solicitantes WHERE id=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                solicitante.setNombre(rs.getString(2));
                solicitante.setInstitucion(rs.getString(3));
                solicitante.setTelefono(rs.getString(4));
                solicitante.setEmail(rs.getString(5));
                solicitante.setUsuario(rs.getString(6));
                solicitante.setContrasena(rs.getString(7));

            }

        } catch (Exception e) {
        }

        return solicitante;

    }

    public int actualizarSolicitante(Solicitante solicitante) {

        String sql = "UPDATE solicitantes SET nombre=?,institucion=?,telefono=?,email=?,usuario=?,contrasena=? WHERE id=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, solicitante.getNombre());
            ps.setString(2, solicitante.getInstitucion());
            ps.setString(3, solicitante.getTelefono());
            ps.setString(4, solicitante.getEmail());
            ps.setString(5, solicitante.getUsuario());
            ps.setString(6, solicitante.getContrasena());

            ps.setInt(7, solicitante.getId());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;

    }

    public void eliminarSolicitante(int id) {

        String sql = "DELETE FROM  solicitantes WHERE id =" + id;

        try {
            con = cn.Conexion();

            ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
        
        
        
        
}
