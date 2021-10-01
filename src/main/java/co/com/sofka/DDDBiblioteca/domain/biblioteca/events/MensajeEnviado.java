package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.domain.generic.DomainEvent;

public class MensajeEnviado extends DomainEvent {
    private final  String mensaje;
    public MensajeEnviado(String mensaje) {
        super("sofka.biblioteca.mensajeenviado");
        this.mensaje=mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
