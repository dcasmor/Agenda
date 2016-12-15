package com.example.dcasm.agenda;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by dcasm on 12/12/2016.
 */

public class AgendaAdapter extends BaseAdapter {

    private ArrayList<Contacto> contactos;
    private final Activity actividad;

    public AgendaAdapter(Activity a, ArrayList<Contacto> v) {
        super();
        this.contactos = v;
        this.actividad = a;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = actividad.getLayoutInflater();
        View view1 = li.inflate(R.layout.objetoLista, null, true);
        ViewHolder holder;

        if (null == view1) {
            view1 = li.inflate(R.layout.objetoLista, null, false);

            holder = new ViewHolder();
            holder.img = (ImageView) view.findViewById(R.id.ivContacto);
            holder.nom = (TextView) view.findViewById(R.id.tvNombre);
            holder.tel = (TextView) view.findViewById(R.id.tvTelefono);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view1.getTag();
        }

        Contacto contacto = getItem(i);

        holder.nom.setText(contacto.getNombre());
        holder.tel.setText(contacto.getTelefono());
        //Glide.with(getContext()).load(R.drawable.image_contact_default).into(holder.img);

        return view1;
    }

    static class ViewHolder {
        ImageView img;
        TextView nom;
        TextView tel;
    }

    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Contacto getItem(int i) {
        return contactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return contactos.get(i).getIdContacto();
    }
/*public AgendaAdapter (Context context, List<Contacto> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.objetoLista, parent, false);

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
    }*/
}
