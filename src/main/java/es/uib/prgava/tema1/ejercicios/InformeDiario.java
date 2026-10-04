package es.uib.prgava.tema1.ejercicios;

import es.uib.prgava.tema1.monitor.LectorResultados;
import es.uib.prgava.tema1.monitor.Servicio;

/**
 * Ejercicio 1.2.5. Lo mismo que {@link InformeDiarioAcoplado}, pero con las dependencias
 * invertidas.
 *
 * <p>Los colaboradores entran por el constructor y se declaran con el tipo de la interfaz. La
 * salida también es un colaborador, para que una prueba pueda capturar el texto sin mirar la
 * consola.
 */
public final class InformeDiario {

    // TODO 1.2.5: declara aquí los dos colaboradores, con el tipo de la interfaz y no de la
    // clase concreta, y guárdalos en el constructor.

    public InformeDiario(LectorResultados repositorio, Salida salida) {
        // TODO 1.2.5
        throw new UnsupportedOperationException("TODO 1.2.5: constructor de InformeDiario");
    }

    /**
     * Escribe el informe de un servicio, tres líneas en la salida y exactamente en este orden:
     *
     * <pre>
     * servicio: &lt;nombre&gt;
     * comprobaciones: &lt;cuántas&gt;
     * fallos: &lt;cuántos&gt;
     * </pre>
     */
    public void emitir(Servicio servicio) {
        // TODO 1.2.5
        throw new UnsupportedOperationException("TODO 1.2.5: InformeDiario.emitir");
    }

    // TODO 1.2.5: cablea en Principal, y solo ahí, las implementaciones concretas.
}
