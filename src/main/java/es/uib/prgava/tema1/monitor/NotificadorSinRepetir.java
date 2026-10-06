package es.uib.prgava.tema1.monitor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Ejercicio 1.2.6. Notificador que filtra lo repetido: del mismo servicio, solo el primer
 * aviso.
 *
 * <p>Recibe otro notificador y le reenvía lo que pasa el filtro. Fíjate en que esta clase
 * <em>recibe</em> un {@code Notificador} y además <em>es</em> un {@code Notificador}.
 */
public final class NotificadorSinRepetir implements Notificador {

    private final Notificador destino;
    private final Set<Servicio> notificados = new HashSet<>();

    public NotificadorSinRepetir(Notificador destino) {
        this.destino = Objects.requireNonNull(destino, "destino");
    }

    @Override
    public void notificar(Alerta alerta) {
        Objects.requireNonNull(alerta, "alerta");
        if (notificados.add(alerta.servicio())) {
            destino.notificar(alerta);
        }
    }

    /** Para que un servicio que se recupera vuelva a poder avisar. */
    public void olvidar(Servicio servicio) {
        notificados.remove(servicio);
    }
}
