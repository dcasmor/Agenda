package com.example.dcasm.agenda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by dcasm on 12/12/2016.
 */

public class AgendaAdapter extends ArrayAdapter<Contacto> {

    public AgendaAdapter (Context context, List<Contacto> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RecyclerView.ViewHolder holder;

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_item_agenda, parent, false);

            holder = new RecyclerView.ViewHolder() {
                @Override
                public String toString() {
                    return super.toString();
                }
            }
        }
    }
}
