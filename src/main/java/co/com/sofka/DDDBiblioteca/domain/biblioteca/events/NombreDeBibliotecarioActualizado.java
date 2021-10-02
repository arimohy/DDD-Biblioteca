package co.com.sofka.DDDBiblioteca.domain.biblioteca.events;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.Bibliotecario;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecarioId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeBibliotecarioActualizado extends DomainEvent {
    private final Nombre nombre;
    public NombreDeBibliotecarioActualizado(Nombre nombre) {
        super("sofka.biblioteca.nombredebibliotecarioactualizado");
        this.nombre=nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
