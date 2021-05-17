/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sergio
 */
public class Asesoria {

    int id;
    String tema;
    String descripcion;
    int id_asesor;
    int id_solicitante;
    int id_administrador;
    Date fecha;
    Time hora;
    String estatus;
    String nombre_solicitante;
    String nombre_asesor;
    String fechaa;
    String enlace;
    String email;

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public Asesoria(String fechaa) {
        this.fechaa = fechaa;
    }

    
    
    public String getFechaa() {
        return fechaa;
    }

    public void setFechaa(String fechaa) {
        this.fechaa = fechaa;
    }
    
    
    
    

    public Asesoria() {
    }

    public Asesoria(int id, String tema, String descripcion, int id_asesor, int id_solicitante, int id_administrador, Date fecha, Time hora, String estatus, String nombre_solicitante, String nombre_asesor, String email) {
        this.id = id;
        this.tema = tema;
        this.descripcion = descripcion;
        this.id_asesor = id_asesor;
        this.id_solicitante = id_solicitante;
        this.id_administrador = id_administrador;
        this.fecha = fecha;
        this.hora = hora;
        this.estatus = estatus;
        this.nombre_solicitante = nombre_solicitante;
        this.nombre_asesor = nombre_asesor;
        this.email = email;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_asesor() {
        return id_asesor;
    }

    public void setId_asesor(int id_asesor) {
        this.id_asesor = id_asesor;
    }

    public int getId_solicitante() {
        return id_solicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.id_solicitante = id_solicitante;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombre_solicitante() {
        return nombre_solicitante;
    }

    public void setNombre_solicitante(String nombre_solicitante) {
        this.nombre_solicitante = nombre_solicitante;
    }



    public String getNombre_asesor() {
        return nombre_asesor;
    }

    public void setNombre_asesor(String nombre_asesor) {
        this.nombre_asesor = nombre_asesor;
    }
}

