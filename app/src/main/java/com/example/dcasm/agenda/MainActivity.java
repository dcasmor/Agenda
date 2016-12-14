package com.example.dcasm.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AgendaFragment agendaFragment = (AgendaFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_main);

        if (agendaFragment == null) {
            agendaFragment = AgendaFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.content_main, agendaFragment)
                    .commit();
        }

        String ins = "PRAGMA foreign_keys = ON;" +
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
        Log.d("OYE", ins);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
