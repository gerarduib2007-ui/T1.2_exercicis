package es.uib.prgava.tema1.monitor;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

/**
 * Ejercicio 1.2.8. Sonda cuyo comportamiento decides tú por completo, al contrario que
 * {@link SondaSimulada}.
 *
 * <p>Extiende el esqueleto de {@link SondaBase}: el algoritmo ya está escrito en
 * {@code sondear}, que es {@code final}. Lo único que falta es el paso variable.
 */
public final class SondaDeterminista extends SondaBase {

    private final List<Duration> latencias;
    private int llamadas = 0;

    /** @param latencias las que devolverá {@code medir}, una por llamada y en orden */
    public SondaDeterminista(Duration umbral, List<Duration> latencias) {
        super(umbral);
        this.latencias = List.copyOf(latencias);
    }

    /**
     * Paso variable: la latencia de esta llamada, o vacío para simular que no responde.
     *
     * <p>Cuando se agote la lista, vacío.
     */
    @Override
    protected Optional<Duration> medir(Servicio servicio) {
        if (llamadas >= latencias.size()) {
            return Optional.empty();
        }
        return Optional.of(latencias.get(llamadas++));
    }
}
