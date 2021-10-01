package co.com.sofka.DDDBiblioteca.domain.biblioteca.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreBibliotecario extends Command {
    private final BibliotecaId bibliotecaId;
    private final BibliotecaId entityId;
    private final Nombre nombre;

    public ActualizarNombreBibliotecario(BibliotecaId bibliotecaId, BibliotecaId entityId, Nombre nombre) {
        this.bibliotecaId = bibliotecaId;
        this.entityId = entityId;
        this.nombre = nombre;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }

    public BibliotecaId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
