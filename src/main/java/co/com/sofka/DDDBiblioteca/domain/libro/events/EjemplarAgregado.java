package co.com.sofka.DDDBiblioteca.domain.libro.events;

import co.com.sofka.DDDBiblioteca.domain.libro.values.EjemplarId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Estado;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;

public class EjemplarAgregado extends DomainEvent {
    private final EjemplarId ejemplarId;
    private final Estado estado;
    private final Ubicacion ubicacion;
    public EjemplarAgregado(EjemplarId entityId, Estado estado, Ubicacion ubicacion) {
        super("sofka.libro.ejemplaragregado");
        this.ejemplarId=entityId;
        this.estado=estado;
        this.ubicacion=ubicacion;
    }

    public EjemplarId getEjemplarId() {
        return ejemplarId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
