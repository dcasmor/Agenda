package com.example.dcasm.agenda;

import android.content.ContentValues;
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

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactos.sdb";
    private static final String TABLA_CONTACTOS = "contactos";
    private static final String TABLA_TELEFONOS = "telefonos";
    private static final String TABLA_FOTOS = "fotos";

    private static final String sql1 = "\nPRAGMA FOREIGN_KEYS = ON;";

    private static final String sql2 = "\nCREATE TABLE CONTACTOS(" +
            "\nIDCONTACTO INTEGER PRIMARY KEY NOT NULL," +
            "\nNOMBRE VARCHAR(50) NOT NULL," +
            "\nDIRECCION VARCHAR(50) NOT NULL," +
            "\nWEBBLOG VARCHAR(100)," +
            "\nEMAIL VARCHAR(100));";

    private static final String sql3 = "\nCREATE TABLE TELEFONOS(" +
            "\nIDTELEFONOS INTEGER PRIMARY KEY NOT NULL," +
            "\nTELEFONO VARCHAR(45) NOT NULL," +
            "\nCONTACTO INTEGER NOT NULL," +
            "\nFOREIGN KEY(CONTACTO) REFERENCES CONTACTOS(IDCONTACTO));";

    private static final String sql4 = "\nCREATE TABLE FOTOS(" +
            "\nIDFOTO INTEGER NOT NULL," +
            "\nNOMFICHERO VARCHAR(50) NOT NULL," +
            "\nOBSERVFFOTO VARCHAR(255)," +
            "\nCONTACTO INTEGER NOT NULL," +
            "\nFOREIGN KEY(CONTACTO) REFERENCES CONTACTOS(IDCONTACTO));";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    private HashMap<Object, Contacto> contacto = new HashMap<>();

    public List<Contacto> getContactos() {
        return new ArrayList<>(contacto.values());
    }

    public long altaContacto(Contacto c) {
        long nreg_afectados = -1;
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("nombre", c.getNombre());
            valores.put("telefono", c.getTelefono());
            valores.put("direccion", c.getDireccion());
            valores.put("email", c.getEmail());
            valores.put("foto", c.getFoto());
        }
        db.close();
        return nreg_afectados;
    }

    //Métodos de la clase
    /*private static Database database = new Database();
    private HashMap<Object, Contacto> contacto = new HashMap<>();

    public static Database getInstance() { return database; }

    private Database() {
        altaContacto(new Contacto(1, "Danilo", "633014522", "Tartesicos", "pornhub.com"));
        altaContacto(new Contacto(2, "Steve", "666666666", "Montaña", "mi.com"));
        altaContacto(new Contacto(3, "Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        altaContacto(new Contacto(4, "Orejones", "121212121", "Marasena", "dumbo.com"));
        altaContacto(new Contacto(5, "Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
        altaContacto(new Contacto(6, "Danilo", "633014522", "Tartesicos", "pornhub.com"));
        altaContacto(new Contacto(7, "Steve", "666666666", "Montaña", "mi.com"));
        altaContacto(new Contacto(8, "Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        altaContacto(new Contacto(9, "Orejones", "121212121", "Marasena", "dumbo.com"));
        altaContacto(new Contacto(10, "Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
        altaContacto(new Contacto(11, "Danilo", "633014522", "Tartesicos", "pornhub.com"));
        altaContacto(new Contacto(12, "Steve", "666666666", "Montaña", "mi.com"));
        altaContacto(new Contacto(13, "Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        altaContacto(new Contacto(14, "Orejones", "121212121", "Marasena", "dumbo.com"));
        altaContacto(new Contacto(15, "Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
    }

    private void altaContacto(Contacto cont) { contacto.put(cont.getIdContacto(), cont); }

    public ArrayList<Contacto> getContactos() { return new ArrayList<>(contacto.values()); }*/
}
