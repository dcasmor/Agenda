package com.example.dcasm.agenda;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Contactos {
    private static final long SERIALVERSIONUID = 1L;

    long idContacto;
    String nombre;
    String telefono;
    String direccion;
    String webBlog;
    String email;
    String foto;

    public Contactos(long id, String nom, String tel, String dir, String ema, String web, String fot) {
        idContacto = id;
        nombre = nom;
        direccion = dir;
        email = ema;
        webBlog = web;
        foto = fot;
        telefono = tel;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto() { return foto; }

    public void setFoto(String foto) { this.foto = foto; }

    @Override
    public String toString() {
        return "Contactos{" +
                "direccion='" + direccion + '\'' +
                ", idContacto=" + idContacto +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", webBlog='" + webBlog + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
