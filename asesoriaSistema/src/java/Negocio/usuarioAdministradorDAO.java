/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.Asesor;
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
public class usuarioAdministradorDAO {

    Conexion cn = new Conexion();
    Connection con;
    int r;
    PreparedStatement ps;
    ResultSet rs;

    public Usuario validar(String usuario, String contrasena) {
        Usuario user = new Usuario();

        String sql = "SELECT * FROM administradores WHERE usuario=? AND contrasena=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();

            while (rs.next()) {
                user.setUsuario(rs.getString("usuario"));
                user.setContrasena(rs.getString("contrasena"));
                user.setNombre(rs.getString("nombre"));
                user.setEmail(rs.getString("email"));

            }
        } catch (Exception e) {
        }
        return user;

    }

    public List listarAsesor() {

        String sql = "SELECT * FROM asesores";
        List<Asesor> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Asesor asesor = new Asesor();
                asesor.setId(rs.getInt(1));
                asesor.setNombre(rs.getString(2));
                asesor.setSemestre(rs.getString(3));
                asesor.setTelefono(rs.getString(4));
                asesor.setEmail(rs.getString(5));
                asesor.setUsuario(rs.getString(6));
                asesor.setContrasena(rs.getString(7));

                lista.add(asesor);
            }
        } catch (Exception e) {
        }
        return lista;

    }

    public int agregarAsesor(Asesor asesor) {

        String sql = "INSERT INTO asesores (nombre, semestre, telefono, email, usuario, contrasena) VALUES (?,?,?,?,?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, asesor.getNombre());
            ps.setString(2, asesor.getSemestre());
            ps.setString(3, asesor.getTelefono());
            ps.setString(4, asesor.getEmail());
            ps.setString(5, asesor.getUsuario());
            ps.setString(6, asesor.getContrasena());
            // ps.setDate(7, asesor.getFecha());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;

    }

    public Asesor listarIdAsesor(int id) {
        Asesor asesor = new Asesor();

        String sql = "SELECT * FROM asesores WHERE id=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                asesor.setNombre(rs.getString(2));
                asesor.setSemestre(rs.getString(3));
                asesor.setTelefono(rs.getString(4));
                asesor.setEmail(rs.getString(5));
                asesor.setUsuario(rs.getString(6));
                asesor.setContrasena(rs.getString(7));

            }

        } catch (Exception e) {
        }

        return asesor;

    }

    public int actualizarAsesor(Asesor asesor) {

        String sql = "UPDATE asesores SET nombre=?, semestre=?, telefono=?, email=?, usuario=?, contrasena=? WHERE id=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, asesor.getNombre());
            ps.setString(2, asesor.getSemestre());
            ps.setString(3, asesor.getTelefono());
            ps.setString(4, asesor.getEmail());
            ps.setString(5, asesor.getUsuario());
            ps.setString(6, asesor.getContrasena());
            ps.setInt(7, asesor.getId());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;

    }

    public void eliminarAsesor(int id) {

        String sql = "DELETE FROM  asesores WHERE id =" + id;

        try {
            con = cn.Conexion();

            ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    //aqui empiezan 
}
