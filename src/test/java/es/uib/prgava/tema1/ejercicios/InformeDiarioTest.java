package es.uib.prgava.tema1.ejercicios;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import es.uib.prgava.tema1.monitor.RepositorioEnMemoria;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Ejercicio 1.2.5: se prueba sin mirar la consola, que es de lo que se trataba. */
class InformeDiarioTest {

    /** Salida de mentira: en lugar de imprimir, guarda. */
    private static final class SalidaGuardada implements Salida {
        private final List<String> lineas = new ArrayList<>();

        @Override
        public void escribir(String linea) {
            lineas.add(linea);
        }
    }

    @Test
    void escribeElInformeEnLaSalidaQueSeLePasa() {
        var repositorio = new RepositorioEnMemoria();
        for (var resultado : Datos.historialMezclado()) {
            repositorio.guardar(resultado);
        }
        var salida = new SalidaGuardada();

        new InformeDiario(repositorio, salida).emitir(Datos.WEB);

        assertEquals(List.of(
                "servicio: " + Datos.WEB.nombre(),
                "comprobaciones: 3",
                "fallos: 1"), salida.lineas);
    }

    @Test
    void conUnRepositorioVacioNoInventaDatos() {
        var salida = new SalidaGuardada();
        new InformeDiario(new RepositorioEnMemoria(), salida).emitir(Datos.WEB);
        assertEquals(List.of(
                "servicio: " + Datos.WEB.nombre(),
                "comprobaciones: 0",
                "fallos: 0"), salida.lineas);
    }
}
