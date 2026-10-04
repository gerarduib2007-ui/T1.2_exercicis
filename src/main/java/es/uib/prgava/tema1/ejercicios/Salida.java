package es.uib.prgava.tema1.ejercicios;

/**
 * Ejercicio 1.2.5. Adónde va el texto de un informe.
 *
 * <p>Existe para que {@link InformeDiario} no dependa de {@code System.out}: en el programa se
 * cablea una salida que imprime, y en una prueba una que guarda lo escrito.
 */
public interface Salida {

    void escribir(String linea);
}
