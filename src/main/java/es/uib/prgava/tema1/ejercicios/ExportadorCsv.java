package es.uib.prgava.tema1.ejercicios;

import java.util.List;

/**
 * Ejercicio 1.2.4. Solo exporta: recibe las fichas ya hechas y las convierte a texto.
 *
 * <p>Esta clase <strong>ya está escrita</strong>. De los ocho métodos de la interfaz le
 * interesa uno.
 */
public final class ExportadorCsv implements GestorDispositivos {

    private final List<FichaDispositivo> fichas;

    public ExportadorCsv(List<FichaDispositivo> fichas) {
        this.fichas = List.copyOf(fichas);
    }

    @Override
    public void darDeAlta(String nombre, String direccionIp) {
        // no aplica
    }

    @Override
    public void borrar(String nombre) {
        // no aplica
    }

    @Override
    public void renombrar(String nombre, String nuevoNombre) {
        // no aplica
    }

    @Override
    public boolean existe(String nombre) {
        throw new UnsupportedOperationException("este exportador no consulta");
    }

    @Override
    public List<String> nombres() {
        throw new UnsupportedOperationException("este exportador no consulta");
    }

    @Override
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

    @Override
    public String exportarJson() {
        throw new UnsupportedOperationException("este exportador solo hace CSV");
    }
}
