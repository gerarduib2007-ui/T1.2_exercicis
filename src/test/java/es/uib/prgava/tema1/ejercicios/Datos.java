package es.uib.prgava.tema1.ejercicios;

import java.time.Duration;
import java.util.List;

import es.uib.prgava.tema1.monitor.Resultado;
import es.uib.prgava.tema1.monitor.Servicio;

/** Datos de ejemplo compartidos por varias pruebas. */
final class Datos {

    static final Servicio WEB = Servicio.desde("https://www.uib.es");
    static final Servicio DNS = Servicio.desde("dns:uib.es");

    private Datos() { }

    /** Historial mezclado: activos, degradados y caídos de dos servicios. */
    static List<Resultado> historialMezclado() {
        return List.of(
                Resultado.activo(WEB, Duration.ofMillis(100)),
                Resultado.caido(DNS),
                Resultado.degradado(WEB, Duration.ofMillis(700)),
                Resultado.activo(DNS, Duration.ofMillis(40)),
                Resultado.caido(WEB));
    }
}
