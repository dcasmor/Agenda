package com.example.dcasm.agenda;

import android.app.Fragment;
import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dcasm on 15/12/2016.
 */

public class Fragmento extends Fragment {

    static Adaptador a;
    static ArrayList<Contacto> arrayList = new ArrayList<>();

    public Fragmento(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.objeto_lista, container, false);

        ArrayList<Contacto> listaContactos
        return root;
    }

    private ArrayList<Contacto> GetListaContactos() {
        ArrayList<Contacto> lista = new ArrayList<Contacto>();

        Contacto contacto = new Contacto();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        a = new Adaptador(this, arrayList);

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
