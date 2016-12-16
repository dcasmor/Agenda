package com.example.dcasm.agenda;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnadirContacto extends AppCompatActivity {

    final Context context = this;
    private Button bAnadir, bTelefono, bFoto;
    private EditText etNom, etDir, etEmail, etWeb, etFoto, etTel;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etNom = (EditText) findViewById(R.id.etAddName);
        etDir = (EditText) findViewById(R.id.etAddAddress);
        etTel = (EditText) findViewById(R.id.etAddPhone);
        etEmail = (EditText) findViewById(R.id.etAddEmail);
        etFoto = (EditText) findViewById(R.id.etAddPhoto);
        etWeb = (EditText) findViewById(R.id.etAddWeb);

        bTelefono = (Button) findViewById(R.id.bAddPhone);
        bTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_phone);
                dialog.setTitle(R.string.phone_input);
                final EditText et = (EditText) dialog.findViewById(R.id.etPhoneAdd);
                et.setText(etTel.getText());
                Button bAceptar = (Button) dialog.findViewById(R.id.bAddPhoneAceptar);
                bAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        etTel.setText(et.getText());
                        dialog.cancel();
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
        bFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EVENTO DE TOMA DE FOTOGRAFIA
            }
        });

        bAnadir = (Button) findViewById(R.id.bAddButton);
        bAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contactos c = new Contactos(etNom.getText().toString(), etDir.getText().toString(),
                        etEmail.getText().toString(), etWeb.getText().toString());
                Telefonos t = new Telefonos(etTel.getText().toString());
                Fotos f = new Fotos(etFoto.getText().toString());
                Database db = new Database(context);
                db.alta(c, t, f);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
