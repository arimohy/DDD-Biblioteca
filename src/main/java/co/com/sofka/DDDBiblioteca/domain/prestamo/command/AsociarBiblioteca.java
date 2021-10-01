package co.com.sofka.DDDBiblioteca.domain.prestamo.command;

import co.com.sofka.DDDBiblioteca.domain.biblioteca.values.BibliotecaId;
import co.com.sofka.DDDBiblioteca.domain.prestamo.values.PrestamoId;
import co.com.sofka.domain.generic.Command;

public class AsociarBiblioteca extends Command {
    private final PrestamoId prestamoId;
    private final BibliotecaId bibliotecaId;

    public AsociarBiblioteca(PrestamoId prestamoId, BibliotecaId bibliotecaId) {
        this.prestamoId = prestamoId;
        this.bibliotecaId = bibliotecaId;
    }

    public PrestamoId getPrestamoId() {
        return prestamoId;
    }

    public BibliotecaId getBibliotecaId() {
        return bibliotecaId;
    }
}
