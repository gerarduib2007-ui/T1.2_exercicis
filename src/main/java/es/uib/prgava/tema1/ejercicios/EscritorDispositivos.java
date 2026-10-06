// EscritorDispositivos.java
package es.uib.prgava.tema1.ejercicios;

/** Operaciones que modifican el inventario. */
public interface EscritorDispositivos {
    void darDeAlta(String nombre, String direccionIp);

    void borrar(String nombre);

    void renombrar(String nombre, String nuevoNombre);
}
