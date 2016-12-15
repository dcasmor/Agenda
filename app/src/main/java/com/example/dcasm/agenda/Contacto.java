package com.example.dcasm.agenda;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Contacto implements Serializable {
    private static final long SERIALVERSIONUID = 1L;

    private int idContacto;
    private String nombre;
    private String telefono;
    private String direccion;
    private String webBlog;

    public Contacto(int id, String nom, String tel, String dir, String web) {
        idContacto = id;
        nombre = nom;
        direccion = dir;
        webBlog = web;
        telefono = tel;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) { this.idContacto = idContacto; }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
