package com.example.dcasm.agenda;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Fragmento extends Fragment {

    private ListView listaAgenda;
    private Adaptador adaptador;

    public Fragmento() {
        // Required empty public constructor
    }

    public static Fragmento newInstance() {
        Fragmento fragment = new Fragmento();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_agenda, container, false);

        //Instancia del ListView.
        listaAgenda = (ListView) root.findViewById(R.id.agenda_list);

        // /Inicializar el adaptador con la fuente de datos.
        //Log.d("DATABASE", "BREAKPOINT");
        Database db = new Database(getActivity());
        db.getReadableDatabase();
        adaptador = new Adaptador(getActivity(), db.getContactos());

        //Relacionar la lista con el adaptador.
        listaAgenda.setAdapter(adaptador);

        //Gestión eventos.
        listaAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Contacto contacto = adaptador.getItem(position);
                Toast.makeText(getActivity(), "Abrir detalle del contacto: \n" +
                        contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            adaptador.clear();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
