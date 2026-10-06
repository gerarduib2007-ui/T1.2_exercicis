package es.uib.prgava.tema1.monitor;

/** Escribe las alertas recibidas en la consola. */
public final class NotificadorConsola implements Notificador {

    @Override
    public void notificar(Alerta alerta) {
        System.out.println(alerta.servicio().nombre() + ": " + alerta.mensaje());
    }
}
