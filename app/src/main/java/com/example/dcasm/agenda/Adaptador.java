package com.example.dcasm.agenda;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

/**
 * Created by dcasm on 12/12/2016.
 */

public class Adaptador extends CursorAdapter {

    public Adaptador(Context context, Cursor objetos) {
        super(context, objetos, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.objeto_lista, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        final ImageView iv = (ImageView) view.findViewById(R.id.ivContacto);
        TextView tvNombre = (TextView) view.findViewById(R.id.tvNombre);
        TextView tvTelefono = (TextView) view.findViewById(R.id.tvTelefono);

        String nombre = cursor.getString(cursor.getColumnIndex("NOMBRE"));
        String telefono = cursor.getString(cursor.getColumnIndex("TELEFONO"));
        String imagenRuta = cursor.getString(cursor.getColumnIndex("OBSERVFOTO"));
        String imagenArchivo = cursor.getString(cursor.getColumnIndex("NOMFICHERO"));

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);

        Glide
                .with(context)
                .load(Uri.parse(imagenRuta + imagenArchivo))
                .asBitmap()
                .error(R.drawable.image_contact_default)
                .centerCrop()
                .into(new BitmapImageViewTarget(iv) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable
                                = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCircular(true);
                        iv.setImageDrawable(drawable);
                    }
                });
    }

    /*
    @Override
    public View getView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

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

        Contactos contacto = getItem(position);

        holder.nom.setText(contacto.getNombre());
        //holder.tel.setText(contacto.getTelefono());
        Glide.with(getContext()).load(R.drawable.image_contact_default).into(holder.img);

        return convertView;
    }

    static class ViewHolder {
        ImageView img;
        TextView nom;
        TextView tel;
    }

    */


}
