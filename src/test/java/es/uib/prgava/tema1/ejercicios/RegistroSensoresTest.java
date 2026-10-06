package es.uib.prgava.tema1.ejercicios;

import es.uib.prgava.tema1.ejercicios.registroSensores.RegistroSensores;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ejercicio 1.2.1. Estas pruebas pasan <strong>antes</strong> de refactorizar y tienen que
 * seguir pasando <strong>después</strong>, sin tocarlas: esa es la definición de refactorizar.
 */
class RegistroSensoresTest {

    private static RegistroSensores conLecturas(double... lecturas) {
        var registro = new RegistroSensores("s1", 25.0);
        for (double lectura : lecturas) {
            registro.anadir(lectura);
        }
        return registro;
    }

    @Test
    void laMediaDeUnRegistroVacioEsCero() {
        assertEquals(0.0, conLecturas().media());
    }

    @Test
    void calculaLaMediaDeLasLecturas() {
        assertEquals(20.0, conLecturas(10.0, 20.0, 30.0).media());
    }

    @Test
    void noAvisaConMenosDeTresLecturas() {
        assertFalse(conLecturas(30.0, 30.0).hayQueAvisar());
    }

    @Test
    void avisaCuandoLaMediaPasaElUmbral() {
        assertTrue(conLecturas(30.0, 30.0, 30.0).hayQueAvisar());
    }

    @Test
    void noAvisaCuandoLaMediaNoLlegaAlUmbral() {
        assertFalse(conLecturas(10.0, 10.0, 10.0).hayQueAvisar());
    }

    @Test
    void elTextoDelAvisoLlevaElSensorLaMediaYElUmbral() {
        var texto = conLecturas(30.0, 30.0, 30.0).textoDelAviso();
        assertTrue(texto.contains("s1"));
        assertTrue(texto.contains("30"));
        assertTrue(texto.contains("25"));
    }

    @Test
    void unaLecturaFueraDeRangoEsRechazada() {
        assertThrows(IllegalArgumentException.class, () -> conLecturas(200.0));
    }

    @Test
    void lasLecturasQueDevuelveNoSePuedenModificarPorFuera() {
        var lecturas = conLecturas(1.0, 2.0).lecturas();
        assertEquals(2, lecturas.size());
        assertThrows(UnsupportedOperationException.class, () -> lecturas.add(3.0));
    }
}
