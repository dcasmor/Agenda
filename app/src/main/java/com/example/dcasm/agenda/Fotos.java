package com.example.dcasm.agenda;

/**
 * Created by dcasm on 16/12/2016.
 */

public class Fotos {

    long idFoto = -1;
    String nomFichero;
    String observ;
    long contacto;

    public Fotos(long id, String nom, String obs, long con) {
        idFoto = id;
        nomFichero = nom;
        observ = obs;
        contacto = con;
    }

    public long getContacto() {
        return contacto;
    }

    public void setContacto(long contacto) {
        this.contacto = contacto;
    }

    public long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(long idFoto) {
        this.idFoto = idFoto;
    }

    public String getNomFichero() {
        return nomFichero;
    }

    public void setNomFichero(String nomFichero) {
        this.nomFichero = nomFichero;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    @Override
    public String toString() {
        return "Fotos{" +
                "contacto=" + contacto +
                ", idFoto=" + idFoto +
                ", nomFichero='" + nomFichero + '\'' +
                ", observ='" + observ + '\'' +
                '}';
    }
}
