package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecarioId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class BibliotecarioAgregado extends DomainEvent {
    private final BibliotecarioId bibliotecarioId;
    private final Nombre nombre;
    public BibliotecarioAgregado(BibliotecarioId entityId, Nombre nombre) {
        super("sofka.biblioteca.bibliotecarioagregado");
        this.bibliotecarioId=entityId;
        this.nombre=nombre;
    }

    public BibliotecarioId getBibliotecarioId() {
        return bibliotecarioId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
