package co.com.sofka.DDDBiblioteca.domain.biblioteca.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.EstadoDeBiblioteca;
import co.com.sofka.domain.generic.Command;

public class ActualizarEstadoDeBiblioteca extends Command {
    private final BibliotecaId bibliotecaId;
    private final EstadoDeBiblioteca estadoDeBiblioteca;

    public ActualizarEstadoDeBiblioteca(BibliotecaId bibliotecaId,EstadoDeBiblioteca estadoDeBiblioteca) {
        this.bibliotecaId=bibliotecaId;
        this.estadoDeBiblioteca = estadoDeBiblioteca;
    }

    public EstadoDeBiblioteca getEstadoDeBiblioteca() {
        return estadoDeBiblioteca;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }
}
