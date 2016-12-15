package com.example.dcasm.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

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
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, agendaFragment)
                    .commit();
        }
    }
}
