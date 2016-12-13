package com.example.dcasm.agenda;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AgendaFragment extends Fragment {

    private ListView listaAgenda;
    private AgendaAdapter agendaAdapter;

    public AgendaFragment() {
        // Required empty public constructor
    }

    public static AgendaFragment newInstance(/*String param1, String param2*/) {
        AgendaFragment fragment = new AgendaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_agenda, container, false);
        listaAgenda = (ListView) root.findViewById(R.id.agenda_list);

        agendaAdapter = new AgendaAdapter(getActivity(), Database.getInstance().getContactos());

        listaAgenda.setAdapter(agendaAdapter);

        listaAgenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contacto contacto = agendaAdapter.getItem(i);
                Toast.makeText(getActivity(), "Abrir detalle del contacto", Toast.LENGTH_SHORT).show();
            }
        });

        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        return root;
    }

    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            agendaAdapter.clear();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
