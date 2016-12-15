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

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BD_Contactos.db";
    private static final String TABLA_CONTACTOS = "contactos";
    private static final String TABLA_TELEFONOS = "telefonos";
    private static final String TABLA_FOTOS = "fotos";

    private static final String sql1 = "PRAGMA FOREIGN_KEYS ON;";
    private static final String sql2 = "CREATE TABLE CONTACTOS(" +
            "IDCONTACTO INTEGER PRIMARY KEY NOT NULL," +
            "NOMBRE VARCHAR(50) NOT NULL," +
            "DIRECCION VARCHAR(50) NOT NULL," +
            "WEBBLOG VARCHAR(100));";
    private static final String sql3 = "CREATE TABLE TELEFONOS(" +
            "IDTELEFONOS INTEGER PRIMARY KEY NOT NULL," +
            "TELEFONO VARCHAR(45) NOT NULL," +
            "CONTACTO INTEGER NOT NULL," +
            "FOREIGN KEY(CONTACTO) REFERENCES CONTACTO(IDCONTACTO));";

    private static final String sql4 = "CREATE TABLE FOTOS(" +
            "IDFOTO INTEGER NOT NULL," +
            "NOMFICHERO VARCHAR(50) NOT NULL," +
            "OBSERVFFOTO VARCHAR(255)," +
            "CONTACTO INTEGER NOT NULL," +
            "FOREIGN KEY(CONTACTO) REFERENCES CONTACTOS(IDCONTACTO));";

    public static Database newInstance(Context context) {
        Database db = new Database(context);
        return db;
    }

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("BREAKPOINT 3", "ON CREATE DE DATABASE");
        db.execSQL(sql2);
        db.execSQL(sql1);
        db.execSQL(sql3);
        db.execSQL(sql4);
        Log.d("BREAKPOINT 4", "ON CREATE DE DATABASE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }

    private HashMap<Object, Contacto> contacto = new HashMap<>();

    public List<Contacto> getContactos() {
        Log.d("BREAKPOINT 2", "GET CONTACTOS DE LA DATABASE");
        return new ArrayList<>(contacto.values());
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
