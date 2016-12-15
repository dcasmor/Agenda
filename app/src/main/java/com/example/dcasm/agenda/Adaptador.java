package com.example.dcasm.agenda;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Adaptador extends BaseAdapter {

    private static ArrayList<Contacto> lista;
    private final Activity actividad;

    public Adaptador(Activity a, ArrayList<Contacto> v) {
        super();
        this.lista = v;
        this.actividad = a;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = actividad.getLayoutInflater();
        View view1 = li.inflate(R.layout.objeto_lista, null, true);
        ViewHolder holder;

        if (null == view1) {
            view1 = li.inflate(R.layout.objeto_lista, null, false);

            holder = new ViewHolder();
            holder.img = (ImageView) view.findViewById(R.id.ivContacto);
            holder.nom = (TextView) view.findViewById(R.id.tvNombre);
            holder.tel = (TextView) view.findViewById(R.id.tvTelefono);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view1.getTag();
        }

        holder.nom.setText(lista.get(i).getNombre());
        holder.tel.setText(lista.get(i).getTelefono());
        //Glide.with(getContext()).load(R.drawable.image_contact_default).into(holder.img);
        //Glide.with(actividad).load(R.drawable.image_contact_default).into(holder.img);

        return view1;
    }

    static class ViewHolder {
        ImageView img;
        TextView nom;
        TextView tel;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lista.get(i).getIdContacto();
    }

/*public Adaptador (Context context, List<Contacto> objects) {
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
