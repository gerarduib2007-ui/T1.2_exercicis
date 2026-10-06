package es.uib.prgava.tema1.ejercicios;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Ejercicio 1.2.3. */
class ListaSoloLecturaTest {

    private static final List<String> TRES = List.of("a", "b", "c");

    @Test
    void ofreceLoQueDeVerdadCumple() {
        var lista = new ListaSoloLectura(TRES);
        assertEquals(3, lista.tamano());
        assertEquals("b", lista.get(1));
        assertTrue(lista.contiene("c"));
        assertFalse(lista.contiene("z"));
    }

    @Test
    void laListaQueDevuelveTampocoSePuedeModificar() {
        var comoLista = new ListaSoloLectura(TRES).comoLista();
        assertThrows(UnsupportedOperationException.class, () -> comoLista.add("d"));
    }

    @Test
    void cambiarLaListaOriginalNoAfectaALaCopia() {
        var original = new ArrayList<>(TRES);
        var lista = new ListaSoloLectura(original);
        original.add("d");
        assertEquals(3, lista.tamano());
    }

    @Test
    void laVersionHeredadaMienteAQuienLaUsaComoLista() {
        List<String> comoSuperclase = new ListaSoloLecturaHeredada(TRES);
        assertThrows(UnsupportedOperationException.class, () -> comoSuperclase.add("d"));
    }

}
