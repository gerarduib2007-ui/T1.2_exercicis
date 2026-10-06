package es.uib.prgava.tema1.ejercicios;

import es.uib.prgava.tema1.monitor.LectorResultados;
import es.uib.prgava.tema1.monitor.Resultado;
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

    private final LectorResultados repositorio;
    private final Salida salida;

    public InformeDiario(LectorResultados repositorio, Salida salida) {
        this.repositorio = repositorio;
        this.salida = salida;
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
        var historial = repositorio.historial(servicio);
        int fallos = 0;
        for (Resultado resultado : historial) {
            if (resultado.esFallo()) {
                fallos++;
            }
        }
        salida.escribir("servicio: " + servicio.nombre());
        salida.escribir("comprobaciones: " + historial.size());
        salida.escribir("fallos: " + fallos);
    }
}
