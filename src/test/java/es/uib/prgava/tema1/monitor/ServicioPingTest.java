package es.uib.prgava.tema1.monitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 1.2.7, la parte del monitor: un tipo de servicio más, sin tocar el Monitor. */
class ServicioPingTest {

    @Test
    void laFabricaReconoceElPrefijoPing() {
        var servicio = Servicio.desde("ping:uib.es");
        assertInstanceOf(ServicioPing.class, servicio);
        assertEquals("ping:uib.es", servicio.nombre());
    }

    @Test
    void losTiposDeAntesSiguenFuncionando() {
        assertInstanceOf(ServicioHttp.class, Servicio.desde("https://www.uib.es"));
        assertInstanceOf(ServicioDns.class, Servicio.desde("dns:uib.es"));
        assertInstanceOf(ServicioTcp.class, Servicio.desde("tcp:mail.uib.es:25"));
    }

    @Test
    void unTextoDesconocidoSigueSiendoRechazado() {
        assertThrows(IllegalArgumentException.class, () -> Servicio.desde("gopher:uib.es"));
    }
}
