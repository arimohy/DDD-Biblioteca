package co.com.sofka.DDDBiblioteca.domain.biblioteca.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.*;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Facultad;
import co.com.sofka.DDDBiblioteca.domain.generics.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearBiblioteca extends Command {
    private final BibliotecaId entityId;
    private final EstadoDeBiblioteca estadoDeBiblioteca;

    public CrearBiblioteca(BibliotecaId entityId, EstadoDeBiblioteca estadoDeBiblioteca) {
        this.entityId = entityId;
        this.estadoDeBiblioteca = estadoDeBiblioteca;
    }

    public BibliotecaId getEntityId() {
        return entityId;
    }

    public EstadoDeBiblioteca getEstadoDeBiblioteca() {
        return estadoDeBiblioteca;
    }

}
