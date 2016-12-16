package com.example.dcasm.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragmento fragmento = (Fragmento)
                getSupportFragmentManager().findFragmentById(R.id.content_main);

        if (fragmento == null) {
            fragmento = Fragmento.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, fragmento)
                    .commit();
        }
    }
}
