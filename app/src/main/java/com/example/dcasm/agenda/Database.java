package com.example.dcasm.agenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dcasm on 13/12/2016.
 */

public class Database {
    private static Database database = new Database();
    private HashMap<String, Contacto> contacto = new HashMap<>();

    public static Database getInstance() { return database; }

    private Database() {
        saveContacto(new Contacto("Danilo", "633014522", "Tartesicos", "pornhub.com"));
        saveContacto(new Contacto("Steve", "666666666", "Montaña", "mi.com"));
        saveContacto(new Contacto("Tolete", "999999999", "Pedro Antonio", "toyota.com"));
        saveContacto(new Contacto("Orejones", "121212121", "Marasena", "dumbo.com"));
        saveContacto(new Contacto("Dios mediante", "456789123", "Francisco Ayala", "diosmediante.com"));
    }

    private void saveContacto(Contacto cont) { contacto.put(cont.getIdContacto(), cont); }

    public List<Contacto> getContactos() { return new ArrayList<>(contacto.values()); }
}
