package co.com.sofka.DDDBiblioteca.domain.prestamo.events;

import co.com.sofka.DDDBiblioteca.domain.prestamo.values.Observacion;
import co.com.sofka.domain.generic.DomainEvent;

public class ObservacionModificada extends DomainEvent {
    private final Observacion observacion;
    public ObservacionModificada(String mensaje) {
        super("sofka.prestamo.observacionmodificada");
        this.observacion=new Observacion(mensaje);
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
