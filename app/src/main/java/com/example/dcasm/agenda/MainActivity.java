package com.example.dcasm.agenda;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    static Adaptador a;
    static ArrayList<Contacto> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        a = new Adaptador(this, arrayList);
        a.notifyDataSetChanged();

        setListAdapter(a);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Fragmento recargada", Toast.LENGTH_SHORT);
        a = null;
        a = new Adaptador(this, arrayList);
        a.notifyDataSetChanged();
        setListAdapter(a);
    }
}
