package es.uib.prgava.tema1.ejercicios;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ejercicio 1.2.4. Las pruebas usan cada clase por sus propios métodos, así que dividir la
 * interfaz no las rompe. Lo que tienen que dejar de hacer, cuando acabes, es llamar a un método
 * que la clase no debería haber tenido nunca.
 */
class GestorDispositivosTest {

    private static final List<FichaDispositivo> FICHAS = List.of(
            new FichaDispositivo("web01", "10.0.0.1"),
            new FichaDispositivo("dns01", "10.0.0.2"));

    @Test
    void elCatalogoEnMemoriaCumpleTodoLoQuePromete() {
        var catalogo = new CatalogoEnMemoria();
        catalogo.darDeAlta("web01", "10.0.0.1");
        catalogo.darDeAlta("dns01", "10.0.0.2");
        assertTrue(catalogo.existe("web01"));
        assertEquals(2, catalogo.cuantos());
        catalogo.renombrar("web01", "web02");
        assertTrue(catalogo.existe("web02"));
        catalogo.borrar("web02");
        assertFalse(catalogo.existe("web02"));
        assertEquals(1, catalogo.cuantos());
    }

    @Test
    void elInventarioDeConsultaConsulta() {
        var consulta = new ConsultaDispositivos(FICHAS);
        assertTrue(consulta.existe("dns01"));
        assertEquals(2, consulta.cuantos());
        assertEquals(List.of("web01", "dns01"), consulta.nombres());
    }

    @Test
    void elExportadorExporta() {
        var exportador = new ExportadorCsv(FICHAS);
        assertEquals("web01;10.0.0.1\ndns01;10.0.0.2\n", exportador.exportarCsv());
        assertEquals(2, exportador.cuantos());
    }

    // TODO 1.2.4: cuando hayas dividido la interfaz, añade aquí una prueba que compruebe que
    // un cliente que solo consulta puede recibir un ConsultaDispositivos y un
    // CatalogoEnMemoria, y que no puede pedirle a ninguno de los dos nada que no cumpla.
}
