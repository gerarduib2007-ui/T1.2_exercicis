// LectorDispositivos.java
package es.uib.prgava.tema1.ejercicios;

import java.util.List;

/** Operaciones de consulta del inventario. */
public interface LectorDispositivos {
    boolean existe(String nombre);

    List<String> nombres();

    int cuantos();
}
