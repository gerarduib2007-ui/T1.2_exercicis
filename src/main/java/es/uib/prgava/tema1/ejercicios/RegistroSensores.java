// RegistroSensores.java
package es.uib.prgava.tema1.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class RegistroSensores {

    private final List<Double> lecturas = new ArrayList<>();
    private final String sensor;
    private final double umbral;

    public RegistroSensores(String sensor, double umbral) {
        this.sensor = sensor;
        this.umbral = umbral;
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

    public double media() {
        if (lecturas.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (double lectura : lecturas) {
            suma += lectura;
        }
        return suma / lecturas.size();
    }

    public boolean hayQueAvisar() {
        return lecturas.size() >= 3 && media() > umbral;
    }

    public String textoDelAviso() {
        return "[AVISO] " + sensor + ": media " + String.format("%.1f", media())
                + ", por encima del umbral " + umbral;
    }

    public void avisar() {
        if (hayQueAvisar()) {
            System.out.println(textoDelAviso());
        }
    }
}
