package com.example.dcasm.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.dcasm.agenda.Contract.Contacto;

/**
 * Created by dcasm on 13/12/2016.
 */

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contactos.sdb";

    private static final String sql = "PRAGMA FOREIGN_KEYS = ON; " +
            "CREATE TABLE " + Contacto.TABLE_NAME_C + " (" +
            Contacto._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Contacto.ID + "TEXT NOT NULL," +
            Contacto.NOMBRE + " VARCHAR(50) NOT NULL," +
            Contacto.DIRECCION + " VARCHAR(50) NOT NULL," +
            Contacto.CORREO + " VARCHAR(50)," +
            Contacto.WEBBLOG + " VARCHAR(100)); " +
            "CREATE TABLE " + Contacto.TABLE_NAME_T + " (" +
            Contacto.ID_TELEFONO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Contacto.TELEFONO + " VARCHAR(45) NOT NULL," +
            Contacto.CLAVE + " INTEGER," +
            "FOREIGN KEY(" + Contacto.CLAVE + ") " +
            "REFERENCES " + Contacto.TABLE_NAME_C + "(" + Contacto._ID + ")); " +
            "CREATE TABLE " + Contacto.TABLE_NAME_F + " (" +
            Contacto.ID_FOTO + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            Contacto.FICHERO + " VARCHAR(50) NOT NULL, " +
            Contacto.RUTA + " VARCHAR(255)," +
            Contacto.CLAVE + " INTEGER," +
            "FOREIGN KEY(" + Contacto.CLAVE + ") " +
            "REFERENCES " + Contacto.TABLE_NAME_C + "(" + Contacto._ID + "));";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        //mockData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public Cursor getContactos() {
        SQLiteDatabase db = getReadableDatabase();
        if (db != null);
        Cursor cursor = db.rawQuery("SELECT contactos._ID AS _ID, " +
                "contactos.nombre AS nombre, " +
                "telefonos.telefonos AS telefono " +
                "FROM contactos, telefonos " +
                "WHERE contactos._ID = telefonos.contacto " +
                "AND contactos._ID = telefonos.contacto " +
                "ORDER BY contactos.nombre ASC;",
                null);
        return cursor;
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
            String[] col = {"_ID"};
            Cursor cId = db.rawQuery("SELECT MAX(_ID) FROM CONTACTOS", null);
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
