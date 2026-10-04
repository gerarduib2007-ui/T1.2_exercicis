package es.uib.prgava.tema1.ejercicios;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 1.2.4. Inventario de solo consulta: se construye una vez y no cambia.
 *
 * <p>Esta clase <strong>ya está escrita</strong>, y mira lo que se ve obligada a escribir para
 * cumplir la interfaz: cuatro métodos que no aplican. Ese es el síntoma del principio I.
 */
public final class ConsultaDispositivos implements GestorDispositivos {

    private final List<FichaDispositivo> fichas;

    public ConsultaDispositivos(List<FichaDispositivo> fichas) {
        this.fichas = List.copyOf(fichas);
    }

    @Override
    public void darDeAlta(String nombre, String direccionIp) {
        throw new UnsupportedOperationException("este inventario es de solo consulta");
    }

    @Override
    public void borrar(String nombre) {
        throw new UnsupportedOperationException("este inventario es de solo consulta");
    }

    @Override
    public void renombrar(String nombre, String nuevoNombre) {
        throw new UnsupportedOperationException("este inventario es de solo consulta");
    }

    @Override
    public boolean existe(String nombre) {
        for (var ficha : fichas) {
            if (ficha.nombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> nombres() {
        var todos = new ArrayList<String>();
        for (var ficha : fichas) {
            todos.add(ficha.nombre());
        }
        return List.copyOf(todos);
    }

    @Override
    public int cuantos() {
        return fichas.size();
    }

    @Override
    public String exportarCsv() {
        return "";                      // no aplica: nadie le pide CSV
    }

    @Override
    public String exportarJson() {
        return "";                      // no aplica: nadie le pide JSON
    }
}
