package es.uib.prgava.tema1.ejercicios.registroSensores;

import java.util.List;

public class Media {
    public double media(List<Double> lecturas) {
        if (lecturas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (double lectura : lecturas) {
            suma += lectura;
        }
        return suma / lecturas.size();
    }
}
