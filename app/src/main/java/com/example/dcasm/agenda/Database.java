package com.example.dcasm.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dcasm on 13/12/2016.
 */

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contactos.sdb";

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public Cursor getContactos() {
        return getReadableDatabase().query("CONTACTOS",
                null, null, null, null, null, null);
    }

    public long altaContacto(Contactos c, Telefonos t, Fotos f) {
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
            Cursor cId = db.rawQuery("SELECT MAX(IDCONTACTO) FROM CONTACTOS", null);
            cId.moveToFirst();
            int id = cId.getInt(cId.getPosition());

            ContentValues valoresT = new ContentValues();
            valoresT.put("TELEFONO", t.getTelefono());
            valoresT.put("CONTACTO", id);
            rT = db.insert("TELEFONOS", null, valoresT);

            ContentValues valoresF = new ContentValues();
            valoresF.put("NOMFICHERO", f.getNomFichero());
            valoresF.put("OBSERVFOTO", f.getObserv());
            valoresF.put("CONTACTO", id);
            rF = db.insert("FOTOS", null, valoresF);

            if (rC == -1 || rT == -1 || rF == -1)
                return -1L;
        }
        db.close();
        return rC;
    }
}
