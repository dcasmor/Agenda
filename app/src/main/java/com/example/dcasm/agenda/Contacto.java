package com.example.dcasm.agenda;

import java.util.UUID;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Contacto {
    private int idContacto;
    private String nombre;
    private String direccion;
    private String webBlog;
    private long telefono;

    public Contacto(String nom, String dir, String web, long tel) {
        idContacto = Integer.parseInt(UUID.randomUUID().toString());
        nombre = nom;
        direccion = dir;
        webBlog = web;
        telefono = tel;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWebBlog() {
        return webBlog;
    }

    public void setWebBlog(String webBlog) {
        this.webBlog = webBlog;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "idContacto=" + idContacto +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", webBlog='" + webBlog + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
