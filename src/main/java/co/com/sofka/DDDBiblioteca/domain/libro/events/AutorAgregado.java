package co.com.sofka.DDDBiblioteca.domain.libro.events;

import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.DDDBiblioteca.domain.libro.values.AutorId;
import co.com.sofka.DDDBiblioteca.domain.libro.values.Nacionalidad;
import co.com.sofka.domain.generic.DomainEvent;

public class AutorAgregado extends DomainEvent {
    private final AutorId autorId;
    private final Nombre nombre;
    private final Nacionalidad nacionalidad;
    public AutorAgregado(AutorId entityId, Nombre nombre, Nacionalidad nacionalidad) {
        super("sofka.libro.autoragregado");
        this.autorId=entityId;
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
    }

    public AutorId getAutorId() {
        return autorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }
}
