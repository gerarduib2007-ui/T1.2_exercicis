// GestorDispositivos.java
package es.uib.prgava.tema1.ejercicios;

import java.util.List;

public interface GestorDispositivos {

    void darDeAlta(String nombre, String direccionIp);

    void borrar(String nombre);

    void renombrar(String nombre, String nuevoNombre);

    boolean existe(String nombre);

    List<String> nombres();

    int cuantos();

    String exportarCsv();

    String exportarJson();
}
