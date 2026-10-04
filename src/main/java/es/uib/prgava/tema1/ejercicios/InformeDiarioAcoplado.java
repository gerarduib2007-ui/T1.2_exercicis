// InformeDiarioAcoplado.java
package es.uib.prgava.tema1.ejercicios;

import es.uib.prgava.tema1.monitor.RepositorioEnMemoria;
import es.uib.prgava.tema1.monitor.Servicio;

public class InformeDiarioAcoplado {

    private final RepositorioEnMemoria repositorio = new RepositorioEnMemoria();

    public void imprimir(Servicio servicio) {
        var historial = repositorio.historial(servicio);
        int fallos = 0;
        for (var resultado : historial) {
            if (resultado.esFallo()) {
                fallos++;
            }
        }
        System.out.println("Informe de " + servicio.nombre());
        System.out.println("  comprobaciones: " + historial.size());
        System.out.println("  fallos: " + fallos);
    }
}
