// Responsabilidades y quién pediría cada cambio:
// - Añadir: quien cambie la validación o conservación de las lecturas.
// - Media: quien cambie la fórmula o el tratamiento de una lista vacía.
// - DecisionAviso: quien cambie las condiciones para emitir el aviso.
// - TextoAviso: quien cambie el formato del texto.
// RegistroSensores conserva la API pública y coordina las clases anteriores.
package es.uib.prgava.tema1.ejercicios.registroSensores;

import java.util.ArrayList;
import java.util.List;

public class RegistroSensores {
    private final List<Double> lecturas = new ArrayList<>();
    private final String sensor;
    private final double umbral;
    private final Añadir gestorLecturas = new Añadir(lecturas);
    private final Media calculadoraMedia = new Media();
    private final DecisionAviso decisionAviso = new DecisionAviso();
    private final TextoAviso textoAviso = new TextoAviso();
    private final Aviso aviso = new Aviso();

    public RegistroSensores(String sensor, double umbral) {
        this.sensor = sensor;
        this.umbral = umbral;
    }

    public void anadir(double lectura) {
        gestorLecturas.anadir(lectura);
    }

    public List<Double> lecturas() {
        return gestorLecturas.lecturas();
    }

    public double media() {
        return calculadoraMedia.media(lecturas);
    }

    public boolean hayQueAvisar() {
        return decisionAviso.hayQueAvisar(lecturas, media(), umbral);
    }

    public String textoDelAviso() {
        return textoAviso.crear(sensor, media(), umbral);
    }

    public void avisar() {
        if (hayQueAvisar()) {
            aviso.mostrar(textoDelAviso());
        }
    }
}
