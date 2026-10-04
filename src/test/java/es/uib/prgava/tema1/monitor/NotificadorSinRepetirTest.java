package es.uib.prgava.tema1.monitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Ejercicio 1.2.6. */
class NotificadorSinRepetirTest {

    private static final Servicio WEB = Servicio.desde("https://www.uib.es");
    private static final Servicio DNS = Servicio.desde("dns:uib.es");

    private NotificadorRegistro destino;
    private NotificadorSinRepetir filtro;

    @BeforeEach
    void prepararNotificadores() {
        destino = new NotificadorRegistro();
        filtro = new NotificadorSinRepetir(destino);
    }

    @Test
    void delMismoServicioSoloPasaElPrimerAviso() {
        filtro.notificar(Alerta.ahora(WEB, "uno"));
        filtro.notificar(Alerta.ahora(WEB, "dos"));
        filtro.notificar(Alerta.ahora(WEB, "tres"));
        assertEquals(1, destino.alertas().size());
        assertEquals("uno", destino.alertas().get(0).mensaje());
    }

    @Test
    void cadaServicioTieneSuPrimeraVez() {
        filtro.notificar(Alerta.ahora(WEB, "uno"));
        filtro.notificar(Alerta.ahora(DNS, "dos"));
        assertEquals(2, destino.alertas().size());
    }

    @Test
    void despuesDeOlvidarUnServicioVuelveAAvisar() {
        filtro.notificar(Alerta.ahora(WEB, "uno"));
        filtro.olvidar(WEB);
        filtro.notificar(Alerta.ahora(WEB, "dos"));
        assertEquals(2, destino.alertas().size());
    }

    @Test
    void olvidarUnServicioQueNoEstabaNoMolesta() {
        filtro.olvidar(DNS);
        filtro.notificar(Alerta.ahora(WEB, "uno"));
        assertEquals(1, destino.alertas().size());
    }
}
