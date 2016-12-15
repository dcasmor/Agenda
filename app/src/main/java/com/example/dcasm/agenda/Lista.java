package com.example.dcasm.agenda;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dcasm on 15/12/2016.
 */

public class Lista extends ListActivity {
    static AgendaAdapter a;
    static ArrayList<Contacto> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        a = new AgendaAdapter(this, arrayList);

        setListAdapter(a);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Lista recargada", Toast.LENGTH_SHORT);
        a = null;
        a = new AgendaAdapter(this, arrayList);
        a.notifyDataSetChanged();
        setListAdapter(a);
    }
}
