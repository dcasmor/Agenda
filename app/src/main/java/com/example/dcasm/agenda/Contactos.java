package com.example.dcasm.agenda;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Contactos {

    long idContacto = -1;
    String nombre;
    String direccion;
    String webBlog;
    String email;

    public Contactos(long id, String nom, String tel, String dir, String ema, String web) {
        idContacto = id;
        nombre = nom;
        direccion = dir;
        email = ema;
        webBlog = web;
    }

    public long getIdContacto() { return idContacto; }

    public void setIdContacto(long idContacto) { this.idContacto = idContacto; }

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

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getWebBlog() {
        return webBlog;
    }

    public void setWebBlog(String webBlog) {
        this.webBlog = webBlog;
    }

    @Override
    public String toString() {
        return "Contactos{" +
                "direccion='" + direccion + '\'' +
                ", idContacto=" + idContacto +
                ", nombre='" + nombre + '\'' +
                ", webBlog='" + webBlog + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
