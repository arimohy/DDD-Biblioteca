package co.com.sofka.DDDBiblioteca.domain.biblioteca.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecarioId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class AgregarBibliotecario extends Command {
    private final BibliotecaId bibliotecaId;
    private final BibliotecarioId entityId;
    private final Nombre nombre;

    public AgregarBibliotecario(BibliotecaId bibliotecaId,BibliotecarioId entityId, Nombre nombre) {
        this.bibliotecaId=bibliotecaId;
        this.entityId = entityId;
        this.nombre = nombre;
    }

    public BibliotecarioId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }
}
