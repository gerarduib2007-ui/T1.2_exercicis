package es.uib.prgava.tema1.monitor;

/**
 * Ejercicio 1.2.6. Notificador que filtra lo repetido: del mismo servicio, solo el primer
 * aviso.
 *
 * <p>Recibe otro notificador y le reenvía lo que pasa el filtro. Fíjate en que esta clase
 * <em>recibe</em> un {@code Notificador} y además <em>es</em> un {@code Notificador}.
 */
public final class NotificadorSinRepetir implements Notificador {

    // TODO 1.2.6: recuerda aquí los servicios ya notificados. Un Set<Servicio> es el tipo
    // adecuado para «¿está este ya?», y funciona porque los servicios son registros y traen
    // equals y hashCode escritos.

    public NotificadorSinRepetir(Notificador destino) {
        // TODO 1.2.6
        throw new UnsupportedOperationException("TODO 1.2.6: constructor de NotificadorSinRepetir");
    }

    @Override
    public void notificar(Alerta alerta) {
        // TODO 1.2.6: reenvía al destino solo la primera vez que ves ese servicio.
        throw new UnsupportedOperationException("TODO 1.2.6: NotificadorSinRepetir.notificar");
    }

    /** Para que un servicio que se recupera vuelva a poder avisar. */
    public void olvidar(Servicio servicio) {
        // TODO 1.2.6
        throw new UnsupportedOperationException("TODO 1.2.6: NotificadorSinRepetir.olvidar");
    }
}
