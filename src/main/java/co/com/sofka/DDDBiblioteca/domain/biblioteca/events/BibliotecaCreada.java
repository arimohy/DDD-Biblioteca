package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.EstadoDeBiblioteca;
import co.com.sofka.domain.generic.DomainEvent;

public class BibliotecaCreada extends DomainEvent {
    private final EstadoDeBiblioteca estadoDeBiblioteca;
    public BibliotecaCreada(EstadoDeBiblioteca estadoDeBiblioteca) {
        super("sofka.biblioteca.bibliotecacreada");
        this.estadoDeBiblioteca=estadoDeBiblioteca;
    }

    public EstadoDeBiblioteca getEstadoDeBiblioteca() {
        return estadoDeBiblioteca;
    }
}
