package com.example.dcasm.agenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Adaptador extends ArrayAdapter<Contacto> {

    private static ArrayList<Contacto> lista;

    public Adaptador(Context context, List<Contacto> objetos) {
        super(context, 0, objetos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.objeto_lista, parent, false);

            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.ivContacto);
            holder.nom = (TextView) convertView.findViewById(R.id.tvNombre);
            holder.tel = (TextView) convertView.findViewById(R.id.tvTelefono);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contacto contacto = getItem(position);

        holder.nom.setText(contacto.getNombre());
        holder.tel.setText(contacto.getTelefono());
        Glide.with(getContext()).load(R.drawable.image_contact_default).into(holder.img);

        return convertView;
    }

    static class ViewHolder {
        ImageView img;
        TextView nom;
        TextView tel;
    }
}
