package es.uib.prgava.tema1.ejercicios;

import es.uib.prgava.tema1.monitor.RepositorioEnMemoria;
import es.uib.prgava.tema1.monitor.Alerta;
import es.uib.prgava.tema1.monitor.Notificador;
import es.uib.prgava.tema1.monitor.NotificadorConsola;
import es.uib.prgava.tema1.monitor.NotificadorSinRepetir;
import es.uib.prgava.tema1.monitor.Servicio;

/** Punto de entrada: aquí se conectan las implementaciones concretas. */
public final class Principal {

    private Principal() { }

    public static void main(String[] args) {
        var repositorio = new RepositorioEnMemoria();
        Salida salidaPorConsola = System.out::println;
        var informe = new InformeDiario(repositorio, salidaPorConsola);
        informe.emitir(Servicio.desde("https://example.com"));

        Servicio servicio = Servicio.desde("https://example.com");
        Notificador notificador = new NotificadorSinRepetir(new NotificadorConsola());
        notificador.notificar(Alerta.ahora(servicio, "servicio no disponible"));
        notificador.notificar(Alerta.ahora(servicio, "servicio sigue sin responder"));
    }
}
