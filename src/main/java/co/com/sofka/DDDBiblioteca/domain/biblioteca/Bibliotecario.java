package co.com.sofka.DDDBiblioteca.domain.biblioteca;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecarioId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Bibliotecario extends Entity<BibliotecarioId> {
    private final Nombre nombre;
    public Bibliotecario(BibliotecarioId entityId,Nombre nombre) {
        super(entityId);
        this.nombre=nombre;
    }

    public Nombre nombre() {
        return nombre;
    }
}
