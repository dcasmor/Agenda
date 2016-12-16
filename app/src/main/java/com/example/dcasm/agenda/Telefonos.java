package com.example.dcasm.agenda;

/**
 * Created by dcasm on 16/12/2016.
 */

public class Telefonos {

    long idTelefono = -1;
    String telefono;
    long contacto;

    public Telefonos(long id, String tel, long cont) {
        idTelefono = id;
        telefono = tel;
        contacto = cont;
    }

    public long getContacto() {
        return contacto;
    }

    public void setContacto(long contacto) {
        this.contacto = contacto;
    }

    public long getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(long idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Telefonos{" +
                "contacto=" + contacto +
                ", idTelefono=" + idTelefono +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
