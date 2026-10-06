package es.uib.prgava.tema1.ejercicios.registroSensores;

import java.util.List;

/** Valida, guarda y expone una copia inmodificable de las lecturas. */
public class Añadir {
    private final List<Double> lecturas;

    public Añadir(List<Double> lecturas) {
        this.lecturas = lecturas;
    }

    public void anadir(double lectura) {
        if (lectura < -50 || lectura > 150) {
            throw new IllegalArgumentException("lectura fuera de rango: " + lectura);
        }
        lecturas.add(lectura);
    }

    public List<Double> lecturas() {
        return List.copyOf(lecturas);
    }
}
