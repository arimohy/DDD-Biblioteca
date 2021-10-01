package co.com.sofka.DDDBiblioteca.domain.prestamo.events;

import co.com.sofka.DDDBiblioteca.domain.libro.values.LibroId;
import co.com.sofka.domain.generic.DomainEvent;

public class LibroAsociado extends DomainEvent {
    private final LibroId libroId;
    public LibroAsociado(LibroId libroId) {
        super("sofka.prestamo.libroasociado");
        this.libroId=libroId;
    }

    public LibroId getLibroId() {
        return libroId;
    }
}
