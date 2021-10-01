package co.com.sofka.DDDBiblioteca.domain.prestamo.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.domain.generic.Command;

public class AsociarBiblioteca extends Command {
    private final BibliotecaId bibliotecaId;

    public AsociarBiblioteca(BibliotecaId bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }
}
