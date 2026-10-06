package es.uib.prgava.tema1.ejercicios.registroSensores;

import java.util.List;

/** Decide si hay suficientes lecturas y la media supera el umbral. */
public class DecisionAviso {
    public boolean hayQueAvisar(List<Double> lecturas, double media, double umbral) {
        return lecturas.size() >= 3 && media > umbral;
    }
}
