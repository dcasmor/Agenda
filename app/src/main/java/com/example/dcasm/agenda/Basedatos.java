package com.example.dcasm.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by dcasm on 15/12/2016.
 */

public class Basedatos extends SQLiteOpenHelper {

    public Basedatos(Context context) {
        super(context, "contactos.db", null, 1);
        Log.d("BREAK", "Constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table contactos(id integer not null);");
        Log.d("BREAK", "CREADA");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }

    public List<Contacto> getContactos() {
        return null;
    }
}
