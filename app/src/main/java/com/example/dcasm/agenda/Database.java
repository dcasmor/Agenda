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
    private static final String ins = "PRAGMA foreign_keys = ON;" +
            "\ncreate table [contactos] (" +
            "\n[idcontacto] integer not null primary key autoincrement," +
            "\n[nombre] varchar(50) null," +
            "\n[direccion] varchar(50) null," +
            "\n[webblog] varchar(100) null);" +
            "\ncreate table [telefonos] (" +
            "\n[idtelefonos] integer not null primary key," +
            "\n[telefono] varchar(45) null," +
            "\n[idcontacto] integer null," +
            "\nforeign_key (idcontacto) references contactos(idcontacto));" +
            "\ncreate table [fotos] (" +
            "\n[idfoto] integer not null primary key," +
            "\n[nomfichero] varchar(50) null," +
            "\n[observfoto] varchar(255) null," +
            "\n[idcontacto] integer null," +
            "\nforeign key (idcontacto) references contactos(idcontacto));";

    //private static Database database = new Database();
    private HashMap<String, Contacto> contacto = new HashMap<>();

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("OYE", ins);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ins);
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
