package com.example.dcasm.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dcasm on 13/12/2016.
 */

public class Database extends SQLiteOpenHelper{

    private static Contacto cont;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactos.db";
    private static final String TABLA_CONTACTOS = "contactos";
    private static final String TABLA_TELEFONOS = "telefonos";
    private static final String TABLA_FOTOS = "fotos";

    //private static Database database = new Database();
    private HashMap<String, Contacto> contacto = new HashMap<>();

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**public static Database getInstance() { return database; }

    private Database() {
        saveContacto(new Contacto("Danilo", "633014522", "Tartesicos", "pornhub.com"));
        saveContacto(new Contacto("Steve", "666666666", "Montaña", "mi.com"));
        saveContacto(new Contacto("Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        saveContacto(new Contacto("Orejones", "121212121", "Marasena", "dumbo.com"));
        saveContacto(new Contacto("Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
    }*/

    private void saveContacto(Contacto cont) { contacto.put(cont.getIdContacto(), cont); }

    public List<Contacto> getContactos() { return new ArrayList<>(contacto.values()); }
}
