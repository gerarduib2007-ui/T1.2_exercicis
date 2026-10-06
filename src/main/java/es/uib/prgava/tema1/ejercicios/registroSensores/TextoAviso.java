package es.uib.prgava.tema1.ejercicios.registroSensores;

/** Construye el texto que acompaña al aviso. */
public class TextoAviso {
    public String crear(String sensor, double media, double umbral) {
        return "[AVISO] " + sensor + ": media " + String.format("%.1f", media)
                + ", por encima del umbral " + umbral;
    }
}
