package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.EstadoDeBiblioteca;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoDeBibliotecaActualizada extends DomainEvent {
    private final EstadoDeBiblioteca estadoDeBiblioteca;
    public EstadoDeBibliotecaActualizada(EstadoDeBiblioteca estadoDeBiblioteca) {
        super("sofka.biblioteca.estadodebibliotecaactualizada");
        this.estadoDeBiblioteca=estadoDeBiblioteca;
    }

    public EstadoDeBiblioteca getEstadoDeBiblioteca() {
        return estadoDeBiblioteca;
    }
}
