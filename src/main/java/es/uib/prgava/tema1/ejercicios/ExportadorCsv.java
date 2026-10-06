package es.uib.prgava.tema1.ejercicios;

import java.util.List;

/**
 * Ejercicio 1.2.4. Solo exporta: recibe las fichas ya hechas y las convierte a texto.
 *
 * <p>Esta clase <strong>ya está escrita</strong>. Solo cumple el contrato de exportación CSV.
 */
public final class ExportadorCsv implements ExportadorDispositivos {

    private final List<FichaDispositivo> fichas;

    public ExportadorCsv(List<FichaDispositivo> fichas) {
        this.fichas = List.copyOf(fichas);
    }

    /** Número de fichas que se exportarán. */
    public int cuantos() {
        return fichas.size();
    }

    @Override
    public String exportarCsv() {
        var texto = new StringBuilder();
        for (var ficha : fichas) {
            texto.append(ficha.nombre()).append(';').append(ficha.direccionIp()).append('\n');
        }
        return texto.toString();
    }
}
