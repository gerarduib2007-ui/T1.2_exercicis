// ListaSoloLecturaHeredada.java
package es.uib.prgava.tema1.ejercicios;

import java.util.ArrayList;
import java.util.Collection;

public class ListaSoloLecturaHeredada extends ArrayList<String> {

    private static final long serialVersionUID = 1L;   // lo pide `javac -Xlint:all`

    public ListaSoloLecturaHeredada(Collection<String> inicial) {
        super(inicial);
    }

    @Override
    public boolean add(String elemento) {
        throw new UnsupportedOperationException("lista de solo lectura");
    }

    @Override
    public boolean remove(Object elemento) {
        throw new UnsupportedOperationException("lista de solo lectura");
    }
}
