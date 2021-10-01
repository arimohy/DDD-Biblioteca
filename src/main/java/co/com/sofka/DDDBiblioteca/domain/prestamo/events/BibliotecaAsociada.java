package co.com.sofka.DDDBiblioteca.domain.prestamo.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.domain.generic.DomainEvent;

public class BibliotecaAsociada extends DomainEvent {
    private final BibliotecaId bibliotecaId;
    public BibliotecaAsociada(BibliotecaId bibliotecaId) {
        super("sofka.prestamo.bibliotecaasociada");
        this.bibliotecaId=bibliotecaId;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }
}
