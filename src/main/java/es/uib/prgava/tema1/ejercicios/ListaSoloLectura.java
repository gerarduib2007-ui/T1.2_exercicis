package es.uib.prgava.tema1.ejercicios;

import java.util.List;

/**
 * Ejercicio 1.2.3. Lista de solo lectura hecha bien: ofrece <em>solo</em> lo que de verdad
 * cumple.
 *
 * <p>Contiene una lista en lugar de ser una, así que no hereda ningún método que tenga que
 * desmentir después. Compárala con {@link ListaSoloLecturaHeredada}.
 */
public final class ListaSoloLectura {

    private final List<String> elementos;

    public ListaSoloLectura(List<String> elementos) {
        this.elementos = List.copyOf(elementos);
    }

    public int tamano() {
        return elementos.size();
    }

    public String get(int indice) {
        return elementos.get(indice);
    }

    public boolean contiene(String elemento) {
        return elementos.contains(elemento);
    }

    /** Para poder recorrerla en un for-each sin poder modificarla. */
    public List<String> comoLista() {
        return elementos;
    }

    /**
     * Intenta añadir un elemento a cualquier lista y devuelve el tamaño resultante.
     *
     * <p>Con una {@code ArrayList} normal, la operación tiene éxito y devuelve el tamaño
     * actualizado. Si se le pasa una {@link ListaSoloLecturaHeredada}, lanza
     * {@link UnsupportedOperationException}. Esto viola el principio de sustitución:
     * aunque la lista heredada es una {@code List<String>}, no puede usarse donde se espera
     * una lista modificable sin cambiar el comportamiento esperado.
     */
    public static int añadirYDevolverTamano(List<String> lista) {
        lista.add("nuevo elemento");
        return lista.size();
    }
}
