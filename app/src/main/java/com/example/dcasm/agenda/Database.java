package com.example.dcasm.agenda;

import java.util.HashMap;

/**
 * Created by dcasm on 13/12/2016.
 */

public class Database {
    private static Database database = new Database();
    private HashMap<String, Contacto> contacto = new HashMap<>();

    public static Database getInstance() { return database; }

    private Database() {

    }

    private void saveContacto(Contacto cont) { contacto.put(cont.getIdContacto(), cont); }
}
