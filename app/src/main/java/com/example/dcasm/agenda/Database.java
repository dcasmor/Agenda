package com.example.dcasm.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dcasm on 13/12/2016.
 */

public class Database extends SQLiteOpenHelper{

    private static Contacto cont;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactos.s3db";
    private static final String TABLA_CONTACTOS = "contactos";
    private static final String TABLA_TELEFONOS = "telefonos";
    private static final String TABLA_FOTOS = "fotos";

    private static final String PRAGMA = "PRAGMA FOREIGN_KEYS ON;";
    private static final String SQLCONTACTOS = "CREATE TABLE CONTACTOS(" +
            "IDCONTACTO INTEGER PRIMARY KEY NOT NULL," +
            "NOMBRE VARCHAR(50) NOT NULL," +
            "DIRECCION VARCHAR(50) NOT NULL," +
            "WEBBLOG VARCHAR(100));";
    private static final String SQLTELEFONOS = "CREATE TABLE TELEFONOS(" +
            "IDTELEFONOS INTEGER PRIMARY KEY NOT NULL," +
            "TELEFONO VARCHAR(45) NOT NULL," +
            "CONTACTO INTEGER NOT NULL," +
            "FOREIGN KEY(CONTACTO) REFERENCES CONTACTO(IDCONTACTO));";

    private static final String SQLFOTOS = "CREATE TABLE FOTOS(" +
            "IDFOTO INTEGER NOT NULL," +
            "NOMFICHERO VARCHAR(50) NOT NULL," +
            "OBSERVFFOTO VARCHAR(255)," +
            "CONTACTO INTEGER NOT NULL," +
            "FOREIGN KEY(CONTACTO) REFERENCES CONTACTOS(IDCONTACTO));";

    //private static Database database = new Database();
    private HashMap<String, Contacto> contacto = new HashMap<>();

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLCONTACTOS);
        sqLiteDatabase.execSQL(PRAGMA);
        sqLiteDatabase.execSQL(SQLTELEFONOS);
        sqLiteDatabase.execSQL(SQLFOTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
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
