/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.Asesoria;
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
public class usuarioAsesorDAO {

    Conexion cn = new Conexion();
    Connection con;

    PreparedStatement ps;
    ResultSet rs;
    int resultado;

    public Usuario validar(String usuario, String contrasena) {
        Usuario user = new Usuario();

        String sql = "SELECT * FROM asesores WHERE usuario=? AND contrasena=?";

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

        String sql = "SELECT a.id, a.Tema, a.Descripcion, a.fecha, a.hora, s.nombre "
                + "FROM asesorias a "
                + "LEFT JOIN solicitantes s ON a.id_solicitante = s.id "
                + "WHERE id_asesor=" + id;
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
                asesoria.setNombre_solicitante(rs.getString(6));

                lista.add(asesoria);
            }
        } catch (Exception e) {
        }
        return lista;

    }

    public int agregar(Asesoria asesoria) {

        String sql = "INSERT INTO asesorias(Tema, Descripcion) VALUES (?,?) ";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(2, asesoria.getTema());
            ps.setString(3, asesoria.getDescripcion());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return resultado;

    }



}
