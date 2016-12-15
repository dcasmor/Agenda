package com.example.dcasm.agenda;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnadirContacto extends AppCompatActivity {

    final Context context = this;
    private Button bAnadir, bTelefono, bFoto;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new Database(this);

        bTelefono = (Button) findViewById(R.id.bAddPhone);
        bTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_phone);
                dialog.setTitle("Introduce el teléfono");
                EditText et = (EditText) dialog.findViewById(R.id.etPhoneAdd);
                Button bAceptar = (Button) dialog.findViewById(R.id.bAddPhoneAceptar);
                bAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Guardar telefono en base de datos
                    }
                });

                Button bCancelar = (Button) dialog.findViewById(R.id.bAddPhoneCancelar);
                bCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        bFoto = (Button) findViewById(R.id.bAddPhoto);

        bAnadir = (Button) findViewById(R.id.bAddButton);
        bAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
