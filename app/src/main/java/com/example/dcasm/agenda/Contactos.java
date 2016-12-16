package com.example.dcasm.agenda;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Contactos {

    private int id;
    private String nombre;
    private String direccion;
    private String email;
    private String sitioWeb;

    public Contactos(String nombre, String direccion, String email, String sitioWeb) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.sitioWeb = sitioWeb;
    }

    public Contactos(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex("IDCONTACTO"));
        nombre = cursor.getString(cursor.getColumnIndex("NOMBRE"));
        direccion = cursor.getString(cursor.getColumnIndex("DIRECCION"));
        email = cursor.getString(cursor.getColumnIndex("EMAIL"));
        sitioWeb = cursor.getString(cursor.getColumnIndex("WEBBLOG"));
    }

    public ContentValues toContactosContentValues() {
        ContentValues values = new ContentValues();
        values.put("NOMBRE", nombre);
        values.put("DIRECCION", direccion);
        values.put("EMAIL", email);
        values.put("WEBBLOG", sitioWeb);
        return values;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }
}
