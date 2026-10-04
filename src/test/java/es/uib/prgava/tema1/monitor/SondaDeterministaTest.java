package es.uib.prgava.tema1.monitor;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Ejercicio 1.2.8. */
class SondaDeterministaTest {

    private static final Servicio WEB = Servicio.desde("https://www.uib.es");
    private static final Duration UMBRAL = Duration.ofMillis(500);

    @Test
    void clasificaSegunElUmbralSinQueLaSondaDecidaNada() {
        var sonda = new SondaDeterminista(UMBRAL,
                List.of(Duration.ofMillis(100), Duration.ofMillis(900)));
        assertEquals(Estado.ACTIVO, sonda.sondear(WEB).estado());
        assertEquals(Estado.DEGRADADO, sonda.sondear(WEB).estado());
    }

    @Test
    void elLimiteExactoTodaviaEsActivo() {
        var sonda = new SondaDeterminista(UMBRAL, List.of(UMBRAL));
        assertEquals(Estado.ACTIVO, sonda.sondear(WEB).estado());
    }

    @Test
    void cuandoSeAgotaLaListaElServicioNoResponde() {
        var sonda = new SondaDeterminista(UMBRAL, List.of(Duration.ofMillis(100)));
        assertEquals(Estado.ACTIVO, sonda.sondear(WEB).estado());
        assertEquals(Estado.CAIDO, sonda.sondear(WEB).estado());
        assertEquals(Estado.CAIDO, sonda.sondear(WEB).estado());
    }

    @Test
    void laLatenciaDelCaidoEsCero() {
        var sonda = new SondaDeterminista(UMBRAL, List.of());
        assertEquals(Duration.ZERO, sonda.sondear(WEB).latencia());
    }
}
