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
        //mockData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public Cursor getContactos() {
        SQLiteDatabase db = getReadableDatabase();
        if (db != null);
        Cursor c = db.rawQuery("SELECT CONTACTOS.NOMBRE AS NOMBRE, TELEFONOS.TELEFONO AS TELEFONO FROM " +
                "CONTACTOS, TELEFONOS WHERE CONTACTOS.IDCONTACTO = TELEFONOS.CONTACTO ORDER BY " +
                "NOMBRE ASC;",
                null);
        return c;
    }

    public long altaContacto(SQLiteDatabase db, Contactos contacto) {
        return db.insert("CONTACTOS", null, contacto.toContactosContentValues());
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        altaContacto(sqLiteDatabase, new Contactos("Carlos Perez", "Abogado penalista",
                "300 200 1111", "carlos_perez.jpg"));
        altaContacto(sqLiteDatabase, new Contactos("Daniel Samper", "Abogado accidentes de tráfico",
                "300 200 2222", "daniel_samper.jpg"));
        altaContacto(sqLiteDatabase, new Contactos("Lucia Aristizabal", "Abogado de derechos laborales",
                "300 200 3333", "lucia_aristizabal.jpg"));
        altaContacto(sqLiteDatabase, new Contactos("Marina Acosta", "Abogado de familia",
                "300 200 4444", "marina_acosta.jpg"));
        altaContacto(sqLiteDatabase, new Contactos("Olga Ortiz", "Abogado de administración pública",
                "300 200 5555", "olga_ortiz.jpg"));
        altaContacto(sqLiteDatabase, new Contactos("Pamela Briger", "Abogado fiscalista",
                "300 200 6666", "pamela_briger.jpg"));
        altaContacto(sqLiteDatabase, new Contactos("Rodrigo Benavidez", "Abogado Mercantilista",
                "300 200 1111", "rodrigo_benavidez.jpg"));
        altaContacto(sqLiteDatabase, new Contactos("Tom Bonz", "Abogado penalista",
                "300 200 1111", "tom_bonz.jpg"));
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
            //valoresC.put("WEBBLOG", c.getWebBlog());

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
