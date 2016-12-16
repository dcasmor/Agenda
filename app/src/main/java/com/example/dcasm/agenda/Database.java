package com.example.dcasm.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
            "\nIDCONTACTO INTEGER PRIMARY KEY AUTOINCREMENT," +
            "\nNOMBRE VARCHAR(50) NOT NULL," +
            "\nDIRECCION VARCHAR(50) NOT NULL," +
            "\nWEBBLOG VARCHAR(100)," +
            "\nEMAIL VARCHAR(100));";

    private static final String sql3 = "\nCREATE TABLE TELEFONOS(" +
            "\nIDTELEFONOS INTEGER PRIMARY KEY AUTOINCREMENT," +
            "\nTELEFONO VARCHAR(45) NOT NULL," +
            "\nCONTACTO INTEGER," +
            "\nFOREIGN KEY(CONTACTO) REFERENCES CONTACTOS(IDCONTACTO));";

    private static final String sql4 = "\nCREATE TABLE FOTOS(" +
            "\nIDFOTO INTEGER PRIMARY KEY AUTOINCREMENT," +
            "\nNOMFICHERO VARCHAR(50) NOT NULL," +
            "\nOBSERVFOTO VARCHAR(255)," +
            "\nCONTACTO INTEGER," +
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
        Log.d("BREAKPOINT", "CREACION DATABASE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    private HashMap<Object, Contactos> contacto = new HashMap<>();

    public List<Contactos> getContactos() {
        return new ArrayList<>(contacto.values());
    }

    public long alta(Contactos c, Telefonos t, Fotos f) {
        long rC = -1;
        long rT = rC;
        long rF = rT;

        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valoresC = new ContentValues();
            valoresC.put("NOMBRE", c.getNombre());
            valoresC.put("DIRECCION", c.getDireccion());
            valoresC.put("EMAIL", c.getEmail());
            valoresC.put("WEBBLOG", c.getWebBlog());

            rC = db.insert("CONTACTOS", null, valoresC);
            String[] col = {"IDCONTACTO"};
            Cursor cId = db.query("CONTACTOS", col, null, null, null, null, "DESC");
            int id = cId.getInt(0);

            ContentValues valoresT = new ContentValues();
            valoresT.put("TELEFONO", t.getTelefono());
            valoresT.put("CONTACTO", id);
            rT = db.insert("TELEFONOS", null, valoresT);

            ContentValues valoresF = new ContentValues();
            valoresF.put("NOMFICHERO", f.getNomFichero());
            //valoresF.put("OBSERVFOTO", f.getObserv());
            valoresF.put("CONTACTO", id);
            rF = db.insert("FOTOS", null, valoresF);

            if (rC == -1 || rT == -1 || rF == -1)
                return -1L;
        }
        db.close();
        return rC;
    }

    //Métodos de la clase
    /*private static Database database = new Database();
    private HashMap<Object, Contacto> contacto = new HashMap<>();

    public static Database getInstance() { return database; }

    private Database() {
        alta(new Contacto(1, "Danilo", "633014522", "Tartesicos", "pornhub.com"));
        alta(new Contacto(2, "Steve", "666666666", "Montaña", "mi.com"));
        alta(new Contacto(3, "Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        alta(new Contacto(4, "Orejones", "121212121", "Marasena", "dumbo.com"));
        alta(new Contacto(5, "Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
        alta(new Contacto(6, "Danilo", "633014522", "Tartesicos", "pornhub.com"));
        alta(new Contacto(7, "Steve", "666666666", "Montaña", "mi.com"));
        alta(new Contacto(8, "Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        alta(new Contacto(9, "Orejones", "121212121", "Marasena", "dumbo.com"));
        alta(new Contacto(10, "Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
        alta(new Contacto(11, "Danilo", "633014522", "Tartesicos", "pornhub.com"));
        alta(new Contacto(12, "Steve", "666666666", "Montaña", "mi.com"));
        alta(new Contacto(13, "Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        alta(new Contacto(14, "Orejones", "121212121", "Marasena", "dumbo.com"));
        alta(new Contacto(15, "Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
    }

    private void alta(Contacto cont) { contacto.put(cont.getIdContacto(), cont); }

    public ArrayList<Contacto> getContactos() { return new ArrayList<>(contacto.values()); }*/
}
