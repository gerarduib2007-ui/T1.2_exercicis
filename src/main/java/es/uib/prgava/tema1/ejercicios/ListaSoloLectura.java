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
        // TODO 1.2.3: guarda una copia inmutable, no la lista que te pasan.
        throw new UnsupportedOperationException("TODO 1.2.3: constructor de ListaSoloLectura");
    }

    public int tamano() {
        // TODO 1.2.3
        throw new UnsupportedOperationException("TODO 1.2.3: ListaSoloLectura.tamano");
    }

    public String get(int indice) {
        // TODO 1.2.3
        throw new UnsupportedOperationException("TODO 1.2.3: ListaSoloLectura.get");
    }

    public boolean contiene(String elemento) {
        // TODO 1.2.3
        throw new UnsupportedOperationException("TODO 1.2.3: ListaSoloLectura.contiene");
    }

    /** Para poder recorrerla en un for-each sin poder modificarla. */
    public List<String> comoLista() {
        // TODO 1.2.3
        throw new UnsupportedOperationException("TODO 1.2.3: ListaSoloLectura.comoLista");
    }

    // TODO 1.2.3: escribe aquí el método del paso 1 del enunciado (recibe una List<String>,
    // le añade un elemento y devuelve el tamaño), pruébalo con una ArrayList y con una
    // ListaSoloLecturaHeredada, y explica en un comentario por qué es una violación del
    // principio de sustitución.
}
