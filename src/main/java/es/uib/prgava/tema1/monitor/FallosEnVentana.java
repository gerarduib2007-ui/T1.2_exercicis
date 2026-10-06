package es.uib.prgava.tema1.monitor;

import java.util.List;

/**
 * Ejercicio 1.2.2. Política de alerta nueva, sin tocar {@link Monitor} ni
 * {@link PoliticaDeAlerta}: eso es el principio abierto/cerrado.
 *
 * <p>A diferencia de {@link FallosConsecutivos}, los fallos no tienen que ser seguidos.
 */
public final class FallosEnVentana implements PoliticaDeAlerta {

    private final int minimoFallos;
    private final int tamanoVentana;

    /**
     * @throws IllegalArgumentException si no se cumple 1 &le; minimoFallos &le; tamanoVentana
     */
    public FallosEnVentana(int minimoFallos, int tamanoVentana) {
        // TODO 1.2.2: valida los dos parámetros antes de asignarlos.
        if (minimoFallos < 1 || minimoFallos > tamanoVentana) {
            throw new IllegalArgumentException(
                    "Debe cumplirse 1 <= minimoFallos <= tamanoVentana.");
        }
        this.minimoFallos = minimoFallos;
        this.tamanoVentana = tamanoVentana;
    }

    /**
     * Cierto si entre las últimas {@code tamanoVentana} comprobaciones hay al menos
     * {@code minimoFallos} fallos. Si el historial es más corto que la ventana, considera los
     * que haya.
     */
    @Override
    public boolean debeAlertar(List<Resultado> historial) {
        // TODO 1.2.2
        int inicio = Math.max(0, historial.size() - tamanoVentana);
        int fallos = 0;
        for (int i = inicio; i < historial.size(); i++) {
            if (historial.get(i).esFallo()) {
                fallos++;
                if (fallos >= minimoFallos) {
                    return true;
                }
            }
        }
        return false;
    }
    /** Descriptivo: el Monitor lo usa al componer el mensaje de la alerta. */
    @Override
    public String toString() {
        // TODO 1.2.2
        return "FallosEnVentana{minimoFallos=" + minimoFallos
                + ", tamanoVentana=" + tamanoVentana + '}';
    }
}
