package es.uib.prgava.tema1.monitor;

/**
 * Ejercicio 1.2.7. Un tipo de servicio más: responde al eco de red.
 *
 * <p>Se construye desde {@code Servicio.desde("ping:host")}, que tienes que ampliar.
 */
public record ServicioPing(String host) implements Servicio {

    @Override
    public String nombre() {
        return "ping:" + host;
    }
}
