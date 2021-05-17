/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.Asesoria;
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
public class asesoriaDAO {

    Conexion cn = new Conexion();
    Connection con;
    int r;
    PreparedStatement ps;
    ResultSet rs;

    public List listar(int id) {   //este es el que estoy usando para listar asesorias de  asesores

        String sql = "SELECT a.id, a.tema, a.descripcion, a.fecha, a.hora, ase.nombre, a.enlace FROM asesorias a LEFT JOIN asesores ase ON a.id_asesor = ase.id WHERE id_asesor=" + id;
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
                asesoria.setEnlace(rs.getString(7));

                lista.add(asesoria);
            }
        } catch (Exception e) {
        }
        return lista;

    }

    public List listarAsesoria() { //este se usa para listar en General

        String sql = "SELECT a.id, a.tema, a.descripcion, a.fecha, a.hora, ase.nombre, ase.email, a.enlace FROM asesorias a LEFT JOIN asesores ase ON a.id_asesor = ase.id";
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
                asesoria.setEmail(rs.getString(7));
                asesoria.setEnlace(rs.getString(8));

                lista.add(asesoria);
            }
        } catch (Exception e) {
        }
        return lista;

    }

    public int agregarAsesoria(Asesoria asesoria) {

        String sql = "INSERT INTO asesorias (tema, descripcion, fecha, id_asesor, enlace) VALUES (?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, asesoria.getTema());
            ps.setString(2, asesoria.getDescripcion());
            ps.setDate(3, asesoria.getFecha());
            //  ps.setTime(4, asesoria.getHora());
            ps.setInt(4, asesoria.getId_asesor());
            ps.setString(5, asesoria.getEnlace());
            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;

    }

    public Asesoria listarIdAsesoria(int id) {
        Asesoria asesoria = new Asesoria();

        String sql = "SELECT * FROM asesorias WHERE id=" + id;
        List<Asesoria> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                asesoria.setTema(rs.getString(2));
                asesoria.setDescripcion(rs.getString(3));
                asesoria.setFecha(rs.getDate(4));
                //asesoria.setHora(rs.getTime(6));
                asesoria.setId_asesor(rs.getInt(5));
                asesoria.setEnlace(rs.getString(6));

                lista.add(asesoria);

            }

        } catch (Exception e) {
        }

        return asesoria;

    }

    public Asesoria listarIdAsesoria_1(int id) {
        Asesoria asesoria = new Asesoria();

        String sql = "SELECT * FROM asesorias WHERE id_asesor=" + id;
        List<Asesoria> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                asesoria.setId(rs.getInt(2));
                asesoria.setTema(rs.getString(3));
                asesoria.setDescripcion(rs.getString(4));
                asesoria.setId_asesor(rs.getInt(5));
                asesoria.setId_solicitante(rs.getInt(6));
                asesoria.setFecha(rs.getDate(7));
                asesoria.setHora(rs.getTime(8));
                asesoria.setEstatus(rs.getString(9));

                lista.add(asesoria);

            }

        } catch (Exception e) {
        }

        return asesoria;

    }

    public int actualizarAsesoria(Asesoria asesoria) {

        String sql = "UPDATE asesorias SET tema=?, descripcion=?, fecha=?, id_asesor=?, enlace=? WHERE id=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, asesoria.getTema());
            ps.setString(2, asesoria.getDescripcion());
            ps.setDate(3, asesoria.getFecha());
            ps.setInt(4, asesoria.getId_asesor());
            ps.setString(5, asesoria.getEnlace());
            ps.setInt(6, asesoria.getId());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;

    }

    public void eliminarAsesoria(int id) {

        String sql = "DELETE FROM  asesorias WHERE id =" + id;

        try {
            con = cn.Conexion();

            ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

}
