package co.com.sofka.DDDBiblioteca.domain.prestamo.events;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.LectorId;
import co.com.sofka.domain.generic.DomainEvent;

public class LectorAgregado extends DomainEvent {
    private final LectorId lectorId;
    private  final Nombre nombre;
    private final Facultad facultad;
    public LectorAgregado(LectorId entityId, Nombre nombre, Facultad facultad) {
        super("sofka.prestamo.lectoragregado");
        this.lectorId=entityId;
        this.nombre=nombre;
        this.facultad=facultad;
    }

    public LectorId getLectorId() {
        return lectorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Facultad getFacultad() {
        return facultad;
    }
}
