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
    private static final String DATABASE_NAME = "contactos.s3db";
    private static final String TABLA_CONTACTOS = "contactos";
    private static final String TABLA_TELEFONOS = "telefonos";
    private static final String TABLA_FOTOS = "fotos";
    private static final String ins = "PRAGMA foreign_keys = ON;" +
            "create table [contactos] (" +
            "[idcontacto] integer not null primary key autoincrement," +
            "[nombre] varchar(50) null," +
            "[direccion] varchar(50) null," +
            "[webblog] varchar(100) null);" +
            "create table [telefonos] (" +
            "[idtelefonos] integer not null primary key," +
            "[telefono] varchar(45) null," +
            "[idcontacto] integer null," +
            "foreign_key (idcontacto) references contactos(idcontacto));" +
            "create table [fotos] (" +
            "[idfoto] integer not null primary key," +
            "[nomfichero] varchar(50) null," +
            "[observfoto] varchar(255) null," +
            "[idcontacto] integer null," +
            "foreign key (idcontacto) references contactos(idcontacto));";

    //private static Database database = new Database();
    private HashMap<String, Contacto> contacto = new HashMap<>();

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ins);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public Database(Context context, String DATABASE_NAME, SQLiteDatabase.CursorFactory factory, int DATABASE_VERSION) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
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
