package com.example.dcasm.agenda;

import android.provider.BaseColumns;

/**
 * Created by dcasm on 16/12/2016.
 */

public class Contract {

    public static abstract class Contacto implements BaseColumns {

        public static final String TABLE_NAME_C = "contactos";
        public static final String TABLE_NAME_T = "telefonos";
        public static final String TABLE_NAME_F = "fotos";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DIRECCION = "direccion";
        public static final String TELEFONO = "telefono";
        public static final String ID_TELEFONO = "idtelefono";
        public static final String ID_FOTO = "idfoto";
        public static final String CORREO = "email";
        public static final String WEBBLOG = "webblog";
        public static final String CLAVE = "contacto";
        public static final String FICHERO = "nomfoto";
        public static final String RUTA = "observfoto";
    }
}
