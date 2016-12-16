package com.example.dcasm.agenda;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
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

public class Fragmento extends Fragment {

    private static final int MODIFICAR = 1;

    private ListView lista;
    private Adaptador adaptador;
    private Database db;

    public Fragmento() {
        // Required empty public constructor
    }

    public static Fragmento newInstance() { return new Fragmento(); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_agenda, container, false);

        lista = (ListView) root.findViewById(R.id.agenda_list);
        adaptador = new Adaptador(getActivity(), null);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Cursor currentItem = (Cursor) adaptador.getItem(position);
                //String item = currentItem.getString(currentItem.getColumnIndex("IDCONTACTO"));
                //modificaContacto(item);
            }
        });

        db = new Database(getActivity());

        lista();
        setHasOptionsMenu(true);
        return root;
    }

    private void modificaContacto(String id) {
        Intent i = new Intent(getActivity(), null);
        i.putExtra(null, id);
        startActivityForResult(i, MODIFICAR);
    }

    private Cursor lista() {
        //new CargaContactos().execute();
        return db.getContactos();
        }

    private class CargaContactos extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return db.getContactos();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                adaptador.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_add) {
            Intent i = new Intent(getContext(), AnadirContacto.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
