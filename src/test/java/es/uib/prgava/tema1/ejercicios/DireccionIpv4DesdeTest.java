package es.uib.prgava.tema1.ejercicios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Ejercicio 1.2.7, la parte de la dirección: la fábrica estática. */
class DireccionIpv4DesdeTest {

    @Test
    void construyeDesdeUnTextoBienFormado() {
        assertEquals(new DireccionIpv4(192, 168, 1, 1), DireccionIpv4.desde("192.168.1.1"));
        assertEquals(new DireccionIpv4(0, 0, 0, 0), DireccionIpv4.desde("0.0.0.0"));
        assertEquals(new DireccionIpv4(255, 255, 255, 255), DireccionIpv4.desde("255.255.255.255"));
    }

    @Test
    void elNumeroDePartesTieneQueSerCuatro() {
        assertThrows(IllegalArgumentException.class, () -> DireccionIpv4.desde("10.0.0"));
        assertThrows(IllegalArgumentException.class, () -> DireccionIpv4.desde("10.0.0.1.1"));
    }

    @Test
    void unaParteQueNoEsUnNumeroSeRechaza() {
        assertThrows(IllegalArgumentException.class, () -> DireccionIpv4.desde("10.0.0.x"));
        assertThrows(IllegalArgumentException.class, () -> DireccionIpv4.desde(""));
    }

    @Test
    void elRangoLoSigueValidandoElConstructor() {
        assertThrows(IllegalArgumentException.class, () -> DireccionIpv4.desde("10.0.0.256"));
    }

    @Test
    void desdeYToStringSonInversos() {
        assertEquals("192.168.1.1", DireccionIpv4.desde("192.168.1.1").toString());
    }
}
