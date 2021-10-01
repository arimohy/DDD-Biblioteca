package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeBibliotecarioActualizado extends DomainEvent {
    private final BibliotecaId bibliotecaId;
    private final Nombre nombre;
    public NombreDeBibliotecarioActualizado(BibliotecaId entityId, Nombre nombre) {
        super("sofka.biblioteca.nombredebibliotecarioactualizado");
        this.bibliotecaId=entityId;
        this.nombre=nombre;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
